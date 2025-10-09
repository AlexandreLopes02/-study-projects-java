package br.pratica.iniciante.level6.advancedagenda;

import java.util.Scanner;

public class AdvancedAgenda {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        var opcao = -1;
        while (opcao != 0){
            System.out.println("""
                    \n===== MENU DE OPÇÕES =====
                    1 - Adicionar contato
                    2 - Listar contatos
                    3 - Buscar contatos
                    4 - Atualizar contato
                    5 - Remover contatos
                    
                    0 - SAIR
                    Escolha uma opção:
                    """);

            String linhaOpcao = scanner.nextLine();

            try {
                opcao = Integer.parseInt(linhaOpcao);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao){
                case 1 -> {
                    System.out.println("--- Adicionar Contato ---");
                    System.out.print("Id (apenas números): ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    scanner.nextLine();
                    agenda.adicionarContato(new Contact(id, nome, telefone , email));
                }
                case 2 -> agenda.listarContatos();
                case 3 -> {
                    System.out.println("--- Buscar Contato ---");
                    System.out.println("Digite o termo de busca (nome ou telefone ): ");
                    String termo = scanner.nextLine();
                    agenda.buscarContatos(termo);
                }
                case  4 -> {
                    System.out.println("--- Atualizar Contato ---");
                    System.out.print("Digite o nome ou telefone que deseja atualizar: ");
                    String termo = scanner.nextLine();

                    System.out.print("Novo Id: ");
                    int novoId = Integer.parseInt(scanner.nextLine());

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo telefone: ");
                    String novoTelefone = scanner.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = scanner.nextLine();
                    agenda.atualizarContato(termo, novoId, novoNome, novoTelefone, novoEmail);
                }
                case  5 -> {
                    System.out.println("Digite o nome do contato que deseja remover: ");
                    String nome = scanner.nextLine();
                    agenda.removerContato(nome);
                }
                case 0 -> System.out.println("Fechando a agenda....");
                default -> System.out.println("Opçõa invalida!");
            }
        }

        scanner.close();

    }
}
