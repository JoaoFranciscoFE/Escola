package br.com.escola.estrelaguia.Enums;

public enum StatusMatricula {
    ATIVO,
    DESMATRICULADO;

    public boolean isAtivo() {
        return this == ATIVO;
    }
}
