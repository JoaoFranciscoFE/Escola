package br.com.escola.estrelaguia.Model;

import br.com.escola.estrelaguia.Enums.TipoNota;

import java.util.Date;

public class Nota {
    private double valor;
    private TipoNota tipo;  // Enum para representar o tipo da nota
    private Date dataCadastro; // Data de quando a nota foi registrada
    private String observacao; // Observações adicionais sobre a nota
    private String disciplinaAssociada; // Nome da disciplina associada à nota
    private Aluno aluno; // Aluno que recebeu a nota

    // Construtor com todos os atributos
    public Nota(double valor, TipoNota tipo, Date dataCadastro, String observacao, String disciplinaAssociada, Aluno aluno) {
        this.valor = valor;
        this.tipo = tipo;
        this.dataCadastro = dataCadastro;
        this.observacao = observacao;
        this.disciplinaAssociada = disciplinaAssociada;
        this.aluno = aluno;
    }

    // Métodos Getters e Setters
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoNota getTipo() {
        return tipo;
    }

    public void setTipo(TipoNota tipo) {
        this.tipo = tipo;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDisciplinaAssociada() {
        return disciplinaAssociada;
    }

    public void setDisciplinaAssociada(String disciplinaAssociada) {
        this.disciplinaAssociada = disciplinaAssociada;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    public boolean verificarAprovacao() {
        if (tipo == TipoNota.PARCIAL) {
            return valor >= 6.0;
        } else if (tipo == TipoNota.FINAL) {
            return valor >= 7.0;
        } else {
            return valor >= 5.0; // Para outras notas (por exemplo, para "ATIVIDADE")
        }
    }

    /**
     * Exibe um resumo das informações da nota, incluindo valor, tipo e a disciplina associada.
     */
    public void exibirResumoNota() {
        System.out.println("Nota de " + aluno.getNome() + " - Disciplina: " + disciplinaAssociada);
        System.out.println("Valor: " + valor + " | Tipo: " + tipo + " | Observação: " + (observacao != null ? observacao : "Nenhuma"));
    }

    /**
     * Atualiza a nota, alterando tanto o valor quanto a observação.
     *
     * @param novoValor   o novo valor da nota.
     * @param novaObservacao a nova observação para a nota.
     */
    public void atualizarNota(double novoValor, String novaObservacao) {
        this.valor = novoValor;
        this.observacao = novaObservacao;
        System.out.println("Nota atualizada: " + aluno.getNome() + " - " + disciplinaAssociada);
    }

    /**
     * Verifica se a nota é de uma disciplina específica.
     *
     * @param nomeDisciplina nome da disciplina para comparação.
     * @return true se a nota pertence à disciplina fornecida, caso contrário, false.
     */
    public boolean pertenceADisciplina(String nomeDisciplina) {
        return disciplinaAssociada.equalsIgnoreCase(nomeDisciplina);
    }

    /**
     * Exibe a data em que a nota foi registrada no formato padrão.
     */
    public void exibirDataCadastro() {
        System.out.println("Data de cadastro da nota: " + dataCadastro);
    }
}
