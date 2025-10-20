package br.pratica.iniciante.level3.banco;

import java.util.Scanner;

public class Conta {

    private String titular;
    private double saldo;
    Scanner scanner = new Scanner(System.in);

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void menu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n---- Menu da Conta ----");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir informações");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> depositar();
                case 2 -> sacar();
                case 3 -> exibirInformacoes();
                case 0 -> System.out.println("Encerrando o acesso à conta...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    public void depositar() {
        System.out.print("Digite o valor que deseja depositar: ");
        double valor = scanner.nextDouble();

        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$%.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar() {
        System.out.print("Digite o valor que deseja sacar: ");
        double valor = scanner.nextDouble();

        if (valor > saldo) {
            System.out.printf("Saldo insuficiente! Você possui R$%.2f em conta.%n", saldo);
        } else if (valor <= 0) {
            System.out.println("Valor inválido para saque!");
        } else {
            saldo -= valor;
            System.out.printf("Saque de R$%.2f realizado com sucesso!%n", valor);
        }
    }

    public void exibirInformacoes() {
        System.out.println("\n---- Informações da Conta ----");
        System.out.println("Titular: " + titular);
        System.out.printf("Saldo atual: R$%.2f%n", saldo);
    }
}
