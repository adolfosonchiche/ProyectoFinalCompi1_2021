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
        <link  rel="icon"   href="img/updater.png" type="image/png" />
        <link rel="stylesheet" type="text/css" href="resource/styless.css">
        <link rel="stylesheet" type="text/css" href="resource/sstyles2.css">
        <title>compi_1</title>
    </head>
    <body bgcolor="#A5F4EF">


        <div ALIGN="CENTER" ><h2 ALIGN="CENTER" > Compilador Captchas</h2></div>
        <%
        %>
        <form method="#">

            <br><label class="label">AREA DE CODIGO</label><br>
            <textarea  class="example-full-width2"  id="area"  name="area" rows="20" cols="140"
                       placeholder="escribe el codigo C_GCIC aqui..."required></textarea>
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

        <%
            if (request.getParameter("entrar") != null) {

                String nomUser = request.getParameter("area");

                //     <br><input type="submit" value="compilar" name="entrar" />
                try {
                    //out.write("DATOS: \n" + nomUser);

        %>
        <br><label class="label">SALIDA</label><br>
        <textarea class="example-full-width" name="textarea" rows="20" cols="140" readonly><%=nomUser%></textarea><br>
        <%

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
