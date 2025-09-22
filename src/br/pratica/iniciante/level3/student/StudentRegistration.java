package br.pratica.iniciante.level3.student;

public class StudentRegistration {
    public static void main(String[] args) {

        Student a1 = new Student("Heitor", 5.5, 7.8, 9.2);
        Student a2 = new Student("Sofia", 4.5, 8.9, 9.2);

        a1.exibirInfo();
        a2.exibirInfo();
    }
}
