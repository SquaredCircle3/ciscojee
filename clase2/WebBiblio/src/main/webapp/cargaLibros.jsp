<%-- 
    Document   : cargaLibros
    Created on : Sep 15, 2020, 8:45:41 PM
    Author     : pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Carga de libro</h1>
        
        <p>
            <%-- Esto es un bloque de código - Scriptlet --%>
            <%
                Calendar fecha = Calendar.getInstance();
                int hora = fecha.get(Calendar.HOUR);
            %>
            <b>Hora actual: <%=hora%> </b>
            <br>
            <% 
                if (hora >= 9) {
            %>
                Buenas noches
            <%
                } else {
            %>
                Buenos dias
            <%
                }
            %>
           
            <br>
            <%-- Esto es una expresión --%>
            <%= new Date() %>
        </p>
    </body>
</html>
