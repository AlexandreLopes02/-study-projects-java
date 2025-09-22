package br.pratica.iniciante.level3.student;

public class Student {
    String nome;
    double nota1;
    double nota2;
    double nota3;

    public Student(String nome, double nota1, double nota2, double nota3){
        this.nome = nome;
        this.nota1 = validarNota(nota1);
        this.nota2 = validarNota(nota2);
        this.nota3 = validarNota(nota3);
    }

    private double validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            System.out.println("⚠ Nota inválida (" + nota + "), ajustando para 0.");
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

    public void exibirInfo() {
        System.out.printf("Aluno: %s%nMédia: %.2f%nSituação: %s%n%n",
                nome, calcularMedia(), verificarSituacao());
    }

}
