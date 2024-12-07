package br.com.escola.estrelaguia.DAO;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;
import br.com.escola.estrelaguia.Model.Aluno;
import br.com.escola.estrelaguia.Model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private List<Aluno> alunos;

    public AlunoDAO() {
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> buscarAlunos() {
        return alunos;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAlunoPorCpf(String cpf) {
        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }

    public void matricularAluno(Aluno aluno) {
        aluno.setMatriculado(true);
    }

    public void desmatricularAluno(Aluno aluno) {
        aluno.setMatriculado(false);
    }

    public List<Disciplina> listarDisciplinasAluno(Aluno aluno) {
        List<Disciplina> disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina("Matemática", TipoDisciplina.ELETIVA, 10, "Sexta"));
        disciplinas.add(new Disciplina("Português", "POR101"));
        return disciplinas;
    }

    public String verificarSituacaoAluno(Aluno aluno) {
        if (aluno.isMatriculado()) {
            return "Matriculado";
        } else {
            return "Desmatriculado";
        }
    }
}