package br.pratica.iniciante.level4.agendadecontato;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void removerContato(String nome) {
        Contato contatoRemovido = null;

        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contatoRemovido = c;
                break;
            }
        }

        if (contatoRemovido != null) {
            contatos.remove(contatoRemovido);
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    public void buscarContato(String nome) {
        boolean encontrado = false;
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                c.exibirInformacoes();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("\n---- Lista de Contatos ----");
            for (Contato c : contatos) {
                c.exibirInformacoes();
            }
        }
    }
}
