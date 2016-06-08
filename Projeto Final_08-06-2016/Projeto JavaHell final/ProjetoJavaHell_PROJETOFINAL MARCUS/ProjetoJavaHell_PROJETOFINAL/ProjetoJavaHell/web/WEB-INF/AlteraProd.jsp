<%-- 
    Document   : alteraProd
    Created on : 06/05/2016, 21:02:13
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html class="no-js" lang="">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Alterar Produto</title>
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
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
                <img src="_imagens/alterarProd.jpg" id="imgMenuDinamico"/>
            </header>
            <section id="corpo">
                <form method="post" action="AlterarProdutoServlet02" class="form-inline">
                    <legend>Alterar Produto</legend>
                    <fieldset>
                        <div class="form-group">
                            <div class="input-group">
                                <label class="input-group-addon" for="nomeProduto">Codigo do Produto:</label>
                                <input type="text" pattern="[0-9]+$" name="nomeProduto" id="produto" placeholder="Produto a ser Alterado" class="form-control" >
                            </div>
                            <input type="submit" value='Pesquisar' name="alterarBotao" class="btn btn-info"/>
                        </div>
                        </br>
                        <hr style="height:1px; background-color:#E8E8E8;">
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="id">ID:</label>
                                <input type="text" placeholder="ID do Produto" name="id" value="${id}" readonly="readonly" class="form-control" />
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="categoria">Categoria:</label>
                                <input type="text" placeholder="Digite a Categoria" pattern="[A-z\s]+$" name="categoria" value="${categoria}" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="nome">Nome:</label>
                                <input type="text" placeholder="Digite o Nome" pattern="[A-z\s]+$" name="nome" value="${nome}" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="tamanho">Tamanho:</label>
                                <input type="text" placeholder="Digite o Tamanho" name="tamanho"  value="${tamanho}" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="preco">Preço:</label>
                                <input type="text" placeholder="Digite o Preço" name="preco"  value="${preco}" class="form-control"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="sr-only" ></label>
                                <label class="input-group-addon" style="width:110px;" for="quantidade">Quantidade:</label>
                                <input type="text" readonly="readonly" placeholder="Digite a Quantidade" pattern="[0-9]+$" name="quantidade" value="${quantidade}" class="form-control"/>
                            </div>
                        </div>
                        </br></br><input type="submit" value='Alterar' name="alterarBotao" class="btn btn-warning"/>
                        </br></br>${produto}
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
