package br.pratica.iniciante.level5.todolist;

import java.io.*;
import java.util.ArrayList;

public class TaskManager {

    ArrayList<Task> tasks = new ArrayList<>();

    private static final String ARQUIVO = "tarefas.txt";

    public void adicionarTafera(Task t){
        tasks.add(t);
        salvarArquivo();
        System.out.println("Tafera adicionada a sua lista!");
    }

    public void listarTarefas() {
        if (tasks.isEmpty()) {
            System.out.println("Sua lista de tarefas está vazia!");
            return;
        }

        System.out.println("\n===== LISTA DE TAREFAS =====");
        tasks.stream()
                .sorted((t1, t2) -> Integer.compare(t2.getPrioridade(),
                        t1.getPrioridade())) // maior prioridade primeiro
                .forEach(System.out::println);
    }

    public void marcarConcluida(String titulo) {
        if (tasks.isEmpty()) {
            System.out.println("Sua lista de tarefas está vazia!");
            return;
        }
        boolean encontrada = false;

        for (Task t : tasks) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                if (t.isConcluida()) {
                    System.out.println("Esta tarefa já foi concluída!");
                } else {
                    t.concluir(); // muda status
                    salvarArquivo();
                    System.out.println("Tarefa concluída: " + t.getTitulo());
                }
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("Tarefa não encontrada: " + titulo);
        }
    }

    public void removerTarefa(String titulo){
        boolean removido = tasks.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
        if (removido) {
            salvarArquivo();
            System.out.println("Tarefa removido com sucesso!");
        } else {
            System.out.println("Tarefa não encontrado.");
        }
    }

    private void carregarArquivo() {
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 4) { // agora salva também o status
                    try {
                        String titulo = partes[0].trim();
                        String descricao = partes[1].trim();
                        int prioridade = Integer.parseInt(partes[2].trim());
                        boolean status = Boolean.parseBoolean(partes[3].trim());
                        Task t = new Task(titulo, descricao, prioridade);
                        if (status) t.concluir();
                        tasks.add(t);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ Prioridade inválida na linha: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Task task : tasks) {
                bw.write(task.getTitulo() + "|" +
                        task.getDescricao() + "|" +
                        task.getPrioridade() + "|" +
                        task.isConcluida());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
