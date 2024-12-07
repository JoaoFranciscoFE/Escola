package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.ICadastrar;
import br.com.escola.estrelaguia.Contracts.IConsultar;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Turma implements ICadastrar, IConsultar {
    private String nome;
    private int ano;
    private Set<Aluno> alunos;
    private String horario;
    private Professor professorResponsavel;

    public Turma(String nome, int ano, String horario, Professor professorResponsavel) {
        this.nome = nome;
        this.ano = ano;
        this.horario = horario;
        this.professorResponsavel = professorResponsavel;
        this.alunos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Set<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (aluno.getStatusMatricula().isAtivo()) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado à turma.");
        } else {
            System.out.println("Não foi possível adicionar o aluno " + aluno.getNome() + " pois ele não está com matrícula ativa.");
        }
    }

    public void removerAluno(Aluno aluno) {
        if (alunos.remove(aluno)) {
            System.out.println("Aluno " + aluno.getNome() + " removido da turma.");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma.");
        }
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public void exibirDadosTurma() {
        System.out.println("Turma: " + nome + " | Ano: " + ano + " | Horário: " + horario);
        if (professorResponsavel != null) {
            System.out.println("Professor responsável: " + professorResponsavel.getNome());
        }
        if (!alunos.isEmpty()) {
            System.out.println("Alunos matriculados:");
            for (Aluno aluno : alunos) {
                System.out.println("  - " + aluno.getNome());
            }
        } else {
            System.out.println("Nenhum aluno matriculado.");
        }
    }


    public int contarAlunos() {
        return alunos.size();
    }


    public Aluno buscarAlunoPorNome(String nome) {
        Optional<Aluno> alunoEncontrado = alunos.stream()
                .filter(aluno -> aluno.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return alunoEncontrado.orElse(null);
    }


    public boolean verificarAlunoMatriculado(Aluno aluno) {
        return alunos.contains(aluno);
    }


    public String listarAlunos() {
        if (alunos.isEmpty()) {
            return "Nenhum aluno matriculado.";
        }
        StringBuilder listaAlunos = new StringBuilder();
        for (Aluno aluno : alunos) {
            listaAlunos.append(aluno.getNome()).append(", ");
        }
        return listaAlunos.substring(0, listaAlunos.length() - 2); // Remove a última vírgula e espaço.
    }


    public void trocarProfessorResponsavel(Professor novoProfessor) {
        System.out.println("Professor responsável trocado de " +
                (professorResponsavel != null ? professorResponsavel.getNome() : "Nenhum") +
                " para " + novoProfessor.getNome());
        this.professorResponsavel = novoProfessor;
    }

    @Override
    public void consultar() {
        System.out.println("Consultando turma: " + nome);
        System.out.println("Ano: " + ano + " | Horário: " + horario);
        if (professorResponsavel != null) {
            System.out.println("Professor responsável: " + professorResponsavel.getNome());
        }
    }

    @Override
    public void cadastrar() {
        System.out.println("Turma " + nome + " cadastrada com sucesso!");
    }
}

