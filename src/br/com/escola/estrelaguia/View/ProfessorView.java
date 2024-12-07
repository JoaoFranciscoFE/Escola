package br.com.escola.estrelaguia.View;

import br.com.escola.estrelaguia.DAO.ProfessorDAO;
import br.com.escola.estrelaguia.DAO.AlunoDAO;
import br.com.escola.estrelaguia.DAO.DisciplinaDAO;
import br.com.escola.estrelaguia.DAO.TurmaDAO;
import br.com.escola.estrelaguia.Model.Professor;

import java.util.Scanner;

public class ProfessorView {
    private ProfessorDAO professorDAO;
    private AlunoDAO alunoDAO;
    private DisciplinaDAO disciplinaDAO;
    private TurmaDAO turmaDAO;
    private Scanner scanner;

    public ProfessorView(ProfessorDAO professorDAO, AlunoDAO alunoDAO, DisciplinaDAO disciplinaDAO, TurmaDAO turmaDAO) {
        this.professorDAO = professorDAO;
        this.alunoDAO = alunoDAO;
        this.disciplinaDAO = disciplinaDAO;
        this.turmaDAO = turmaDAO;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== MENU PROFESSOR ===");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Exibir Dados");
            System.out.println("3. Listar Professores");
            System.out.println("4. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    exibirDadosProfessor();
                    break;
                case 3:
                    listarProfessores();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Departamento: ");
        String departamento = scanner.next();

        Professor professor = new Professor(nome, cpf, departamento);
        professorDAO.addProfessor(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    private void exibirDadosProfessor() {
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.next();
        Professor professor = professorDAO.findProfessorByCpf(cpf);
        if (professor != null) {
            professor.exibirDados();
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private void listarProfessores() {
        System.out.println("Lista de Professores:");
        for (Professor professor : professorDAO.getAllProfessores()) {
            System.out.println(" - " + professor.getNome());
        }
    }
}