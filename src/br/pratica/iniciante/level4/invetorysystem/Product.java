package br.pratica.iniciante.level4.invetorysystem;

public class Product {
    private String nome;
    private Integer quantidade;
    private double preco;

    public Product(String nome, Integer quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getTotal(){
        return quantidade * preco;
    }

    @Override
    public String toString() {
        return String.format("Produtos: %s | Quantidade: %d | Preço: R$%.2f | Total: R$%.2f",nome,quantidade, preco, getTotal());
    }
}
