package br.com.escola.estrelaguia.Model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private Disciplina disciplina;
    private Professor professorResponsavel;
    private List<Aluno> alunos;
    private int capacidadeMaxima;

    public Turma(String nome, Disciplina disciplina, Professor professorResponsavel, int capacidadeMaxima) {
        this.nome = nome;
        this.disciplina = disciplina;
        this.professorResponsavel = professorResponsavel;
        this.capacidadeMaxima = capacidadeMaxima;
        this.alunos = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (alunos.size() < capacidadeMaxima) {
            if (!alunos.contains(aluno)) {
                alunos.add(aluno);
                return true;
            }
            System.out.println("Aluno já está matriculado nesta turma.");
        } else {
            System.out.println("Capacidade máxima da turma atingida.");
        }
        return false;
    }


    public boolean removerAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            return true;
        }
        System.out.println("Aluno não encontrado na turma.");
        return false;
    }


    public String getNome() {
        return nome;
    }

    public static Turma buscarTurmaPorNome(String nome, List<Turma> turmas) {
        for (Turma turma : turmas) {
            if (turma.getNome().equalsIgnoreCase(nome)) {
                return turma;
            }
        }
        return null;
    }

    public void detalhesTurma() {
        System.out.println("Nome da Turma: " + this.nome);
        System.out.println("Disciplina: " + this.disciplina.getNome());
        System.out.println("Professor Responsável: " + this.professorResponsavel.getNome());
        System.out.println("Capacidade Máxima: " + this.capacidadeMaxima);
        System.out.println("Alunos Matriculados:");
        for (Aluno aluno : this.alunos) {
            System.out.println(" - " + aluno.getNome());
        }
    }

}
