package br.pratica.iniciante.level3.bank;

import java.util.Scanner;

public class Account {

    private String titular;
    private Double saldo;
    Scanner scanner = new Scanner(System.in);

    public Account(String titular, double saldo){
        this.titular = titular;
        this.saldo = saldo;
    }

    public void menu(){
        var opcao = -1;
        while (opcao != 0){
            System.out.println("\n---- Menu da Conta ----");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Exibir informações");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> depositar();
                case 2 -> sacar();
                case 3 -> exibir();
                case 0 -> System.out.println("Finalizando seu acesso...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    public void depositar(){
        System.out.println("Qual valor deseja depositar: ");
        var valor = scanner.nextDouble();
        if (valor > 0) {
            saldo += valor;
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(){
        System.out.println("Qual valor deseja sacar: ");
        var valor = scanner.nextDouble();
        if(valor <= saldo){
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente! Você tem: R$" + saldo);
        }
    }

    public void exibir(){
        System.out.println("Titular da conta: " + titular);
        System.out.println("Saldo em conta R$" + saldo);
    }
}
