<%-- 
    Document   : alteraProd
    Created on : 06/05/2016, 21:02:13
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Alterar produto</title>
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
                <img src="_imagens/alterarProd.jpg" width="400" height="100"/>
            </header>

            <section id="corpo">
                <form method="post" action="AlterarProdutoServlet02">
                    <p id="tituloAlteraProd">Alterar Produto</p>
                    <fieldset>
                        <p>Codigo do Produto: <input type="text"  pattern="[0-9]+$" name="nomeProduto" id="produto" placeholder="Produto a ser alterado"/>
                        <input type="submit" value='Pesquisar' name="alterarBotao"/>
                        <p>Id</p><input type="text" placeholder="Id do produto" name="id" value="${id}" readonly="readonly"/>
                        </br></br><p>Categoria</p><input type="text" placeholder="Digite a categoria" pattern="[A-z\s]+$" name="categoria" value="${categoria}"/>
                        </br></br><p>Nome</p><input type="text" placeholder="Digite o nome" pattern="[A-z\s]+$" name="nome" value="${nome}"/>
                        </br></br><p>Tamanho</p><input type="text" placeholder="Digite o tamanho" name="tamanho"  value="${tamanho}"/>
                        </br></br><p>Quantidade</p><input type="text" placeholder="Digite a quantidade" pattern="[0-9]+$" name="quantidade" value="${quantidade}" />
                        </br></br></br><input type="submit" value='Alterar' name="alterarBotao"/>
                        </br></br>${produto}
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
