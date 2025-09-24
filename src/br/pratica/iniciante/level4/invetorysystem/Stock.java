package br.pratica.iniciante.level4.invetorysystem;

import java.util.ArrayList;

public class Stock {

    private final ArrayList<Product> produtos = new ArrayList<>();

    public void adicionarP(Product p){
        produtos.add(p);
        System.out.println("Produto adicionado!");
    }

    public void removerP(String nome){
        boolean removido = produtos.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
        if (removido){
        System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encrontado. Digite o nome de um produto que tenha registrado!");
        }
    }

    public void listarP(){
        if(produtos.isEmpty()){
            System.out.println("Nenhum produto na cadastrado!");
        } else {
            System.out.println("Produtos cadastrado: ");
            for (Product p : produtos){
                System.out.println(p);
            }
        }
    }

    public void valorTotEmEstoque(){
        double total = 0;
        for (Product p : produtos){
            total += p.getTotal();
        }
        System.out.printf("Valor total do estoque: R$%.2f%n" , total);
    }
}
