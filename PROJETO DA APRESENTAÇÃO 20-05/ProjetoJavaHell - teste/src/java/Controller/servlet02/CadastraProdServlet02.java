/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet02;

import Model.ProdutosDao;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
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
@WebServlet(name = "CadastraProdServlet02", urlPatterns = {"/CadastraProdServlet02"})
public class CadastraProdServlet02 extends HttpServlet {

    
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
            ProdutosDao obj = new ProdutosDao();
            obj.setCategoria(request.getParameter("categoria"));
            obj.setNome(request.getParameter("nome"));
            obj.setTamanho(request.getParameter("tamanho"));
            obj.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
            obj.cadastrarProduto();
            //Incluir esta linha
            request.setAttribute("produto", "Produto: " + obj.getNome() + " cadastrado com sucesso!!");
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/CadastraProd.jsp").forward(request, response);
        }
        catch(NumberFormatException | SQLException e){
            System.out.println("Erro: " + e);
        }      
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}