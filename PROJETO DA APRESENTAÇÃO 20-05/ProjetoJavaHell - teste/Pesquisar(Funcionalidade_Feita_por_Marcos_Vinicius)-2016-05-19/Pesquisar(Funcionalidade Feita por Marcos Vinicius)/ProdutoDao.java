/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ester Valéria
 */
public class ProdutoDao {
    
    private Connection obterConexao() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        // Passo 1: Registrar driver JDBC.
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        // Passo 2: Abrir a conexÃ£o
        conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/FastFood",
                "app", // usuario
                "app"); // senha
        return conn;
    }
    
    public List<Produto> pesquisarProduto(String x) {
    
    PreparedStatement stmt = null;
    Connection conn = null;
    
    Produto novoP = null;
    List<Produto> listaDoProduto = new ArrayList<Produto>();
    
    String sql = "SELECT * FROM PRODUTOS WHERE PRODUTOS.NOME = ?";
    try {
      conn = obterConexao();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, x);
      ResultSet resultado = stmt.executeQuery();

      while (resultado.next()) {
        Long id = resultado.getLong("ID_PRODUTO");  
        String categoria = resultado.getString("CATEGORIA");
        String nome = resultado.getString("NOME");
        String tamanho = resultado.getString("TAMANHO");
        int quantidade = Integer.parseInt(resultado.getString("QUANTIDADE"));
        
        novoP = new Produto(id,categoria,nome,tamanho,quantidade);
        listaDoProduto.add(novoP);
      }
      
    } catch (SQLException ex) {
      Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
          Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return listaDoProduto;
  }
    
    
    public void inserirProduto(String categoria, String nome,String tamanho, int quantidade) {
        Statement stmt = null;
        Connection conn = null;
        
        Produto produto = new Produto(categoria,nome,tamanho,quantidade);
        
        String sql = "INSERT INTO PRODUTOS (CATEGORIA, NOME, TAMANHO, QUANTIDADE) VALUES (?,?,?,?)";

        try {
            conn = obterConexao();
            PreparedStatement p = conn.prepareStatement(sql);
            
            p.setString(1, produto.getCategoria());
            p.setString(2,produto.getNome());
            p.setString(3, produto.getTamanho());
            p.setInt(4, produto.getQuantidade());
            p.executeUpdate();
            

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
