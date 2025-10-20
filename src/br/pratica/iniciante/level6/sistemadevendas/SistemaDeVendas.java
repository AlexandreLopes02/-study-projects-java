package br.pratica.iniciante.level6.sistemadevendas;

import java.util.Scanner;

public class SistemaDeVendas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("""
                    \n===== SISTEMA DE VENDAS =====
                    1 - Cadastrar produto
                    2 - Listar estoque
                    3 - Realizar venda
                    4 - Exibir histórico de vendas
                    0 - Sair
                    """);
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    try {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome do produto: ");
                        String nome = scanner.nextLine();

                        System.out.print("Preço: ");
                        double preco = scanner.nextDouble();

                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();

                        if (quantidade <= 0) {
                            System.out.println("⚠️ Quantidade inválida! Deve ser maior que 0.");
                            break;
                        }

                        loja.cadastrarProduto(new Produto(id, nome, preco, quantidade));
                    } catch (Exception e) {
                        System.out.println("⚠️ Erro: " + e.getMessage());
                        scanner.nextLine();
                    }
                }
                case 2 -> loja.listarEstoque();
                case 3 -> {
                    loja.listarEstoque();
                    System.out.print("\nDigite o ID do produto: ");
                    int id = scanner.nextInt();
                    System.out.print("Digite a quantidade que deseja comprar: ");
                    int qtd = scanner.nextInt();
                    loja.realizarVenda(id, qtd);
                }
                case 4 -> loja.exibirHistoricoDeVendas();
                case 0 -> System.out.println("Encerrando o sistema de vendas...");
                default -> System.out.println("⚠️ Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
