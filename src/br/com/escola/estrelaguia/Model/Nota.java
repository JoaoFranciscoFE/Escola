package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoNota;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nota {
    private double valor;
    private TipoNota tipo;
    private LocalDate dataCadastro;
    private String observacao;
    private Disciplina disciplinaAssociada;
    private Aluno aluno;

    public Nota(double valor, TipoNota tipo, LocalDate dataCadastro, String observacao, Disciplina disciplinaAssociada, Aluno aluno) {
        this.valor = valor;
        this.tipo = tipo;
        this.dataCadastro = dataCadastro;
        this.observacao = observacao;
        this.disciplinaAssociada = disciplinaAssociada;
        this.aluno = aluno;
    }

    public double getValor() {
        return valor;
    }

    public TipoNota getTipo() {
        return tipo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplinaAssociada() {
        return disciplinaAssociada;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public boolean verificarAprovacao() {
        if (tipo == TipoNota.PARCIAL) {
            return valor >= 6.0;
        } else if (tipo == TipoNota.FINAL) {
            return valor >= 7.0;
        } else {
            System.out.println("Tipo de nota desconhecido.");
            return false;
        }
    }

    public void exibirResumoNota() {
        System.out.println("Nota de " + aluno.getNome() + " - Disciplina: " + disciplinaAssociada.getNome());
        System.out.println("Valor: " + valor + " | Tipo: " + tipo + " | Observação: " + (observacao != null ? observacao : "Nenhuma"));
    }


    public void exibirDataCadastro() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data de cadastro da nota: " + dataCadastro.format(formatter));
    }
}
