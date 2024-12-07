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


    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Obrigatória: " + getNome());
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        System.out.println("Professor Responsável: " + professorResponsavel);
        System.out.println("Horário das Aulas: " + horarioAulas);
        System.out.println("Descrição do Conteúdo: " + descricaoConteudo);
    }
}
