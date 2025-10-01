package br.pratica.iniciante.level5.libraryvirtual;

public class Book {
    private String titulo;
    private String autor;
    private int ano;

    public Book(String titulo, String autor, Integer ano) {
        this.titulo = titulo.trim();
        this.autor = autor.trim();
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return String.format("Título: %s | Autor: %s | Ano: %d", titulo, autor, ano);
    }
}
