package com.example.spotgridfds.domain;

import java.util.Date;

public class Assinatura {
    private Long codigoAssinatura;
    private App appAssinatura;
    private Cliente clienteAssinatura;
    private Date inicioVigencia;
    private Date fimVigencia;

    public Assinatura(Long codigoAssinatura, App appAssinatura, Cliente clienteAssinatura, Date inicioVigencia, Date fimVigencia) {
        this.codigoAssinatura = codigoAssinatura;
        this.appAssinatura = appAssinatura;
        this.clienteAssinatura = clienteAssinatura;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Assinatura() {};

    public Long getCodigoAssinatura() {
        return codigoAssinatura;
    }

    public void setCodigoAssinatura(Long codigoAssinatura) {
        this.codigoAssinatura = codigoAssinatura;
    }

    public App getAppAssinatura() {
        return appAssinatura;
    }

    public void setAppAssinatura(App appAssinatura) {
        this.appAssinatura = appAssinatura;
    }

    public Cliente getClienteAssinatura() {
        return clienteAssinatura;
    }

    public void setClienteAssinatura(Cliente clienteAssinatura) {
        this.clienteAssinatura = clienteAssinatura;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(Date fimVigencia) {
        this.fimVigencia = fimVigencia;
    }
}
