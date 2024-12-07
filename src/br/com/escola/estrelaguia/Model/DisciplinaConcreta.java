package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

public class DisciplinaConcreta extends Disciplina {
    public DisciplinaConcreta(String nome, TipoDisciplina tipo, int cargaHoraria, String professor, String horarioAulas) {
        super(nome, TipoDisciplina.CONCRETA, cargaHoraria, professor, horarioAulas);
    }

    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Concreta: " + getNome());
    }
}
