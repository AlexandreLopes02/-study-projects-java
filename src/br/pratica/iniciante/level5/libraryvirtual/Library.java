package br.pratica.iniciante.level5.libraryvirtual;

import java.io.*;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();

    private static final String ARQUIVO = "biblioteca.txt";

    public Library() {
        carregarArquivo();
    }

    public void adicionarLivro(Book book){
        books.add(book);
        salvarArquivo();
        System.out.println("Livro adicionado com sucesso");
    }

    public void listarLivros(){
        if (books.isEmpty()){
            System.out.println("Biblioteca vazia!");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + " - " + books.get(i));
            }
        }
    }

    public void buscarLivro(String termo){
        if (books.isEmpty()) {
            System.out.println("Biblioteca vazia! Favor adicionar livro.");
            return;
        }

        boolean encontrado = false;
        for (Book book : books) {
            if (book.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                    book.getAutor().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println("Livro encontrado: " + book);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o termo: " + termo);
        }
    }

    public void removerLivro(String titulo){
        boolean removido = books.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));
        if (removido) {
            salvarArquivo();
            System.out.println("✅ Livro removido com sucesso!");
        } else {
            System.out.println("⚠ Livro não encontrado.");
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
                if (partes.length == 3) {
                    try {
                        String titulo = partes[0].trim();
                        String autor = partes[1].trim();
                        int ano = Integer.parseInt(partes[2].trim());
                        books.add(new Book(titulo, autor, ano));
                    } catch (NumberFormatException e) {
                        System.out.println("⚠ Ano inválido na linha: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Book livro : books) {
                bw.write(livro.getTitulo() + "|" + livro.getAutor() + "|" + livro.getAno());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}


