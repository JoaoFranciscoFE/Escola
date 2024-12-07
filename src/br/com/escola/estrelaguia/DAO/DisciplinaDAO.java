package br.com.escola.estrelaguia.DAO;

import br.com.escola.estrelaguia.Model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void addDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public Disciplina findDisciplinaByName(String nome) {
        return disciplinas.stream()
                .filter(disciplina -> disciplina.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Disciplina> getAllDisciplinas() {
        return disciplinas;
    }

    public void removeDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }
}
