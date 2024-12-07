package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.IAvaliar;
import br.com.escola.estrelaguia.Contracts.ICadastrar;
import br.com.escola.estrelaguia.Contracts.IConsultar;
import br.com.escola.estrelaguia.Contracts.IMatriculavel;
import br.com.escola.estrelaguia.Enums.StatusMatricula;
import br.com.escola.estrelaguia.Enums.TipoDisciplina;
import br.com.escola.estrelaguia.Enums.TipoPessoa;

import java.util.HashSet;
import java.util.Set;

public class Aluno extends Pessoa implements IAvaliar, IMatriculavel, IConsultar, ICadastrar {
    private StatusMatricula statusMatricula;
    private Set<Disciplina> disciplinas;
    private String telefone;
    private String email;
    private String endereco;
    private double mediaGeral;
    private int totalFaltas;
    private int anoDeIngresso;

    public Aluno(String nome, String cpf, String telefone, String email, String endereco, int anoDeIngresso) {
        super(nome, cpf, TipoPessoa.ALUNO);
        this.statusMatricula = StatusMatricula.DESMATRICULADO;
        this.disciplinas = new HashSet<>();
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.mediaGeral = 0.0;
        this.totalFaltas = 0;
        this.anoDeIngresso = anoDeIngresso;
    }

    public boolean isAtivo() {
        return statusMatricula == StatusMatricula.ATIVO;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusMatricula getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(StatusMatricula statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    @Override
    public void exibirDados() {
        System.out.println("Aluno: " + getNome() +
                " | CPF: " + getCpf() +
                " | Status Matrícula: " + statusMatricula +
                " | Telefone: " + telefone +
                " | Email: " + email +
                " | Endereço: " + endereco +
                " | Média Geral: " + mediaGeral +
                " | Faltas: " + totalFaltas +
                " | Ano de Ingresso: " + anoDeIngresso);
    }
    @Override
    public boolean verificarAprovacao() {
        if (statusMatricula != StatusMatricula.ATIVO) {
            System.out.println(getNome() + " não está matriculado.");
            return false; // Se o aluno estiver sem matricula, n tem nem como ele se aprovar
        }

        boolean aprovado = true;

        // Ve se o aluno tá lascado em alguma disciplina
        for (Disciplina disciplina : disciplinas) {
            double mediaNotas = calcularMediaNotas(disciplina);

            // Se for uma disciplina obrigatória e a média for inferior a 6, reprovou de primeira, patrão
            if (disciplina.getTipo() == TipoDisciplina.OBRIGATORIA && mediaNotas < 6) {
                aprovado = false;
                System.out.println(getNome() + " não foi aprovado em " + disciplina.getNome() + " (Disciplina Obrigatória).");
            }
            // Se for uma disciplina eletiva e a média for inferior a 5, reprovou igual patrão, não tem jeito
            if (disciplina.getTipo() == TipoDisciplina.ELETIVA && mediaNotas < 5) {
                aprovado = false;
                System.out.println(getNome() + " não foi aprovado em " + disciplina.getNome() + " (Disciplina Eletiva).");
            }
        }

        return aprovado;
    }

    private double calcularMediaNotas(Disciplina disciplina) {
        double somaNotas = 0;
        int quantidadeNotas = disciplina.getNotas().size();

        // Vê se o cara tem algo né
        if (quantidadeNotas == 0) {
            return 0;
        }

        for (Nota nota : disciplina.getNotas()) {
            somaNotas += nota.getValor();
        }

        // Calcula e retorna a média
        return somaNotas / quantidadeNotas;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @Override
    public void exibirResumoNota() {
        for (Disciplina disciplina : disciplinas) {
            System.out.println("Disciplina: " + disciplina.getNome());
            for (Nota nota : disciplina.getNotas()) {
                System.out.println("  Nota: " + nota.getValor() + " | Tipo: " + nota.getTipo());
            }
        }
    }

    @Override
    public void matricular() {
        if (statusMatricula == StatusMatricula.DESMATRICULADO) {
            statusMatricula = StatusMatricula.ATIVO;
            System.out.println(getNome() + " foi matriculado.");
        } else {
            System.out.println(getNome() + " já está matriculado.");
        }
    }

    @Override
    public void desmatricular() {
        if (statusMatricula == StatusMatricula.ATIVO) {
            statusMatricula = StatusMatricula.DESMATRICULADO;
            System.out.println(getNome() + " foi desmatriculado.");
        } else {
            System.out.println(getNome() + " não está matriculado.");
        }
    }

    @Override
    public void consultar() {
        System.out.println("Consultando informações de " + getNome() + "...");

    }
    @Override
    public void cadastrar() {
        System.out.println("Aluno " + getNome() + " cadastrado com sucesso!");
    }
}
