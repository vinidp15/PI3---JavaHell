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
public class Gerente extends Funcionario {
    
    //Construtor da classe
    public Gerente(int id_funcionario, String nome, String cpf, int idade, String cargo, String senha, String sexo){
        //Ira passar os valores do parametro do construtor para a classe Mae
        super(id_funcionario,nome,cpf,idade,cargo,senha,sexo);
    }
}
