package br.pratica.iniciante.level2;


import java.util.Arrays;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase");
        String usuario = scanner.nextLine();
        String[] frase = usuario.split(" ");
        System.out.println(Arrays.toString(frase));
        int tamanho = frase.length;
        int caracteres = usuario.length();

        System.out.println("Número de caracteres: " + caracteres);
        System.out.println("Número de palavras: " + tamanho);

        scanner.close();
    }
}
