<%-- 
    Document   : linkform
    Created on : 18 may. 2021, 7:01:58
    Author     : hectoradolfo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="icon"   href="img/irlink.png" type="image/png" />
        <title>CUNOC COMPI 1</title>
    </head>
    <body background="img/formp.png">
        
       
        <%@ include file = "menu.jsp" %>
        <h3> ${nombre}</h3>
        <h4>${link}</h4>
        <h3>${enlace}</h3>
        <a href=${enlaceIr}>IR AL FORMULARIO</a>          

        <% 
        %>
        
    </body>
</html>
