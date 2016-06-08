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
public class Entrada extends Movimentacao{
    
    //Construtor de entrada
    public Entrada(int id_movimentacao, String tipoMovimentacao, int id_funcionario, int id_produto, int quantidade, String dataMovimentacao) {
        //Ira passar os valores do parametro do construtor para a classe Mae
        super(id_movimentacao, tipoMovimentacao, id_funcionario, id_produto, quantidade, dataMovimentacao);
    }    
    
}
