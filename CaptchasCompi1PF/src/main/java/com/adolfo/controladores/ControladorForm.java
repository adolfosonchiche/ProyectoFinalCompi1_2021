package com.adolfo.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hectoradolfo
 */
@WebServlet("/ControladorForm")
public class ControladorForm extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String id = request.getParameter("captcha");
        if (id != null) {
            request.setAttribute("nombre", "LINK DEL FORMULARIO "+ id ); 
            request.setAttribute("link", "http://localhost:8080/CaptchasCompi1PF/ControladorFormulario?form=" + id + " " ); 
            request.setAttribute("enlace", "TAMBIEN PUEDE SELECCIONAR:"); 
        request.setAttribute("enlaceIr", "\"http://localhost:8080/CaptchasCompi1PF/ControladorFormulario?form=" + id + "\""); 
        
            request.getRequestDispatcher("/linkform.jsp").forward(request, response);
        }
        
    }
}
