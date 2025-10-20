package br.pratica.iniciante.level5.listadetarefas;

import java.util.Scanner;

public class GerenciadorDeTarefas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Tarefas tarefas = new Tarefas();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    \n===== LISTA DE TAREFAS =====
                    1 - Adicionar tarefa
                    2 - Listar tarefas
                    3 - Marcar tarefa como concluída
                    4 - Remover tarefa

                    0 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título da tarefa: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Prioridade (1 a 5): ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();

                    tarefas.adicionarTarefa(new Tarefa(titulo, descricao, prioridade));
                }
                case 2 -> tarefas.listarTarefas();
                case 3 -> {
                    System.out.print("Digite o título da tarefa: ");
                    String titulo = scanner.nextLine();
                    tarefas.marcarConcluida(titulo);
                }
                case 4 -> {
                    System.out.print("Digite o título da tarefa que deseja remover: ");
                    String titulo = scanner.nextLine();
                    tarefas.removerTarefa(titulo);
                }
                case 0 -> System.out.println("Encerrando sua lista de tarefas...");
                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
    }
