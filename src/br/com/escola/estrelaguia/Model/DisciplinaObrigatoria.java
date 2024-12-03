package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

// Está aqui pois a disciplina que está no código é abstrata (Sim Erlon, sou eu escrevendo)
public class DisciplinaObrigatoria extends Disciplina {
    private int cargaHoraria;

    public DisciplinaObrigatoria(String nome, int cargaHoraria) {
        super(nome, TipoDisciplina.OBRIGATORIA);
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Obrigatória: " + getNome() + " | Carga Horária: " + cargaHoraria);
    }
}