package com.example.spotgridfds.domain;

public class Cliente {
    private Long codigoCliente;
    private String nomeCliente;
    private String emailCliente;

    public Cliente(Long codigoCliente, String nomeCliente, String emailCliente) {
        this.codigoCliente = codigoCliente;
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
    }

    public Cliente() {};

    public Long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Long codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
