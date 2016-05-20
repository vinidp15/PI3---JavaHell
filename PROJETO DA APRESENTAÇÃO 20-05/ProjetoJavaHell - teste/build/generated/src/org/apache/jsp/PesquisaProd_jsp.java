package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PesquisaProd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"ErroGenerico.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Pesquisar produto</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"Funcionario.css\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"imagemFundo\">\n");
      out.write("            <img src=\"_imagens/fastFood01.jpg\"/>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"interface\">\n");
      out.write("            <header id=\"cabecalho\">\n");
      out.write("                <img src=\"_imagens/logo.jpg \" title=\"Home\"/>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <header id=\"menuDinamico\" align=\"center\">\n");
      out.write("                <img src=\"_imagens/pesquisarProd.jpg\" width=\"400\" height=\"100\"/>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <section id=\"corpo\">\n");
      out.write("               <form method=\"post\" action=\"PesquisarProdutoServlet\">\n");
      out.write("                <fieldset>\n");
      out.write("                    <p>Nome do Produto : <input type=\"text\" name=\"nomeProduto\" id=\"nomeProduto\" placeholder=\"Produto a ser Pesquisar\"/>\n");
      out.write("                        <button name=\"validadar\" id=\"validar\">Validar</button></p>\n");
      out.write("                </fieldset>\n");
      out.write("            </form>\n");
      out.write("                <table border=\"5\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>ID</th>\n");
      out.write("                        <th>CATEGORIA</th>\n");
      out.write("                        <th>NOME</th>\n");
      out.write("                        <th>TAMANHO</th>\n");
      out.write("                        <th>QUANTIDADE</th>\n");
      out.write("                    </tr>\n");
      out.write("                    \n");
      out.write("                    <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pesquisa}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"pes\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><c:out  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pes.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            <td><c:out  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pes.categoria}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            <td><c:out  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pes.nome}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            <td><c:out  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pes.tamanho}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                            <td><c:out  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pes.quantidade}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </c:forEach>\n");
      out.write("                </table>\n");
      out.write("            </section>\n");
      out.write("\n");
      out.write("            <aside id=\"menuLateral\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"/CadastraProdServlet\">CADASTRAR<br>PRODUTO</a></li>\n");
      out.write("                    <li><a href=\"/AlteraProdutoServlet\">ALTERAR<br>PRODUTO</a></li>\n");
      out.write("                    <li><a href=\"/RemoveProdutoServlet\">REMOVER<br>PRODUTO</a></li>\n");
      out.write("                    <li><a href=\"/VendProdServlet\">VENDER<br>PRODUTO</a></li>\n");
      out.write("                    <li><a href=\"/GeraRelatorio.\">GERAR<br>RELATÓRIO</a></li>\n");
      out.write("                    <li><a href=\"/CadastraFunc\">CADASTRAR<br>FUNCIONÁRIO</a></li>\n");
      out.write("                    <li><a href=\"/PesquisaProd\">PESQUISAR<br>PRODUTO</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </aside>\n");
      out.write("\n");
      out.write("            <footer id=\"rodape\">\n");
      out.write("                <p>Copyright<!--Simbolo copyright -->&copy; 2016 - BY JAVAHELL TEAM<br></p>\n");
      out.write("            </footer>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
