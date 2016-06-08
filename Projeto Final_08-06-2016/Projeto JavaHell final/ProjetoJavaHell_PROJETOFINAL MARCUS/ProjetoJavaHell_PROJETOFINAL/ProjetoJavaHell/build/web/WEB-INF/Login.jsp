<%-- 
    Document   : index
    Created on : 24/05/2016, 17:13:21
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Login JavaHell</title>
        <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/cssLogin.css">
        <script src="js/prefixfree.min.js"></script>
        <script language="javascript" src="js/cpf.js"></script>
    </head>

    <body>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">
            <div>Java<span>Food</span></div>
        </div>
        <br>
        <form class="form-signin" method="post" action="LoginServlet02">       
            <div class="login">
                <input type="text"  name="username" onkeypress="javascript: mascara(this, cpf_mask);" maxlength="14" name="cpf" id="cpf" placeholder="Digite o seu CPF: " required="" autofocus=""/>
                <input type="password" name="password" placeholder="Digite a sua senha: " required=""/>
                <input type="submit" value="Entrar">
            </div>
        </form>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    </body>
</html>
