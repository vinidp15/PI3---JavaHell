<%-- 
    Document   : vendProd
    Created on : 06/05/2016, 21:03:34
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Vender produto</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
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
                <img src="_imagens/vendeProd.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <form method="post" action="VendProdServlet02" class="form-inline">
                    <fieldset>
                        <legend>Vender Produto</legend>
                        <fieldset>
                            <div class="form-group">
                                <div class="input-group" style="width:400px;">
                                    <label class="input-group-addon" for="prod1" style="width:150px;">Item 01:</label>
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
                                    <input type="text" required="required" pattern="[0-9]+$" name="qtd01" required="required" value="0" pattern="[0-9]+$" id="quantidadeId" placeholder="Quantidade do Produto" class="form-control"/>
                                </div>
                            </div>
                            </br></br>
                            <div class="form-group">
                                <div class="input-group" style="width:400px;">
                                    <label class="input-group-addon" for="prod2" style="width:150px;">Item 02:</label>
                                    <select name="prod2" class="form-control">
                                        <c:forEach var="produtos2" items="${produtos}">
                                            <option></br>${produtos2}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            </br>
                            <div class="form-group">
                                <div class="input-group" style="width:400px;">
                                    <label class="input-group-addon" for="qtd02" style="width:150px;">Quantidade:</label>
                                    <input type="text" required="required" pattern="[0-9]+$" required="required" pattern="[0-9]+$" name="qtd02" required="required" value="0" pattern="[0-9]+$" id="quantidadeId" placeholder="Quantidade do Produto" class="form-control"/>
                                </div>
                            </div>
                            </br></br>
                            <div class="form-group">
                                <div class="input-group" style="width:400px;">
                                    <label class="input-group-addon" for="prod3" style="width:150px;">Item 03:</label>
                                    <select name="prod3" class="form-control">
                                        <c:forEach var="produtos3" items="${produtos}">
                                            <option></br>${produtos3}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            </br>
                            <div class="form-group">
                                <div class="input-group" style="width:400px;">
                                    <label class="input-group-addon" for="qtd03" style="width:150px;">Quantidade:</label>
                                    <input type="text" required="required" pattern="[0-9]+$" required="required" pattern="[0-9]+$" name="qtd03" required="required" value="0" pattern="[0-9]+$" id="quantidadeId" placeholder="Quantidade do Produto" class="form-control"/>
                                </div>
                            </div>
                            </br></br><button name="cadastrar" id="cadastrar" class="btn btn-primary">Finalizar Venda</button>
                        </fieldset>
                        <br><p>${vendamsg}</p>
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
