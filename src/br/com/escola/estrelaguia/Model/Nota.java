package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.IAvaliar;
import br.com.escola.estrelaguia.Enums.TipoNota;

public class Nota extends Avaliacao{
    private double nota;
    private TipoNota tipoNota;

    public Nota(double valor, TipoNota tipoNota) {
        this.nota = valor;
        this.tipoNota = tipoNota;
    }

    @Override
    public double calcularNotaFinal() {
        return nota;
    }
}