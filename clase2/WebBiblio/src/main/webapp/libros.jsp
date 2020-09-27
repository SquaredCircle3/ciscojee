<%-- 
    Document   : cargaLibros
    Created on : Sep 15, 2020, 8:45:41 PM
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Libros</h1>
        <p style="color: green">${success}</p>
        <form action='LibroServlet' method="POST" name="formLibro">
        <p>
        <table style="border: none">
            <tr>
                <td>Título:</td>
                <td><input type="text" name="txtTitulo" /></td>
            </tr>
            <tr>
                <td>Autor:</td>
                <td><input type="text" name="txtAutor" /></td>
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input type="text" name="txtISBN" /></td>
            </tr>
            <tr>
                <td>Año edición:</td>
                <td><input type="text" name="txtAnioEdicion" /></td>
            </tr>
            <tr>
                <td>Editorial:</td>
                <td><input type="text" name="txtEditorial" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="btnEnviar" value="Enviar"/>
                </td>
            </tr>
        </table>
        </p>
        </form>
        
        <p>
            ${libros}
        </p>
    </body>
</html>
