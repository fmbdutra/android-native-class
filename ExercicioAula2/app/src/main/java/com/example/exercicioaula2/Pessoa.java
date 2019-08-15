package com.example.exercicioaula2;

public class Pessoa {

    private String nome;
    private Boolean isSolteiro;
    private Boolean isCasado;
    private Boolean isViuvo;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Boolean getSolteiro() {
        return isSolteiro;
    }

    public void setSolteiro(Boolean solteiro) {
        isSolteiro = solteiro;
    }

    public Boolean getCasado() {
        return isCasado;
    }

    public void setCasado(Boolean casado) {
        isCasado = casado;
    }

    public Boolean getViuvo() {
        return isViuvo;
    }

    public void setViuvo(Boolean viuvo) {
        isViuvo = viuvo;
    }
}
