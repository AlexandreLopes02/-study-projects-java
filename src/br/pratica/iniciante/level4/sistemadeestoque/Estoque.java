package br.pratica.iniciante.level4.sistemadeestoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("✅ Produto adicionado com sucesso!");
    }

    public void removerProduto(String nome) {
        boolean removido = produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));

        if (removido) {
            System.out.println("🗑️ Produto removido com sucesso!");
        } else {
            System.out.println("⚠️ Produto não encontrado! Verifique o nome digitado.");
        }
    }

    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("📦 Nenhum produto cadastrado no estoque.");
        } else {
            System.out.println("\n---- Lista de Produtos ----");
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    public void exibirValorTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getValorTotal();
        }
        System.out.printf("💰 Valor total do estoque: R$%.2f%n", total);
    }
}
