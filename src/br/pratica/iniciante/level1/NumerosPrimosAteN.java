package br.pratica.iniciante.level1;

import java.util.Scanner;

public class NumerosPrimosAteN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        if (numero <= 1) {
            System.out.println("O número " + numero + " não é primo.");
        } else {
            boolean primo = true;

            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                System.out.println("O número " + numero + " é primo!");
            } else {
                System.out.println("O número " + numero + " não é primo!");
            }
        }
    }
}
