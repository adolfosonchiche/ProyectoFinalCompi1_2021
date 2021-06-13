<%-- 
    Document   : index
    Created on : 15 may. 2021, 16:35:57
    Author     : hectoradolfo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  rel="icon"   href="img/updater.png" type="image/png" />
        <link rel="stylesheet" type="text/css" href="resource/styless.css">
        <link rel="stylesheet" type="text/css" href="resource/sstyles2.css">
        <title>compi_1</title>
    </head>
    <body bgcolor="#A5F4EF">
 <% 
        %>

        <div ALIGN="CENTER" ><h2 ALIGN="CENTER" > Compilador Captchas</h2></div>
       
        <form>
            <br><label class="label">AREA DE CODIGO</label><br>
            <textarea  class="example-full-width2"  id="area"  name="area" rows="20" cols="200"
                       placeholder="escribe el codigo C_GCIC aqui..."
                       required onfocus="this.innerHTML">${datos}</textarea>
            <br><br>

            <table border="4" width="600">
                <tr>
                    <td><button class="button-row" value="compilar" name="entrar" type="submit" >Compilar</button> </td>
                    <td><input class="file" type="file" id="file" name = "file" ></td>
                </tr>
            </table>


            <script>
                function handleFileSelect(evt) {
                    const input = document.getElementById('file');
                    const editor = document.getElementById('area');

                    if (input.files.length > 0) {
                        readFile(input.files[0]);
                    }

                    function readFile(file) {
                        const reader = new FileReader();
                        reader.onload = function () {
                            editor.value = reader.result;
                        },
                                reader.readAsText(file);

                    }
                }
                document.getElementById('file').addEventListener('change', handleFileSelect, false);

            </script>
            <br>
        </form>

        <% try {
            //if (request.getParameter("entrar") != null) {


        %>
        <br><label class="label">SALIDA</label><br>
        <textarea class="example-full-width" name="textarea" rows="20" cols="140" readonly>${resultado}</textarea><br>
        <% //}%>
        <%@ include file = "menu.jsp" %>

        <h1>Lista de Captchas</h1>
        <form Method="GET" action="/ControladorPrincipal">
            <table border="5" width="700">
                <tr>
                    <th>ID captchas</th>
                </tr>
                <c:forEach items="${captcha}" var="cp">
                    <tr>
                        <td>${cp.id}</td>
                        <td><a href="${pageContext.request.contextPath}/ControladorForm?captcha=${cp.id}">Generar Link</a></td>
                    </tr>
                </c:forEach>
            </table>
            <h1>Tabla de variables</h1>
            <table border="5" width="700">
                <tr>
                    <th>Id</th>
                    <th>tipo</th>
                    <th>Ambito</th>
                    <th>Proceso</th>
                    <th>Ejecucion</th>
                </tr>
                <c:forEach items="${listVar}" var="var">
                    <tr>
                        <td>${var.dato}</td>
                        <td>${var.tipo}</td>
                        <td>${var.modo}</td>
                        <td>${var.proceso}</td>
                        <td>${var.numEjecucion}</td><!--  -->
                    </tr>
                </c:forEach>
            </table>
<% 
} catch(Exception e){ }
        %>

        
        
        
    </body>
</html>
