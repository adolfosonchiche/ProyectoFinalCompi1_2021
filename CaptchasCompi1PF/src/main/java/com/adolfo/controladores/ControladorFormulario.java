package com.adolfo.controladores;

import static com.adolfo.captchascompi1pf.CaptchasModel.PATH;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hectoradolfo
 */
@WebServlet("/ControladorFormulario")
public class ControladorFormulario extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("form");
        String contenido = "";
        if (id != null) {
            try (FileReader fileReader = new FileReader(PATH +"/"+ id);
                    BufferedReader reader = new BufferedReader(fileReader)) {
                String linea = reader.readLine();

                

                while (linea != null) {
                    try {
                       contenido += linea + "\n";
                       //JOptionPane.showMessageDialog(null, contenido);

                    } catch (Exception e) {
                    }
                    linea = reader.readLine();
                }
                out.println(contenido);
            } catch (Exception e) {
                System.out.println("Excepcion con archivo " + e);
            }
            

        }

    }

}
