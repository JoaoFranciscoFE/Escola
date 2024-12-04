package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.IConsultar;
import br.com.escola.estrelaguia.Enums.StatusMatricula;
import br.com.escola.estrelaguia.Enums.TipoPessoa;

import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa implements IConsultar {
    private StatusMatricula statusMatricula;
    private Set<Disciplina> disciplinas;

    public Aluno(String nome, String cpf) {
        super(nome, cpf, TipoPessoa.ALUNO);
        this.statusMatricula = StatusMatricula.DESMATRICULADO;
        this.disciplinas = new HashSet<>();
    }

    public void alterarStatusMatricula(StatusMatricula status) {
        this.statusMatricula = status;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    @Override
    public void exibirDados() {
        System.out.println("Aluno: " + getNome() + " | CPF: " + getCpf() + " | Status Matrícula: " + statusMatricula);
    }

    @Override
    public void consultar(String consultado) {
        if (getNome().equalsIgnoreCase(consultado) || getCpf().equals(consultado)) {
            exibirDados();
        } else {
            System.out.println("Aluno não encontrado com o critério fornecido: " + consultado);
        }
    }
}
