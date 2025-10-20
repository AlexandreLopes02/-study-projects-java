package br.pratica.iniciante.level2;


import java.util.Arrays;
import java.util.Scanner;

public class ContadorDePalavras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String fraseUsuario = scanner.nextLine();

        String[] palavras = fraseUsuario.trim().split("\\s+"); // evita contar espaços duplos
        int quantidadePalavras = palavras.length;
        int quantidadeCaracteres = fraseUsuario.replace(" ", "").length(); // ignora espaços

        System.out.println("\nFrase separada: " + Arrays.toString(palavras));
        System.out.println("Número de caracteres (sem espaços): " + quantidadeCaracteres);
        System.out.println("Número de palavras: " + quantidadePalavras);

        scanner.close();
    }
}
