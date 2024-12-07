package br.com.escola.estrelaguia.Main;

import br.com.escola.estrelaguia.DAO.AlunoDAO;
import br.com.escola.estrelaguia.DAO.DisciplinaCoDAO;
import br.com.escola.estrelaguia.DAO.ProfessorDAO;
import br.com.escola.estrelaguia.Enums.TipoDisciplina;
import br.com.escola.estrelaguia.Model.*;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Menu Principal");
            System.out.println("1. Alunos");
            System.out.println("2. Professores");
            System.out.println("3. Disciplinas");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Alunos (para não se perder)
                    System.out.println("Menu de Alunos");
                    System.out.println("1. Cadastrar Aluno");
                    System.out.println("2. Listar Alunos");
                    System.out.println("3. Buscar Aluno");
                    System.out.println("4. Atualizar Aluno");
                    System.out.println("5. Excluir Aluno");
                    System.out.println("6. Matricular Aluno em Disciplina");
                    System.out.println("7. Desmatricular Aluno de Disciplina");
                    System.out.println("8. Voltar");

                    int opcaoAluno = scanner.nextInt();
                    scanner.nextLine();

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
                            int anoingreco = scanner.nextInt();

                            Aluno aluno = new Aluno(nomeAluno, cpfAluno, telefoneAluno, emailAluno, endereco, anoingreco);
                            AlunoDAO alunoDAO = new AlunoDAO();
                            alunoDAO.cadastrarAluno(aluno);

                            System.out.println("Aluno registrado com sucesso!");
                            break;
                        case 2:

                            AlunoDAO alunoDAO2 = new AlunoDAO();
                            List<Aluno> alunos = alunoDAO2.buscarAlunos();

                            for (Aluno a : alunos) {
                                System.out.println(a.getNome() + " - " + a.getCpf());
                            }
                            break;
                        case 3:
                            System.out.print("Digite o CPF do aluno: ");
                            String cpfAlunoBuscar = scanner.nextLine();

                            AlunoDAO alunoDAO3 = new AlunoDAO();
                            Aluno alunoBuscar = alunoDAO3.buscarAlunoPorCpf(cpfAlunoBuscar);

                            if (alunoBuscar != null) {
                                System.out.println(alunoBuscar.getNome() + " - " + alunoBuscar.getCpf());
                            } else {
                                System.out.println("Aluno não encontrado!");
                            }
                            break;
                        case 4:
                            System.out.print("Digite o CPF do aluno: ");
                            String cpfAlunoAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo nome do aluno: ");
                            String nomeAlunoAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo e-mail do aluno: ");
                            String emailAlunoAtualizar = scanner.nextLine();

                            AlunoDAO alunoDAO4 = new AlunoDAO();
                            alunoDAO4.atualizarAluno(cpfAlunoAtualizar, nomeAlunoAtualizar, emailAlunoAtualizar);

                            System.out.println("Aluno atualizado com sucesso!");
                            break;
                        case 5:
                            System.out.print("Digite o CPF do aluno: ");
                            String cpfAlunoExcluir = scanner.nextLine();

                            AlunoDAO alunoDAO5 = new AlunoDAO();
                            alunoDAO5.excluirAluno(cpfAlunoExcluir);

                            System.out.println("Aluno excluído com sucesso!");
                            break;
                        case 6:
                            System.out.print("Digite o CPF do aluno: ");
                            String cpfAlunoMatricular = scanner.nextLine();
                            System.out.print("Digite o código da disciplina: ");
                            String codigoDisciplinaMatricular = scanner.nextLine();

                            AlunoDAO alunoDAO6 = new AlunoDAO();
                            try {
                                alunoDAO6.matricularAluno(aluno, cpfAlunoMatricular, codigoDisciplinaMatricular);
                                System.out.println("Aluno matriculado na disciplina com sucesso!");
                            } catch (Exception e) {
                                System.out.println("Erro ao matricular aluno: " + e.getMessage());
                            }
                            break;
                        case 7:
                            System.out.print("Digite o CPF do aluno: ");
                            String cpfAlunoDesmatricular = scanner.nextLine();
                            System.out.print("Digite o código da disciplina: ");
                            String codigoDisciplinaDesmatricular = scanner.nextLine();

                            AlunoDAO alunoDAO7 = new AlunoDAO();
                            try {
                                alunoDAO7.desmatricularAluno(aluno, cpfAlunoDesmatricular, codigoDisciplinaDesmatricular);
                                System.out.println("Aluno desmatriculado da disciplina com sucesso!");
                            } catch (Exception e) {
                                System.out.println("Erro ao desmatricular aluno: " + e.getMessage());
                            }
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                case 2:
                    // Menu de Professores (para não se perder)
                    System.out.println("Menu de Professores");
                    System.out.println("1. Cadastrar Professor");
                    System.out.println("2. Listar Professores");
                    System.out.println("3. Buscar Professor");
                    System.out.println("4. Atualizar Professor");
                    System.out.println("5. Excluir Professor");
                    System.out.println("6. Atribuir Professor a Disciplina");
                    System.out.println("7. Voltar");

                    int opcaoProfessor = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcaoProfessor) {
                        case 1:

                            System.out.print("Digite o nome do professor: ");
                            String nomeProfessor = scanner.nextLine();
                            System.out.print("Digite o CPF do professor: ");
                            String cpfProfessor = scanner.nextLine();
                            System.out.print("Digite o departamento do professor: ");
                            String departamentoProfessor = scanner.nextLine();

                            ProfessorDAO professorDAO = new ProfessorDAO();
                            Professor professor = professorDAO.criarProfessor(nomeProfessor, cpfProfessor, departamentoProfessor);

                            System.out.println("Professor criado com sucesso!");
                            break;
                        case 2:
                            ProfessorDAO professorDAO2 = new ProfessorDAO();
                            List<Professor> professores = professorDAO2.listarProfessores();

                            for (Professor p : professores) {
                                System.out.println(p.getNome() + " - " + p.getCpf());
                            }
                            break;
                        case 3:
                            System.out.print("Digite o CPF do professor: ");
                            String cpfProfessorBuscar = scanner.nextLine();

                            ProfessorDAO professorDAO3 = new ProfessorDAO();
                            Professor professorBuscar = professorDAO3.buscarProfessor(cpfProfessorBuscar);

                            if (professorBuscar != null) {
                                System.out.println(professorBuscar.getNome() + " - " + professorBuscar.getCpf());
                            } else {
                                System.out.println("Professor não encontrado!");
                            }
                            break;
                        case 4:
                            System.out.print("Digite o CPF do professor: ");
                            String cpfProfessorAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo nome do professor: ");
                            String nomeProfessorAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo e-mail do professor: ");
                            String emailProfessorAtualizar = scanner.nextLine();

                            ProfessorDAO professorDAO4 = new ProfessorDAO();
                            professorDAO4.atualizarProfessor(cpfProfessorAtualizar, nomeProfessorAtualizar, emailProfessorAtualizar);

                            System.out.println("Professor atualizado com sucesso!");
                            break;
                        case 5:
                            System.out.print("Digite o CPF do professor: ");
                            String cpfProfessorExcluir = scanner.nextLine();

                            ProfessorDAO professorDAO5 = new ProfessorDAO();
                            professorDAO5.excluirProfessor(cpfProfessorExcluir);

                            System.out.println("Professor excluído com sucesso!");
                            break;
                        case 6:
                            System.out.print("Digite o CPF do professor: ");
                            String cpfProfessorAtribuir = scanner.nextLine();
                            System.out.print("Digite o código da disciplina: ");
                            String codigoDisciplinaAtribuir = scanner.nextLine();

                            ProfessorDAO professorDAO6 = new ProfessorDAO();
                            professorDAO6.atribuirProfessor(cpfProfessorAtribuir, codigoDisciplinaAtribuir);

                            System.out.println("Professor atribuído com sucesso!");
                            break;
                        case 7:
                            break;
                    }
                    break;
                case 3:
                    // Menu de Disciplinas (para não se perder)
                    System.out.println("Menu de Disciplinas");
                    System.out.println("1. Cadastrar Disciplina");
                    System.out.println("2. Listar Disciplinas");
                    System.out.println("3. Buscar Disciplina");
                    System.out.println("4. Atualizar Disciplina");
                    System.out.println("5. Excluir Disciplina");
                    System.out.println("6. Voltar");

                    int opcaoDisciplina = scanner.nextInt();
                    scanner.nextLine();

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

                            DisciplinaConcreta disciplina = new DisciplinaConcreta(nomeDisciplina, tipoDisciplina, cargaHoraria, professor, horarioAulas);
                            DisciplinaCoDAO disciplinaConcretaDAO = new DisciplinaCoDAO();
                            disciplinaConcretaDAO.addDisciplina(disciplina);

                            System.out.println("Disciplina cadastrada com sucesso!");
                            break;
                        case 2:
                            // Listar Disciplinas
                            DisciplinaCoDAO disciplinaConcretaDAO2 = new DisciplinaCoDAO();
                            List<DisciplinaConcreta> disciplinas = disciplinaConcretaDAO2.listarDisciplinasConcretas();

                            for (Disciplina d : disciplinas) {
                                System.out.println(d.getNome());
                            }
                            break;
                        case 3:
                            // Buscar Disciplina
                            System.out.print("Digite o código da disciplina: ");
                            String codigoDisciplinaBuscar = scanner.nextLine();

                            DisciplinaCoDAO disciplinaConcretaDAO3 = new DisciplinaCoDAO();
                            Disciplina disciplinaBuscar = disciplinaConcretaDAO3.econtrarDisciplinaporNome(codigoDisciplinaBuscar);

                            if (disciplinaBuscar != null) {
                                System.out.println(disciplinaBuscar.getNome());
                            } else {
                                System.out.println("Disciplina não encontrada!");
                            }
                            break;
                        case 4:
                            // Atualizar Disciplina
                            System.out.print("Digite o código da disciplina: ");
                            String codigoDisciplinaAtualizar = scanner.nextLine();
                            System.out.print("Digite o novo nome da disciplina: ");
                            String nomeDisciplinaAtualizar = scanner.nextLine();

                            DisciplinaCoDAO disciplinaConcretaDAO4 = new DisciplinaCoDAO();
                            DisciplinaConcreta disciplinaAtualizar = (DisciplinaConcreta) disciplinaConcretaDAO4.econtrarDisciplinaporNome(codigoDisciplinaAtualizar);
                            if (disciplinaAtualizar != null) {
                                disciplinaAtualizar.setNome(nomeDisciplinaAtualizar);
                                disciplinaConcretaDAO4.atualizarDisciplina(disciplinaAtualizar);
                                System.out.println("Disciplina atualizada com sucesso!");
                            } else {
                                System.out.println("Disciplina não encontrada!");
                            }
                            break;
                        case 5:
                            System.out.print("Digite o código da disciplina: ");
                            String codigoDisciplinaExcluir = scanner.nextLine();
                            DisciplinaCoDAO disciplinaConcretaDAO5 = new DisciplinaCoDAO();
                            Disciplina disciplinaExcluir = disciplinaConcretaDAO5.econtrarDisciplinaporNome(codigoDisciplinaExcluir);
                            if (disciplinaExcluir != null) {
                                disciplinaConcretaDAO5.removeDisciplina(disciplinaExcluir);
                                System.out.println("Disciplina excluída com sucesso!");
                            } else {
                                System.out.println("Disciplina não encontrada!");
                            }
                            break;
                        case 6:
                            // Voltar
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada de dados. Tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}