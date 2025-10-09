package br.pratica.iniciante.level6.advancedagenda;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Agenda {

    ArrayList<Contact> contacts = new ArrayList<>();

    private static final String ARQUIVO = "contatos.txt";

    public Agenda() {
        carregarContatos();
    }

    public void adicionarContato(Contact contact) {
        for (Contact c : contacts) {
            if (c.getTelefone().equals(contact.getTelefone())) {
                System.out.println("⚠️ Já existe um contato com esse telefone!");
                return;
            }
        }
        contacts.add(contact);
        salvarContatos();
        System.out.println("✅ Contato adicionado com sucesso!");
    }

    public void listarContatos(){
        if( contacts.isEmpty()){
            System.out.println("Agenda vazia!");
            return;
        }
        Collections.sort(contacts);
        System.out.println("\nLista de contatos: ");
        for (Contact contact : contacts){
            System.out.println(contact);
        }
    }

    public void buscarContatos(String termo){
        if(contacts.isEmpty()){
            System.out.println("Contato não encrotado");
        }
        boolean encontrado = false;
        for (Contact contact : contacts) {
            if (contact.getNome().toLowerCase().contains(termo.toLowerCase()) ||
                    contact.getTelefone().toLowerCase().contains(termo.toLowerCase())){
                System.out.println("Contato encontrado: " + contact);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum contato foi encontrado com o termo: " + termo + "use apenas nome ou telefone!");
        }
    }

    public Contact buscarContatoExato(String termo) {
        for (Contact contact : contacts) {
            if (contact.getNome().equalsIgnoreCase(termo) ||
                    contact.getTelefone().equalsIgnoreCase(termo)) {
                return contact;
            }
        }
        return null;
    }


    public void atualizarContato(String chave, int novoId, String novoNome, String novoTelefone, String novoEmail) {
        Contact c = buscarContatoExato(chave);
        if (c != null) {
            c.setId(novoId);
            c.setNome(novoNome);
            c.setTelefone(novoTelefone);
            c.setEmail(novoEmail);
            salvarContatos();
            System.out.println("🔄 Contato atualizado com sucesso!");
        } else {
            System.out.println("❌ Contato não encontrado!");
        }
    }

    public void removerContato(String nome){
        boolean removido = contacts.removeIf(l -> l.getNome().equalsIgnoreCase(nome));
        if (removido) {
            salvarContatos();
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }


    private void carregarContatos() {
        File file = new File(ARQUIVO);
        if (!file.exists()) {
            return;
        }

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
                        Contact c = new Contact(id, nome, telefone, email);
                        contacts.add(c);
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ linha invalida " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao carregar contato: " + e.getMessage());
        }
    }

    private void salvarContatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Contact contact : contacts) {
                bw.write(contact.getId() + "|" +
                        contact.getNome() + "|" +
                        contact.getTelefone() + "|" +
                        contact.getEmail());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("⚠ Erro ao salvar contato: " + e.getMessage());
        }
    }
}
