package br.pratica.iniciante.level5.libraryvirtual;

import java.util.Scanner;

public class VirtualLibrary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        var opcao = -1;
        while (opcao != 0){
            System.out.println("""
                    \n=====OPÇÕES=====
                    1 - Adicionar livro
                    2 - Listar livros
                    3 - Buscar livro
                    4 - Remover livro
                    
                    0- SAIR
                    Escolha:
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.println("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.println("Ano: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    library.adicionarLivro(new Book(titulo, autor , ano));
                }
                case 2 -> library.listarLivros();
                case 3 -> {
                    System.out.println("Digite o termo de busca (título ou autor): ");
                    String termo = scanner.nextLine();
                    library.buscarLivro(termo);
                }
                case  4 -> {
                    System.out.println("Digite o titulo do livro que deseja remover: ");
                    String titulo = scanner.nextLine();
                    library.removerLivro(titulo);
                }
                case 0 -> System.out.println("Finalizando seu acesso a biblioteca...");
                default -> System.out.println("Opçõa invalida!");
            }
        }

        scanner.close();
    }
}
