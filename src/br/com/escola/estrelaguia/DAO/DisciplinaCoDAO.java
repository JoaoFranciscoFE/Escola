package br.com.escola.estrelaguia.DAO;

import br.com.escola.estrelaguia.Model.Disciplina;
import br.com.escola.estrelaguia.Model.DisciplinaConcreta;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaCoDAO {
    private List<DisciplinaConcreta> disciplinaConcretas = new ArrayList<>();

    public void addDisciplina(Disciplina disciplina) {
        disciplinaConcretas.add((DisciplinaConcreta) disciplina);
    }

    public Disciplina econtrarDisciplinaporNome(String nome) {
        return disciplinaConcretas.stream()
                .filter(disciplina -> disciplina.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<DisciplinaConcreta> getDisciplinasConcretas() {
        return disciplinaConcretas;
    }

    public void removeDisciplina(Disciplina disciplina) {
        disciplinaConcretas.remove(disciplina);
    }

    public List<DisciplinaConcreta> listarDisciplinasConcretas() {
        return disciplinaConcretas;
    }


    public void atualizarDisciplina(DisciplinaConcreta disciplina) {
        for (DisciplinaConcreta d : disciplinaConcretas) {
            if (d.getNome().equals(disciplina.getNome())) {
                d.setNome(disciplina.getNome());
                d.setTipo(disciplina.getTipo());
                d.setCargaHoraria(disciplina.getCargaHoraria());
                d.setProfessor(disciplina.getProfessor());
                d.setHorarioAulas(disciplina.getHorarioAulas());
                System.out.println("Disciplina atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Disciplina não encontrada!");
    }
}
