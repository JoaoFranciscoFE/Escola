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
}
