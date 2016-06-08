<%-- 
    Document   : cadastraProd
    Created on : 06/05/2016, 21:01:36
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html class="no-js" lang="">
    <head>
        <title>Cadastrar Produto</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
        <script src="js/Funcionario.js" type="text/javascript"></script>
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
                <img src="_imagens/cadastraProd.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <form method="post" action="CadastraProdServlet02" class="form-inline">
                    <legend>Cadastro de Produto</legend>
                    <fieldset>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="categoria">Categoria:</label>
                                <select name="categoria" class="form-control">                                
                                    <option value="Bebidas">Bebidas</option>
                                    <option value="Lanches">Lanches</option>
                                    <option value="Salgados">Salgados</option>
                                    <option value="Sobremesa">Sobremesa</option>
                                    <option value="Saladas">Saladas</option>
                                </select>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="nome">Nome:</label>
                                <input class="form-control" type="text" name="nome" required="required" id="nomeId" placeholder="Nome do Produto"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="tamanho">Tamanho:</label>
                                <select name="tamanho" class="form-control">                                
                                    <option value="Pequeno">Pequeno</option>
                                    <option value="Medio">Medio</option>
                                    <option value="Grande">Grande</option>
                                    <option value="1 litro">1 litro</option>
                                    <option value="2 litros">2 litros</option>
                                </select>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="quantidade">Quantidade:</label>
                                <input class="form-control" type="text" name="quantidade" required="required" pattern="[0-9]+$" id="quantidadeId" placeholder="Quantidade do Produto"/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="valor">Preço:</label>
                                <input class="form-control" placeholder="Digite o Preço"  type="text" name="valor" required="required" onKeyPress="return(MascaraMoeda(this, '.', ',', event))"/>
                            </div>
                        </div>
                        </br></br><button name="cadastrar" id="cadastrar" class="btn btn-success">Cadastrar</button>
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
