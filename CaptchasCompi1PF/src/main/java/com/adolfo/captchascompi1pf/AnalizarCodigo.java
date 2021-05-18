package com.adolfo.captchascompi1pf;

import com.adolfo.analizadores.Lexico;
import com.adolfo.analizadores.Parser;
import java.io.StringReader;

/**
 *
 * @author hectoradolfo
 */
public class AnalizarCodigo {

    private String resultado;
    private int num = 1;
    CaptchasModel captchasModel;

    public AnalizarCodigo() {
        this.captchasModel = new CaptchasModel();
        
    }

    public String crearCaprcha(String codigo) {
        this.captchasModel.crearCarpeta();
        this.resultado = "****";

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

            }

        } catch (Exception e) {
            this.resultado += "Error irrecuperable... " + e;
            System.out.println("Error irrecuperable.. " + e);

        }
        return this.resultado;

    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

}
