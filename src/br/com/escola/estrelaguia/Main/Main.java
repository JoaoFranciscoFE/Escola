package br.com.escola.estrelaguia.Main;

import br.com.escola.estrelaguia.Model.*;
import br.com.escola.estrelaguia.Enums.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static br.com.escola.estrelaguia.Model.Turma.buscarTurmaPorNome;

public class Main {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();
    public static List<Turma> turmas = new ArrayList<>();
    static Disciplina disciplina = new DisciplinaObrigatoria("Ciêncais", 10, "João", "Sexta", "Ciências");
    static Professor professor = new Professor("João", "1234", "Ciências");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    alunoMenu(scanner);
                    break;
                case 2:
                    professorMenu(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void alunoMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU ALUNO ===");
            System.out.println("1. Exibir Dados");
            System.out.println("2. Listar Disciplinas");
            System.out.println("3. Listar Turmas");
            System.out.println("4. Verificar Situação do Aluno");
            System.out.println("5. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int op = scanner.nextInt();

            switch (op) {
                case 1:
                    exibirDadosAluno(scanner);
                    break;
                case 2:
                    listarDisciplinasAluno(scanner);
                    break;
                case 3:
                    listarDisciplinasAluno(scanner);
                    break;
                case 4:
                    verificarSituacaoAluno(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void professorMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU PROFESSOR ===");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Matricular Aluno");
            System.out.println("4. Desmatricular Aluno");
            System.out.println("5. Adicionar Turma");
            System.out.println("6. Remover Turma");
            System.out.println("7. Exibir Dados");
            System.out.println("8. Listar Disciplinas");
            System.out.println("0. Retornar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                int op = scanner.nextInt();
                switch (op) {
                    case 1 -> cadastrarProfessor(scanner);
                    case 2 -> cadastrarAluno(scanner);
                    case 3 -> matricularAluno(scanner);
                    case 4 -> desmatricularAluno(scanner);
                    case 5 -> adicionarTurma(scanner);
                    case 6 -> removerTurma(scanner);
                    case 7 -> exibirDadosProfessor(scanner);
                    case 8 -> listarDisciplinasProfessor(scanner);
                    case 0 -> {
                        System.out.println("Retornando ao Menu Principal...");
                        return;
                    }
                    default -> System.out.println("Opção inválida. Por favor, insira um número entre 1 e 11.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }
    }

    private static void adicionarTurma(Scanner scanner) {
        System.out.print("Nome da Turma: ");
        String nomeTurma = scanner.nextLine();
        System.out.print("Descrição da Turma: ");
        String descricao = scanner.nextLine();

        Turma turma = new Turma(nomeTurma, disciplina, professor, 10);
        turmas.add(turma);
        System.out.println("Turma cadastrada com sucesso!");
    }



    private static void removerTurma(Scanner scanner) {
        System.out.print("Digite o nome da turma: ");
        String nomeTurma = scanner.nextLine();

        Turma turma = buscarTurmaPorNome(nomeTurma, turmas);
        if (turma != null) {
            turmas.remove(turma);
            System.out.println("Turma removida com sucesso!");
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    private static void cadastrarProfessor(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Departamento: ");
        String departamento = scanner.next();

        Professor professor = new Professor(nome, cpf, departamento);
        professores.add(professor);
        professor.cadastrar();
    }

    private static void cadastrarAluno(Scanner scanner) {
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
        alunos.add(aluno);
        aluno.cadastrar();
    }

    private static void matricularAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            aluno.matricular();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void desmatricularAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();
        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            aluno.desmatricular();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void adicionarDisciplina(Scanner scanner) {
        System.out.print("Nome da Disciplina: ");
        String disciplinaNome = scanner.nextLine();
        System.out.print("Carga Horária: ");
        int cargaHoraria = scanner.nextInt();
        System.out.print("Professor Responsável: ");
        String professorResponsavel = scanner.nextLine();
        System.out.print("Horário das Aulas: ");
        String horarioAulas = scanner.nextLine();
        System.out.print("Descrição do Conteúdo: ");
        String descricaoConteudo = scanner.nextLine();

        Disciplina disciplina = new DisciplinaObrigatoria(disciplinaNome, cargaHoraria, professorResponsavel, horarioAulas, descricaoConteudo);
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso!");
    }

    private static void exibirDadosAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            aluno.exibirDados();
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void listarDisciplinasAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            if (aluno.getDisciplinas().isEmpty()) {
                System.out.println("O aluno não está matriculado em nenhuma disciplina.");
            } else {
                System.out.println("Disciplinas do aluno " + aluno.getNome() + ": ");
                for (Disciplina disciplina : aluno.getDisciplinas()) {
                    System.out.println(" - " + disciplina.getNome());
                }
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void verificarSituacaoAluno(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpf = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpf);
        if (aluno != null) {
            String situacao = aluno.verificarSituacaoAluno();
            System.out.println(situacao);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    private static void atribuirDisciplinaAoProfessor(Scanner scanner) {
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();

        Professor professor = buscarProfessorPorCpf(cpf);
        if (professor != null) {
            System.out.print("Nome da Disciplina: ");
            String disciplinaNome = scanner.nextLine();
            Disciplina disciplina = new DisciplinaObrigatoria(disciplinaNome, 60, professor.getNome(), "15:00 - 17:00", "Conteúdo padrão");
            disciplinas.add(disciplina);
            professor.adicionarDisciplina(disciplina);
            System.out.println("Disciplina atribuída com sucesso!");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private static void removerDisciplinaDoProfessor(Scanner scanner) {
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();

        Professor professor = buscarProfessorPorCpf(cpf);
        if (professor != null) {
            System.out.print("Nome da Disciplina: ");
            String disciplinaNome = scanner.nextLine();
            Disciplina disciplina = buscarDisciplinaPorNome(disciplinaNome);
            if (disciplina != null) {
                professor.removerDisciplina(disciplina);
                disciplinas.remove(disciplina);
                System.out.println("Disciplina removida com sucesso!");
            } else {
                System.out.println("Disciplina não encontrada.");
            }
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private static void exibirDadosProfessor(Scanner scanner) {
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();

        Professor professor = buscarProfessorPorCpf(cpf);
        if (professor != null) {
            professor.exibirDados();
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private static void listarDisciplinasProfessor(Scanner scanner) {
        System.out.print("Digite o CPF do professor: ");
        String cpf = scanner.nextLine();

        Professor professor = buscarProfessorPorCpf(cpf);
        if (professor != null) {
            if (professor.getDisciplinas().isEmpty()) {
                System.out.println("O professor não leciona nenhuma disciplina.");
            } else {
                System.out.println("Disciplinas do professor " + professor.getNome() + ": ");
                for (Disciplina disciplina : professor.getDisciplinas()) {
                    System.out.println(" - " + disciplina.getNome());
                }
            }
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    private static Aluno buscarAlunoPorCpf(String cpf) {
        return alunos.stream()
                .filter(aluno -> aluno.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    private static Professor buscarProfessorPorCpf(String cpf) {
        return professores.stream()
                .filter(professor -> professor.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    private static Disciplina buscarDisciplinaPorNome(String nome) {
        return disciplinas.stream()
                .filter(disciplina -> disciplina.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }


    private static void matricularAlunoEmDisciplina(Scanner scanner) {
        System.out.print("Digite o CPF do aluno: ");
        String cpfAluno = scanner.nextLine();

        Aluno aluno = buscarAlunoPorCpf(cpfAluno);
        if (aluno != null) {
            System.out.print("Digite o nome da disciplina: ");
            String nomeDisciplina = scanner.nextLine();

            Disciplina disciplina = buscarDisciplinaPorNome(nomeDisciplina);
            if (disciplina != null) {
                if (aluno.getStatusMatricula() == StatusMatricula.ATIVO) {
                    disciplina.adicionarAluno(aluno);
                    aluno.adicionarDisciplina(disciplina);
                    System.out.println("Aluno " + aluno.getNome() + " matriculado na disciplina " + disciplina.getNome() + " com sucesso!");
                } else {
                    System.out.println("O aluno não está matriculado. Por favor, matricule-o antes.");
                }
            } else {
                System.out.println("Disciplina não encontrada.");
            }
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }
    private static void criarDisciplinaEletiva(Scanner scanner) {
        System.out.print("Nome da Disciplina Eletiva: ");
        String nome = scanner.nextLine();
        System.out.print("Requer Aprovação (true/false): ");
        boolean requerAprovacao = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Área de Estudo: ");
        String areaDeEstudo = scanner.nextLine();
        System.out.print("Duração (semanas): ");
        int duracaoSemanas = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Recursos Extras: ");
        String recursosExtras = scanner.nextLine();

        DisciplinaEletiva eletiva = new DisciplinaEletiva(nome, requerAprovacao, areaDeEstudo, duracaoSemanas, recursosExtras);
        disciplinas.add(eletiva);
        System.out.println("Disciplina Eletiva criada com sucesso!");
    }

    private static void listarDisciplinasEletivas() {
        System.out.println("\n=== DISCIPLINAS ELETIVAS ===");
        disciplinas.stream()
                .filter(d -> d instanceof DisciplinaEletiva)
                .forEach(d -> {
                    d.detalhesDisciplina();
                    System.out.println("-----------------------------");
                });
    }
    private static void gerenciarAlunosInteressados(Scanner scanner) {
        System.out.print("Digite o nome da disciplina eletiva: ");
        String nomeDisciplina = scanner.nextLine();

        DisciplinaEletiva eletiva = (DisciplinaEletiva) disciplinas.stream()
                .filter(d -> d instanceof DisciplinaEletiva && d.getNome().equalsIgnoreCase(nomeDisciplina))
                .findFirst()
                .orElse(null);

        if (eletiva != null) {
            System.out.println("\n=== GERENCIAR ALUNOS INTERESSADOS ===");
            System.out.println("1. Listar Alunos Interessados");
            System.out.println("2. Registrar Interesse de Aluno");
            System.out.println("3. Retornar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1 -> eletiva.listarInteressados();
                case 2 -> {
                    System.out.print("Digite o CPF do aluno: ");
                    String cpf = scanner.nextLine();
                    Aluno aluno = buscarAlunoPorCpf(cpf);
                    if (aluno != null) {
                        eletiva.registrarInteresse(aluno);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 3 -> System.out.println("Retornando...");
                default -> System.out.println("Opção inválida.");
            }
        } else {
            System.out.println("Disciplina Eletiva não encontrada.");
        }
    }

    public static void cadastrarTurma(Scanner scanner) {
        System.out.print("Nome da Turma: ");
        String nomeTurma = scanner.nextLine();
        System.out.print("Nome da Disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        Disciplina disciplina = buscarDisciplinaPorNome(nomeDisciplina);
        if (disciplina != null) {
            System.out.print("CPF do Professor Responsável: ");
            String cpfProfessor = scanner.nextLine();

            Professor professor = buscarProfessorPorCpf(cpfProfessor);
            if (professor != null) {
                System.out.print("Capacidade máxima: ");
                int capacidade = scanner.nextInt();
                scanner.nextLine();
                Turma novaTurma = new Turma(nomeTurma, disciplina, professor, capacidade);
                System.out.println("Turma cadastrada com sucesso!");
            } else {
                System.out.println("Professor não encontrado.");
            }
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public static void adicionarAlunoTurma(Scanner scanner, List<Turma> turmas) {
        System.out.print("Nome da Turma: ");
        String nomeTurma = scanner.nextLine();
        Turma turma = buscarTurmaPorNome(nomeTurma, turmas);

        if (turma != null) {
            System.out.print("CPF do Aluno: ");
            String cpfAluno = scanner.nextLine();
            Aluno aluno = buscarAlunoPorCpf(cpfAluno);

            if (aluno != null) {
                if (turma.adicionarAluno(aluno)) {
                    System.out.println("Aluno adicionado com sucesso.");
                }
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
    public static void removerAlunoTurma(Scanner scanner, List<Turma> turmas) {
        System.out.print("Nome da Turma: ");
        String nomeTurma = scanner.nextLine();
        Turma turma = buscarTurmaPorNome(nomeTurma, turmas);

        if (turma != null) {
            System.out.print("CPF do Aluno: ");
            String cpfAluno = scanner.nextLine();
            Aluno aluno = buscarAlunoPorCpf(cpfAluno);

            if (aluno != null) {
                if (turma.removerAluno(aluno)) {
                    System.out.println("Aluno removido com sucesso.");
                }
            } else {
                System.out.println("Aluno não encontrado.");
            }
        } else {
            System.out.println("Turma não encontrada.");
        }
    }
}