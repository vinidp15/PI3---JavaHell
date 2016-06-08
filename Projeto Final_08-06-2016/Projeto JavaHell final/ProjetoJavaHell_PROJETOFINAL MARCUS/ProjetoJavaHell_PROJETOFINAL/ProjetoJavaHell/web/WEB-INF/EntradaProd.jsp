<%-- 
    Document   : EntradaProd
    Created on : 03/06/2016, 10:58:03
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
    <head>
        <title>Entrada de Produto</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
    </head>
    <body>
        <div id="imagemFundo">
            <img src="_imagens/fastFood01.jpg"/>
        </div>
        <div id="interface">
            <header id="logado">
                <p>Usuário logado: ${usuarioLogado}!</p>
            </header>
            <header id="cabecalho">
                <a href="/ProjetoJavaHell/HomeServlet"><img id="imgLogo" src="_imagens/logo.jpg " onclick="" title="Home"/></a>
            </header>
            <header id="logout">
                <a href="/ProjetoJavaHell/LogoutServlet"><p>SAIR</p></a>
            </header>
            <header id="menuDinamico" align="center">
                <img src="_imagens/entradaDeProduto.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <form method="post" action="EntradaProdServlet02" class="form-inline">
                    <legend>Entrada de Produto</legend>
                    <fieldset>
                        <div class="form-group">
                            <div class="input-group" style="width:400px;">
                                <label class="input-group-addon" for="prod1" style="width:150px;">Selecionar produto:</label>
                                <select name="prod1" class="form-control">
                                    <c:forEach var="produtos1" items="${produtos}">
                                        <option></br>${produtos1}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:400px;">
                                <label class="input-group-addon" for="qtd01" style="width:150px;">Quantidade:</label>
                                <input type="text" name="qtd01" required="required" value="0" pattern="[0-9]+$" id="quantidadeId" placeholder="Quantidade do Produto" class="form-control"/>
                            </div>
                        </div>
                        </br></br>
                        <button name="validar" id="Ok" class="btn btn-success">OK</button>
                    </fieldset>
                    <br><p>${entradamsg}</p>
                </form>
            </section>
            <aside id="menuLateral">
                <ul>
                    <li><a href="/ProjetoJavaHell/CadastraProdServlet01">CADASTRAR<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell/AlteraProdutoServlet01">ALTERAR<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell/RemoveProdutoServlet01">REMOVER<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell/VendProdServlet01">VENDER<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell/GeraRelatorioServlet01">GERAR<br>RELATÓRIO</a></li>
                    <li><a href="/ProjetoJavaHell/CadastraFuncServlet01">CADASTRAR<br>FUNCIONÁRIO</a></li>
                    <li><a href="/ProjetoJavaHell/PesquisaProdServlet01">PESQUISAR<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell/EntradaProdServlet01">ENTRADA<br>PRODUTO</a></li>
                </ul>
            </aside>

            <footer id="rodape">
                <p>Copyright<!--Simbolo copyright -->&copy; 2016 - BY JAVAHELL TEAM<br></p>
            </footer>

        </div>
    </body>
</html>
