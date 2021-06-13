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

        /*String dat = "'a'";
        char as = dat.charAt(1);
 int asciiValue = as;*/
        //System.out.println("es el assci " + asciiValue);
        String entrada = " <!-- Captcha-2\n" +
"     Tipo: Grafico\n" +
"\n" +
"      * Este codigo Evulua:\n" +
"       GENERAL:\n" +
"       * Comentarios de linea y bloque\n" +
"       * Varias etiquetas GCIC con sus respectivos parametros\n" +
"       * El uso del procedimiento ON_LOAD\n" +
"       * El uso de un procedimiento nombrado\n" +
"       * Uso de getElemenById en los procedimientos para obtener datos capturados por las etiquetas\n" +
"       * Funciones especiales EXIT, ALERT INFO, y REDIRECT opcional\n" +
"       \n" +
"       IMPORTANTES:\n" +
"       * La instruccion INSERT para agregar una nueva etiqueta parrafo y una etiqueta input\n" +
"       * El ciclo REPEAT\n" +
"       * Operaciones aritmeticas Suma, Multiplicacion y Division entre enteros y decimales  y Suma entre cadenas y enteros\n" +
"       * Variables integer, decimal y string en modo normal y con la anotacion @global\n" +
"       * Condicion IF , IF-ELSE y IF - ELSE IF\n" +
"       * Bloques de una instruccion e instrucciones\n" +
" -->\n" +
"\n" +
"<C_GCIC [id= \"captcha_grafico_1\"] [name= \"Captcha Grafico 1\"]>\n" +
"    !! El encabezado de la página que tendrá mi captcha\n" +
"    <C_HEAD>\n" +
"       <C_LINK \n" +
"          !! El link al que redirige mi captcha\n" +
"          [href= \"https://www.usac.edu.gt/\"]>\n" +
"       </C_LINK>\n" +
"          !! El título de mi página\n" +
"       <C_TITLE> Mi primer Captcha Gráfico</C_TITLE>\n" +
"    </C_HEAD>\n" +
"    !! El cuerpo de la página\n" +
"    <C_BODY [background= \"#e5e6ea\"] >\n" +
"        !! un título simple estilizado\n" +
"        <C_H1 [id= \"title_2\"] [text-align= \"center\"] [color= \"#7eff33\"] >\n" +
"           Mi primer Captcha Gráfico\n" +
"        </C_H1>\n" +
"        !! Un salto normal\n" +
"        <C_BR>\n" +
"        !! imagen para resolver el  captcha grafico\n" +
"        <C_DIV [class= \"row\"] [id= \"contenedor_3\"] [text-align= \"center\"]>\n" +
"              <C_IMG [src= \"https://images-na.ssl-images-amazon.com/images/I/71myuXh28YL._AC_SX425_.jpg\"] [id= \"img_2\"] [width= \"600px\"] [height= \"600px\"] [alt= \"captcha\"]>\n" +
"              </C_IMG>\n" +
"        </C_DIV>\n" +
"        !! Información para resolver en el  captcha\n" +
"        <C_SPAM [id= \"mostrar_1\"] [text-align= \"center\"] [color= \"#3366ff\"] >\n" +
"           ¿ Cuántas Pelotas de Fútbol ve en la imagen de arriba?\n" +
"        </C_SPAM>\n" +
"        !! Emulación de un simple cargando.... para luego insertar el input\n" +
"        <C_SCRIPTING>\n" +
"           ON_LOAD () [\n" +
"              !!Estas instrucciones se ejecutan media vez se entra al scripting\n" +
"              integer  inicio ;\n" +
"              decimal  numero_1 =  10 + 4*2.50 + 100/10.0;\n" +
"              decimal  numero_2 =  numero_1 + 20;\n" +
"              !!Definiendo el limite de 101\n" +
"              decimal  limite = numero_2 * 2 + 0.2*5;\n" +
"              !!Insertando un parrafo\n" +
"              INSERT('<C_P [color= \"#e80729\"] [text-align= \"center\"] [id= \"parrafo_2\"] >CARGANDO...</C_P>');\n" +
"             \n" +
"              \n" +
"              !! Haciendo el Repeat para generar mas texto en el parrafo\n" +
"              REPEAT (inicio=0 ) HUNTIL (101)\n" +
"                 !! bloque de instrucciones\n" +
"                 INIT {:\n" +
"                   INSERT('cvx');\n" +
"                 :} END\n" +
"              !!fin del parrafo\n" +
"              !! Insertamos el input para que el usuario ingrese su respuesta\n" +
"              INSERT('<C_INPUT [type= \"number\"] [text-align= \"left\"] [id= \"entrada_2\"] ></C_INPUT>');\n" +
"           ]\n" +
"        </C_SCRIPTING>\n" +
"        !! Boton que llama al procedimiento evaluar\n" +
"        <C_BUTTON [id= \"boton_2\"] [onclick= \"PROCESS_evaluar2()\"] [background=\"blue\"]>            \n" +
"           Procesar...\n" +
"        </C_BUTTON> \n" +
"   \n" +
"        !! Scripting para el procedimiento evaluar\n" +
"        <C_SCRIPTING>\n" +
"            PROCESS_evaluar2() [\n" +
"               !! Instrucciones de PROCESS_evaluar() \n" +
"               integer @global intentos = 1;\n" +
"               integer @global limite = 4;\n" +
"               integer @global faltantes = 4;             \n" +
"               string result_caja_texto = getElemenById('entrada_2');\n" +
"               string result_bueno = \"2\";\n" +
"               string result_cercano = \"1\";\n" +
"               string mensaje_fallo;\n" +
"               string mensaje_acierto;\n" +
"               string mensaje_cercano = \"Estás muy cerca por favor intenta de nuevo\";\n" +
"               string mensaje_final = \"El captcha no logró ser validado :( intente mas tarde\";\n" +
"               faltantes = faltantes - 1;\n" +
"               mensaje_fallo=\"El captcha no fue validado le quedan \"+faltantes +\"intentos\";\n" +
"               mensaje_acierto = \"El captcha fue validado en el intento \" + intentos;\n" +
"                              \n" +
"               !! Validacion del numero de oportunidades restantes\n" +
"               IF (intentos == limite) THEN\n" +
"                  INIT {:\n" +
"                     ALERT_INFO(mensaje_final);\n" +
"                     EXIT();\n" +
"                  :} END \n" +
"\n" +
"               !! Validación de fallas y aciertos\n" +
"               IF (result_caja_texto == result_cercano ) THEN\n" +
"                  !!si el resultado es cercano no le descontamos el intento\n" +
"                  ALERT_INFO(mensaje_cercano);\n" +
"               ELSE IF (result_caja_texto == result_bueno ) THEN\n" +
"                  !!El resultado es el esperado\n" +
"                  INIT {:\n" +
"                     ALERT_INFO(mensaje_acierto);\n" +
"                  !!puede usarse también EXIT() para redirigir \n" +
"                  :} END    \n" +
"               ELSE \n" +
"                  !!si el intento es incorrecto\n" +
"                  INIT {:\n" +
"                     ALERT_INFO(mensaje_fallo);\n" +
"                     intentos = intentos + 1;\n" +
"                  :} END\n" +
"            ]\n" +
"        </C_SCRIPTING>  \n" +
"    </C_BODY>\n" +
"</C_GCIC>";
        /*"@@@ @@@ <!-- Mi primer captcha\n"
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

            String resultado = "Se encontraron errores: \n";
                for (int i = 0; i < lexico.getErrorList().size(); i++) {
                    resultado += lexico.getErrorList().get(i) + "\n";
                }

                for (int i = 0; i < pa.getErrorSintactico().size(); i++) {
                    resultado += pa.getErrorSintactico().get(i) + "\n";
                }
                for (int i = 0; i < pa.getErroSemantico().size(); i++) {
                    resultado += pa.getErroSemantico().get(i) + "\n";
                }
                for (int i = 0; i < lexico.getListTablaSimbol().size(); i++) {
                    System.out.println("tipo simbolo: " + lexico.getListTablaSimbol().get(i).getTipo()
                            + "  lexema: " + lexico.getListTablaSimbol().get(i).getDato()
                     + "  modo: " + lexico.getListTablaSimbol().get(i).getModo());
                }
                System.out.println(" "  + resultado);
            /*for (int i = 0; i < lexico.getErrorList().size(); i++) {
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
        } catch (Exception e) {
            System.out.println("Error irrecuperable.. " + e);

        }

    }

}
