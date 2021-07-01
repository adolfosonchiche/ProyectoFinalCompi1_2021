package com.adolfo.controladores;

import com.adolfo.analizadores.Lexico;
import com.adolfo.analizadores.Parser;
import com.adolfo.analizadores.datos.EtiquetaId;
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
    private String captchaNuevo;
    private EtiquetaId etiqueta = new EtiquetaId();
    private int num = 1;
    private CaptchasModel form = new CaptchasModel();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("compilar") != null) {
               // this.resultado = "";
                String codigo = request.getParameter("area");
                request.setAttribute("datos", codigo);

                StringReader reader = new StringReader(codigo);
                Lexico lexico = new Lexico(reader);
                /*pide un archivo que tenga el codigo para leerlo*/

                Parser pa = new Parser(lexico);

                try {
                    pa.parse();
                    } catch (Exception e) {
                    this.resultado = "Error irrecuperable en el analisis sintactico... \n" + e;
                    System.out.println("Error irrecuperable.. " + e);

                }
                try {
                    
                    if ( pa.getErrorSintactico().size() > 0 || lexico.getErrorList().size() > 0) {
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
                        /*for (int i = 0; i < pa.getErroSemantico().size(); i++) {
                            resultado += pa.getErroSemantico().get(i) + "\n";
                        }*/
                        String idCpa = "";
                        //this.resultado = "\nEl captcha se creo correctamente, ahora ya puede utilizarlo!!! ";
                        if (pa.getIdCaptcha().equals("")) {
                            idCpa = "nuevoCaptch" + num;
                        } else {
                            idCpa = pa.getIdCaptcha();
                        }
                        this.captchaNuevo = pa.getCaptchaCreado() + "\n " ;
                        this.form.saveChangedFileCaptchasId(idCpa);
                       // System.out.println(" \n" + this.captchaNuevo);
                        this.form.saveChangedFileCaptchas(this.captchaNuevo, idCpa);
                        request.setAttribute("listVar", lexico.getListTablaSimbol());
                        this.resultado = "\nEl captcha se creo correctamente,"
                                + " \ncon el nombre: "+ idCpa + "  ahora ya puede utilizarlo!!! ";                        

                    }

                } catch (Exception e) {
                    this.resultado = "Error irrecuperable... " + e;
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
