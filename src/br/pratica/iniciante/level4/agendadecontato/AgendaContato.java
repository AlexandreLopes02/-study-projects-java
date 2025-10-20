package br.pratica.iniciante.level4.agendadecontato;

import java.util.Scanner;

public class AgendaContato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n---- Agenda de Contatos ----");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Listar todos os contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa buffer

            switch (opcao) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    agenda.adicionarContato(new Contato(nome, telefone, email));
                }
                case 2 -> {
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nome = scanner.nextLine();
                    agenda.removerContato(nome);
                }
                case 3 -> {
                    System.out.print("Digite o nome do contato que deseja buscar: ");
                    String nome = scanner.nextLine();
                    agenda.buscarContato(nome);
                }
                case 4 -> agenda.listarContatos();
                case 0 -> System.out.println("Encerrando a agenda...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}

