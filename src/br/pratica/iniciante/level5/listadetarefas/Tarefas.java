package br.pratica.iniciante.level5.listadetarefas;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tarefas {

    private final List<Tarefa> tarefas = new ArrayList<>();
    private static final String ARQUIVO = "tarefas.txt";

    public Tarefas() {
        carregarArquivo();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        salvarArquivo();
        System.out.println("✅ Tarefa adicionada à lista!");
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("📭 Sua lista de tarefas está vazia!");
            return;
        }

        System.out.println("\n===== LISTA DE TAREFAS =====");
        tarefas.stream()
                .sorted(Comparator.comparingInt(Tarefa::getPrioridade).reversed())
                .forEach(System.out::println);
    }

    public void marcarConcluida(String titulo) {
        if (tarefas.isEmpty()) {
            System.out.println("📭 Sua lista de tarefas está vazia!");
            return;
        }

        boolean encontrada = false;

        for (Tarefa t : tarefas) {
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                if (t.isConcluida()) {
                    System.out.println("⚠️ Esta tarefa já está concluída!");
                } else {
                    t.concluir();
                    salvarArquivo();
                    System.out.println("✅ Tarefa concluída: " + t.getTitulo());
                }
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("❌ Tarefa não encontrada: " + titulo);
        }
    }

    public void removerTarefa(String titulo) {
        boolean removido = tarefas.removeIf(t -> t.getTitulo().equalsIgnoreCase(titulo));

        if (removido) {
            salvarArquivo();
            System.out.println("🗑️ Tarefa removida com sucesso!");
        } else {
            System.out.println("⚠️ Tarefa não encontrada.");
        }
    }

    private void carregarArquivo() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 4) {
                    try {
                        String titulo = partes[0].trim();
                        String descricao = partes[1].trim();
                        int prioridade = Integer.parseInt(partes[2].trim());
                        boolean status = Boolean.parseBoolean(partes[3].trim());

                        Tarefa t = new Tarefa(titulo, descricao, prioridade);
                        if (status) t.concluir();
                        tarefas.add(t);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Prioridade inválida na linha: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Tarefa tarefa : tarefas) {
                bw.write(tarefa.getTitulo() + "|" +
                        tarefa.getDescricao() + "|" +
                        tarefa.getPrioridade() + "|" +
                        tarefa.isConcluida());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}
