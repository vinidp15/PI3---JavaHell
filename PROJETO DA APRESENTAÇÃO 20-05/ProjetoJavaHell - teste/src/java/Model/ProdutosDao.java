/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author AX4B
 */
public class ProdutosDao {

    private Connection conn;
    private String sql;
    private Statement state;
    private ResultSet resultSet;
    private PreparedStatement prepareStmt;
    private String categoria;
    private String nome;
    private String tamanho;
    private int quantidade;
    private int id_produto;
    private ArrayList<String> produtos;
    ProdutosDao novoP;
    
    public ProdutosDao() {
        this.produtos = new ArrayList();
    }

    public ProdutosDao(String categoria, String nome, String tamanho, int quantidade, int id_produto) {
        this.categoria = categoria;
        this.nome = nome;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.id_produto = id_produto;
    }

    public ArrayList<String> getProdutos() {
        return produtos;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //ALTERAR PRODUTO
    public void alteraProduto() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            sql = "UPDATE PRODUTO SET CATEGORIA = '" + this.getCategoria().toUpperCase()
                    + "', NOME = '" + this.getNome().toUpperCase()
                    + "', QUANTIDADE = '" + this.getQuantidade()
                    + "', TAMANHO = '" + this.getTamanho().toUpperCase() + "'"
                    + " WHERE ID_PRODUTO = '" + Integer.toString(this.getId_produto()) + "'";
            state = this.conn.createStatement();
            state.executeUpdate(sql);
            state.close();
        } catch (Exception e) {
            System.out.println("Erro ao alterar produto: " + e);
        } finally {
            Conexao.fechaConexao(this.conn);
        }
    }

//REMOVER PRODUTO
    public void removeProduto() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.state = this.conn.createStatement();
            this.state.executeUpdate("DELETE FROM PRODUTO WHERE ID_PRODUTO = " + this.getId_produto());
        } catch (Exception e) {
            System.out.println("Erro ao delerar produto: " + e);
        } finally {
            this.state.close();
            Conexao.fechaConexao(this.conn);
        }
    }

    //CADASTRAR PRODUTO
    public void cadastrarProduto() throws SQLException {
        try {
            this.getCodOperacaoDisp();
            this.conn = Conexao.abreConexao();
            this.sql = "INSERT INTO PRODUTO (ID_PRODUTO, CATEGORIA, NOME, TAMANHO, QUANTIDADE)"
                    + "values (?,?,?,?,?)";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.prepareStmt.setInt(1, this.getId_produto());
            this.prepareStmt.setString(2, this.getCategoria().toUpperCase());
            this.prepareStmt.setString(3, this.getNome().toUpperCase());
            this.prepareStmt.setString(4, this.getTamanho().toUpperCase());
            this.prepareStmt.setInt(5, this.getQuantidade());
            this.prepareStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    //Verificar o proximo id de produto disponivel
    public void getCodOperacaoDisp() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT MAX(ID_PRODUTO) from PRODUTO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            this.setId_produto(this.resultSet.getInt(1) + 1);
        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    //SELECIONA LISTA DE PRODUTOS NO ARRAYLIST
    public void insereListaProdutos() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from PRODUTO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();

            while (this.resultSet.next()) {
                this.produtos.add("Id: " + this.resultSet.getString(1)
                        + ", Categoria: " + this.resultSet.getString(2)
                        + ", Nome: " + this.resultSet.getString(3)
                        + ", Tamanho: " + this.resultSet.getString(4)
                        + ", Quantidade: " + this.resultSet.getInt(5));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de produtos: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    //SELECIONA LISTA DE PRODUTOS NO ARRAYLIST
    public void selecionaListaProdutos() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from PRODUTO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();

            while (this.resultSet.next()) {
                this.produtos.add(this.resultSet.getString(3));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de produtos: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    //SELECIONA PRODUTO POR CODIGO DE ID_PRODUTO
    public void selecionaProduto() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * FROM PRODUTO WHERE PRODUTO.ID_PRODUTO = " + this.getId_produto();
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();

            while (this.resultSet.next()) {
                this.setId_produto(this.resultSet.getInt(1));
                this.setCategoria(this.resultSet.getString(2));
                this.setNome(this.resultSet.getString(3));
                this.setTamanho(this.resultSet.getString(4));
                this.setQuantidade(this.resultSet.getInt(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    //SELECT POR NOME PARA PESQUISA
    public List<ProdutosDao> pesquisarProduto(String x) throws SQLException {
        List<ProdutosDao> listaDoProduto = new ArrayList<>();
        novoP = null;
        sql = "SELECT * FROM PRODUTO WHERE PRODUTO.NOME = ?";
        try {
            conn = Conexao.abreConexao();
            prepareStmt = conn.prepareStatement(sql);
            prepareStmt.setString(1, x);
            resultSet = prepareStmt.executeQuery();

            while (resultSet.next()) {
                novoP = new ProdutosDao(resultSet.getString("CATEGORIA")
                        , resultSet.getString("NOME")
                        , resultSet.getString("TAMANHO")
                         , resultSet.getInt("QUANTIDADE")
                        ,resultSet.getInt("ID_PRODUTO"));
                listaDoProduto.add(novoP);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return listaDoProduto;
    }
}
