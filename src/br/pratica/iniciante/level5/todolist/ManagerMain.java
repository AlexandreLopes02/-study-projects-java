package br.pratica.iniciante.level5.todolist;

import java.util.Scanner;

public class ManagerMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        var opcao = -1;
        while (opcao != 0){
            System.out.println("""
                    \n=====To-Do List=====
                    1 - Adicionar tarefa
                    2 - Listar tarefas
                    3 - Concluir tarefa
                    4 - Remover tarefa
                    
                    0- SAIR
                    Escolha:
                    """);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao){
                case 1 -> {
                    System.out.println("Tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.println("Prioridade: ");
                    int prioridade = scanner.nextInt();
                    scanner.nextLine();
                    manager.adicionarTafera(new Task(titulo, descricao , prioridade));
                }
                case 2 -> manager.listarTarefas();
                case 3 -> {
                    System.out.println("Digite o nome da tarefa: ");
                    String nomeTarefa = scanner.nextLine();
                    manager.marcarConcluida(nomeTarefa);
                }
                case  4 -> {
                    System.out.println("Digite qual tarefa deseja remover: ");
                    String titulo = scanner.nextLine();
                    manager.removerTarefa(titulo);
                }
                case 0 -> System.out.println("Finalizando sua lista de tarefas...");
                default -> System.out.println("Opçõa invalida!");
            }
        }
        scanner.close();
    }
}
