package br.com.escola.estrelaguia.View;

import br.com.escola.estrelaguia.DAO.DisciplinaDAO;
import br.com.escola.estrelaguia.Model.Disciplina;
import br.com.escola.estrelaguia.Model.DisciplinaObrigatoria;

import java.util.Scanner;

public class DisciplinaView {
    private DisciplinaDAO disciplinaDAO;
    private Scanner scanner;

    public DisciplinaView(DisciplinaDAO disciplinaDAO) {
        this.disciplinaDAO = disciplinaDAO;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== MENU DISCIPLINA ===");
            System.out.println("1. Cadastrar Disciplina");
            System.out.println("2. Exibir Dados");
            System.out.println("3. Listar Disciplinas");
            System.out.println("4. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    cadastrarDisciplina();
                    break;
                case 2:
                    exibirDadosDisciplina();
                    break;
                case 3:
                    listarDisciplinas();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarDisciplina() {
        System.out.print("Nome da Disciplina: ");
        String nome = scanner.next();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        System.out.print("Professor Responsável: ");
        String professorResponsavel = scanner.next();
        System.out.print("Horário das Aulas: ");
        String horarioAulas = scanner.next();
        System.out.print("Descrição do Conteúdo: ");
        String descricaoConteudo = scanner.next();

        Disciplina disciplina = new DisciplinaObrigatoria(nome, cargaHoraria, professorResponsavel, horarioAulas, descricaoConteudo);
        disciplinaDAO.addDisciplina(disciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private void exibirDadosDisciplina() {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.next();
        Disciplina disciplina = disciplinaDAO.findDisciplinaByName(nome);
        if (disciplina != null) {
            disciplina.detalhesDisciplina();
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private void listarDisciplinas() {
        System.out.println("Lista de Disciplinas:");
        for (Disciplina disciplina : disciplinaDAO.getAllDisciplinas()) {
            System.out.println(" - " + disciplina.getNome());
        }
    }
}

