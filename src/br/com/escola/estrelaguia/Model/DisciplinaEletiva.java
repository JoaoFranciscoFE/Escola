package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaEletiva extends Disciplina {
    private boolean requerAprovacao;
    private String areaDeEstudo;
    private int duracaoSemanas;
    private String recursosExtras;
    private List<Aluno> alunosInteresse;

    public DisciplinaEletiva(String nome, boolean requerAprovacao, String areaDeEstudo, int duracaoSemanas, String recursosExtras) {
        super(nome, TipoDisciplina.ELETIVA, 0, "N/A", "30");
        this.requerAprovacao = requerAprovacao;
        this.areaDeEstudo = areaDeEstudo;
        this.duracaoSemanas = duracaoSemanas;
        this.recursosExtras = recursosExtras;
        this.alunosInteresse = new ArrayList<>();
    }

    public boolean isRequerAprovacao() {
        return requerAprovacao;
    }

    public void setRequerAprovacao(boolean requerAprovacao) {
        this.requerAprovacao = requerAprovacao;
    }

    public String getAreaDeEstudo() {
        return areaDeEstudo;
    }

    public void setAreaDeEstudo(String areaDeEstudo) {
        this.areaDeEstudo = areaDeEstudo;
    }

    public int getDuracaoSemanas() {
        return duracaoSemanas;
    }

    public void setDuracaoSemanas(int duracaoSemanas) {
        this.duracaoSemanas = duracaoSemanas;
    }

    public String getRecursosExtras() {
        return recursosExtras;
    }

    public void setRecursosExtras(String recursosExtras) {
        this.recursosExtras = recursosExtras;
    }

    public List<Aluno> getAlunosInteresse() {
        return alunosInteresse;
    }

    public void registrarInteresse(Aluno aluno) {
        if (!alunosInteresse.contains(aluno)) {
            alunosInteresse.add(aluno);
            System.out.println("Interesse registrado para o aluno: " + aluno.getNome());
        } else {
            System.out.println("O aluno já registrou interesse nessa disciplina.");
        }
    }

    public boolean verificarAptidao(Aluno aluno) {
        boolean apto = !requerAprovacao || aluno.getStatusMatricula().isAtivo();
        System.out.println("O aluno " + aluno.getNome() + (apto ? " está apto" : " não está apto") + " a se matricular.");
        return apto;
    }

    public int vagasRestantes() {
        return getMaximoAlunos() - getAlunosMatriculados().size();
    }

    public void listarInteressados() {
        System.out.println("Alunos interessados na disciplina " + getNome() + ":");
        for (Aluno aluno : alunosInteresse) {
            System.out.println(" - " + aluno.getNome());
        }
    }

    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Eletiva: " + getNome());
        System.out.println("Requer Aprovação: " + (requerAprovacao ? "Sim" : "Não"));
        System.out.println("Área de Estudo: " + areaDeEstudo);
        System.out.println("Duração: " + duracaoSemanas + " semanas");
        System.out.println("Recursos Extras: " + recursosExtras);
        System.out.println("Vagas Restantes: " + vagasRestantes());
    }
}
