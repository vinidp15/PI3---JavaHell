/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet02;

import Model.ProdutosDao;
import java.io.IOException;
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
@WebServlet(name = "AlterarProdutoServlet02", urlPatterns = {"/AlterarProdutoServlet02"})
public class AlterarProdutoServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
    }

    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        



} catch (SQLException ex) {
            Logger.getLogger(AlterarProdutoServlet02.class

.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String operacao = request.getParameter("alterarBotao");
            ProdutosDao obj = new ProdutosDao();
            if (operacao.equals("Pesquisar")) {
                obj.setId_produto(Integer.parseInt(request.getParameter("nomeProduto")));
                obj.selecionaProduto();
                request.setAttribute("id", obj.getId_produto());
                request.setAttribute("categoria", obj.getCategoria());
                request.setAttribute("nome", obj.getNome());
                request.setAttribute("tamanho", obj.getTamanho());
                request.setAttribute("quantidade", obj.getQuantidade());
                this.getServletContext().getRequestDispatcher("/WEB-INF/AlteraProd.jsp").forward(request, response);
            } else {
                obj.setId_produto(Integer.parseInt(request.getParameter("id")));
                obj.setCategoria(request.getParameter("categoria"));
                obj.setNome(request.getParameter("nome"));
                obj.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
                obj.setTamanho(request.getParameter("tamanho"));
                obj.alteraProduto();
                //Incluir esta linha
                request.setAttribute("produto", "Produto: " + obj.getNome() + " alterado com sucesso!!");
                
                this.getServletContext().getRequestDispatcher("/WEB-INF/AlteraProd.jsp").forward(request, response);
            }
        } catch (NumberFormatException | SQLException | ServletException | IOException e) {
            System.out.println(e);
        }
    }

    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
