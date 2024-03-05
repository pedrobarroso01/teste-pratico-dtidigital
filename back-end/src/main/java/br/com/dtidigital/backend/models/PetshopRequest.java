package br.com.dtidigital.backend.models;

public class PetshopRequest {
    private String data;
    private int qtdPequenos;
    private int qtdGrandes;

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getQtdPequenos() {
        return qtdPequenos;
    }
    public void setQtdPequenos(int qtdPequenos) {
        this.qtdPequenos = qtdPequenos;
    }
    public int getQtdGrandes() {
        return qtdGrandes;
    }
    public void setQtdGrandes(int qtdGrandes) {
        this.qtdGrandes = qtdGrandes;
    }

}

