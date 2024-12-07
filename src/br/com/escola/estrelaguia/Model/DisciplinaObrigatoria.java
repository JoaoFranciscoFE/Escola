package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaObrigatoria extends Disciplina {
    private int cargaHoraria;
    private String professorResponsavel;
    private String horarioAulas;
    private String descricaoConteudo;
    private List<Aluno> alunosMatriculados;

    public DisciplinaObrigatoria(String nome, int cargaHoraria, String professorResponsavel, String horarioAulas, String descricaoConteudo) {
        super(nome, TipoDisciplina.OBRIGATORIA, 30, "Padrao","10");
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
        this.horarioAulas = horarioAulas;
        this.descricaoConteudo = descricaoConteudo;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Getters e Setters
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public String getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(String horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    public String getDescricaoConteudo() {
        return descricaoConteudo;
    }

    public void setDescricaoConteudo(String descricaoConteudo) {
        this.descricaoConteudo = descricaoConteudo;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    // Métodos úteis

    // 1. Adicionar aluno à disciplina
    public void adicionarAluno(Aluno aluno) {
        if (!alunosMatriculados.contains(aluno)) {
            alunosMatriculados.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado com sucesso.");
        } else {
            System.out.println("O aluno " + aluno.getNome() + " já está matriculado nesta disciplina.");
        }
    }

    // 2. Remover aluno da disciplina
    public void removerAluno(Aluno aluno) {
        if (alunosMatriculados.contains(aluno)) {
            alunosMatriculados.remove(aluno);
            System.out.println("Aluno " + aluno.getNome() + " removido da disciplina.");
        } else {
            System.out.println("O aluno " + aluno.getNome() + " não está matriculado nesta disciplina.");
        }
    }

    // 3. Exibir lista de alunos matriculados
    public void listarAlunosMatriculados() {
        System.out.println("Alunos matriculados na disciplina " + getNome() + ":");
        for (Aluno aluno : alunosMatriculados) {
            System.out.println(" - " + aluno.getNome());
        }
    }

    // 4. Verificar carga horária restante
    public int cargaHorariaRestante(int aulasConcluidas) {
        int restante = cargaHoraria - aulasConcluidas;
        return Math.max(restante, 0);
    }

    // 5. Sobrescrevendo `detalhesDisciplina` para incluir mais informações
    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Obrigatória: " + getNome());
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        System.out.println("Professor Responsável: " + professorResponsavel);
        System.out.println("Horário das Aulas: " + horarioAulas);
        System.out.println("Descrição do Conteúdo: " + descricaoConteudo);
    }
}
