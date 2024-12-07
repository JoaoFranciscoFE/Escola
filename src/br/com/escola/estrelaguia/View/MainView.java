package br.com.escola.estrelaguia.View;

import br.com.escola.estrelaguia.DAO.*;

import java.util.Scanner;

public class MainView {
    private AlunoDAO alunoDAO;
    private ProfessorDAO professorDAO;
    private DisciplinaDAO disciplinaDAO;
    private TurmaDAO turmaDAO;
    private Scanner scanner;

    public MainView(AlunoDAO alunoDAO, ProfessorDAO professorDAO, DisciplinaDAO disciplinaDAO, TurmaDAO turmaDAO) {
        this.alunoDAO = alunoDAO;
        this.professorDAO = professorDAO;
        this.disciplinaDAO = disciplinaDAO;
        this.turmaDAO = turmaDAO;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. Disciplina");
            System.out.println("4. Turma");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    MainView mainView = new MainView(alunoDAO, professorDAO, disciplinaDAO, turmaDAO);
                    mainView.showMenu();
                    break;
                case 2:
                    ProfessorView professorView = new ProfessorView(professorDAO, alunoDAO, disciplinaDAO, turmaDAO);
                    professorView.showMenu();
                    break;
                case 3:
                    DisciplinaView disciplinaView = new DisciplinaView(disciplinaDAO);
                    disciplinaView.showMenu();
                    break;
                case 4:
                    TurmaView turmaView = new TurmaView(turmaDAO, disciplinaDAO, professorDAO);
                    turmaView.showMenu();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
