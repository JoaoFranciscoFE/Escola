package br.com.escola.estrelaguia.Model;

import java.util.HashSet;
import java.util.Set;

public class Turma {
    private String nome;
    private int ano;
    private Set<Aluno> alunos;
    private String horario;
    private Professor professorResponsavel;

    public Turma(String nome, int ano, String horario, Professor professorResponsavel) {
        this.nome = nome;
        this.ano = ano;
        this.horario = horario;
        this.professorResponsavel = professorResponsavel;
        this.alunos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }
    public void exibirDadosTurma() {
        System.out.println("Turma: " + nome + " | Ano: " + ano + " | Horário: " + horario);
        if (professorResponsavel != null) {
            System.out.println("Professor responsável: " + professorResponsavel.getNome());
        }
        if (!alunos.isEmpty()) {
            System.out.println("Alunos matriculados:");
            for (Aluno aluno : alunos) {
                System.out.println("  - " + aluno.getNome());
            }
        } else {
            System.out.println("Nenhum aluno matriculado.");
        }
    }
}
