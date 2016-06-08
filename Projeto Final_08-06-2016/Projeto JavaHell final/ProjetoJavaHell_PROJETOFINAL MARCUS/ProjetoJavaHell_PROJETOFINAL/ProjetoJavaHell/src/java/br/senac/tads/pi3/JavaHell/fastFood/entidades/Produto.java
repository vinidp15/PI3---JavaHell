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
public class Produto {
    private int id_produto;
    private String categoria;
    private String nome;
    private String tamanho;
    private String preco;
    private int quantidade;

    //Construtor da Classe
    public Produto(int id_produto, String categoria, String nome, String tamanho, String preco, int quantidade) {
        this.id_produto = id_produto;
        this.categoria = categoria;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    //Construtor da Classe
    public Produto(Produto produto) {
        this.id_produto = produto.id_produto;
        this.categoria = produto.categoria;
        this.nome = produto.nome;
        this.tamanho = produto.tamanho;
        this.preco = produto.preco;
        this.quantidade = produto.quantidade;
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
    public String getCategoria() {
        return categoria;
    }

    //Método que irá alterar o valor da variável da classe
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    //Método que irá pegar o valor da variável da classe
    public String getNome() {
        return nome;
    }

    //Método que irá alterar o valor da variável da classe
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Método que irá pegar o valor da variável da classe
    public String getTamanho() {
        return tamanho;
    }

    //Método que irá alterar o valor da variável da classe
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    //Método que irá pegar o valor da variável da classe
    public String getPreco() {
        return preco;
    }

    //Método que irá alterar o valor da variável da classe
    public void setPreco(String preco) {
        this.preco = preco;
    }

    //Método que irá pegar o valor da variável da classe
    public int getQuantidade() {
        return quantidade;
    }

    //Método que irá alterar o valor da variável da classe
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 
}
