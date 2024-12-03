package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

public abstract class Disciplina {
    private String nome;
    private TipoDisciplina tipo;

    public Disciplina(String nome, TipoDisciplina tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public abstract void detalhesDisciplina();
}