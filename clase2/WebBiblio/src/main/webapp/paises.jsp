<%-- 
    Document   : paises
    Created on : Sep 28, 2020, 7:39:24 PM
    Author     : pablo
--%>

<%@page import="org.cisco.jee.biblioteca.Pais"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@include file="header.jsp" %>
<p style="color: green">${success}</p>
<form action="PaisServlet" method="POST">
    <table style="border: none">
            <tr>
                <td>Pais:</td>
                <td><input type="text" name="txtPais" /></td>
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
    Utilizando scriptlets <br>
<table>
    <%  
        List<Pais> listado = (List<Pais>)application.getAttribute("paises");
        if (listado!=null) {
            for(Pais p: listado){
    %> 
    <tr>
        <td> <%=p.getNombre()%> </td>
    </tr>
    <%
            }
        }
    %>
</table>
</p>
<p>
    Utilizando JSTL + EL <br>
    <ol>
    <c:forEach items="${paises}" var="unPais" >
        <li>${unPais.nombre}</li>
    </c:forEach>
    </ol>
</p>
<hr>
        <p>
            <%-- EXTERNAL TAG LIBRARY --%>
            <display:table name="${paises}" />
        </p>
<%@include file="footer.jsp" %>
