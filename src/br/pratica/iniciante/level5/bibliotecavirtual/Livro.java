package br.pratica.iniciante.level5.bibliotecavirtual;

public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
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

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return String.format("📖 Título: %s | Autor: %s | Ano: %d", titulo, autor, ano);
    }
}
