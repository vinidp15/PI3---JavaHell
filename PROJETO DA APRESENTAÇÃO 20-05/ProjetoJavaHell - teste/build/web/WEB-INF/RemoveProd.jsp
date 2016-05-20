<%-- 
    Document   : removeProd
    Created on : 06/05/2016, 21:02:36
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Remover produto</title>
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
                <img src="_imagens/removeProd.jpg" width="400" height="100"/>
            </header>

            <section id="corpo">
                <p id="tituloRemoveProd">Remover Produto</p>
                <form method="post" action="RemoverProdutoServlet2">
                    <fieldset>
                        <p>Codigo do Produto: <input type="text" required="required" pattern="[0-9]+$" name="nomeProduto" id="produto" placeholder="Produto a ser Removido"/>
                            <input type="submit" value='Deletar'/>
                            </br><p><b>Id: </b></p>${id}
                            </br><p><b>Nome: </b></p>${nome}
                            </br><p><b>Categoria: </b></p>${categoria}
                            </br><p><b>Tamanho: </b></p>${tamanho}
                            </br><p><b>Quantidade </b></p>${quantidade}
                            </br></br><b>${produto}</b>
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
