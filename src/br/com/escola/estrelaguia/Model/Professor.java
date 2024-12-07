package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.ICadastrar;
import br.com.escola.estrelaguia.Contracts.IConsultar;
import br.com.escola.estrelaguia.Enums.TipoPessoa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Professor extends Pessoa implements ICadastrar, IConsultar {
    private String departamento;
    private Set<Disciplina> disciplinas;

    public Professor(String nome, String cpf, String departamento) {
        super(nome, cpf, TipoPessoa.PROFESSOR);
        this.departamento = departamento;
        this.disciplinas = new HashSet<>();
    }

    // Métodos getters e setters básicos
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        if (disciplinas.contains(disciplina)) {
            System.out.println("A disciplina " + disciplina.getNome() + " já está atribuída ao professor.");
        } else {
            disciplinas.add(disciplina);
            System.out.println("Disciplina " + disciplina.getNome() + " atribuída ao professor " + getNome() + ".");
        }
    }

    public void removerDisciplina(Disciplina disciplina) {
        if (disciplinas.remove(disciplina)) {
            System.out.println("Disciplina " + disciplina.getNome() + " removida do professor " + getNome() + ".");
        } else {
            System.out.println("Disciplina " + disciplina.getNome() + " não encontrada na lista do professor.");
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("Professor: " + getNome() + " | CPF: " + getCpf() + " | Departamento: " + departamento);
        if (!disciplinas.isEmpty()) {
            System.out.println("Disciplinas: ");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("  - " + disciplina.getNome());
            }
        } else {
            System.out.println("Nenhuma disciplina atribuída.");
        }
    }

    public int contarDisciplinas() {
        return disciplinas.size();
    }


    public boolean ensinaDisciplina(Disciplina disciplina) {
        return disciplinas.contains(disciplina);
    }

    public Disciplina buscarDisciplinaPorNome(String nome) {
        Optional<Disciplina> disciplinaEncontrada = disciplinas.stream()
                .filter(disciplina -> disciplina.getNome().equalsIgnoreCase(nome))
                .findFirst();
        return disciplinaEncontrada.orElse(null);
    }

    public String listarDisciplinas() {
        if (disciplinas.isEmpty()) {
            return "Nenhuma disciplina atribuída.";
        }
        StringBuilder lista = new StringBuilder();
        for (Disciplina disciplina : disciplinas) {
            lista.append(disciplina.getNome()).append(", ");
        }
        return lista.substring(0, lista.length() - 2);
    }

    public void trocarDepartamento(String novoDepartamento) {
        System.out.println("Departamento do professor " + getNome() + " alterado de " + departamento + " para " + novoDepartamento + ".");
        this.departamento = novoDepartamento;
    }

    @Override
    public void consultar() {
        System.out.println("Consultando professor: " + getNome());
        System.out.println("Departamento: " + departamento);
        if (!disciplinas.isEmpty()) {
            System.out.println("Disciplinas ministradas: ");
            for (Disciplina disciplina : disciplinas) {
                System.out.println("  - " + disciplina.getNome());
            }
        }
    }

    @Override
    public void cadastrar() {
        System.out.println("Professor " + getNome() + " cadastrado com sucesso!");
    }
}
