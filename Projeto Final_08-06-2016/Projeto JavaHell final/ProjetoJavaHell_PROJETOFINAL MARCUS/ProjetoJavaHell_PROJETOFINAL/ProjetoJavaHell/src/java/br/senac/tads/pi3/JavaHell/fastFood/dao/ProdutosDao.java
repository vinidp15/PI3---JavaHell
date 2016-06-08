/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.JavaHell.fastFood.dao;

import br.senac.tads.pi3.JavaHell.fastFood.entidades.Funcionario;
import br.senac.tads.pi3.JavaHell.fastFood.entidades.Movimentacao;
import br.senac.tads.pi3.JavaHell.fastFood.entidades.Produto;
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
public class ProdutosDao {

    private Produto produto;
    private Connection conn;
    private String sql;
    private Statement state;
    private ResultSet resultSet;
    private PreparedStatement prepareStmt;
    private ArrayList<String> produtos;
    private ArrayList<Produto> listaProdutos;
    
    /**
    * 
    * Metodo construtor vazio
    */
    public ProdutosDao() {
        this.listaProdutos = new ArrayList();
        this.produtos = new ArrayList();
        produto = null;
    }    

    /**
    * 
    * @return uma lista de produtos
    */
    public ArrayList<String> getProdutos() {
        return produtos;
    }

    /**
    * 
    * Este método altera um produto  o estoque
    * @param produto
    * @throws java.sql.SQLException
    */
    public void alteraProduto(Produto produto) throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            sql = "UPDATE PRODUTO SET CATEGORIA = '" + produto.getCategoria().toUpperCase()
                    + "', NOME = '" + produto.getNome().toUpperCase()
                    + "', QUANTIDADE = '" + produto.getQuantidade()
                    + "', PRECO = '" + produto.getPreco()
                    + "', TAMANHO = '" + produto.getTamanho().toUpperCase() + "'"
                    + " WHERE ID_PRODUTO = '" + Integer.toString(produto.getId_produto()) + "'";
            state = this.conn.createStatement();
            state.executeUpdate(sql);
            state.close();
        } catch (Exception e) {
            System.out.println("Erro ao alterar produto: " + e);
        } finally {
            Conexao.fechaConexao(this.conn);
        }
    }
    
    /**
    * 
    * Este metodo atualiza somente a quantidade em estoque
    * @param id
    * @param qtd
    * @param qtdAtual
    * @param tipoOperacao
    * @throws java.sql.SQLException
    */
    public void updateQuantidade(int id, int qtd, int qtdAtual, String tipoOperacao) throws SQLException {
        try {
            int valorAtual = 0;//Variavel local somente para este metodo
            this.conn = Conexao.abreConexao();
            if (tipoOperacao.equals("Venda")){//Se for venda é subtraído a quantidade em estoque
                valorAtual = qtdAtual - qtd;
            }
            else{
                valorAtual = qtdAtual + qtd;//Se for entrada é incrementada a quantidade em estoque
            }
            sql = "UPDATE PRODUTO SET QUANTIDADE = " + Integer.toString((valorAtual)) 
               + " WHERE ID_PRODUTO = " + Integer.toString(id);
            state = this.conn.createStatement();
            state.executeUpdate(sql);
            state.close();
        } catch (Exception e) {
            System.out.println("Erro ao alterar quantidade do produto: " + e);
        } finally {
            Conexao.fechaConexao(this.conn);
        }
    }

    /**
    * 
    * Este método remove um produto no estoque
    * @throws java.sql.SQLException
    */
    public void removeProduto(Produto produto) throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.state = this.conn.createStatement();
            this.state.executeUpdate("DELETE FROM PRODUTO WHERE ID_PRODUTO = " + produto.getId_produto());
        } catch (Exception e) {
            System.out.println("Erro ao delerar produto: " + e);
        } finally {
            this.state.close();
            Conexao.fechaConexao(this.conn);
        }
    }

    /**
    * 
    * Este método cadastra um produto no estoque
    * @param produto
    * @throws java.sql.SQLException
    */
    public void cadastrarProduto(Produto produto) throws SQLException {
        try {
            this.getCodOperacaoDisp();
            this.conn = Conexao.abreConexao();
            this.sql = "INSERT INTO PRODUTO (ID_PRODUTO, CATEGORIA, NOME, TAMANHO, PRECO, QUANTIDADE)"
                    + "values (?,?,?,?,?,?)";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.prepareStmt.setInt(1, produto.getId_produto());
            this.prepareStmt.setString(2, produto.getCategoria().toUpperCase());
            this.prepareStmt.setString(3, produto.getNome().toUpperCase());
            this.prepareStmt.setString(4, produto.getTamanho().toUpperCase());
            this.prepareStmt.setString(5, produto.getPreco());
            this.prepareStmt.setInt(6, produto.getQuantidade());
            this.prepareStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    /**
    *
    * Este metodo selecioma proximo id de operação disponivel
    * @return o id de produto
    * @throws java.sql.SQLException
    */
    public int getCodOperacaoDisp() throws SQLException {
        int id = 0;
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT MAX(ID_PRODUTO) from PRODUTO";
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
    *
    * Este método cria uma lista de produtos que é mostrado na hora da venda
    * @throws SQLException
    */
    public void itensVenda() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from PRODUTO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            this.produtos.add("Nenhum");
            while (this.resultSet.next()) {
                this.produtos.add("Id: " + this.resultSet.getString(1)
                        + ", Categoria: " + this.resultSet.getString(2)
                        + ", Nome: " + this.resultSet.getString(3)
                        + ", Tamanho: " + this.resultSet.getString(4)
                        + ", R$: " + this.resultSet.getString(5)
                        + ", Qtd: " + this.resultSet.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de produtos: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }
    
    /**
    *
    * Este método cria uma lista de produtos
    * @return 
    * @throws SQLException
    */
    public List<Produto> listaProdutos() throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from PRODUTO";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            while (this.resultSet.next()) {
                this.listaProdutos.add(new Produto(this.resultSet.getInt(1)
                                                , this.resultSet.getString(2)
                                                , this.resultSet.getString(3)
                                                , this.resultSet.getString(4)
                                                , this.resultSet.getString(5)
                                                , this.resultSet.getInt(6)));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de produtos: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return this.listaProdutos;
    }    

    /**
    * 
    * Este metodo seleciona uma lista de produto
    * @throws java.sql.SQLException
    */
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

    /**
    * 
    * Este metodo seleciona uma lista de produto filtrando por id
    * @return um produto 
    * @throws java.sql.SQLException
    */
    public Produto selecionaProduto(String id) throws SQLException {
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * FROM PRODUTO WHERE PRODUTO.ID_PRODUTO = " + id;
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();

            while (this.resultSet.next()) {
                this.produto = new Produto(this.resultSet.getInt(1)
                                         , this.resultSet.getString(2)
                                         , this.resultSet.getString(3)
                                         , this.resultSet.getString(4)
                                         ,  this.resultSet.getString(5)
                                         ,  this.resultSet.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return this.produto;
    }

    /**
    * 
    * Este metodo pesquisa um produto por nome
    * @param nome
    * @return um produto
    * @throws java.sql.SQLException
    */
    public List<Produto> pesquisarProduto(String nome) throws SQLException {
        sql = "SELECT * FROM PRODUTO WHERE PRODUTO.NOME = ?";
        try {
            conn = Conexao.abreConexao();
            prepareStmt = conn.prepareStatement(sql);
            prepareStmt.setString(1, nome);
            resultSet = prepareStmt.executeQuery();

            while (resultSet.next()) {
                listaProdutos.add(new Produto(resultSet.getInt("ID_PRODUTO")
                        , resultSet.getString("CATEGORIA")
                        , resultSet.getString("NOME")
                        , resultSet.getString("TAMANHO")
                        , resultSet.getString("PRECO")
                        ,resultSet.getInt("QUANTIDADE")));
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println(e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return listaProdutos;
    }
    
    /**
    * 
    * Este metodo seleciona toda a quantidade disponivel de um produto
    * em estoque por id
    * @param id
    * @return 
    * @throws java.sql.SQLException
    */
    public int somaProdutoEmEstoque(int id) throws SQLException{
        int soma = 0;
        try{
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT QUANTIDADE FROM PRODUTO WHERE PRODUTO.ID_PRODUTO = " + Integer.toString(id);
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            this.resultSet.next();
            soma = this.resultSet.getInt(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return soma;
    }
    
    /**
    * 
     * @param id
     * @return 
     * @throws java.sql.SQLException
    */
    public String selecionaPrecoPorId(int id) throws SQLException{
        String preco = null;
        try{
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT PRECO FROM PRODUTO WHERE PRODUTO.ID_PRODUTO = " + Integer.toString(id);
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            this.resultSet.next();
            preco = this.resultSet.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return preco;
    }
    
}
