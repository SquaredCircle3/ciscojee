<%-- 
    Document   : cargaLibros
    Created on : Sep 15, 2020, 8:45:41 PM
    Author     : pablo
--%>

<%@page import="org.cisco.jee.biblioteca.Libro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@include file="header.jsp" %>

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
        
        <%-- SCRIPTLETS --%>
        <p>
            <table>
            <%
                List<Libro> libros = (List<Libro>)session.getAttribute("libros");
                if(libros != null && libros.size() > 0) {
                    for(Libro l: libros) {
            %>
                <tr>
                <td><%=l.getTitulo()%></td>
                <td><%=l.getIsbn()%></td>
                </tr>
            <%
                    }
                }
            %>
            </table>
        </p> 
        <hr>
        <%-- JSTL + EL --%>
        <p>
        <table>
            <c:forEach items="${libros}" var="libro">
                <tr>
                <td>${libro.titulo}</td>
                <td>${libro.isbn}</td>
                </tr>
            </c:forEach>
        </table>
        </p>
        <hr>
        <p>
            <%-- EXTERNAL TAG LIBRARY --%>
            <display:table name="${libros}" />
        </p>
        <hr>
    
<%@include file="footer.jsp" %>