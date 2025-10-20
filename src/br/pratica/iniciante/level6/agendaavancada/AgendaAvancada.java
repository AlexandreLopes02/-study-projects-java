package br.pratica.iniciante.level6.agendaavancada;

import java.util.Scanner;

public class AgendaAvancada {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    \n===== MENU DE OPÇÕES =====
                    1 - Adicionar contato
                    2 - Listar contatos
                    3 - Buscar contato
                    4 - Atualizar contato
                    5 - Remover contato

                    0 - Sair
                    """);
            System.out.print("Escolha uma opção: ");

            String linhaOpcao = scanner.nextLine();

            try {
                opcao = Integer.parseInt(linhaOpcao);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n--- Adicionar Contato ---");
                    System.out.print("ID (apenas números): ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    agenda.adicionarContato(new Contato(id, nome, telefone, email));
                }
                case 2 -> agenda.listarContatos();
                case 3 -> {
                    System.out.println("\n--- Buscar Contato ---");
                    System.out.print("Digite o termo de busca (nome ou telefone): ");
                    String termo = scanner.nextLine();
                    agenda.buscarContatos(termo);
                }
                case 4 -> {
                    System.out.println("\n--- Atualizar Contato ---");
                    System.out.print("Digite o nome ou telefone que deseja atualizar: ");
                    String termo = scanner.nextLine();

                    System.out.print("Novo ID: ");
                    int novoId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    System.out.print("Novo e-mail: ");
                    String novoEmail = scanner.nextLine();

                    agenda.atualizarContato(termo, novoId, novoNome, novoTelefone, novoEmail);
                }
                case 5 -> {
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nome = scanner.nextLine();
                    agenda.removerContato(nome);
                }
                case 0 -> System.out.println("Encerrando a agenda...");
                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
