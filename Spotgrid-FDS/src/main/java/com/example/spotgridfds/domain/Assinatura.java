package com.example.spotgridfds.domain;

import com.example.spotgridfds.config.AdminAcess;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

public class Assinatura {
    private static long codigoAssinaturaControle = 0;
    private long codigoAssinatura;
    private Aplicativo aplicativo;
    private Cliente cliente;
    private Date inicioVigencia;
    private Date fimVigencia;
    private boolean pago;

    private List<Pagamento> pagamentos = new ArrayList<Pagamento>();

    public Assinatura(Aplicativo aplicativo, Cliente cliente) {
        this.codigoAssinatura = codigoAssinaturaControle++;
        this.aplicativo = aplicativo;
        this.cliente = cliente;
        this.inicioVigencia = new Date();
        this.pago  = true;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inicioVigencia);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        this.fimVigencia = calendar.getTime();
    }

    public long getCodigoAssinatura() {
        return codigoAssinatura;
    }

    public Aplicativo getAplicativo() {
        return aplicativo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void updateVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inicioVigencia);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        this.fimVigencia = calendar.getTime();
    }

    public Date getFimVigencia() {
        return fimVigencia;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

   public void informaPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        pago = true;
   }
}
