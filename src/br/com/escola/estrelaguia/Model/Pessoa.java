package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoPessoa;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private TipoPessoa tipo;

    public Pessoa(String nome, String cpf, TipoPessoa tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public abstract void exibirDados();
}