package br.com.escola.estrelaguia.DAO;

import br.com.escola.estrelaguia.Enums.StatusMatricula;
import br.com.escola.estrelaguia.Model.*;

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

    public void matricularAluno(Aluno aluno, String cpfAluno, String codigoDisciplina) {
        aluno.setStatusMatricula(StatusMatricula.ATIVO);
    }

    public void desmatricularAluno(Aluno aluno, String cpfAluno, String codigoDisciplina) {
        aluno.setStatusMatricula(StatusMatricula.DESMATRICULADO);
    }


    public void atualizarAluno(String cpf, String novoNome, String novoEmail) {
        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setEmail(novoEmail);
        }
    }

    public void excluirAluno(String cpf) {
        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            alunos.remove(aluno);
        }
    }

    public void avaliar(Aluno aluno) {
        AvaliacaoFinal avaliacaoFinal = new AvaliacaoFinal("Avaliação Final", 1.0);
        double notaFinal = avaliacaoFinal.getNotaFinal();
        System.out.println("Nota final: " + notaFinal);
    }
}