package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoPessoa;

public class Funcionario extends Pessoa {
    private String cargo;

    public Funcionario(String nome, String cpf, String cargo) {
        super(nome, cpf, TipoPessoa.FUNCIONARIO);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public void exibirDados() {
        System.out.println("Funcionário: " + getNome() + " | Cargo: " + cargo);
    }
}