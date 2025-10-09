package br.pratica.iniciante.level6.salessystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> store = new ArrayList<>();
    private List<Sales> sales = new ArrayList<>();

    private static final String ESTOQUE = "estoque.txt";
    private static final String VENDAS = "vendas.txt";

    public Store() {
        carregarEstoque();
        carregarVendas(); // Carrega histórico, mas não exibe
    }

    // --- ESTOQUE ---

    public void cadastrarProduto(Product product) {
        store.add(product);
        salvarEstoque();
        System.out.println("✅ Produto cadastrado com sucesso.");
    }

    public void listarEstoque() {
        if (store.isEmpty()) {
            System.out.println("Estoque vazio!");
            return;
        }
        System.out.println("\n===== PRODUTOS EM ESTOQUE =====");
        for (Product product : store) {
            System.out.println(product);
        }
    }

    // --- VENDAS ---

    public void venderProduto(int id, int qtd) {
        if (store.isEmpty()) {
            System.out.println("O estoque está vazio.");
            return;
        }

        if (qtd <= 0) {
            System.out.println("⚠ Quantidade inválida. Digite um valor maior que 0.");
            return;
        }

        for (Product produtoAtual : store) {
            if (produtoAtual.getId() == id) {
                if (produtoAtual.getQuantidade() < qtd) {
                    System.out.println("⚠ Estoque insuficiente. Disponível: " + produtoAtual.getQuantidade());
                    return;
                }

                produtoAtual.setQuantidade(produtoAtual.getQuantidade() - qtd);
                salvarEstoque();

                Sales venda = new Sales();
                venda.adicionarProduto(produtoAtual, qtd);
                sales.add(venda);
                salvarVenda(venda);

                System.out.printf("\n✅ Venda de %d unidade(s) de %s realizada com sucesso!\n", qtd, produtoAtual.getNome());
                System.out.printf("💰 Valor total da compra: R$ %.2f%n", venda.getTotal());
                return;
            }
        }

        System.out.println("⚠ Produto com ID " + id + " não encontrado.");
    }

    public void exibirHistoricoVendas() {
        if (sales.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
            return;
        }
        System.out.println("\n===== HISTÓRICO DE VENDAS =====");
        sales.forEach(System.out::println);
    }

    // --- PERSISTÊNCIA ---

    private void salvarEstoque() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ESTOQUE))) {
            for (Product product : store) {
                bw.write(product.getId() + "|" +
                        product.getNome() + "|" +
                        product.getPreco() + "|" +
                        product.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao salvar estoque: " + e.getMessage());
        }
    }

    private void carregarEstoque() {
        File file = new File(ESTOQUE);
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
                    store.add(new Product(id, nome, preco, qtd));
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao carregar estoque: " + e.getMessage());
        }
    }

    private void salvarVenda(Sales venda) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(VENDAS, true))) {
            bw.write(venda.exportarParaArquivo());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("⚠ Erro ao salvar venda: " + e.getMessage());
        }
    }

    private void carregarVendas() {
        File file = new File(VENDAS);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Sales venda = Sales.importarDeArquivo(linha);
                if (venda != null) {
                    sales.add(venda);
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao carregar vendas: " + e.getMessage());
        }
    }
}
