package br.com.escola.estrelaguia.Model;

public class AvaliacaoFinal extends Avaliacao {
    public AvaliacaoFinal(String nome, double peso) {
        super(nome, peso);
    }

    @Override
    public double calcularNota() {
        double notaProva1 = 7.0;
        double notaProva2 = 8.0;
        double notaTrabalho1 = 9.0;
        double notaTrabalho2 = 8.5;

        double pesoProva1 = 0.3;
        double pesoProva2 = 0.3;
        double pesoTrabalho1 = 0.2;
        double pesoTrabalho2 = 0.2;

        return (notaProva1 * pesoProva1) + (notaProva2 * pesoProva2) + (notaTrabalho1 * pesoTrabalho1) + (notaTrabalho2 * pesoTrabalho2);
    }
}