<%-- 
    Document   : autor
    Created on : Sep 28, 2020, 7:52:04 PM
    Author     : pablo
--%>

<%@page import="org.cisco.jee.biblioteca.Autor"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>



<p style="color: green">${success}</p>
<form action="AutorServlet" method="POST">
    <table style="border: none">
            <tr>
                <td>Nombre:</td>
                <td><input type="text" name="txtNombre" /></td>
            </tr>
            <tr>
                <td>Apellido:</td>
                <td><input type="text" name="txtApellido" /></td>
            </tr>
            <tr>
                <td>Pais:</td>
                <td>
                    <select name="lstPaises">
                        <c:forEach items="${paises}" var="pais">
                            <option value="${pais.id}">${pais.nombre}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="btnEnviar" value="Enviar"/>
                </td>
            </tr>
    </table>
</form>
<hr>

        <p>
            <table>
            <%
                List<Autor> autores = (List<Autor>)application.getAttribute("autores");
                if(autores != null && autores.size() > 0) {
                    for(Autor autor: autores) {
            %>
                <tr>
                <td><%=autor.getNombre()%></td>
                <td><%=autor.getApellido()%></td>
                <td><%=autor.getPais().getNombre()%></td>
                </tr>
            <%
                    }
                }
            %>
            </table>
        </p>
<%@include file="footer.jsp" %>