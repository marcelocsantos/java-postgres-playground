package com.example.model;

public class Estado {

    private Long id;
    private String nome;
    private String UF;
    private RegiaoGeografica regiaoGeografica;
    private int areaKm2;
    private int populacao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUF() {
        return UF;
    }
    public void setUF(String uF) {
        UF = uF;
    }
    public RegiaoGeografica getRegiaoGeografica() {
        return regiaoGeografica;
    }
    public void setRegiaoGeografica(RegiaoGeografica regiaoGeografica) {
        this.regiaoGeografica = regiaoGeografica;
    }
    public int getArea() {
        return areaKm2;
    }
    public void setArea(int area) {
        this.areaKm2 = area;
    }
    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    };   
    
}
