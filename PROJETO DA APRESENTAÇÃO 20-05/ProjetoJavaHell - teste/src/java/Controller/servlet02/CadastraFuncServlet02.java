/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet02;

import Model.FuncionarioDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AX4B
 */
@WebServlet(name = "CadastraFuncServlet02", urlPatterns = {"/CadastraFuncServlet02"})
public class CadastraFuncServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        try{            
            FuncionarioDao obj = new FuncionarioDao();
            obj.setNome(request.getParameter("nome"));
            obj.setCpf(request.getParameter("cpf"));
            obj.setIdade(Integer.parseInt(request.getParameter("idade")));
            obj.setCargo(request.getParameter("cargo"));
            obj.setSexo(request.getParameter("sexo"));
            request.setAttribute("funcionario", "Funcionario: " + obj.getNome() + " cadastrado!!");
            //Incluir esta linha
            request.setAttribute("funcionario", "Funcionario: " + obj.getNome() + " cadastrado com sucesso!!");
            
            obj.cadastrarFuncionario();
            this.getServletContext().getRequestDispatcher("/WEB-INF/CadastraFunc.jsp").forward(request, response);
        }
        catch(NumberFormatException e){
            System.out.println("Erro: " + e);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraFuncServlet02.class.getName()).log(Level.SEVERE, null, ex);
            this.getServletContext().getRequestDispatcher("/WEB-INF/CadastraFunc.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
