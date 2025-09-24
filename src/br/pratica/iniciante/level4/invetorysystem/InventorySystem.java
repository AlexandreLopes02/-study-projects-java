package br.pratica.iniciante.level4.invetorysystem;

import java.util.Scanner;

public class InventorySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stock stock = new Stock();
        int opcao = -1;
        while (opcao != 0){
            System.out.println("""
                    \n===== SISTEMA DE ESTOQUE =====
                    1 - adicionar produto.
                    2 - Remover produto.
                    3 - Listar produtos.
                    4 - Valor total em estoque.
                    
                    0 - Sair.
                    \nEscolha:
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao){
                case 1 -> {
                    System.out.println("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.println("Quantidade: ");
                    int qtd = scanner.nextInt();
                    System.out.println("Preço: ");
                    double preco = scanner.nextDouble();
                    stock.adicionarP(new Product(nome,qtd,preco));

                }
                case 2 -> {
                    System.out.println("Nome do produto pra remover: ");
                    String nome = scanner.nextLine();
                    stock.removerP(nome);
                }
                case 3 -> stock.listarP();
                case 4 -> stock.valorTotEmEstoque();
                case 0 -> System.out.println("Saindo do sistema...");
                default -> System.out.println("Opção invalida!");
            }
        }
    }

}
