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
public class Funcionario {
    private int id_funcionario;
    private String nome;
    private String cpf;
    private int idade;
    private String cargo;
    private String senha;    
    private String sexo;

    //Construtor da Classe
    public Funcionario(int id_funcionario, String nome, String cpf, int idade, String cargo, String senha, String sexo) {
        this.id_funcionario = id_funcionario;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.cargo = cargo;
        this.senha = senha;
        this.sexo = sexo;
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
    public String getNome() {
        return nome;
    }

    //Método que irá alterar o valor da variável da classe
    public void setNome(String nome) {
        this.nome = nome;
    }

    //Método que irá pegar o valor da variável da classe
    public String getCpf() {
        return cpf;
    }

    //Método que irá alterar o valor da variável da classe
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Método que irá pegar o valor da variável da classe
    public int getIdade() {
        return idade;
    }

    //Método que irá alterar o valor da variável da classe
    public void setIdade(int idade) {
        this.idade = idade;
    }

    //Método que irá pegar o valor da variável da classe
    public String getCargo() {
        return cargo;
    }

    //Método que irá alterar o valor da variável da classe
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //Método que irá pegar o valor da variável da classe
    public String getSenha() {
        return senha;
    }

    //Método que irá alterar o valor da variável da classe
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Método que irá pegar o valor da variável da classe
    public String getSexo() {
        return sexo;
    }

    //Método que irá alterar o valor da variável da classe
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
