package com.example.model;

public class Cliente {
    private double renda;
    private char sexo;
    private int anoNascimento;
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }    

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        this.renda = renda;
    }


 }