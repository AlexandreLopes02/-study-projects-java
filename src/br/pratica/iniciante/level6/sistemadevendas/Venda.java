package br.pratica.iniciante.level6.sistemadevendas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Venda {

    private List<Produto> produtosVendidos = new ArrayList<>();
    private double total;
    private LocalDateTime dataHora;

    public Venda() {
        this.dataHora = LocalDateTime.now();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        Produto vendido = new Produto(produto.getId(), produto.getNome(), produto.getPreco(), quantidade);
        produtosVendidos.add(vendido);
        total += produto.getPreco() * quantidade;
    }


    public double getTotal() {
        return total;
    }

    public String getDataHoraFormatada() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(fmt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("🧾 Venda em ").append(getDataHoraFormatada()).append("\n");
        for (Produto p : produtosVendidos) {
            sb.append("- ").append(p.getNome()).append(" (x").append(p.getQuantidade())
                    .append(") R$ ").append(String.format("%.2f", p.getPreco() * p.getQuantidade())).append("\n");
        }
        sb.append("💰 Total: R$ ").append(String.format("%.2f", total)).append("\n");
        return sb.toString();
    }

    // ======== MÉTODOS PARA ARQUIVO ========

    public String exportarParaArquivo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getDataHoraFormatada()).append(";");
        for (Produto p : produtosVendidos) {
            sb.append(p.getNome()).append(",").append(p.getQuantidade())
                    .append(",").append(p.getPreco()).append("|");
        }
        sb.append(total);
        return sb.toString();
    }

    public static Venda importarDeArquivo(String linha) {
        try {
            if (!linha.contains(";")) return null;

            String[] partes = linha.split(";");
            String data = partes[0];
            String produtosStr = partes[1];
            String[] produtosSplit = produtosStr.split("\\|");

            Venda venda = new Venda();
            venda.dataHora = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

            for (int i = 0; i < produtosSplit.length - 1; i++) {
                String[] info = produtosSplit[i].split(",");
                if (info.length == 3) {
                    String nome = info[0];
                    int qtd = Integer.parseInt(info[1]);
                    double preco = Double.parseDouble(info[2]);
                    venda.produtosVendidos.add(new Produto(0, nome, preco, qtd));
                }
            }

            venda.total = Double.parseDouble(produtosSplit[produtosSplit.length - 1]);
            return venda;
        } catch (Exception e) {
            System.out.println("⚠️ Erro ao importar venda: " + e.getMessage());
            return null;
        }
    }
}
