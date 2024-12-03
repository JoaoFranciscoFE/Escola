package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.StatusMatricula;
import br.com.escola.estrelaguia.Enums.TipoPessoa;


import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa {
    private StatusMatricula statusMatricula;  // Adicionando status de matrícula
    private Set<Disciplina> disciplinas;

    public Aluno(String nome, String cpf) {
        super(nome, cpf, TipoPessoa.ALUNO); // Tipo aluno
        this.statusMatricula = StatusMatricula.DESMATRICULADO;  // Status inicial
        this.disciplinas = new HashSet<>();
    }

    public void alterarStatusMatricula(StatusMatricula status) {
        this.statusMatricula = status;
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(StatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    @Override
    public void exibirDados() {
        System.out.println("Aluno: " + getNome() + " | CPF: " + getCpf() + " | Status Matrícula: " + statusMatricula);
    }
}