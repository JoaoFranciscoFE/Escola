package br.com.escola.estrelaguia.Main;


import br.com.escola.estrelaguia.Enums.TipoDisciplina;
import br.com.escola.estrelaguia.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Aluno> alunos = new ArrayList<>();
    static List<Professor> professores = new ArrayList<>();
    static List<Disciplina> disciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = null;
        boolean menuInicial = true;
        while (menuInicial) {
            try {
                System.out.println("Menu Principal");
                System.out.println("1. Alunos");
                System.out.println("2. Professores");
                System.out.println("3. Disciplinas");
                System.out.println("4. Sair");

                System.out.println("Digite uma opção:");
                int opcaoMenuInicial = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoMenuInicial) {
                    case 1:
                        boolean menuAlunos = true;
                        while (menuAlunos) {
                            System.out.println("Menu de Alunos");
                            System.out.println("1. Cadastrar Aluno");
                            System.out.println("2. Listar Alunos");
                            System.out.println("3. Buscar Aluno");
                            System.out.println("4. Atualizar Aluno");
                            System.out.println("5. Excluir Aluno");
                            System.out.println("6. Matricular Aluno em Disciplina");
                            System.out.println("7. Desmatricular Aluno de Disciplina");
                            System.out.println("8. Voltar");

                            System.out.print("Digite uma opção:");
                            int opcaoAluno = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (opcaoAluno) {
                                    case 1:
                                        System.out.print("Digite o nome do aluno: ");
                                        String nomeAluno = scanner.nextLine();
                                        System.out.print("Digite o CPF do aluno: ");
                                        String cpfAluno = scanner.nextLine();
                                        System.out.print("Digite o telefone do aluno: ");
                                        String telefoneAluno = scanner.nextLine();
                                        System.out.print("Digite o e-mail do aluno: ");
                                        String emailAluno = scanner.nextLine();
                                        System.out.print("Digite o endereco do aluno: ");
                                        String endereco = scanner.nextLine();
                                        System.out.print("Digite o ano de ingresso do aluno: ");
                                        int anoIngresso = scanner.nextInt();

                                        aluno = new Aluno(nomeAluno, cpfAluno, telefoneAluno, emailAluno, endereco, anoIngresso);
                                        alunos.add(aluno);

                                        System.out.println("Aluno registrado com sucesso!");
                                        break;
                                    case 2:
                                        for (Aluno a : alunos) {
                                            System.out.println(a.getNome() + " - " + a.getCpf());
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Digite o CPF do aluno: ");
                                        String cpfAlunoBuscar = scanner.nextLine();

                                        for (Aluno a : alunos) {
                                            if (a.getCpf().equals(cpfAlunoBuscar)) {
                                                System.out.println(a.getNome() + " - " + a.getCpf());
                                            }
                                        }
                                        break;
                                    case 4:
                                        System.out.print("Digite o CPF do aluno: ");
                                        String cpfAlunoAtualizar = scanner.nextLine();
                                        System.out.print("Digite o novo nome do aluno: ");
                                        String nomeAlunoAtualizar = scanner.nextLine();
                                        System.out.print("Digite o novo e-mail do aluno: ");
                                        String emailAlunoAtualizar = scanner.nextLine();

                                        for (Aluno a : alunos) {
                                            if (a.getCpf().equals(cpfAlunoAtualizar)) {
                                                a.setNome(nomeAlunoAtualizar);
                                                a.setEmail(emailAlunoAtualizar);
                                            }
                                        }

                                        System.out.println("Aluno atualizado com sucesso!");
                                        break;
                                    case 5:
                                        System.out.print("Digite o CPF do aluno: ");
                                        String cpfAlunoExcluir = scanner.nextLine();

                                        alunos.removeIf(a -> a.getCpf().equals(cpfAlunoExcluir));

                                        System.out.println("Aluno excluído com sucesso!");
                                        break;

                                    case 6:
                                        System.out.print("Digite o CPF do aluno: ");
                                        String cpfAlunoMatricular = scanner.nextLine();
                                        System.out.print("Digite o código da disciplina: ");
                                        String codigoDisciplinaMatricular = scanner.nextLine();

                                        for (Aluno a : alunos) {
                                            if (a.getCpf().equals(cpfAlunoMatricular)) {
                                                for (Disciplina d : disciplinas) {
                                                    if (d.getNome().equals(codigoDisciplinaMatricular)) {
                                                        a.getDisciplinas().add(d);
                                                        System.out.println("Aluno matriculado na disciplina com sucesso!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 7:
                                        System.out.print("Digite o CPF do aluno: ");
                                        String cpfAlunoDesmatricular = scanner.nextLine();
                                        System.out.print("Digite o código da disciplina: ");
                                        String codigoDisciplinaDesmatricular = scanner.nextLine();

                                        for (Aluno a : alunos) {
                                            if (a.getCpf().equals(cpfAlunoDesmatricular)) {
                                                for (Disciplina d : disciplinas) {
                                                    if (d.getNome().equals(codigoDisciplinaDesmatricular)) {
                                                        a.getDisciplinas().remove(d);
                                                        System.out.println("Aluno desmatriculado da disciplina com sucesso!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 8:
                                        menuAlunos = false;
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                            } catch (Exception e) {
                                System.err.println("Erro no menu de alunos: " + e.getMessage());
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 2:
                        boolean menuProfessores = true;
                        while (menuProfessores) {
                            System.out.println("Menu de Professores");
                            System.out.println("1. Cadastrar Professor");
                            System.out.println("2. Listar Professores");
                            System.out.println("3. Buscar Professor");
                            System.out.println("4. Atualizar Professor");
                            System.out.println("5. Excluir Professor");
                            System.out.println("6. Atribuir Professor a Disciplina");
                            System.out.println("7. Voltar");

                            System.out.print("Digite uma opção:");
                            int opcaoProfessor = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (opcaoProfessor) {
                                    case 1:
                                        System.out.print("Digite o nome do professor: ");
                                        String nomeProfessor = scanner.nextLine();
                                        System.out.print("Digite o CPF do professor: ");
                                        String cpfProfessor = scanner.nextLine();
                                        System.out.print("Digite o departamento do professor: ");
                                        String departamentoProfessor = scanner.nextLine();

                                        Professor professor = new Professor(nomeProfessor, cpfProfessor, departamentoProfessor);
                                        professores.add(professor);

                                        System.out.println("Professor cadastrado com sucesso!");
                                        break;
                                    case 2:
                                        for (Professor p : professores) {
                                            System.out.println(p.getNome() + " - " + p.getCpf());
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Digite o CPF do professor: ");
                                        String cpfProfessorBuscar = scanner.nextLine();

                                        for (Professor p : professores) {
                                            if (p.getCpf().equals(cpfProfessorBuscar)) {
                                                System.out.println(p.getNome() + " - " + p.getCpf());
                                            }
                                        }
                                        break;
                                    case 4:
                                        System.out.print("Digite o CPF do professor: ");
                                        String cpfProfessorAtualizar = scanner.nextLine();
                                        System.out.print("Digite o novo nome do professor: ");
                                        String nomeProfessorAtualizar = scanner.nextLine();
                                        System.out.print("Digite o novo e-mail do professor: ");
                                        String emailProfessorAtualizar = scanner.nextLine();

                                        for (Professor p : professores) {
                                            if (p.getCpf().equals(cpfProfessorAtualizar)) {
                                                p.setNome(nomeProfessorAtualizar);
                                                p.setEmail(emailProfessorAtualizar);
                                            }
                                        }

                                        System.out.println("Professor atualizado com sucesso!");
                                        break;
                                    case 5:
                                        System.out.print("Digite o CPF do professor: ");
                                        String cpfProfessorExcluir = scanner.nextLine();

                                        professores.removeIf(p -> p.getCpf().equals(cpfProfessorExcluir));

                                        System.out.println("Professor excluído com sucesso!");
                                        break;
                                    case 6:
                                        System.out.print("Digite o CPF do professor: ");
                                        String cpfProfessorAtribuir = scanner.nextLine();
                                        System.out.print("Digite o código da disciplina: ");
                                        String codigoDisciplinaAtribuir = scanner.nextLine();

                                        for (Professor p : professores) {
                                            if (p.getCpf().equals(cpfProfessorAtribuir)) {
                                                for (Disciplina d : disciplinas) {
                                                    if (d.getNome().equals(codigoDisciplinaAtribuir)) {
                                                        p.getDisciplinas().add(d);
                                                        System.out.println("Professor atribuído à disciplina com sucesso!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 7:
                                        menuProfessores = false;
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                            } catch (Exception e) {
                                System.err.println("Erro no menu de professores: " + e.getMessage());
                                scanner.nextLine();
                            }
                        }
                        break;
                    case 3:
                        boolean menuDisciplinas = true;
                        while (menuDisciplinas) {
                            System.out.println("Menu de Disciplinas");
                            System.out.println("1. Cadastrar Disciplina");
                            System.out.println("2. Listar Disciplinas");
                            System.out.println("3. Buscar Disciplina");
                            System.out.println("4. Atualizar Disciplina");
                            System.out.println("5. Excluir Disciplina");
                            System.out.println("6. Voltar");

                            System.out.print("Digite uma opção:");
                            int opcaoDisciplina = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (opcaoDisciplina) {
                                    case 1:
                                        System.out.print("Digite o nome da disciplina: ");
                                        String nomeDisciplina = scanner.nextLine();
                                        System.out.print("Digite o tipo da disciplina (TEÓRICA ou PRÁTICA): ");
                                        TipoDisciplina tipoDisciplina = TipoDisciplina.valueOf(scanner.nextLine().toUpperCase());
                                        System.out.print("Digite a carga horária da disciplina: ");
                                        int cargaHoraria = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Digite o nome do professor: ");
                                        String professor = scanner.nextLine();
                                        System.out.print("Digite o horário das aulas: ");
                                        String horarioAulas = scanner.nextLine();

                                        System.out.print("Digite o tipo de disciplina (CONCRETA ou ELETIVA): ");
                                        String tipo = scanner.nextLine();

                                        if (tipo.equalsIgnoreCase("CONCRETA")) {
                                            Disciplina disciplina = new DisciplinaConcreta(nomeDisciplina, tipoDisciplina, cargaHoraria, professor, horarioAulas);
                                            disciplinas.add(disciplina);
                                        } else if (tipo.equalsIgnoreCase("ELETIVA")) {
                                            System.out.print("Digite se a disciplina requer aprovação (SIM ou NÃO): ");
                                            boolean requerAprovacao = scanner.nextLine().equalsIgnoreCase("SIM");
                                            System.out.print("Digite a área de estudo da disciplina: ");
                                            String areaDeEstudo = scanner.nextLine();
                                            System.out.print("Digite a duração da disciplina em semanas: ");
                                            int duracaoSemanas = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Digite os recursos extras da disciplina: ");
                                            String recursosExtras = scanner.nextLine();

                                            Disciplina disciplina = new DisciplinaEletiva(nomeDisciplina, requerAprovacao, areaDeEstudo, duracaoSemanas, recursosExtras);
                                            disciplinas.add(disciplina);
                                        }

                                        System.out.println("Disciplina cadastrada com sucesso!");
                                        break;
                                    case 2:
                                        for (Disciplina d : disciplinas) {
                                            System.out.println(d.getNome());
                                        }
                                        break;
                                    case 3:
                                        System.out.print("Digite o código da disciplina: ");
                                        String codigoDisciplinaBuscar = scanner.nextLine();

                                        for (Disciplina d : disciplinas) {
                                            if (d.getNome().equals(codigoDisciplinaBuscar)) {
                                                System.out.println(d.getNome());
                                            }
                                        }
                                        break;
                                    case 4:
                                        System.out.print("Digite o código da disciplina: ");
                                        String codigoDisciplinaAtualizar = scanner.nextLine();
                                        System.out.print("Digite o novo nome da disciplina: ");
                                        String nomeDisciplinaAtualizar = scanner.nextLine();

                                        for (Disciplina d : disciplinas) {
                                            if (d.getNome().equals(codigoDisciplinaAtualizar)) {
                                                d.setNome(nomeDisciplinaAtualizar);
                                            }
                                        }

                                        System.out.println("Disciplina atualizada com sucesso!");
                                        break;
                                    case 5:
                                        System.out.print("Digite o código da disciplina: ");
                                        String codigoDisciplinaExcluir = scanner.nextLine();

                                        disciplinas.removeIf(d -> d.getNome().equals(codigoDisciplinaExcluir));

                                        System.out.println("Disciplina excluída com sucesso!");
                                        break;
                                    case 6:
                                        menuDisciplinas = false;
                                        break;
                                    default:
                                        System.out.println("Opção inválida. Tente novamente.");
                                }
                            } catch (Exception e) {
                                System.err.println("Erro no menu de disciplinas: " + e.getMessage());
                                scanner.nextLine();
                            }
                        }
                        break;
                }
            } catch (Exception e) {
                System.err.println("Erro no menu geral: " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
