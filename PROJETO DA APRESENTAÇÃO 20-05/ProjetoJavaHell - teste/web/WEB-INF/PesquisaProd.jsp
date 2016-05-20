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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
    </head>
    <body>
        <div id="imagemFundo">
            <img src="_imagens/fastFood01.jpg"/>
        </div>
        <div id="interface">
            <header id="cabecalho">
                <img src="_imagens/logo.jpg " title="Home"/>
            </header>

            <header id="menuDinamico" align="center">
                <img src="_imagens/pesquisarProd.jpg" width="400" height="100"/>
            </header>

            <section id="corpo">
                <p id="pesquisarProd">Pesquisar Produto</p>
                <form method="post" action="PesquisarProdutoServlet02">
                    <fieldset>
                        <p>Nome do Produto : <input type="text" name="nomeProduto" id="nomeProduto" placeholder="Produto a ser Pesquisar"/>
                            <button name="validar" id="validar">Validar</button></p>

                        <table id="tabela"border="5">
                            <tr>
                                <th>ID</th>
                                <th>CATEGORIA</th>
                                <th>NOME</th>
                                <th>TAMANHO</th>
                                <th>QUANTIDADE</th>
                            </tr>

                            <c:forEach items="${pesquisa}" var="pes">
                                <td>${pes.id}</td>
                                <td>${pes.categoria}</td>
                                <td>${pes.nome}</td>
                                <td>${pes.tamanho}</td>
                                <td>${pes.quantidade}</td>
                            </c:forEach>                                                           
                        </table>

                    </fieldset>
                </form>
            </section>
            <aside id="menuLateral">
                <ul>
                    <li><a href="/ProjetoJavaHell_-_teste/CadastraProdServlet01">CADASTRAR<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell_-_teste/AlteraProdutoServlet01">ALTERAR<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell_-_teste/RemoveProdutoServlet01">REMOVER<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell_-_teste/VendProdServlet01">VENDER<br>PRODUTO</a></li>
                    <li><a href="/ProjetoJavaHell_-_teste/GeraRelatorioServlet01">GERAR<br>RELATÓRIO</a></li>
                    <li><a href="/ProjetoJavaHell_-_teste/CadastraFuncServlet01">CADASTRAR<br>FUNCIONÁRIO</a></li>
                    <li><a href="/ProjetoJavaHell_-_teste/PesquisaProdServlet01">PESQUISAR<br>PRODUTO</a></li>
                </ul>
            </aside>

            <footer id="rodape">
                <p>Copyright<!--Simbolo copyright -->&copy; 2016 - BY JAVAHELL TEAM<br></p>
            </footer>

        </div>
    </body>
</html>
