package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.IMatriculavel;
import br.com.escola.estrelaguia.Enums.StatusMatricula;

import java.util.ArrayList;
import java.util.List;

public class CadastroAluno implements IMatriculavel {
    private List<Aluno> alunos;

    public CadastroAluno() {
        this.alunos = new ArrayList<>();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(String cpf) {
        alunos.removeIf(aluno -> aluno.getCpf().equals(cpf));
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            alunos.forEach(Aluno::exibirDados);
        }
    }

    @Override
    public void matricular() {
        System.out.println("Implementar lógica de matrícula no sistema.");
    }

    @Override
    public void cancelarMatricula() {
        System.out.println("Implementar lógica de cancelamento de matrícula.");
    }
}
