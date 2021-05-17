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
        String dat = "'a'";
        char as = dat.charAt(1);
 int asciiValue = as;
        System.out.println("es el assci " + asciiValue);
        String entrada = "<!-- Mi primer captcha\n" +
"en el curso de Organización de Lenguajes y Compiladores 1\n" +
"-->\n" +
"<C_GCIC [id= \"captcha_matematico_1\"] [id= \"captcha_matematico_1\"] [name= \"Captcha Matemático 1\"]>\n" +
"!! El encabezado de la página que tendrá mi captcha\n" +
"<C_hEAd>\n" +
"<C_LINK\n" +
"!! El link al que redirige mi captcha\n" +
"[href= \"https://scontent.fgua3-2.fna.fbcdn.net/v/t1.6435-9/60347042_1212262572266566_3335110932194918400_n.jpg?_nc_cat=105&ccb=1-3&_nc_sid=a4a2d7&_nc_ohc=z4doWTNBJKIAX_Q92U-&_nc_ht=scontent.fgua3-2.fna&oh=f36885b58e3ecb2150b2f20869dec23c&oe=60BE5FCA\"]>\n" +
"</C_LINK>\n" +
"!! El título de mi página\n" +
"<C_TITLE> Mi primer Captcha Matemático</C_TITLE>\n" +
"</C_hEAd>\n" +
"!! El cuerpo de la página\n" +
"<C_BODY [background= \"#e5e6ea\"] >\n" +
"!! un título simple estilizado\n" +
"<C_H1 [id= \"title_1\"] [text-align= \"center\"] [color= \"#7eff33\"] >\n" +
"Mi primer Captcha Matemático\n" +
"</C_H1>\n" +
"!! Un salto normal\n" +
"<C_br>\n" +
"!! Información de la operación a resolver en el captcha\n" +
"<C_SPAM [id= \"mostrar_1\"] [text-align= \"center\"] [color= \"#3366ff\"] >\n" +
"¿ Qué resultado genera la operación siguiente: 5+5 ?\n" +
"</C_SPAM>\n" +
"!! Input para la Respuesta del usuario generado con un scripting\n" +
"<C_SCRIPTINg>\n" +
"ON_LOAD () [\n" +
"!!Estas instrucciones se ejecutan media vez se entra al scripting\n" +
"!! Insertamos el input con sus parámetros con la instrucción INSERT\n" +
"INSERT('<C_INPUT [type= \"text\"] [text-align= \"center\"]\n" +
"[id= \"entrada_1\"] ></C_INPUT>');\n" +
"]\n" +
"</C_SCRIPTING>\n" +
"!! Boton que llama a la funcionalidad calc\n" +
"<C_BUTTON [id= \"boton_1\"] [onclick= \"PROCESS_calc()\"] [background=\"green\"]>\n" +
"Procesar...\n" +
"</C_BUTTON>\n" +
"!! Scripting para la función calc\n" +
"<C_SCRIPTING>\n" +
"PROCESS_calc() [\n" +
"!! Estas instrucciones no se ejecutan hasta llamar a PROCESS_calc()\n" +
"integer @global contador_fallas = 5;\n" +
"string result_caja_texto = getElemenById('entrada_1');\n" +
"string result = \"10 \";\n" +
"string mensaje_fallo = \"El captcha no fue validado intente otra vez \";\n" +
"string mensaje_acierto = \"El captcha fue validado \";\n" +
"string mensaje_final = \"El captcha no logró ser validado :( intente mas tarde\";\n" +
"!! Validacion del numero de oportunidades restantes\n" +
"IF (contador_fallas == 0) THEN\n" +
"INIT {:\n" +
"ALERT_INFO(mensaje_final);\n" +
"EXIT();\n" +
":} END\n" +
"!! Validación de fallas y aciertos\n" +
"IF (result_caja_texto == result ) THEN\n" +
"!!si el resultado es correcto\n" +
"INIT {:\n" +
"ALERT_INFO(mensaje_acierto);\n" +
":} END\n" +
"ELSE\n" +
"!! si el intento es incorrecto\n" +
"\n" +
"INIT {:\n" +
"ALERT_INFO(mensaje_fallo);\n" +
"contador_fallas = contador_fallas - 1;\n" +
":} END\n" +
"]\n" +
"</C_SCRIPTING>\n" +
"</C_BODY>\n" +
"</C_GcIC>\n" +
"\n" +
"\n" +
"!!Fin de estructura GCIC \n \n"; /*"@@@ @@@ <!-- Mi primer captcha\n"
                + "en el curso de Organización de Lenguajes y Compiladores 1\n"
                + "-->\n"
                + "<     C_GcIC [id= \"captcha_matematico_1\"] [name= \"Captcha Matemático 1\"]>\n"
                + "!! El encabezado de la página que tendrá mi captcha\n"
                + "<C_hEAd>\n"
                
                + "<C_SCRIPTING> PROCESS_num() [ IF \"carmen\" == \"Carmen\") THEN\n"
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
                + "</C_BODY>\n °"
                + "</C_GcIC>\n@"
                + "\n"
                + "\n"
                + "!!Fin de estructura GCIC\n"
                + "\n\n" ;*/
        //animar objeto anterior (21,34,curva)
        StringReader reader = new StringReader(entrada);
        Lexico lexico = new Lexico(reader);
        /*pide un archivo que tenga el codigo para leerlo*/

        Parser pa = new Parser(lexico);

        try {
            pa.parse();

             for (int i = 0; i < lexico.getErrorList().size(); i++) {
                System.out.println("" + lexico.getErrorList().get(i));
            }

            /*for (int i = 0; i < pa.getErrorSintactico().size(); i++) {
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
            System.out.println("Error irrecuperable.. falta la etiqueta de cierre: </C_Gcic>" + e);

        }

    }

}
