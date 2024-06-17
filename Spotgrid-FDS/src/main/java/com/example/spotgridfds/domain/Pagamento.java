package com.example.spotgridfds.domain;

import java.util.Date;

public class Pagamento {
    private Long codigoPagamento;
    private Assinatura assinaturaPaga;
    private double valorPago;
    private Date dataPagamento;
    private String promocaoPagamento;

    public Pagamento(Long codigoPagamento, Assinatura assinaturaPaga,
                     double valorPago, Date dataPagamento, String promocaoPagamento) {
        this.codigoPagamento = codigoPagamento;
        this.assinaturaPaga = assinaturaPaga;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocaoPagamento = promocaoPagamento;
    }

    public Pagamento () {};

    public Long getCodigoPagamento() {
        return codigoPagamento;
    }

    public void setCodigoPagamento(Long codigoPagamento) {
        this.codigoPagamento = codigoPagamento;
    }

    public Assinatura getAssinaturaPaga() {
        return assinaturaPaga;
    }

    public void setAssinaturaPaga(Assinatura assinaturaPaga) {
        this.assinaturaPaga = assinaturaPaga;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getPromocaoPagamento() {
        return promocaoPagamento;
    }

    public void setPromocaoPagamento(String promocaoPagamento) {
        this.promocaoPagamento = promocaoPagamento;
    }
}
