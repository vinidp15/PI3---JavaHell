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
                <img src="_imagens/removeProd.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <form method="post" action="RemoverProdutoServlet2" class="form-inline">
                    <legend>Remover Produto</legend>
                    <fieldset>
                        <div class="form-group">
                            <div class="input-group">
                                <label class="input-group-addon" for="nomeProduto">Codigo do Produto:</label>
                               <input type="text" required="required" pattern="[0-9]+$" name="nomeProduto" id="produto" placeholder="Produto a ser Removido" class="form-control"/>
                            </div>
                            <input type="submit" value='Deletar'class="btn btn-danger"/>
                        </div>
                        </br>
                        <hr style="height:1px; background-color:#E8E8E8;">
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;">ID:</label>
                                <input type="text" value="${id}" readonly="readonly" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;">Nome:</label>
                                <input type="text" value="${nome}" readonly="readonly" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;">Categoria:</label>
                                <input type="text" value="${categoria}" readonly="readonly" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;">Tamanho:</label>
                                <input type="text" value="${tamanho}" readonly="readonly" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;">Quantidade:</label>
                                <input type="text" value="${quantidade}" readonly="readonly" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        </br><b>${produto}</b>
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
