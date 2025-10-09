package br.pratica.iniciante.level6.salessystem;

public class Product {

    private int id;
    private String nome;
    private double preco;
    private int quantidade;

    public Product(int id, String nome, double preco, int quantidade) {
        if (id < 0 || preco < 0 || quantidade < 0){
            throw new IllegalArgumentException("Valores negativos não são permitidos!");
        }
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0){
            throw new IllegalArgumentException("Valores negativos não são permitidos!");
        }
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("Id: %d | Nome: %s | Preço: %.2f | Quantidade: %d",
                id, nome, preco, quantidade);
    }
}
