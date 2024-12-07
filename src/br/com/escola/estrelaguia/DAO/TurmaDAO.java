package br.com.escola.estrelaguia.DAO;

import br.com.escola.estrelaguia.Model.Turma;

import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    private List<Turma> turmas = new ArrayList<>();

    public void addTurma(Turma turma) {
        turmas.add(turma);
    }

    public Turma findTurmaByName(String nome) {
        return turmas.stream()
                .filter(turma -> turma.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Turma> getAllTurmas() {
        return turmas;
    }

    public void removeTurma(Turma turma) {
        turmas.remove(turma);
    }
}
