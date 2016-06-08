<%-- 
    Document   : PesquisaProd
    Created on : 19/05/2016, 13:29:57
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pesquisar produto</title>
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
                <img src="_imagens/pesquisarProd.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <form method="post" action="PesquisarProdutoServlet02" class="form-inline">
                    <legend>Pesquisar Produto</legend>
                    <fieldset>
                        <div class="form-group">
                            <div class="input-group">
                                <label class="input-group-addon" for="nomeProduto">Nome do Produto:</label>
                                <input type="text" name="nomeProduto" id="nomeProduto" placeholder="Produto a ser Pesquisado" class="form-control"/>
                            </div>
                            <button name="validar" id="validar" class="btn btn-info">Pesquisar</button></p>
                        </div>
                        </br>
                        <hr style="height:1px; background-color:#E8E8E8;">
                    <c:if test = "${pesquisa != null}">
                        <table id="tabela"border="3">
                            <tr>
                                <th>ID</th>
                                <th>CATEGORIA</th>
                                <th>NOME</th>
                                <th>TAMANHO</th>
                                <th>PREÇO</th>
                                <th>QUANTIDADE</th>
                            </tr>

                            <c:forEach items="${pesquisa}" var="pes">
                                <td>${pes.id_produto}</td>
                                <td>${pes.categoria}</td>
                                <td>${pes.nome}</td>
                                <td>${pes.tamanho}</td>
                                <td>${pes.preco}</td>
                                <td>${pes.quantidade}</td>
                            </c:forEach>                                                           
                        </table>
                        </c:if>
                    </fieldset>
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
