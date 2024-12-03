package br.com.escola.estrelaguia.Model;

import java.util.HashSet;
import java.util.Set;

public class Turma {
    private String nome;
    private int ano;
    private Set<Aluno> alunos;

    public Turma(String nome, int ano) {
        this.nome = nome;
        this.ano = ano;
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

    public void exibirDadosTurma() {
        System.out.println("Turma: " + nome + " | Ano: " + ano);
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
