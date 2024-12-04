package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

// Está aqui pois a disciplina que está no código é abstrata (Sim Erlon, sou eu escrevendo)
public class DisciplinaEletiva extends Disciplina {
    private boolean requerAprovacao;

    public DisciplinaEletiva(String nome, boolean requerAprovacao) {
        super(nome, TipoDisciplina.ELETIVA);
        this.requerAprovacao = requerAprovacao;
    }

    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Eletiva: " + getNome() + " | Requer Aprovação: " + (requerAprovacao ? "Sim" : "Não"));
    }
}