package br.com.escola.estrelaguia.Model;

public abstract class Avaliacao {
    protected String nome;
    protected double peso;

    public Avaliacao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public abstract double calcularNotaFinal();

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }
}
