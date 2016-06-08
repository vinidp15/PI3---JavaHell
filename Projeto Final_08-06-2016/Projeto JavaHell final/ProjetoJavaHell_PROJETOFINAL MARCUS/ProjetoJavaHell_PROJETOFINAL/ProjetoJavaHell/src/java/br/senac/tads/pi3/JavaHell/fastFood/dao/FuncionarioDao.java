/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.JavaHell.fastFood.dao;

import br.senac.tads.pi3.JavaHell.fastFood.entidades.Funcionario;
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
public class FuncionarioDao {

    private Connection conn;
    private String sql;
    private ResultSet resultSet;
    private PreparedStatement prepareStmt;
    private String senha;
    private String cpf;
    private String cargo;
    private ArrayList<String> funcionarios;
    private ArrayList<Funcionario> listaFuncionarios;

    //Construtor
    public FuncionarioDao() {
        this.funcionarios = new ArrayList();
        this.listaFuncionarios = new ArrayList();
    }

    //Metodo retorna o valor da variavel
    public String getSenha() {
        return senha;
    }

    //Altera o valor da variavel
    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Metodo retorna o valor da variavel
    public String getCpf() {
        return cpf;
    }

    //Altera o valor da variavel
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Metodo retorna o valor da variavel
    public String getCargo() {
        return cargo;
    }

    //Altera o valor da variavel
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    //Metodo retorna o valor da variavel
    public ArrayList<String> getFuncionarios() {
        return funcionarios;
    }

    //Altera o valor da variavel
    public void setFuncionarios(ArrayList<String> funcionarios) {
        this.funcionarios = funcionarios;
    }

    //Metodo retorna o valor da variavel
    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    //Altera o valor da variavel
    public void setListaFuncionarios(ArrayList<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    /**
    * Valida se o funcionario ja está cadastrado
    *
    * @param funcionario
    * @return 
    * @throws java.sql.SQLException
    */
    public boolean verificaFuncionario(Funcionario funcionario) throws SQLException {
        boolean ret = false;
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * from FUNCIONARIO WHERE FUNCIONARIO.CPF = '" + funcionario.getCpf() + "'";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();
            if (this.resultSet.next()){
                ret = true;
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar funcionario: " + e);
        } finally {
            prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return ret;
    }

    /**
     *
     * Este metodo cadastra um funcionario
     *
     * @param funcionario
     * @throws java.sql.SQLException
     */
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {

        PreparedStatement p = null;
        Connection conn = null;
        String sql = null;

        try{
            this.getIdFuncionario();//Pega o proximo id disponivel
            conn = Conexao.abreConexao();
            sql = "INSERT INTO FUNCIONARIO (ID_FUNCIONARIO, NOME, CPF, IDADE, CARGO, SENHA, SEXO)"
                    + "values (?,?,?,?,?,?,?)";
            p = conn.prepareStatement(sql);
            p.setInt(1, funcionario.getId_funcionario());
            p.setString(2, funcionario.getNome().toUpperCase());
            p.setString(3, funcionario.getCpf().toUpperCase());
            p.setInt(4, funcionario.getIdade());
            p.setString(5, funcionario.getCargo().toUpperCase());
            p.setString(6, funcionario.getSenha().toUpperCase());
            p.setString(7, funcionario.getSexo().toUpperCase());  
            p.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Erro ao cadastrar funcionario: " + e);
        }
        finally{
            p.close();
            Conexao.fechaConexao(conn);
        }
    }

    /**
     *
     * Este método seleciona o proximo id de funcionario disponivel
     *
     * @return o proximo id de funcionario disponivel
     * @throws java.sql.SQLException
     */
    public int getIdFuncionario() throws SQLException {

        Statement prepareStmt = null;
        Connection conn = null;

        String sql = "SELECT MAX(ID_FUNCIONARIO) from FUNCIONARIO";

        int id = 0;

        try {
            conn = Conexao.abreConexao();
            prepareStmt = conn.createStatement();
            ResultSet resultSet = prepareStmt.executeQuery(sql);

            if (resultSet.next()) {

                id = (resultSet.getInt(1) + 1);

            }

        } catch (SQLException | NumberFormatException e) {
            System.out.println("Erro: " + e);
        } finally {
            prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return id;
    }

    /**
     *
     * Este metodo cria uma lista com os dados dos funcionarios cadastrados
     *
     * @throws SQLException
     */
    public void insereListaFuncionarios() throws SQLException {

        Statement prepareStmt = null;
        Connection conn = null;

        String sql = "SELECT * from FUNCIONARIO";

        try {
            conn = Conexao.abreConexao();

            prepareStmt = conn.createStatement();
            ResultSet resultSet = prepareStmt.executeQuery(sql);

            while (resultSet.next()) {
                funcionarios.add("ID: " + resultSet.getString(1)
                        + ", Nome: " + resultSet.getString(2)
                        + ", CPF: " + resultSet.getString(3)
                        + ", Idade: " + resultSet.getInt(4)
                        + ", Cargo: " + resultSet.getString(5)
                        + ", Sexo: " + resultSet.getString(7));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de funcionarios: " + e);
        } finally {
            prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
    }

    /**
     *
     * Este metodo seleciona o cargo e a senha do funcionario para para
     * autenticacao do login
     *
     * @param cpf
     * @throws java.sql.SQLException
     */
    public String selecionaHashSenha(String cpf) throws SQLException {
        String senha = null;
        try {
            this.conn = Conexao.abreConexao();
            this.sql = "SELECT * FROM FUNCIONARIO WHERE FUNCIONARIO.CPF = '" + cpf + "'";
            this.prepareStmt = this.conn.prepareStatement(this.sql);
            this.resultSet = this.prepareStmt.executeQuery();

            while (this.resultSet.next()) {
                this.setCargo(this.resultSet.getString(5));
                senha = this.resultSet.getString(6);
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar senha do funcionario: " + e);
        } finally {
            this.prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return senha;
    }

    /**
     *
     * @param cpf
     * @param senha
     * @return este metodo retorna o id do funcionario filtrando por cpf e senha
     * @throws java.sql.SQLException
     */
    public int selecionaIdByCpfSenha(String cpf, String senha) throws SQLException {
        int id = 0;
        ResultSet resultSet;
        String sql = null;
        PreparedStatement p = null;
        Connection conn = null;
        try{
            conn = Conexao.abreConexao();
            sql = "SELECT ID_FUNCIONARIO FROM FUNCIONARIO WHERE FUNCIONARIO.CPF = '" + cpf
                    + "' and FUNCIONARIO.SENHA = '" + senha + "'";
            p = conn.prepareStatement(sql);
            resultSet = p.executeQuery();
            resultSet.next();
            id = resultSet.getInt(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            p.close();
            Conexao.fechaConexao(conn);
        }
        return id;
    }
    
    /**
    * Retorna o cpf por Id
    *
    * @param cpf
    * @param senha
    * @return 
    * @throws java.sql.SQLException
    */
    public String selecionaNomeByCpfSenha(String cpf, String senha) throws SQLException {
        String nome = null;
        ResultSet resultSet;
        String sql = null;
        PreparedStatement p = null;
        Connection conn = null;
        try{
            conn = Conexao.abreConexao();
            sql = "SELECT NOME FROM FUNCIONARIO WHERE FUNCIONARIO.CPF = '" + cpf
                    + "' and FUNCIONARIO.SENHA = '" + senha + "'";
            p = conn.prepareStatement(sql);
            resultSet = p.executeQuery();
            resultSet.next();
            nome = resultSet.getString(1);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            p.close();
            Conexao.fechaConexao(conn);
        }
        return nome;
    }
    
    

    /**
    * Retorna uma lista de funcionarios 
    *
    * @return 
    * @throws java.sql.SQLException 
    */
    public List<Funcionario> listaFuncionarios() throws SQLException {

        Statement prepareStmt = null;
        Connection conn = null;

        String sql = "SELECT * from FUNCIONARIO";

        try {
            conn = Conexao.abreConexao();
            prepareStmt = conn.createStatement();
            ResultSet resultSet = prepareStmt.executeQuery(sql);
            while (resultSet.next()) {
                this.listaFuncionarios.add(new Funcionario(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)));
            }
        } catch (Exception e) {
            System.out.println("\nErro ao selecionar lista de funcionarios: " + e);
        } finally {
            prepareStmt.close();
            Conexao.fechaConexao(conn);
        }
        return this.listaFuncionarios;
    }

}
