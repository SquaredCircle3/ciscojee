<%-- 
    Document   : index
    Created on : Sep 20, 2020, 7:41:15 PM
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Biblioteca JEE</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo Biblioteca</h1>
        <p style="color: red">
            ${msg}            
        </p>
        
        <form action="./LoginServlet" method="POST">
        <BR>
        Ejemplo de formulario
        <p>
            Usuario: <input type="text" name="txtUsuario" />
            <br>
            Contraseña: <input type="password" name="pwdPassword" />
        </p>
        <p>
            <input type="submit" name="btnSubmit" value="Login" />
        </p>
        </form>
    </body>
</html>
