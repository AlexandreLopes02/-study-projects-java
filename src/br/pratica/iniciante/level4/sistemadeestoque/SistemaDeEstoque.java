package br.pratica.iniciante.level4.sistemadeestoque;

import java.util.Scanner;

public class SistemaDeEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    \n===== SISTEMA DE ESTOQUE =====
                    1 - Adicionar produto
                    2 - Remover produto
                    3 - Listar produtos
                    4 - Exibir valor total em estoque

                    0 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    estoque.adicionarProduto(new Produto(nome, quantidade, preco));
                }
                case 2 -> {
                    System.out.print("Nome do produto para remover: ");
                    String nome = scanner.nextLine();
                    estoque.removerProduto(nome);
                }
                case 3 -> estoque.listarProdutos();
                case 4 -> estoque.exibirValorTotal();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

}
