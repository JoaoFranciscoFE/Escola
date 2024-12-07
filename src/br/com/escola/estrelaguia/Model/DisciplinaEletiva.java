package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoDisciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaEletiva extends Disciplina {
    private boolean requerAprovacao;
    private String areaDeEstudo;
    private int duracaoSemanas;
    private String recursosExtras;

    public DisciplinaEletiva(String nome, boolean requerAprovacao, String areaDeEstudo, int duracaoSemanas, String recursosExtras) {
        super(nome, TipoDisciplina.ELETIVA, 0, "N/A", "30");
        this.requerAprovacao = requerAprovacao;
        this.areaDeEstudo = areaDeEstudo;
        this.duracaoSemanas = duracaoSemanas;
        this.recursosExtras = recursosExtras;
    }



    @Override
    public void detalhesDisciplina() {
        System.out.println("Disciplina Eletiva: " + getNome());
        System.out.println("Requer Aprovação: " + (requerAprovacao ? "Sim" : "Não"));
        System.out.println("Área de Estudo: " + areaDeEstudo);
        System.out.println("Duração: " + duracaoSemanas + " semanas");
        System.out.println("Recursos Extras: " + recursosExtras);
    }
}
