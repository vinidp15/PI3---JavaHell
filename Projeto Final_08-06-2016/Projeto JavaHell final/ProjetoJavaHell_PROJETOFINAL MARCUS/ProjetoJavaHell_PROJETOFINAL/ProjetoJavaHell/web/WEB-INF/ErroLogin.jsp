<%-- 
    Document   : erroLogin
    Created on : 25/05/2016, 14:55:04
    Author     : AX4B
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Erro no Login</title>
        <link rel='stylesheet prefetch' href='http://netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/cssLogin.css">
        <script src="js/prefixfree.min.js"></script>
    </head>

    <body>
        <div>
            <p>Erro no login!!</p>
        </div>
        <div class="body"></div>
        <div class="grad"></div>
        <div class="header">
            <div>Java<span>Food</span></div>
        </div>
        <br>
        <form class="form-signin" method="post" action="LoginServlet02">       
            <div class="login">
                <input type="text"  name="username" placeholder="Digite o seu CPF: " required="" autofocus=""/>
                <input type="password" name="password" placeholder="Digite a sua senha: " required=""/>
                <input type="submit" value="Entrar">
            </div>
            <h3 id="erro">CPF ou senha está incorreto!!</h3>
        </form>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>





    </body>
</html>
