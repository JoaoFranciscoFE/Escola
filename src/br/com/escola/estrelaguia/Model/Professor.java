package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.ICadastrar;
import br.com.escola.estrelaguia.Contracts.IConsultar;
import br.com.escola.estrelaguia.Enums.TipoPessoa;

import java.util.HashSet;

import java.util.Set;

public class Professor extends Pessoa implements ICadastrar, IConsultar {
    private String email;
    private String departamento;
    private Set<Disciplina> disciplinas;

    public Professor(String nome, String cpf, String departamento, String email) {
        super(nome, cpf, TipoPessoa.PROFESSOR);
        this.departamento = departamento;
        this.disciplinas = new HashSet<>();
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            System.out.println("A disciplina " + disciplina.getNome() + " já está atribuída ao professor.");
        } else {
            disciplinas.add(disciplina);
            System.out.println("Disciplina " + disciplina.getNome() + " atribuída ao professor " + getNome() + ".");
        }
    }

    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinas.remove(disciplina)) {
            System.out.println("Disciplina " + disciplina.getNome() + " removida do professor " + getNome() + ".");
        } else {
            System.out.println("Disciplina " + disciplina.getNome() + " não encontrada na lista do professor.");
        }
    }


    @Override
    public void exibirDados() {
        System.out.println("Professor: " + getNome() + " | CPF: " + getCpf() + " | Departamento: " + departamento);
        if (!disciplinas.isEmpty()) {
            System.out.println("Disciplinas: ");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("  - " + disciplina.getNome());
            }
        } else {
            System.out.println("Nenhuma disciplina atribuída.");
        }
    }

    @Override
    public void consultar() {
        System.out.println("Consultando professor: " + getNome());
        System.out.println("Departamento: " + departamento);
        if (!disciplinas.isEmpty()) {
            System.out.println("Disciplinas ministradas: ");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("  - " + disciplina.getNome());
            }
        }
    }

    @Override
    public void cadastrar() {
        System.out.println("Professor " + getNome() + " cadastrado com sucesso!");
    }
}
