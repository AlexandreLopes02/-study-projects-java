package br.pratica.iniciante.level3.estudante;

public class Estudante {
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;

    public Estudante(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = validarNota(nota1);
        this.nota2 = validarNota(nota2);
        this.nota3 = validarNota(nota3);
    }

    private double validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            System.out.printf("⚠️ Nota inválida (%.2f). Ajustada para 0.%n", nota);
            return 0;
        }
        return nota;
    }

    public double calcularMedia() {
        return (nota1 + nota2 + nota3) / 3;
    }

    public String verificarSituacao() {
        double media = calcularMedia();
        if (media >= 7) {
            return "APROVADO";
        } else if (media < 5) {
            return "REPROVADO";
        } else {
            return "RECUPERAÇÃO";
        }
    }

    public void exibirInformacoes() {
        System.out.println("------ Dados do Aluno ------");
        System.out.printf("Nome: %s%n", nome);
        System.out.printf("Média: %.2f%n", calcularMedia());
        System.out.println("Situação: " + verificarSituacao());
        System.out.println("-----------------------------\n");
    }

}
