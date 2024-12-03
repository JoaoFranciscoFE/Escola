package br.com.escola.estrelaguia.Model;

import java.util.ArrayList;

public class Curso {
    private String nome;
    private ArrayList<Disciplina> disciplinas;

    public Curso(String nome) {
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public ArrayList<Disciplina> getDisciplinas() { return disciplinas; }
    public void setDisciplinas(ArrayList<Disciplina> disciplinas) { this.disciplinas = disciplinas; }
}
