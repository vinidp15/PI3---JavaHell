/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.JavaHell.fastFood.dao;

import br.senac.tads.pi3.JavaHell.fastFood.entidades.Movimentacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JavaHell
 */
public class MovimentacaoDao {
    private Connection conn;
    private String sql;
    private PreparedStatement prepareStmt;
    private Statement state;
    private String operador;
    private ArrayList<String> movimentacao;
    private ResultSet resultSet;
    private ArrayList<Movimentacao> listaMovimentacoes;
    
    /**
    * 
    * Metodo construtor
    */
    public MovimentacaoDao() {
        this.movimentacao = new ArrayList();
        this.listaMovimentacoes = new ArrayList();
    }
    
    /**
    * 
    * @return uma lista de movimentação
    */
    public ArrayList<String> getMovimentacao() {
        return movimentacao;
    }
    
    /**
    * 
    * @return uma string de operador
    */
    public String getOperador() {
        return operador;
    }

    /**
    * 
    * @param operador
    */
    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    /**
    * 
    * Este metodo insere uma lista de movimentação de estoque
    * @throws java.sql.SQLException
    */
    public void insereMovimentacao(Movimentacao movimentacao) throws SQLException{
        try{
            this.conn = Conexao.abreConexao();
            this.sql = "INSERT INTO MOVIMENTACAO (ID_MOVIMENTACAO, TIPO_MOVIMENTACAO"
                    + ", ID_FUNCIONARIO, ID_PRODUTO, QUANTIDADE, DATA_MOVIMENTACAO)"
                    + "values (?,?,?,?,?,?)";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.prepareStmt.setInt(1, movimentacao.getId_movimentacao());
            this.prepareStmt.setString(2, movimentacao.getTipoMovimentacao());
            this.prepareStmt.setInt(3, movimentacao.getId_funcionario());
            this.prepareStmt.setInt(4, movimentacao.getId_produto());
            this.prepareStmt.setInt(5, movimentacao.getQuantidade());
            this.prepareStmt.setString(6, movimentacao.getDataMovimentacao());
            this.prepareStmt.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Erro ao movimentar estoque: " + e);
        }
        finally{
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }   
    }
        
    /**
    * 
    * Este metodo insere um registro de movimentaçaõ de estoque
    * tanto de venda quanto de entrada de produto
    * @throws java.sql.SQLException
    */
    public void fazVenda(Movimentacao movimentacao) throws SQLException{
        try{
            this.conn = Conexao.abreConexao();
            this.sql = "UPDATE PRODUTO"
                    + "SET QUANTIDADE = QUANTIDADE - " + movimentacao.getQuantidade()
                    + "WHERE ID_PRODUTO = " + movimentacao.getId_produto();
            this.state = this.conn.createStatement();
            this.state.execute(this.sql);
        }
        catch(Exception e){
            System.out.println("Erro na movimentação de produto: " + e);
        }
        finally{
            this.state.close();
            Conexao.fechaConexao(this.conn);
        }
    }    
    
    /**
    * 
    * Este metodo insere uma lista de movimentação
    * @throws java.sql.SQLException
    */
    public void insereListaMovimentacao() throws SQLException{
        try{
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from MOVIMENTACAO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            
            while(this.resultSet.next()){
                this.movimentacao.add("Id da movimentação: " + this.resultSet.getString(1)
                                    + ", Tipo de Movimentação: " + this.resultSet.getString(2)
                                    + ", Id do funcionário: " + this.resultSet.getString(3)
                                    + ", Id do produto: " + this.resultSet.getString(4)
                                    + ", Data da movimentação: " + this.resultSet.getString(5));
            }
        }
        catch(Exception e){
            System.out.println("\nErro ao selecionar lista de movimentações: " + e);
        }
        finally{
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }
    
    /**
    * 
    * Este metodo verifica o proximo id de movimentação disponivel
    * @throws java.sql.SQLException
    */
    public int getCodMovimentacaoDisp() throws SQLException {
        int id = 0;
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT MAX(ID_MOVIMENTACAO) from MOVIMENTACAO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            id = this.resultSet.getInt(1) + 1;
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return id;
    }
    
    /**
    * Retorna uma lista de movimentação
    *
    * @return 
    * @throws java.sql.SQLException
    */
    public List<Movimentacao> listaMovimentacoes() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from MOVIMENTACAO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            while (this.resultSet.next()) {
                this.listaMovimentacoes.add(new Movimentacao(this.resultSet.getInt(1)
                                                , this.resultSet.getString(2)
                                                , this.resultSet.getShort(3)
                                                , this.resultSet.getInt(4)
                                                , this.resultSet.getInt(5)
                                                , this.resultSet.getString(6)));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de movimentacoes: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return this.listaMovimentacoes;
    }
}
