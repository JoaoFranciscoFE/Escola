package br.com.escola.estrelaguia.Model;

public abstract class Avaliacao {
    private String nome;
    private double peso;

    public Avaliacao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public abstract double calcularNota();

    public double getNotaFinal() {
        return calcularNota() * peso;
    }
}
