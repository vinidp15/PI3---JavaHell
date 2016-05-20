<%-- 
    Document   : vendProd
    Created on : 06/05/2016, 21:03:34
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vender produto</title>
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
                <img src="_imagens/vendeProd.jpg" width="400" height="100"/>
            </header>

            <section id="corpo">
                <p id="tituloRemoverProd">Vender Produto</p>
                <form method="post" action="RemoverProdutoServlet">
                    <fieldset>
                        <div id="produto1">
                            <p>Categoria : <input type="text" name="categoria1" id="categoria" placeholder="Categoria do Produto"/></p>
                            <select name="department">
                                <c:forEach var="produtos" items="${produtos}">
                                    <option>${produtos}</option>
                                </c:forEach>
                            </select>
                            <p>Tamanho : <input type="text" name="tamanho1" id="tamanho" placeholder="Tamanho do Produto"/></p>
                            <p>Quantidade : <input type="text" name="quantidade1" id="quantidade" placeholder="Quantidade do Produto"/></p>    
                        </div>
                        <div id="produto2">
                            <p>Categoria : <input type="text" name="categoria2" id="categoria" placeholder="Categoria do Produto"/></p>
                            <p>Nome : <input type="text" name="nome2" id="nome" placeholder="Nome do Produto"/></p>
                            <p>Tamanho : <input type="text" name="tamanho2" id="tamanho" placeholder="Tamanho do Produto"/></p>
                            <p>Quantidade : <input type="text" name="quantidade2" id="quantidade" placeholder="Quantidade do Produto"/></p>    
                        </div>
                        <div id="produto3">
                            <p>Categoria : <input type="text" name="categoria3" id="categoria" placeholder="Categoria do Produto"/></p>
                            <p>Nome : <input type="text" name="nome3" id="nome" placeholder="Nome do Produto"/></p>
                            <p>Tamanho : <input type="text" name="tamanho3" id="tamanho" placeholder="Tamanho do Produto"/></p>
                            <p>Quantidade : <input type="text" name="quantidade3" id="quantidade" placeholder="Quantidade do Produto"/></p>    
                            <button name="cadastrar" id="cadastrar">Finalizar Venda</button>
                        </div>
                        <button name="cadastrar" id="cadastrar">Finalizar Venda</button>
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
