package br.pratica.iniciante.level6.agendaavancada;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Agenda {

    private final List<Contato> contatos = new ArrayList<>();
    private static final String ARQUIVO = "contatos.txt";

    public Agenda() {
        carregarContatos();
    }

    public void adicionarContato(Contato contato) {
        for (Contato c : contatos) {
            if (c.getTelefone().equals(contato.getTelefone())) {
                System.out.println("⚠️ Já existe um contato com esse telefone!");
                return;
            }
        }
        contatos.add(contato);
        salvarContatos();
        System.out.println("✅ Contato adicionado com sucesso!");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("📭 A agenda está vazia.");
            return;
        }

        Collections.sort(contatos);
        System.out.println("\n---- Lista de Contatos ----");
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }

    public void buscarContatos(String termo) {
        if (contatos.isEmpty()) {
            System.out.println("📭 A agenda está vazia.");
            return;
        }

        boolean encontrado = false;
        for (Contato contato : contatos) {
            if (contato.getNome().toLowerCase().contains(termo.toLowerCase()) ||
                    contato.getTelefone().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println("🔎 Contato encontrado: " + contato);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("❌ Nenhum contato encontrado com o termo: " + termo);
        }
    }

    public Contato buscarContatoExato(String termo) {
        for (Contato contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(termo) ||
                    contato.getTelefone().equalsIgnoreCase(termo)) {
                return contato;
            }
        }
        return null;
    }

    public void atualizarContato(String chave, int novoId, String novoNome, String novoTelefone, String novoEmail) {
        Contato contato = buscarContatoExato(chave);
        if (contato != null) {
            contato.setId(novoId);
            contato.setNome(novoNome);
            contato.setTelefone(novoTelefone);
            contato.setEmail(novoEmail);
            salvarContatos();
            System.out.println("🔄 Contato atualizado com sucesso!");
        } else {
            System.out.println("❌ Contato não encontrado!");
        }
    }

    public void removerContato(String nome) {
        boolean removido = contatos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
        if (removido) {
            salvarContatos();
            System.out.println("🗑️ Contato removido com sucesso!");
        } else {
            System.out.println("⚠️ Contato não encontrado.");
        }
    }

    private void carregarContatos() {
        File file = new File(ARQUIVO);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                if (partes.length == 4) {
                    try {
                        int id = Integer.parseInt(partes[0].trim());
                        String nome = partes[1].trim();
                        String telefone = partes[2].trim();
                        String email = partes[3].trim();
                        contatos.add(new Contato(id, nome, telefone, email));
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Linha inválida: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao carregar contatos: " + e.getMessage());
        }
    }

    private void salvarContatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Contato contato : contatos) {
                bw.write(contato.getId() + "|" +
                        contato.getNome() + "|" +
                        contato.getTelefone() + "|" +
                        contato.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar contatos: " + e.getMessage());
        }
    }
}
