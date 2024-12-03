package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Contracts.IAvaliar;

public abstract class Avaliacao implements IAvaliar {
    public abstract double calcularNotaFinal();
}