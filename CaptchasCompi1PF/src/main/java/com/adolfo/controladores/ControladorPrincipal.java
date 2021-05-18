package com.adolfo.controladores;

import com.adolfo.analizadores.Lexico;
import com.adolfo.analizadores.Parser;
import com.adolfo.captchascompi1pf.CaptchasModel;
import java.io.IOException;
import java.io.StringReader;
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

    private String resultado;
    private int num = 1;
    CaptchasModel captchasModel = new CaptchasModel();
    CaptchasModel form = new CaptchasModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("entrar") != null) {
                String codigo = request.getParameter("area");
                request.setAttribute("datos", codigo);

                StringReader reader = new StringReader(codigo);
                Lexico lexico = new Lexico(reader);
                /*pide un archivo que tenga el codigo para leerlo*/

                Parser pa = new Parser(lexico);

                try {
                    pa.parse();
                    if (lexico.getErrorList().size() > 0 || pa.getErrorSintactico().size() > 0) {
                        this.resultado = "Se encontraron errores: \n";
                        for (int i = 0; i < lexico.getErrorList().size(); i++) {
                            resultado += lexico.getErrorList().get(i) + "\n";
                        }

                        for (int i = 0; i < pa.getErrorSintactico().size(); i++) {
                            resultado += pa.getErrorSintactico().get(i) + "\n";
                        }
                        for (int i = 0; i < pa.getErroSemantico().size(); i++) {
                            resultado += pa.getErroSemantico().get(i) + "\n";
                        }

                        System.out.println("ERRORES ");
                    } else {
                        String idCpa = "";
                        this.resultado = "El captcha se creo correctamente, ahora ya puede utilizarlo!!! ";
                        if (pa.getIdCaptcha().equals("")) {
                            idCpa = "nuevoCaptch" + num;
                        } else {
                            idCpa = pa.getIdCaptcha();
                        }
                        this.captchasModel.saveChangedFileCaptchasId(idCpa);
                        this.captchasModel.saveChangedFileCaptchas(pa.getCaptchaCreado(), idCpa);
                        request.setAttribute("listVar", lexico.getListTablaSimbol());

                    }

                } catch (Exception e) {
                    this.resultado += "Error irrecuperable... " + e;
                    System.out.println("Error irrecuperable.. " + e);

                }
                request.setAttribute("resultado", this.resultado);
                //String datos = analizar.crearCaprcha(codigo);
            }
            request.setAttribute("captcha", form.todosLosCaptcha());

            request.getRequestDispatcher("/index.jsp").forward(request, response);

        } catch (IOException | SQLException | ServletException e) {
            System.out.println("Error User: " + e.getMessage());
        }
    }
}
