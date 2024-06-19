package com.example.spotgridfds.domain;

import com.example.spotgridfds.config.AdminAcess;

public class Aplicativo {
    private AdminAcess adminAcess = new AdminAcess();
    private static long codigoAppControle = 0;
    private long codigoApp;
    private String nomeApp;
    private double custoAppMensal;

    public Aplicativo (String nomeApp, double custoAppMensal) {
        this.nomeApp        = nomeApp;
        this.custoAppMensal = custoAppMensal;
        this.codigoApp = codigoAppControle++;
    }

    public long getCodigoApp() {
        return codigoApp;
    }

    public String getNomeApp() {
        return nomeApp;
    }

    public double getCustoAppMensal() {
        return custoAppMensal;
    }

    public boolean setNomeApp(String passAdmin, String novoNome) {
        if (passAdmin != null && passAdmin.equals(getAdminKey())) {
            this.nomeApp = novoNome;
            return true;
        } else {
            return false;
        }
    }

    public String getAdminKey() {
        return adminAcess.getAdminPass();
    }
}
