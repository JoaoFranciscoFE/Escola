package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoNota;

import java.time.LocalDate;

public class Nota {
    private double valor;
    private TipoNota tipo;

    public Nota(double valor, TipoNota tipo, LocalDate dataCadastro, String observacao, Disciplina disciplinaAssociada, Aluno aluno) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public TipoNota getTipo() {
        return tipo;
    }

}
