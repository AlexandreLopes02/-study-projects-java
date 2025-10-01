package br.pratica.iniciante.level5.todolist;

public class Task {

    private String titulo;
    private String descricao;
    private int prioridade; // 1 = baixa , 5 = alta
    private boolean concluida;

    public Task(String titulo, String descricao, int prioridade) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public void concluir(){
        this.concluida = true;

    }



    @Override
    public String toString() {
        String statusTexto = concluida ? "Concluída ✅" : "Pendente ⏳";
        return String.format("Tarefa: %s | Descrição: %s | Prioridade: %d | Status: %s",
                titulo, descricao, prioridade, statusTexto);
    }

}
