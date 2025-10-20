package br.pratica.iniciante.level6.agendaavancada;

import java.io.Serializable;

public class Contato implements Serializable, Comparable<Contato> {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Contato(int id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Nome: %s | Telefone: %s | E-mail: %s",
                id, nome, telefone, email);
    }

    @Override
    public int compareTo(Contato outro) {
        return this.nome.compareToIgnoreCase(outro.getNome());
    }
}
