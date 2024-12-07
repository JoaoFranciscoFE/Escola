package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

import java.util.ArrayList;
import java.util.List;

public abstract class Disciplina {
    private String nome;
    private TipoDisciplina tipo;
    private int cargaHoraria;
    private String professor;
    private String horarioAulas;
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

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(String horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    public List<String> getMateriais() {
        return materiais;
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

    public void setMaximoAlunos(int maximoAlunos) {
        this.maximoAlunos = maximoAlunos;
    }

    public void adicionarMaterial(String material) {
        materiais.add(material);
    }

    public void listarMateriais() {
        System.out.println("Materiais da disciplina " + nome + ":");
        for (String material : materiais) {
            System.out.println(" - " + material);
        }
    }

    public void adicionarNota(Nota nota) {
        notas.add(nota);
    }

    public double calcularMediaNotas() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        for (Nota nota : notas) {
            soma += nota.getValor();
        }
        return soma / notas.size();
    }
    public void adicionarAluno(Aluno aluno) {
        if (alunosMatriculados.size() < maximoAlunos) {
            alunosMatriculados.add(aluno);
        } else {
            System.out.println("Não há vagas disponíveis para a disciplina: " + nome);
        }
    }

    public abstract void detalhesDisciplina();

}
