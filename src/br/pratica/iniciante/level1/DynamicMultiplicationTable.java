package br.pratica.iniciante.level1;

import java.util.Scanner;

public class DynamicMultiplicationTable {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o numero que deseja saber a tabuada↓↓↓");
        int numero = leitura.nextInt();

        System.out.println("Tabuada do " + numero + ": ");

        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " * " + i +" = " + resultado);
        }

        leitura.close();
    }
}
