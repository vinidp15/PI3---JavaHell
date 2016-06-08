/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.JavaHell.fastFood.entidades;

/**
 *
 * @author JavaHell
 */
public class Movimentacao {
    private int id_movimentacao;
    private int id_funcionario;
    private int id_produto;
    private int quantidade;
    private String dataMovimentacao;
    private String tipoMovimentacao;

    //Construtor da classe Movimentaçao
    public Movimentacao(int id_movimentacao, String tipoMovimentacao, int id_funcionario, int id_produto, int quantidade, String dataMovimentacao) {
        this.id_movimentacao = id_movimentacao;
        this.tipoMovimentacao = tipoMovimentacao;
        this.id_funcionario = id_funcionario;
        this.id_produto = id_produto;
        this.quantidade = quantidade;
        this.dataMovimentacao = dataMovimentacao;
    }

    //Método que irá pegar o valor da variável da classe
    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }
    //Método que irá alterar o valor da variável da classe
    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
    
    //Método que irá pegar o valor da variável da classe
    public int getId_movimentacao() {
        return id_movimentacao;
    }

    //Método que irá alterar o valor da variável da classe
    public void setId_movimentacao(int id_movimentacao) {
        this.id_movimentacao = id_movimentacao;
    }

    //Método que irá pegar o valor da variável da classe
    public int getId_funcionario() {
        return id_funcionario;
    }

    //Método que irá alterar o valor da variável da classe
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    //Método que irá pegar o valor da variável da classe
    public int getId_produto() {
        return id_produto;
    }

    //Método que irá alterar o valor da variável da classe
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    //Método que irá pegar o valor da variável da classe
    public int getQuantidade() {
        return quantidade;
    }

    //Método que irá alterar o valor da variável da classe
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //Método que irá pegar o valor da variável da classe
    public String getDataMovimentacao() {
        return dataMovimentacao;
    }

    //Método que irá alterar o valor da variável da classe
    public void setDataMovimentacao(String dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }
    
}
