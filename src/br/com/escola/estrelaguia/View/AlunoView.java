package br.com.escola.estrelaguia.View;

import br.com.escola.estrelaguia.DAO.AlunoDAO;
import br.com.escola.estrelaguia.Model.Aluno;
import br.com.escola.estrelaguia.Model.Disciplina;

import java.util.List;
import java.util.Scanner;

public class AlunoView {
    private AlunoDAO alunoDAO;

    public AlunoView(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }

    public void exibirAlunos() {
        List<Aluno> alunos = alunoDAO.buscarAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

    public void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Ano de Ingresso: ");
        int anoDeIngresso = scanner.nextInt();

        Aluno aluno = new Aluno(nome, cpf, telefone, email, endereco, anoDeIngresso);
        alunoDAO.cadastrarAluno(aluno);
    }

    public void matricularAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = alunoDAO.buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            alunoDAO.matricularAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void desmatricularAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = alunoDAO.buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            alunoDAO.desmatricularAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void exibirDadosAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = alunoDAO.buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            System.out.println("Nome: " + aluno.getNome());
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Telefone: " + aluno.getTelefone());
            System.out.println("Email: " + aluno.getEmail());
            System.out.println("Endereço: " + aluno.getEndereco());
            System.out.println("Ano de Ingresso: " + aluno.getAnoDeIngresso());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void listarDisciplinasAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = alunoDAO.buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            List<Disciplina> disciplinas = alunoDAO.listarDisciplinasAluno(aluno);
            for (Disciplina disciplina : disciplinas) {
                System.out.println(disciplina.getNome());
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void verificarSituacaoAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = alunoDAO.buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            System.out.println("Situação: " + alunoDAO.verificarSituacaoAluno(aluno));
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
}