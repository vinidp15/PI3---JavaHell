/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.JavaHell.fastFood.dao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JavaHell
 */
public class Conexao {
    
    /**
    *
    * @return  Connection
    * Este metodo retorna uma conexão estática pois é chamado com frequencia
    */
    public static Connection abreConexao() {        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(
            "jdbc:sqlite:C:\\Users\\Ester Valéria\\Downloads\\Projeto JavaHell final\\ProjetoJavaHell_PROJETOFINAL MARCUS\\ProjetoJavaHell_PROJETOFINAL\\ProjetoJavaHell\\JavaHell.db");
            conn.setAutoCommit(false);
            System.out.println("Conectado com banco");
            return conn;
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.out.println("nao conectado com banco");
            System.out.println(e);
            return null;
        }
    }
    
    /**
    * @param Connection
    * Este método fecha a conexao e é estático pois é chamado com frequencia
    * @throws java.sql.SQLException
    */
    public static void fechaConexao(Connection conn) throws SQLException{
        conn.commit();
        conn.close();
    }

}