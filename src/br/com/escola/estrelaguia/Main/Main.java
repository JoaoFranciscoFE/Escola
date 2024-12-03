package br.com.escola.estrelaguia.Main;

import br.com.escola.estrelaguia.Enums.*;
import br.com.escola.estrelaguia.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<Aluno> alunos = new ArrayList<>();
    private static final List<Professor> professores = new ArrayList<>();
    private static final List<Disciplina> disciplinas = new ArrayList<>();
    private static final List<Turma> turmas = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarTurmas();
        boolean running = true;

        while (running) {
            exibirMenu();
            int opcao = obterOpcao();

            try {
                switch (opcao) {
                    case 1 -> adicionarAluno();
                    case 2 -> removerAluno();
                    case 3 -> adicionarDisciplina();
                    case 4 -> removerDisciplina();
                    case 5 -> listarAlunos();
                    case 6 -> listarDisciplinas();
                    case 7 -> consultarNotas();
                    case 8 -> matricularAluno();
                    case 9 -> avaliarDisciplina();
                    case 10 -> adicionarProfessor();
                    case 11 -> listarProfessores();
                    case 0 -> running = false;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Sistema encerrado. Até logo!");
    }

    private static void inicializarTurmas() {
        Turma turma1 = new Turma("Turma A", 2024);
        Turma turma2 = new Turma("Turma B", 2024);
        Turma turma3 = new Turma("Turma C", 2024);
        turmas.add(turma1);
        turmas.add(turma2);
        turmas.add(turma3);
    }

    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Adicionar Aluno");
        System.out.println("2. Remover Aluno");
        System.out.println("3. Adicionar Disciplina");
        System.out.println("4. Remover Disciplina");
        System.out.println("5. Listar Alunos");
        System.out.println("6. Listar Disciplinas");
        System.out.println("7. Consultar Notas");
        System.out.println("8. Matricular Aluno em Disciplina");
        System.out.println("9. Avaliar Disciplina");
        System.out.println("10. Adicionar Professor");
        System.out.println("11. Listar Professores");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Insira um número.");
            return -1;
        }
    }

    private static void adicionarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno novoAluno = new Aluno(nome, cpf);
        alunos.add(novoAluno);
        System.out.println("Aluno adicionado com sucesso!");
    }

    private static void removerAluno() {
        System.out.print("Digite o CPF do aluno a ser removido: ");
        String cpf = scanner.nextLine();
        Aluno alunoRemovido = null;

        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                alunoRemovido = aluno;
                break;
            }
        }

        if (alunoRemovido != null) {
            alunos.remove(alunoRemovido);
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void adicionarDisciplina() {
        System.out.print("Digite o nome da disciplina: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o tipo da disciplina (OBRIGATORIA/ELETIVA): ");
        String tipo = scanner.nextLine().toUpperCase();

        if (tipo.equals("OBRIGATORIA")) {
            System.out.print("Digite a carga horária: ");
            int cargaHoraria = Integer.parseInt(scanner.nextLine());
            Disciplina novaDisciplina = new DisciplinaObrigatoria(nome, cargaHoraria);
            disciplinas.add(novaDisciplina);
        } else if (tipo.equals("ELETIVA")) {
            System.out.print("Requer aprovação? (true/false): ");
            boolean requerAprovacao = Boolean.parseBoolean(scanner.nextLine());
            Disciplina novaDisciplina = new DisciplinaEletiva(nome, requerAprovacao);
            disciplinas.add(novaDisciplina);
        } else {
            System.out.println("Tipo de disciplina inválido.");
        }
        System.out.println("Disciplina adicionada com sucesso!");
    }

    private static void removerDisciplina() {
        System.out.print("Digite o nome da disciplina a ser removida: ");
        String nome = scanner.nextLine();
        Disciplina disciplinaRemovida = null;

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                disciplinaRemovida = disciplina;
                break;
            }
        }

        if (disciplinaRemovida != null) {
            disciplinas.remove(disciplinaRemovida);
            System.out.println("Disciplina removida com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void listarAlunos() {
        System.out.println("\n=== Lista de Alunos ===");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            for (Aluno aluno : alunos) {
                aluno.exibirDados();
            }
        }
    }

    private static void listarDisciplinas() {
        System.out.println("\n=== Lista de Disciplinas ===");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
        } else {
            for (Disciplina disciplina : disciplinas) {
                disciplina.detalhesDisciplina();
            }
        }
    }

    private static void consultarNotas() {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno alunoEncontrado = null;

        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                alunoEncontrado = aluno;
                break;
            }
        }

        if (alunoEncontrado != null) {
            System.out.println("Notas do aluno: " + alunoEncontrado.getNome());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void matricularAluno() {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno alunoEncontrado = null;

        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                alunoEncontrado = aluno;
                break;
            }
        }

        if (alunoEncontrado != null) {
            // Exibir turmas disponíveis
            System.out.println("\n=== Turmas Disponíveis ===");
            for (int i = 0; i < turmas.size(); i++) {
                System.out.println((i + 1) + ". " + turmas.get(i).getNome() + " | Ano: " + turmas.get(i).getAno());
            }

            System.out.print("Escolha a turma para o aluno (digite o número): ");
            int escolhaTurma = Integer.parseInt(scanner.nextLine()) - 1;

            if (escolhaTurma >= 0 && escolhaTurma < turmas.size()) {
                Turma turmaEscolhida = turmas.get(escolhaTurma);
                System.out.print("Digite o nome da disciplina: ");
                String nomeDisciplina = scanner.nextLine();
                Disciplina disciplinaEncontrada = null;

                for (Disciplina disciplina : disciplinas) {
                    if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                        disciplinaEncontrada = disciplina;
                        break;
                    }
                }

                if (disciplinaEncontrada != null) {
                    alunoEncontrado.adicionarDisciplina(disciplinaEncontrada);
                    turmaEscolhida.adicionarAluno(alunoEncontrado);  // Adiciona aluno à turma
                    alunoEncontrado.alterarStatusMatricula(StatusMatricula.MATRICULADO);  // Atualiza status
                    System.out.println("Aluno matriculado na disciplina e turma com sucesso!");
                } else {
                    System.out.println("Disciplina não encontrada.");
                }
            } else {
                System.out.println("Turma inválida.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void avaliarDisciplina() {
        System.out.print("Digite o nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplinaEncontrada = null;

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplinaEncontrada = disciplina;
                break;
            }
        }

        if (disciplinaEncontrada != null) {
            System.out.print("Digite a nota (0 a 10): ");
            double nota = Double.parseDouble(scanner.nextLine());
            Nota novaNota = new Nota(nota, TipoNota.PROVA);
            System.out.println("Nota registrada para a disciplina.");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }
    private static void adicionarProfessor() {
        System.out.print("Digite o nome do professor: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o departamento do professor: ");
        String departamento = scanner.nextLine();

        Professor novoProfessor = new Professor(nome, cpf, departamento);
        professores.add(novoProfessor);
        System.out.println("Professor adicionado com sucesso!");

        System.out.print("Digite o nome da disciplina que o professor irá lecionar: ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplinaEncontrada = null;

        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nomeDisciplina)) {
                disciplinaEncontrada = disciplina;
                break;
            }
        }

        if (disciplinaEncontrada != null) {
            novoProfessor.adicionarDisciplina(disciplinaEncontrada);
            System.out.println("Professor associado à disciplina com sucesso!");
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    private static void listarProfessores() {
        System.out.println("\n=== Lista de Professores ===");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            for (Professor professor : professores) {
                professor.exibirDados();
            }
        }
    }
}