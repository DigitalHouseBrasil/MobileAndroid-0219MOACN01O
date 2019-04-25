package com.br.digitalhouse;

public class Conta {
    private float valor;

    public Conta(float valor){
        this.valor = valor;
    }

    public void sacar(float valor){
        this.valor = this.valor - valor;

    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
