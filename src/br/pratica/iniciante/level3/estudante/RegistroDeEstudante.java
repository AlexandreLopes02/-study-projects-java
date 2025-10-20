package br.pratica.iniciante.level3.estudante;

public class RegistroDeEstudante {
    public static void main(String[] args) {

        Estudante aluno1 = new Estudante("Heitor", 5.5, 7.8, 9.2);
        Estudante aluno2 = new Estudante("Sofia", 4.5, 8.9, 9.2);

        aluno1.exibirInformacoes();
        aluno2.exibirInformacoes();
    }
}
