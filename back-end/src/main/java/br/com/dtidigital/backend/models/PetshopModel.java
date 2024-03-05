package br.com.dtidigital.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "petshops")
@Table(name="petshops")
public class PetshopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int distancia;
    @Column(name = "precopequeno")
    private double precoPequeno;
    @Column(name = "precogrande")
    private double precoGrande;
    @Column(name = "precopequenofds")
    private Double precoPequenoFDS = 0.0;
    @Column(name = "precograndefds")
    private Double precoGrandeFDS = 0.0;



    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getDistancia() {
        return distancia;
    }
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    public double getPrecoPequeno() {
        return precoPequeno;
    }
    public void setPrecoPequeno(double precoPequeno) {
        this.precoPequeno = precoPequeno;
    }
    public double getPrecoGrande() {
        return precoGrande;
    }
    public void setPrecoGrande(double precoGrande) {
        this.precoGrande = precoGrande;
    }
    public double getPrecoPequenoFDS() {
        return precoPequenoFDS;
    }
    public void setPrecoPequenoFDS(double precoPequenoFDS) {
        this.precoPequenoFDS = precoPequenoFDS;
    }
    public double getPrecoGrandeFDS() {
        return precoGrandeFDS;
    }
    public void setPrecoGrandeFDS(double precoGrandeFDS) {
        this.precoGrandeFDS = precoGrandeFDS;
    }  
      
}
