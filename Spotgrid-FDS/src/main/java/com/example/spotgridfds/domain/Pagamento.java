package com.example.spotgridfds.domain;

import java.util.Date;

public class Pagamento {
    private static long codigoPagamentoControle = 0;
    private long codigoPagamento;
    private Assinatura assinatura;
    private double valorPagamento;
    private Date dataPagamento = new Date();
    private String promocao;

    public Pagamento(Assinatura assinatura, double valorPagamento, Date dataPagamento, String promocao) {
        this.codigoPagamento = codigoPagamentoControle++;
        this.assinatura = assinatura;
        this.valorPagamento = valorPagamento;
        this.dataPagamento = dataPagamento;
        if (promocao != null && !promocao.isEmpty()) {
            this.promocao = promocao;
        }
        this.promocao = "none";
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }
}
