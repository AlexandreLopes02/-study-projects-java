package br.pratica.iniciante.level6.sistemadevendas;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Loja {

    private List<Produto> estoque = new ArrayList<>();
    private List<Venda> vendas = new ArrayList<>();

    private static final String ARQUIVO_ESTOQUE = "estoque.txt";
    private static final String ARQUIVO_VENDAS = "vendas.txt";

    public Loja() {
        carregarEstoque();
        carregarVendas();
    }

    // --- ESTOQUE ---

    public void cadastrarProduto(Produto produto) {
        estoque.add(produto);
        salvarEstoque();
        System.out.println("✅ Produto cadastrado com sucesso!");
    }

    public void listarEstoque() {
        if (estoque.isEmpty()) {
            System.out.println("📦 Estoque vazio!");
            return;
        }

        System.out.println("\n===== PRODUTOS EM ESTOQUE =====");
        for (Produto produto : estoque) {
            System.out.println(produto);
        }
    }

    // --- VENDAS ---

    public void realizarVenda(int id, int quantidade) {
        if (estoque.isEmpty()) {
            System.out.println("📭 O estoque está vazio.");
            return;
        }

        if (quantidade <= 0) {
            System.out.println("⚠️ Quantidade inválida. Digite um valor maior que 0.");
            return;
        }

        for (Produto produto : estoque) {
            if (produto.getId() == id) {
                if (produto.getQuantidade() < quantidade) {
                    System.out.println("⚠️ Estoque insuficiente. Disponível: " + produto.getQuantidade());
                    return;
                }

                produto.setQuantidade(produto.getQuantidade() - quantidade);
                salvarEstoque();

                Venda venda = new Venda();
                venda.adicionarProduto(produto, quantidade);
                vendas.add(venda);
                salvarVenda(venda);

                System.out.printf("\n✅ Venda de %d unidade(s) de '%s' realizada com sucesso!%n", quantidade, produto.getNome());
                System.out.printf("💰 Valor total: R$ %.2f%n", venda.getTotal());
                return;
            }
        }

        System.out.println("⚠️ Produto com ID " + id + " não encontrado.");
    }

    public void exibirHistoricoDeVendas() {
        if (vendas.isEmpty()) {
            System.out.println("📭 Nenhuma venda registrada.");
            return;
        }

        System.out.println("\n===== HISTÓRICO DE VENDAS =====");
        vendas.forEach(System.out::println);
    }

    // --- PERSISTÊNCIA ---

    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_ESTOQUE))) {
            for (Produto produto : estoque) {
                bw.write(produto.getId() + "|" + produto.getNome() + "|" + produto.getPreco() + "|" + produto.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠️ Erro ao salvar estoque: " + e.getMessage());
        }
    }

    private void carregarEstoque() {
        File file = new File(ARQUIVO_ESTOQUE);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 4) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    double preco = Double.parseDouble(partes[2]);
                    int qtd = Integer.parseInt(partes[3]);
                    estoque.add(new Produto(id, nome, preco, qtd));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Erro ao carregar estoque: " + e.getMessage());
        }
    }

    private void salvarVenda(Venda venda) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_VENDAS, true))) {
            bw.write(venda.exportarParaArquivo());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("⚠️ Erro ao salvar venda: " + e.getMessage());
        }
    }

    private void carregarVendas() {
        File file = new File(ARQUIVO_VENDAS);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Venda venda = Venda.importarDeArquivo(linha);
                if (venda != null) {
                    vendas.add(venda);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠️ Erro ao carregar vendas: " + e.getMessage());
        }
    }
}
