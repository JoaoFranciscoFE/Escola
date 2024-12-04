package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

import java.util.List;

public abstract class Disciplina {
    private String nome;
    private TipoDisciplina tipo;
    private List<Nota> notas;

    public Disciplina(String nome, TipoDisciplina tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarNota(Nota nota) {
        this.notas.add(nota);
    }

    public abstract void detalhesDisciplina ();
}