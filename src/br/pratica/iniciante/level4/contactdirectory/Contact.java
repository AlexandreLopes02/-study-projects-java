package br.pratica.iniciante.level4.contactdirectory;

public class Contact {


    private String nome;
    private String telefone;
    private String email;

    public Contact(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Telefone: %s | Email: %s",
                nome, telefone, email);
    }
}
