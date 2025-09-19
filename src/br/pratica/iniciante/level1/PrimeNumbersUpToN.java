package br.pratica.iniciante.level1;

import java.util.Scanner;

public class PrimeNumbersUpToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o numero:");
        int num = scanner.nextInt();

        if (num <= 0){
            System.out.println("O número 0 e os números negativos não são primos");
        } if (num % 2 == 0){
            System.out.println("O numero "+ num + " não é um numero primo!");
        } else {
            System.out.println("O numero " + num + " é um numero primo!");
        }
    }
}
