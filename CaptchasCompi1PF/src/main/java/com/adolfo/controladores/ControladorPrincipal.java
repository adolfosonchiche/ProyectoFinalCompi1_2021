package com.adolfo.controladores;

import com.adolfo.captchascompi1pf.CaptchasModel;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hectoradolfo
 */
@WebServlet("/ControladorPrincipal")
public class ControladorPrincipal extends HttpServlet {

    CaptchasModel form = new CaptchasModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

                request.setAttribute("captcha", form.todosLosCaptcha());

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (IOException | SQLException | ServletException e) {
            System.out.println("Error User: " + e.getMessage());
        }
    }
}
