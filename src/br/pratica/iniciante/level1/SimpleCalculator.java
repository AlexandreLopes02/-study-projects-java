package br.pratica.iniciante.level1;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        int resultado;
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****Calculadora Simples*****" +
                "\n↓↓↓Opções↓↓↓" +
                "\n1 - Soma" +
                "\n2 - Subtrair" +
                "\n3 - Multiplicar" +
                "\n4 - Dividir" +
                "\nOBS: SÓ É POSSIVEL FAZER UMA FUNÇÃO POR VEZ!" +
                "\n");
        System.out.println("Digite o primeiro numero: ");
        int n1 = scanner.nextInt();
        System.out.println("Digite o segundo numero: ");
        int n2 = scanner.nextInt();
        System.out.println("Qual função deseja seguir com os numero " + n1 + " e " + n2 + " que informou: ");
        int opção = scanner.nextInt();
        if (opção == 1) {
            resultado = n1 + n2;
            System.out.println("A soma dos " + n1 + " + " + n2 + " = " + resultado);
        }else if (opção == 2) {
            resultado = n1 - n2;
            System.out.println("A subtração dos " + n1 + " - " + n2 + " = " + resultado);
        } else if (opção == 3) {
            resultado = n1 * n2;
            System.out.println("A multiplicação dos " + n1 + " * " + n2 + " = " + resultado);
        } else if (opção == 4){
            resultado = n1 / n2;
            System.out.println("A divisão dos " + n1 + " / " + n2 + " = " + resultado);
        } else {
            System.out.println("ERRO! numero invalido tentar rodar novamente");
        }
    }
}
