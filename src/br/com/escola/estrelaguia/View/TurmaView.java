package br.com.escola.estrelaguia.View;

import br.com.escola.estrelaguia.DAO.TurmaDAO;
import br.com.escola.estrelaguia.DAO.DisciplinaDAO;
import br.com.escola.estrelaguia.DAO.ProfessorDAO;
import br.com.escola.estrelaguia.Model.Aluno;
import br.com.escola.estrelaguia.Model.Turma;
import br.com.escola.estrelaguia.Model.Disciplina;
import br.com.escola.estrelaguia.Model.Professor;

import java.util.Scanner;

public class TurmaView {
    private TurmaDAO turmaDAO;
    private DisciplinaDAO disciplinaDAO;
    private ProfessorDAO professorDAO;
    private Scanner scanner;

    public TurmaView(TurmaDAO turmaDAO, DisciplinaDAO disciplinaDAO, ProfessorDAO professorDAO) {
        this.turmaDAO = turmaDAO;
        this.disciplinaDAO = disciplinaDAO;
        this.professorDAO = professorDAO;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== MENU TURMA ===");
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Exibir Dados");
            System.out.println("3. Listar Turmas");
            System.out.println("4. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    cadastrarTurma();
                    break;
                case 2:
                    exibirDadosTurma();
                    break;
                case 3:
                    listarTurmas();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarTurma() {
        System.out.print("Nome da Turma: ");
        String nomeTurma = scanner.next();
        System.out.print("Nome da Disciplina: ");
        String nomeDisciplina = scanner.next();
        Disciplina disciplina = disciplinaDAO.findDisciplinaByName(nomeDisciplina);

        if (disciplina != null) {
            System.out.print("CPF do Professor Responsável: ");
            String cpfProfessor = scanner.next();
            Professor professor = professorDAO.findProfessorByCpf(cpfProfessor);

            if (professor != null) {
                System.out.print("Capacidade máxima: ");
                int capacidade = scanner.nextInt();
                Turma turma = new Turma(nomeTurma, disciplina, professor, capacidade);
                turmaDAO.addTurma(turma);
                System.out.println("Turma cadastrada com sucesso!");
            } else {
                System.out.println("Professor não encontrado.");
            }
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private void exibirDadosTurma() {
        System.out.print("Digite o nome da turma: ");
        String nomeTurma = scanner.next();
        Turma turma = turmaDAO.findTurmaByName(nomeTurma);

        if (turma != null) {
            // Assuming Turma has a method to display its details
            turma.detalhesTurma();
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private void listarTurmas() {
        System.out.println("Lista de Turmas:");
        for (Turma turma : turmaDAO.getAllTurmas()) {
            System.out.println(" - " + turma.getNome());
        }
    }
}

