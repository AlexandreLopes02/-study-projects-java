package br.pratica.iniciante.level6.salessystem;

import java.util.Scanner;

public class SalesSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Store store = new Store();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    \n===== SISTEMA DE VENDAS =====
                    1 - Cadastrar produto
                    2 - Listar estoque
                    3 - Realizar venda
                    4 - Exibir histórico de vendas
                    0 - Sair
                    
                    Escolha uma opção:
                    """);
            System.out.print("> ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    try {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Preço: ");
                        double preco = scanner.nextDouble();
                        System.out.print("Quantidade: ");
                        int qtd = scanner.nextInt();

                        if (qtd <= 0) {
                            System.out.println("⚠ Quantidade inválida! Deve ser maior que 0.");
                            break;
                        }

                        store.cadastrarProduto(new Product(id, nome, preco, qtd));
                    } catch (Exception e) {
                        System.out.println("⚠ Erro: " + e.getMessage());
                        scanner.nextLine();
                    }
                }
                case 2 -> store.listarEstoque();
                case 3 -> {
                    store.listarEstoque();
                    System.out.print("\nDigite o ID do produto: ");
                    int id = scanner.nextInt();
                    System.out.print("Digite a quantidade que deseja comprar: ");
                    int qtd = scanner.nextInt();
                    store.venderProduto(id, qtd);
                }
                case 4 -> store.exibirHistoricoVendas();
                case 0 -> System.out.println("Encerrando o sistema de vendas...");
                default -> System.out.println("⚠ Opção inválida!");
            }
        }
        scanner.close();
    }
}
