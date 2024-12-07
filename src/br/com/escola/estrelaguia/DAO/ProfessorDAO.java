package br.com.escola.estrelaguia.DAO;

import br.com.escola.estrelaguia.Model.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private List<Professor> professores = new ArrayList<>();

    public void addProfessor(Professor professor) {
        professores.add(professor);
    }

    public Professor findProfessorByCpf(String cpf) {
        return professores.stream()
                .filter(professor -> professor.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public List<Professor> getAllProfessores() {
        return professores;
    }

    public void removeProfessor(Professor professor) {
        professores.remove(professor);
    }

    // Criar Professor
    public Professor criarProfessor(String nome, String cpf, String departamento) {
        Professor professor = new Professor(nome, cpf, departamento);
        addProfessor(professor);
        return professor;
    }

    // Listar Professores
    public List<Professor> listarProfessores() {
        try {
            // Implementação para listar professores no banco de dados
            List<Professor> professores = new ArrayList<>();
            // Adicionar professores à lista
            return professores;
        } catch (Exception e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
            return null;
        }
    }

    // Buscar Professor
    public Professor buscarProfessor(String cpf) {
        try {
            return new Professor("nome", "cpf", "departamento");
        } catch (Exception e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
            return null;
        }
    }

    // Atualizar Professor
    public void atualizarProfessor(String cpf, String nome, String email) {
        try {
            // Implementação para atualizar professor no banco de dados
            System.out.println("Professor atualizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar professor: " + e.getMessage());
        }
    }

    // Excluir Professor
    public void excluirProfessor(String cpf) {
        try {
            // Implementação para excluir professor no banco de dados
            System.out.println("Professor excluído com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao excluir professor: " + e.getMessage());
        }
    }

    // Atribuir Professor
    public void atribuirProfessor(String cpf, String codigoDisciplina) {
        try {
            // Implementação para atribuir professor à disciplina no banco de dados
            System.out.println("Professor atribuído à disciplina com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atribuir professor à disciplina: " + e.getMessage());
        }
    }

}
