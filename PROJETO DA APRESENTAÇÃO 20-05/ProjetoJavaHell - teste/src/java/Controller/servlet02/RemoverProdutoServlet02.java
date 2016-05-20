/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet02;

import Model.ProdutosDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AX4B
 */
@WebServlet(name = "RemoverProdutoServlet2", urlPatterns = {"/RemoverProdutoServlet2"})
public class RemoverProdutoServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {   
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            ProdutosDao obj = new ProdutosDao();
            obj.setId_produto(Integer.parseInt(request.getParameter("nomeProduto")));
            obj.selecionaProduto();
            
            //Incluir esta linha
            if (obj.getNome() != null){
                request.setAttribute("id", obj.getId_produto());
                request.setAttribute("categoria", obj.getCategoria());
                request.setAttribute("nome", obj.getNome());
                request.setAttribute("tamanho", obj.getTamanho());
                request.setAttribute("quantidade", obj.getQuantidade());
            }
            
            //Incluir esta linha
            if (obj.getNome() != null)
                request.setAttribute("produto", "Produto: " + obj.getNome() + " removido com sucesso!!");
            else
                request.setAttribute("produto", "Produto não encontrado!");
            
            obj.removeProduto();
            this.getServletContext().getRequestDispatcher("/WEB-INF/RemoveProd.jsp").forward(request, response);
        }
        catch(NumberFormatException | SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}