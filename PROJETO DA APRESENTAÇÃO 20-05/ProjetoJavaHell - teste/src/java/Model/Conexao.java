/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AX4B
 */
public class Conexao {

    public static Connection abreConexao() {        
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(
            "jdbc:sqlite:C:\\Users\\Guilherme\\Desktop\\PROJETO DA APRESENTAÇÃO 20-05\\ProjetoJavaHell - teste\\JavaHell.db");
            conn.setAutoCommit(false);
            System.out.println("Conectado com banco");
            return conn;
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            System.out.println("nao conectado com banco");
            System.out.println(e);
            return null;
        }
    }
    
    public static void fechaConexao(Connection conn) throws SQLException{
        conn.commit();
        conn.close();
    }

}