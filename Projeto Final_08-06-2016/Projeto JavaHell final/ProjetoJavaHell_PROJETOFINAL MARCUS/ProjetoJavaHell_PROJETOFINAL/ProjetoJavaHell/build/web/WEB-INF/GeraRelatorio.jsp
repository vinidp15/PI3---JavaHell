<%-- 
    Document   : geraRelatorio
    Created on : 06/05/2016, 21:03:49
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="ErroGenerico.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Gerar relatório</title>
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
                <img src="_imagens/geraRel.jpg" id="imgMenuDinamico"/>
            </header>

            <section id="corpo">
                <legend>Gerar relatório</legend>
                <form method="post" action="GeraRelatorioServlet02" class="form-inline">
                    <div class="form-group">
                        <div class="input-group" style="width:350px;">
                            <label class="input-group-addon" style="width:110px;"for="tipoRelatorio">Tipo:</label>
                            <select name="tipoRelatorio" class="form-control">
                                <option value="listarProdutos" selected="selected">Listar Produtos</option>
                                <option value="listarFuncionarios">Listar Funcionários</option>
                                <option value="listarMovimentacoes">Listar Movimentações</option>                      
                            </select>
                        </div>
                        <input type="submit" value='Pesquisar'class="btn btn-info"/></br>
                    </div>
                    <hr style="height:1px; background-color:#E8E8E8;">
                    <p>${relatorio}</p>
                    <c:if test = "${relatorio == 'Relatorio de produtos cadastrados!!'}">
                        <table id="tabela"border="3">
                            <tr>
                                <th>ID</th>
                                <th>CATEGORIA</th>
                                <th>NOME</th>
                                <th>TAMANHO</th>
                                <th>PREÇO</th>
                                <th>QUANTIDADE</th>
                            </tr>

                            <c:forEach items="${relatorioprodutos}" var="rel">
                                <tr>
                                    <td>${rel.id_produto}</td>
                                    <td>${rel.categoria}</td>
                                    <td>${rel.nome}</td>
                                    <td>${rel.tamanho}</td>
                                    <td>${rel.preco}</td>
                                    <td>${rel.quantidade}</td>
                                </tr>
                            </c:forEach>                                                           
                        </table>                                      
                    </c:if>
                    <c:if test = "${relatorio == 'Relatorio de funcionarios cadastrados!!'}">
                        <table id="tabela"border="3">
                            <tr>
                                <th>FUNCIONÁRIO</th>
                                <th>NOME</th>
                                <th>CPF</th>
                                <th>IDADE</th>
                                <th>CARGO</th>
                                <th>SEXO</th>
                            </tr>

                            <c:forEach items="${relatoriofuncionarios}" var="rel">
                                <tr>
                                    <td>${rel.id_funcionario}</td>
                                    <td>${rel.nome}</td>
                                    <td>${rel.cpf}</td>
                                    <td>${rel.idade}</td>
                                    <td>${rel.cargo}</td>
                                    <td>${rel.sexo}</td>
                                </tr>
                            </c:forEach>                                                           
                        </table>                                      
                    </c:if>
                    <c:if test = "${relatorio == 'Relatorio de movimentacoes de produtos!!'}">
                        <table id="tabela"border="3">
                            <tr>
                                <th>Id Movimentacao</th>
                                <th>Tipo Movimentação</th>
                                <th>Id funcionário</th>
                                <th>Id produto</th>
                                <th>Quantidade</th>
                                <th>Data movimentação</th>
                            </tr>
                            <c:forEach items="${relatoriomovimentacao}" var="rel">
                                <tr>
                                    <td>${rel.id_movimentacao}</td>
                                    <td>${rel.tipoMovimentacao}</td>
                                    <td>${rel.id_funcionario}</td>
                                    <td>${rel.id_produto}</td>
                                    <td>${rel.quantidade}</td>
                                    <td>${rel.dataMovimentacao}</td>
                                </tr>
                            </c:forEach>                                                           
                        </table>                                      
                    </c:if>
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