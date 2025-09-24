package br.pratica.iniciante.level4.contactdirectory;

import java.util.Scanner;

public class ContactDirectory {
    public static void main(String[] args) {
//        Contact contact = new Contact("Alexandre", "11913662747", "alenovoxio@gmail.com");
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();

        var opcao = -1;
        while (opcao != 0){
            System.out.println("\n---- Agenda de contatos ----");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Listar contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.println("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.println("Email: ");
                    String email = scanner.nextLine();
                    agenda.adicionarContact(new Contact(nome,telefone,email));
                }
                case 2 -> {
                    System.out.println("Nome para remover o contato: ");
                    String nome = scanner.nextLine();
                    agenda.removerContact(nome);
                }
                case 3 -> {
                    System.out.print("Nome para buscar: ");
                    String nome = scanner.nextLine();
                    agenda.buscarContact(nome);
                }
                case 4 -> agenda.listarContact();
                case 0 -> System.out.println("Finalizando seu acesso...");
                default -> System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}

