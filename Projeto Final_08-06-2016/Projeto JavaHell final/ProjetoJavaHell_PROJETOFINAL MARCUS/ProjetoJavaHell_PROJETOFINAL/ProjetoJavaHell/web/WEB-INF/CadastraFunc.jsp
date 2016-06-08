<%-- 
    Document   : cadastraFunc
    Created on : 06/05/2016, 21:04:03
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html class="no-js" lang="">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cadastrar Funcionário</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <script language="javascript" src="js/cpf.js"></script>
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
                <a href="/ProjetoJavaHell/HomeServlet">
                    <img  id="imgLogo" src="_imagens/logo.jpg" onclick="" title="Home"/></a>
            </header>
            <header id="logout">
                <a href="/ProjetoJavaHell/LogoutServlet"><p>SAIR</p></a>
            </header>
            <header id="menuDinamico" align="center">
                <img id="imgMenuDinamico" src="_imagens/cadastraFunc.jpg"/>
            </header>

            <section id="corpo">
                <form method="post" action="CadastraFuncServlet02" class="form-inline">
                    <fieldset id="geral">
                        <legend>Cadastro de Funcionário</legend>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="sr-only" for="nome"></label>
                                <div class="input-group-addon" style="width:110px;">Nome:</div>
                                <input type="text" name="nome" id="nome" placeholder="Digite seu nome completo" class="form-control input-md" required="required" pattern="[A-z\s]+$">
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="senha">Senha:</label>
                                <input type="password" class="form-control input-md" name="senha" placeholder="Digite a senha" required=""/>
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="cpf">CPF:</label>
                                <input type="text" required="required" onkeypress="javascript: mascara(this, cpf_mask);" maxlength="14" name="cpf" id="cpf" placeholder="Digite o cpf" class="form-control input-md">
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="idade">Idade:</label>
                                <input type="number" required="required" name="idade" pattern="[0-9]+$" id="age" placeholder="Sua idade" class="form-control input-md">
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;" for="sexo">Sexo:</label>
                                <input class="col-md-2" type="radio" name="sexo" value="Masculino">Masculino
                                <input type="radio" name="sexo" value="Feminino"> Feminino
                            </div>
                        </div>
                        </br>
                        <div class="form-group">
                            <div class="input-group" style="width:350px;">
                                <label class="input-group-addon" style="width:110px;"for="cargo">Cargo:</label>
                                <select name="cargo" class="form-control">
                                    <option value="Gerente">Gerente</option>
                                    <option value="Diretor">Diretor</option>
                                    <option value="Vendedor">Vendedor</option>
                                    <option value="AnalistaTecnico">Analista Técnico</option>
                                    <option value="AuxiliarGeral">Auxiliar Geral</option>
                                </select>
                            </div>
                        </div>
                        </br></br>           	
                        <button name="cadastrar" id="cadastrar" class="btn btn-primary">Cadastrar</button>
                        </br>${funcionario}
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
            </footer>>
        </div>
    </body>
</html>