package com.example.spotgridfds.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
    private static long codigoClienteControle = 0;
    private long codigoCliente;
    private String nomeCliente;
    private String emailCliente;

    public Cliente (String nomeCliente, String email) {
        this.codigoCliente = codigoClienteControle++;
        this.nomeCliente = nomeCliente;
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.emailCliente = email;
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public long getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(long codigoCliente) {
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
        if (!isValidEmail(emailCliente)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.emailCliente = emailCliente;
    }
}
