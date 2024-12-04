package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;
// Está aqui pois a disciplina que está no código é abstrata (Sim Erlon, sou eu escrevendo)
public class DisciplinaObrigatoria extends Disciplina {
    private int cargaHoraria;
    private String professorResponsavel;
    private int numeroMaximoAlunos;
    private int numeroAtualAlunos;
    private boolean laboratorioRequerido;
    private String departamento;

    public DisciplinaObrigatoria(String nome, int cargaHoraria, String professorResponsavel,
                                 int numeroMaximoAlunos, boolean laboratorioRequerido, String departamento) {
        super(nome, TipoDisciplina.OBRIGATORIA);
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
        this.numeroMaximoAlunos = numeroMaximoAlunos;
        this.numeroAtualAlunos = 0;
        this.laboratorioRequerido = laboratorioRequerido;
        this.departamento = departamento;
    }

    public void alterarCargaHoraria(int novaCargaHoraria) {
        this.cargaHoraria = novaCargaHoraria;
    }

    public void atualizarDepartamento(String novoDepartamento) {
        this.departamento = novoDepartamento;
    }


    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Obrigatória: " + getNome() + " | Carga Horária: " + cargaHoraria +
                " | Professor: " + professorResponsavel + " | Número Atual/Max. Alunos: " +
                numeroAtualAlunos + "/" + numeroMaximoAlunos + " | Laboratório Requerido: " +
                laboratorioRequerido + " | Departamento: " + departamento);
    }
}
