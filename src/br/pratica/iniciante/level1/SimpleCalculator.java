package br.pratica.iniciante.level1;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultado;
        int opcao = -1;

        while (opcao != 0){
            System.out.println("""
                ↓↓↓ Opções ↓↓↓
                1 - Soma
                2 - Subtrair
                3 - Multiplicar
                4 - Dividir
                
                0 - Sair
                """);

            System.out.println("Escolha a opção");
            opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Fechando a calculadora...");
                break;
            }

            System.out.println("Digite o primeiro numero: ");
            int n1 = scanner.nextInt();
            System.out.println("Digite o segundo numero: ");
            int n2 = scanner.nextInt();

            switch (opcao){
                case 1 -> {
                    resultado = n1 + n2;
                    System.out.println("Resultado da soma: " + resultado + "\n");
                }
                case 2 -> {
                    resultado = n1 - n2;
                    System.out.println("Resultado da subtração: " + resultado + "\n");
                }
                case 3 -> {
                    resultado = n1 * n2;
                    System.out.println("Resultado da multiplicação: " + resultado + "\n");
                }
                case 4 -> {
                    if (n2 == 0) {
                        System.out.println("Erro: não é possível dividir por zero!");
                    } else {
                        resultado = n1 / n2;
                        System.out.println("Resultado da divisão: " + resultado + "\n");
                    }
                }
                default -> System.out.println("Opção inválida!");

            }
        }
    }
}