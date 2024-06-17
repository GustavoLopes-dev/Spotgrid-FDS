package com.example.spotgridfds.domain;

public class App {
    private Long codigoApp;
    private String nomeApp;
    private double precoApp;

    public App(Long codigoApp, String nomeApp, double precoApp) {
        this.codigoApp = codigoApp;
        this.nomeApp = nomeApp;
        this.precoApp = precoApp;
    }

    public App() {};

    public Long getCodigoApp() {
        return codigoApp;
    }

    public void setCodigoApp(Long codigoApp) {
        this.codigoApp = codigoApp;
    }

    public String getNomeApp() {
        return nomeApp;
    }

    public void setNomeApp(String nomeApp) {
        this.nomeApp = nomeApp;
    }

    public double getPrecoApp() {
        return precoApp;
    }

    public void setPrecoApp(double precoApp) {
        this.precoApp = precoApp;
    }
}
