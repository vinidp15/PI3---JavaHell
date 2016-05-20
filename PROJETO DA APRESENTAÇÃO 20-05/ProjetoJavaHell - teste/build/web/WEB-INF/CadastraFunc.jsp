<%-- 
    Document   : cadastraFunc
    Created on : 06/05/2016, 21:04:03
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar funcionario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
        <script language="javascript" src="js/Funcionario.js"></script>
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
                <img src="_imagens/cadastraFunc.jpg" width="400" height="100"/>
            </header>

            <section id="corpo">
                <header id="rodape">
                    <form method="post" action="CadastraFuncServlet02">
                        <fieldset id="geral">                              
                            <p>Nome</p><input type="text" name="nome" required="required" pattern="[A-z\s]+$" id="name" placeholder="Seu nome completo"/>
                            </br><p>CPF</p><input type="text" required="required" size=30 maxlength="30" name="cpf" id="cpfCode" placeholder="Seu cpf (Sem o uso de pontuações)"/>                              	
                            </br><p>Idade</p><input type="text" required="required" name="idade" pattern="[0-9]+$" id="age" placeholder="Sua idade"/><br>   
                            <p>Sexo</p>
                            <input type="radio" name="sexo" value="Masculino" checked>Masculino
                            <input type="radio" name="sexo" value="Feminino"> Feminino            	
                            </br><p>Cargo</p><select name="cargo">
                                <option value="Gerente">Gerente</option>
                                <option value="Diretor">Diretor</option>
                                <option value="Vendedor">Vendedor</option>
                                <option value="Analista Tecnico">Analista Tecnico</option>
                                <option value="Auxiliar Geral">Auxiliar Geral</option>
                            </select>
                            </br></br><button name="cadastrar" id="cadastrar">Cadastrar</button>
                            </br></br>${funcionario}
                        </fieldset>                        
                    </form>  
                </header>
            </section>

            <aside id="menuLateral">
                <ul id="idBotoes">
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
            </footer>>
        </div>
    </body>
</html>