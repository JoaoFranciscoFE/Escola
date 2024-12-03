package br.com.escola.estrelaguia.Main;

import br.com.escola.estrelaguia.Enums.*;
import br.com.escola.estrelaguia.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

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
                    case 7 -> exibirDadosTurma();
                    case 8 -> consultarNotas();
                    case 9 -> matricularAluno();
                    case 10 -> avaliarDisciplina();
                    case 11 -> adicionarProfessor();
                    case 12 -> listarProfessores();
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
        Turma turma1 = new Turma("Turma A", 2024, "10", new Professor("Paulo", "123", "Matemática"));
        Turma turma2 = new Turma("Turma B", 2024, "10", new Professor("Gomez", "123", "História"));
        Turma turma3 = new Turma("Turma C", 2024, "10", new Professor("Rodrigo", "123", "Ciências"));
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
        System.out.println("7. Listar Turmas");
        System.out.println("8. Consultar Notas");
        System.out.println("9. Matricular Aluno em Disciplina");
        System.out.println("10. Avaliar Disciplina");
        System.out.println("11. Adicionar Professor");
        System.out.println("12. Listar Professores");
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
            try {
                System.out.print("Digite a carga horária: ");
                int cargaHoraria = Integer.parseInt(scanner.nextLine());
                Disciplina novaDisciplina = new DisciplinaObrigatoria(nome, cargaHoraria);
                disciplinas.add(novaDisciplina);
                System.out.println("Disciplina adicionada com sucesso!");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. A carga horária deve ser um número.");
            }
        } else if (tipo.equals("ELETIVA")) {
            System.out.print("Requer aprovação? (true/false): ");
            boolean requerAprovacao;
            try {
                requerAprovacao = Boolean.parseBoolean(scanner.nextLine());
                Disciplina novaDisciplina = new DisciplinaEletiva(nome, requerAprovacao);
                disciplinas.add(novaDisciplina);
                System.out.println("Disciplina adicionada com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao adicionar disciplina.");
            }
        } else {
            System.out.println("Tipo de disciplina inválido.");
        }
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

    private static void exibirDadosTurma(){
        System.out.println("\n=== Lista de Turmas ===");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        } else {
            for (int i = 0; i < turmas.size(); i++) {
                System.out.println((i + 1) + ". " + turmas.get(i).getNome() + " | Ano: " + turmas.get(i).getAno());
            }

            System.out.print("Digite o número da turma para exibir os dados: ");
            int escolhaTurma = Integer.parseInt(scanner.nextLine()) - 1;

            if (escolhaTurma >= 0 && escolhaTurma < turmas.size()) {
                Turma turmaEscolhida = turmas.get(escolhaTurma);
                turmaEscolhida.exibirDadosTurma();
            } else {
                System.out.println("Turma inválida.");
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
            System.out.println("\n=== Turmas Disponíveis ===");
            for (int i = 0; i < turmas.size(); i++) {
                System.out.println((i + 1) + ". " + turmas.get(i).getNome() + " | Ano: " + turmas.get(i).getAno());
            }

            try {
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
                        turmaEscolhida.adicionarAluno(alunoEncontrado);
                        alunoEncontrado.alterarStatusMatricula(StatusMatricula.MATRICULADO);
                        System.out.println("Aluno matriculado na disciplina e turma com sucesso!");
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                } else {
                    System.out.println("Turma inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido para a turma.");
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
            System.out.println("Escolha o tipo de nota:");
            System.out.println("1. PROVA");
            System.out.println("2. TRABALHO");
            System.out.println("3. PROJETO");
            System.out.print("Digite a opção (1/2/3): ");
            String tipoNotaEscolhida = scanner.nextLine();

            TipoNota tipoNota = null;
            switch (tipoNotaEscolhida) {
                case "1":
                    tipoNota = TipoNota.PROVA;
                    break;
                case "2":
                    tipoNota = TipoNota.TRABALHO;
                    break;
                case "3":
                    tipoNota = TipoNota.PROJETO;
                    break;
                default:
                    System.out.println("Opção inválida. Nota não registrada.");
                    return;
            }

            System.out.print("Digite a nota (0 a 10): ");
            double nota = scanner.nextDouble();

            Nota novaNota = new Nota(nota, tipoNota);
            disciplinaEncontrada.adicionarNota(novaNota);
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
