/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.servlet02;

import Model.FuncionarioDao;
import Model.MovimentacaoDao;
import Model.ProdutosDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "GeraRelatorioServlet02", urlPatterns = {"/GeraRelatorioServlet02"})
public class GeraRelatorioServlet02 extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GeraRelatorioServlet02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String tipoRelatorio = request.getParameter("tipoRelatorio");
            switch (tipoRelatorio) {
                case "listarProdutos": {
                    ProdutosDao obj = new ProdutosDao();
                    obj.insereListaProdutos();
                    request.setAttribute("lista", obj.getProdutos());
                    //Incluir esta linha
                    request.setAttribute("relatorio", "Relatorio de produtos cadastrados!!");

                    this.getServletContext().getRequestDispatcher("/WEB-INF/GeraRelatorio.jsp").forward(request, response);
                    break;
                }
                case "listarFuncionarios": {
                    FuncionarioDao obj = new FuncionarioDao();
                    obj.insereListaFuncionarios();
                    request.setAttribute("lista", obj.getFuncionarios());
                    //Incluir esta linha
                    request.setAttribute("relatorio", "Relatorio de funcionarios cadastrados!!");
                    
                    this.getServletContext().getRequestDispatcher("/WEB-INF/GeraRelatorio.jsp").forward(request, response);
                    break;
                }
                default: {
                    MovimentacaoDao obj = new MovimentacaoDao();
                    obj.insereListaMovimentacao();
                    request.setAttribute("lista", obj.getMovimentacao());
                    //Incluir esta linha
                    request.setAttribute("relatorio", "Relatorio de movimentacoes de produtos!!");
                    
                    this.getServletContext().getRequestDispatcher("/WEB-INF/GeraRelatorio.jsp").forward(request, response);
                    break;
                }
            }
        } catch (IOException | SQLException | ServletException e) {
            System.out.println(e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
