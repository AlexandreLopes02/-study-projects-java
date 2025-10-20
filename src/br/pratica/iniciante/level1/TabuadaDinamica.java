package br.pratica.iniciante.level1;

import java.util.Scanner;

public class TabuadaDinamica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número que deseja ver a tabuada ↓↓↓");
        int numero = scanner.nextInt();

        System.out.println("\nTabuada do " + numero + ":");

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        scanner.close();
    }
}
