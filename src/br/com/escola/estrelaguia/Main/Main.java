package br.com.escola.estrelaguia.Main;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;
import br.com.escola.estrelaguia.Enums.TipoNota;
import br.com.escola.estrelaguia.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    static List<Aluno> alunos = new ArrayList<>();
    static List<Professor> professores = new ArrayList<>();
    static List<Disciplina> disciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                            System.out.println("Menu de Alunos\n1. Cadastrar Aluno\n2. Listar Alunos\n3. Buscar Aluno\n4. Atualizar Aluno\n5. Excluir Aluno\n6. Matricular Aluno em Disciplina\n7. Desmatricular Aluno de Disciplina\n8. Voltar");
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
                                        scanner.nextLine();

                                        System.out.println("Selecione o tipo de nota do aluno:");
                                        System.out.println("1 - Nota Parcial");
                                        System.out.println("2 - Nota Final");
                                        int tipoNota = scanner.nextInt();
                                        scanner.nextLine();

                                        TipoNota nota;
                                        if (tipoNota == 1) {
                                            nota = TipoNota.PARCIAL;
                                        } else if (tipoNota == 2) {
                                            nota = TipoNota.FINAL;
                                        } else {
                                            System.out.println("Tipo de nota inválido. Usando nota parcial como padrão.");
                                            nota = TipoNota.PARCIAL;
                                        }

                                        Aluno alunocriar = new Aluno(nomeAluno, cpfAluno, telefoneAluno, emailAluno, endereco, anoIngresso, nota);
                                        alunos.add(alunocriar);

                                        System.out.println("Aluno registrado com sucesso!");
                                        break;
                                    case 2:
                                        System.out.println("Lista de Alunos:");
                                        for (Aluno alunolista : alunos) {
                                            System.out.println("Nome: " + alunolista.getNome() + ", CPF: " + alunolista.getCpf() + ", Telefone: " + alunolista.getTelefone() + ", E-mail: " + alunolista.getEmail() + ", Endereço: " + alunolista.getEndereco() + ", Ano de Ingresso: " + alunolista.getAnoDeIngresso() + ", Status de Matrícula: " + alunolista.getStatusMatricula() + ", Disciplinas: " + alunolista.getDisciplinas().stream().map(Disciplina::getNome).collect(Collectors.joining(", ")));
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
                                                        break;
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
                                                a.getDisciplinas().removeIf(x -> x.getNome().equals(codigoDisciplinaDesmatricular));
                                                System.out.println("Aluno desmatriculado da disciplina com sucesso!");
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
                            System.out.println("Menu de Professores\n1. Cadastrar Professor\n2. Listar Professores\n3. Buscar Professor\n4. Atualizar Professor\n5. Excluir Professor\n6. Atribuir Professor a Disciplina\n7. Voltar");

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
                                        System.out.print("Digite o email do professor: ");
                                        String emailProfessor = scanner.nextLine();

                                        Professor professor = new Professor(nomeProfessor, cpfProfessor, departamentoProfessor, emailProfessor);
                                        professores.add(professor);

                                        System.out.println("Professor cadastrado com sucesso!");
                                        break;
                                    case 2:
                                        for (Professor p : professores) {
                                            System.out.println("Professor: " + p.getNome() + " - CPF: " + p.getCpf() + " - Departamento: " + p.getDepartamento() + " - E-mail: " + p.getEmail());
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
                            System.out.println("Menu de Disciplinas\n1. Cadastrar Disciplina\n2. Listar Disciplinas\n3. Buscar Disciplina\n4. Atualizar Disciplina\n5. Excluir Disciplina\n6. Voltar");
                            System.out.print("Digite uma opção:");
                            int opcaoDisciplina = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                switch (opcaoDisciplina) {
                                    case 1:
                                        System.out.print("Digite o nome da disciplina: ");
                                        String nomeDisciplina = scanner.nextLine();
                                        System.out.print("Digite a carga horária da disciplina: ");
                                        int cargaHoraria = scanner.nextInt();
                                        scanner.nextLine();
                                        System.out.print("Digite o nome do professor: ");
                                        String professor = scanner.nextLine();
                                        System.out.print("Digite o horário das aulas: ");
                                        String horarioAulas = scanner.nextLine();

                                        System.out.print("Digite o tipo de disciplina (CONCRETA, ELETIVA ou OBRIGATÓRIA): ");
                                        TipoDisciplina tipo = TipoDisciplina.valueOf(scanner.nextLine());

                                        Disciplina disciplina = null;
                                        if (tipo == TipoDisciplina.CONCRETA) {
                                            disciplina = new DisciplinaConcreta(nomeDisciplina, tipo , cargaHoraria, professor, horarioAulas);
                                        } else if (tipo == TipoDisciplina.ELETIVA) {
                                            System.out.print("Digite se a disciplina requer aprovação (SIM ou NÃO): ");
                                            boolean requerAprovacao = scanner.nextLine().equalsIgnoreCase("SIM");
                                            System.out.print("Digite a área de estudo da disciplina: ");
                                            String areaDeEstudo = scanner.nextLine();
                                            System.out.print("Digite a duração da disciplina em semanas: ");
                                            int duracaoSemanas = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Digite os recursos extras da disciplina: ");
                                            String recursosExtras = scanner.nextLine();

                                            disciplina = new DisciplinaEletiva(nomeDisciplina, requerAprovacao, areaDeEstudo, duracaoSemanas, recursosExtras);
                                        } else if (tipo == TipoDisciplina.OBRIGATORIA) {
                                            System.out.print("Digite a descrição da disciplina: ");
                                            String descricao = scanner.nextLine();

                                            disciplina = new DisciplinaObrigatoria(nomeDisciplina, cargaHoraria, professor, horarioAulas, descricao);
                                        }

                                        Professor professorResponsavel = null;
                                        for (Professor p : professores) {
                                            if (p.getNome().equals(professor)) {
                                                professorResponsavel = p;
                                                break;
                                            }
                                        }
                                        if (professorResponsavel != null) {
                                            professorResponsavel.adicionarDisciplina(disciplina);
                                        } else {
                                            System.out.println("Professor não encontrado");
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

                                        Professor professorResponsavelExcluir = null;
                                        Disciplina disciplinaExcluir = null;

                                        for (Professor p : professores) {
                                            for (Disciplina d : p.getDisciplinas()) {
                                                if (d.getNome().equals(codigoDisciplinaExcluir)) {
                                                    professorResponsavelExcluir = p;
                                                    disciplinaExcluir = d;
                                                    break;
                                                }
                                            }
                                            if (professorResponsavelExcluir != null) {
                                                break;
                                            }
                                        }

                                        if (professorResponsavelExcluir != null) {
                                            professorResponsavelExcluir.removerDisciplina(disciplinaExcluir);
                                            System.out.println("Disciplina excluída com sucesso!");
                                        } else {
                                            System.out.println("Disciplina não encontrada");
                                        }
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
