package br.pratica.iniciante.level4.sistemadeestoque;

public class Produto {
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getValorTotal() {
        return quantidade * preco;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s | Quantidade: %d | Preço: R$%.2f | Total: R$%.2f",
                nome, quantidade, preco, getValorTotal());
    }
}
