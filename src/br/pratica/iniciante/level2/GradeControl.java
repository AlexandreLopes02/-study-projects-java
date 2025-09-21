package br.pratica.iniciante.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeControl {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Double> notas = new ArrayList<>();

        System.out.println("Digite as notas dos alunos (digite um número negativo para encerrar");
        while (true) {
            double nota = scanner.nextDouble();
            if (nota < 0) {
                break;
            }
            notas.add(nota);
        }

        if (notas.isEmpty()){
            System.out.println("Minha lista está vazia");
        } else {
            double soma = 0;
            for (double n : notas){
                soma += n;
            }
            double media = 0;
            media = soma / notas.size();
            System.out.println("\nA media foi: "+ media + "\n");

            if (media >= 7){
                System.out.println("Situação: APROVADO!");
            } else if (media < 5){
                System.out.println("Situação: REPROVADO!");
            } else {
                System.out.println("Situação: RECUPERAÇÃO!");
            }
        }
    }
}

