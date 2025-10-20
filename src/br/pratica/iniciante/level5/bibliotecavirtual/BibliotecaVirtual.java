package br.pratica.iniciante.level5.bibliotecavirtual;

import java.util.Scanner;

public class BibliotecaVirtual {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    \n===== MENU DA BIBLIOTECA =====
                    1 - Adicionar livro
                    2 - Listar livros
                    3 - Buscar livro
                    4 - Remover livro

                    0 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();

                    biblioteca.adicionarLivro(new Livro(titulo, autor, ano));
                }
                case 2 -> biblioteca.listarLivros();
                case 3 -> {
                    System.out.print("Digite o termo de busca (título ou autor): ");
                    String termo = scanner.nextLine();
                    biblioteca.buscarLivro(termo);
                }
                case 4 -> {
                    System.out.print("Digite o título do livro que deseja remover: ");
                    String titulo = scanner.nextLine();
                    biblioteca.removerLivro(titulo);
                }
                case 0 -> System.out.println("Encerrando acesso à biblioteca...");
                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
