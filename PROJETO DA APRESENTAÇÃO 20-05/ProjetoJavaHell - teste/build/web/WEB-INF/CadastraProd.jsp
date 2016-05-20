<%-- 
    Document   : cadastraProd
    Created on : 06/05/2016, 21:01:36
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastrar produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/Funcionario.css"/>
        <script src="js/Funcionario.js" type="text/javascript"></script>
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
                <img src="_imagens/cadastraProd.jpg" width="400" height="100"/>
            </header>

            <section id="corpo">
                <form method="post" action="CadastraProdServlet02">
                    <p id="tituloCadastraProd">Cadastro de Produto</p>
                    <fieldset>
                        <p>Categoria</p>    
                        <select name="categoria">                                
                            <option value="Bebidas">Bebidas</option>
                            <option value="Lanches">Lanches</option>
                            <option value="Salgados">Salgados</option>
                            <option value="Sobremesa">Sobremesa</option>
                            <option value="Saladas">Saladas</option>
                        </select>
                        </br><p>Nome: </p><input type="text" name="nome" required="required" pattern="[A-z\s]+$" id="nomeId" placeholder="Nome do Produto"/>
                        <p>Tamanho</p>    
                        <select name="tamanho">                                
                            <option value="Pequeno">Pequeno</option>
                            <option value="Medio">Medio</option>
                            <option value="Grande">Grande</option>
                            <option value="1 litro">1 litro</option>
                            <option value="2 litros">2 litros</option>
                        </select>
                        </br><p>Quantidade: </p><input type="text" name="quantidade" required="required" pattern="[0-9]+$" id="quantidadeId" placeholder="Quantidade do Produto"/>    
                        </br></br><button name="cadastrar" id="cadastrar">Cadastrar</button>
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
