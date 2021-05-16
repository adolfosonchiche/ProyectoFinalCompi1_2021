/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adolfo.analizadores;

import java.io.StringReader;

/**
 *
 * @author hectoradolfo
 */
public class MainFinalCompi1 {

    static boolean as = true || false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("es el CARMEN TE AMO " + String.valueOf(as));

        String entrada = /*"ini_solicitud";*/ "<!-- Mi primer captcha\n"
                + "en el curso de Organización de Lenguajes y Compiladores 1\n"
                + "-->\n"
                + "<     C_GcIC [id= \"captcha_matematico_1\"] [name= \"Captcha Matemático 1\"]>\n"
                + "!! El encabezado de la página que tendrá mi captcha\n"
                + "<C_hEAd>\n"
                
                + "<C_SCRIPTING> PROCESS_num() [ IF (\"carmen\" == \"Carmen\") THEN\n"
                + "INIT { :\n"
                + " integer @global cn_1 = 12;\n"
                
                
                
                
                + ": } END\n"
                + " ELSE \n"
                + "INIT { :\n"
                + " integer @global cn_1 = 12;\n"
                + ": } END\n"
                
                + "string dar_q = \"asd \"+\"sd\";\n"
                + "char esr_sa = 'V';  ] </C_SCRIPTING>\n"
                
                
                + "<C_LINK\n"
                + "!! El link al que redirige mi captcha\n"
                + "[href= \"https://scontent.fgua3-2.fna.fbcdn.net/v/t1.6435-9/60347042_1212262572266566_3335110932194918400_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=a4a2d7&_nc_ohc=z4doWTNBJKIAX_Q92U-&_nc_ht=scontent.fgua3-2.fna&oh=f36885b58e3ecb2150b2f20869dec23c&oe=60BE5FCA\"]>\n"
                + "</C_LINK>\n"
                + "!! El título de mi página\n"
                + "<C_TITLE> Mi primer Captcha Matemático</C_TITLE>\n"
                + "</C_hEAd>\n"
                + "!! El cuerpo de la página\n"
                + "<C_BODY [background= \"#e5e6ea\"] >\n"
                + "!! un título simple estilizado\n"
                + "<C_H1 [id= \"title_1\"] [text-align= \"center\"] [color= \"#7eff33\"] >\n"
                + "Mi primer Captcha Matemático\n"
                + "</C_H1>\n"
                + "!! Un salto normal\n"
                + "<C_br>\n"
                + "!! Información de la operación a resolver en el captcha\n"
                + "<C_SPAM [id= \"mostrar_1\"] [text-align= \"center\"] [color= \"#3366ff\"] >\n"
                + "¿ Qué resultado genera la operación siguiente: 5+5 ?\n"
                + "</C_SPAM>\n"
                + "!! Input para la Respuesta del usuario generado con un scripting\n"
                + "!! Boton que llama a la funcionalidad calc\n"
                + "<C_BUTTON [id= \"boton_1\"] [onclick= \"PROCESS_calc()\"] [background=\"green\"]>\n"
                + "Procesar...\n"
                + "</C_BUTTON>\n"
                + "</C_BODY>\n"
                + "</C_GcIC>\n"
                + "\n"
                + "\n"
                + "!!Fin de estructura GCIC\n"
                + "\n";
        //animar objeto anterior (21,34,curva)
        StringReader reader = new StringReader(entrada);
        Lexico lexico = new Lexico(reader);
        /*pide un archivo que tenga el codigo para leerlo*/

        Parser pa = new Parser(lexico);

        try {
            pa.parse();

            /* for (int i = 0; i < lexico.getErrorList().size(); i++) {
                System.out.println("errores lexico: lexema " + lexico.getErrorList().get(i));
            }

            for (int i = 0; i < pa.getErrorSintactico().size(); i++) {
                System.out.println("" + pa.getErrorSintactico().get(i));
            }
            if (lexico.getErrorList().size() > 0 || pa.getErrorSintactico().size() > 0) {
                System.out.println("ERRORES ");
            } else {
                for (int i = 0; i < pa.getDatosList().size(); i++) {
                    System.out.println("tipo lexema " + pa.getDatosList().get(i).getTipoSolicitud()
                            + "  parametros " + pa.getDatosList().get(i).getParametros());
                }
            }*/
            System.out.println("");

        } catch (Exception e) {
            System.out.println("Error irrecuperable.." + e);

        }

    }

}
