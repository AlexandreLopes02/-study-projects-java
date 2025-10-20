package br.pratica.iniciante.level5.bibliotecavirtual;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final List<Livro> livros = new ArrayList<>();
    private static final String ARQUIVO = "biblioteca.txt";

    public Biblioteca() {
        carregarArquivo();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        salvarArquivo();
        System.out.println("✅ Livro adicionado com sucesso!");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("📚 Nenhum livro cadastrado na biblioteca.");
        } else {
            System.out.println("\n---- Lista de Livros ----");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println((i + 1) + " - " + livros.get(i));
            }
        }
    }

    public void buscarLivro(String termo) {
        if (livros.isEmpty()) {
            System.out.println("A biblioteca está vazia. Adicione livros primeiro.");
            return;
        }

        boolean encontrado = false;
        for (Livro livro : livros) {
            if (livro.getTitulo().toLowerCase().contains(termo.toLowerCase()) ||
                    livro.getAutor().toLowerCase().contains(termo.toLowerCase())) {
                System.out.println("📗 Livro encontrado: " + livro);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("⚠️ Nenhum livro encontrado com o termo: " + termo);
        }
    }

    public void removerLivro(String titulo) {
        boolean removido = livros.removeIf(l -> l.getTitulo().equalsIgnoreCase(titulo));

        if (removido) {
            salvarArquivo();
            System.out.println("🗑️ Livro removido com sucesso!");
        } else {
            System.out.println("⚠️ Livro não encontrado.");
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
                        livros.add(new Livro(titulo, autor, ano));
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Ano inválido na linha: " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao carregar o arquivo: " + e.getMessage());
        }
    }

    private void salvarArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Livro livro : livros) {
                bw.write(livro.getTitulo() + "|" + livro.getAutor() + "|" + livro.getAno());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}


