/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet01;

import Model.ProdutosDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AX4B
 */
@WebServlet(name = "VendProdServlet01", urlPatterns = {"/VendProdServlet01"})
public class VendProdServlet01 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
            ProdutosDao obj = new ProdutosDao();
            //obj.setId_produto(Integer.parseInt(request.getParameter("nomeProduto")));
            obj.selecionaListaProdutos();   
            request.setAttribute("produtos", obj.getProdutos());            
            request.getRequestDispatcher("WEB-INF/VendProd.jsp").forward(request, response);
        }
        catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
