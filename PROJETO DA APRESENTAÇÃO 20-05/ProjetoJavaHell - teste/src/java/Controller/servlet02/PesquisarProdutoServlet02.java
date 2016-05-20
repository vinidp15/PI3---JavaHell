/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet02;

import Model.ProdutosDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "PesquisarProdutoServlet02", urlPatterns = {"/PesquisarProdutoServlet02"})
public class PesquisarProdutoServlet02 extends HttpServlet {

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

        try {
            ProdutosDao produtoDao = new ProdutosDao();
            String nome = request.getParameter("nomeProduto").toUpperCase();
            List<ProdutosDao> lista = produtoDao.pesquisarProduto(nome);
            request.setAttribute("pesquisa", lista);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/PesquisaProd.jsp").forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
