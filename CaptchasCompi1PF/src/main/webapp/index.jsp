<%-- 
    Document   : index
    Created on : 15 may. 2021, 16:35:57
    Author     : hectoradolfo
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="resource/styless.css">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#BAF6">


        <div ALIGN="CENTER" ><h2 ALIGN="CENTER" > Compilador Captchas</h2></div>
       <%
       %>
      <form>
       <textarea  id="area"  name="area" rows="20" cols="100" required></textarea>
           
       
      
        <br><input type="submit" value="compilar" name="entrar" />
</form>

        <%
            if (request.getParameter("entrar") != null) {
                
                String nomUser = request.getParameter("area");
               
            //   JOptionPane.showMessageDialog(null, "amor" + user);
                try {
                    out.write("DATOS: \n" + nomUser);
                } catch (Exception e) {
                    out.write("error: \n" + e);
                }

               
            }

            if (request.getParameter("cerrar") != null) {
                session.invalidate();
            }

        %>




    </body>
</html>
