package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoPessoa;

import java.util.HashSet;
import java.util.Set;

public class Professor extends Pessoa {
    private String departamento;
    private Set<Disciplina> disciplinas;

    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf, TipoPessoa.PROFESSOR);
        this.departamento = departamento;
        this.disciplinas = new HashSet<>();
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    @Override
    public void exibirDados() {
        System.out.println("Professor: " + getNome() + " | CPF: " + getCpf() + " | Departamento: " + departamento);
        if (!disciplinas.isEmpty()) {
            System.out.println("Disciplinas: ");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("  - " + disciplina.getNome());
            }
        }
    }
}