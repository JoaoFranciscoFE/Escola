package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {
    private String nome;
    private TipoDisciplina tipo;
    int cargaHoraria;
    String professor;
    public String horarioAulas;
    private List<String> materiais;
    private List<Nota> notas;
    private int maximoAlunos;
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    public Disciplina(String nome, TipoDisciplina tipo, int cargaHoraria, String professor, String horarioAulas) {
        this.nome = nome;
        this.tipo = tipo;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.horarioAulas = horarioAulas;
        this.materiais = new ArrayList<>();
        this.notas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public int getMaximoAlunos() {
        return maximoAlunos;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }


    public abstract void detalhesDisciplina();

}
