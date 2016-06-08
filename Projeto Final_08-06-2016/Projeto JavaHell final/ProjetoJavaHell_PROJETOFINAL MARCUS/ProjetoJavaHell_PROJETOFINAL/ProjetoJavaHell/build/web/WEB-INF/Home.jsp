<%-- 
    Document   : Home
    Created on : 30/05/2016, 10:00:26
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <META HTTP-EQUIV="pragma" CONTENT="nocache">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
    </head>
    <body>
        <div id="imagemFundo">
            <img src="_imagens/fastFood01.jpg"/>
        </div>
        <div id="interface">
            <header id="logado">
                <p>Seja bem-vindo, ${usuarioLogado}!</p>
            </header>
            <header id="cabecalho">
                <a href="/ProjetoJavaHell/HomeServlet"><img id="imgLogo" src="_imagens/logo.jpg " onclick="" title="Home"/></a>
            </header>
            <header id="logout">
                <a href="/ProjetoJavaHell/LogoutServlet"><p>SAIR</p></a>
            </header>
            <header id="menuDinamico" align="center">
                <img src="_imagens/paginaHome.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <img src="_imagens/homeFastFood4 (700 x 670).jpg"/>
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
