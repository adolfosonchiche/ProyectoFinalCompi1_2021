package com.adolfo.analizadores.datos;

import java.util.List;

/**
 *
 * @author hectoradolfo
 */
public class EtiquetaId {

    private String direccion = "";
    
    private String fucionEspecial = " <script>\n"
            + "//funcion que retorna un nuemero entero aleatorio del 1 al 9\n"
            + "function NUM_ALEATORIO() {\n"
            + "    return Math.floor((Math.random() * (9 - 1 + 1)) + 1);\n"
            + "}\n"
            + "\n"
            + "//funcion para retornar un caracter aleatorio\n"
            + "function CARACTER_ALEATORIO() {\n"
            + "   var result  = '';\n"
            + "   var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';\n"
            + "   var charactersLength = characters.length;\n"
            + "      result += characters.charAt(Math.floor(Math.random() * charactersLength));\n"
            + "   \n"
            + "   return result;\n"
            + "}\n"
            + "\n"
            + "//funcion que recibe una cadena y la retorna al reves\n"
            + "function REVERSE(cadena) {\n"
            + "  var x = cadena.length;\n"
            + "  var cadenaInvertida = \"\";\n"
            + "\n"
            + "  while (x>=0) {\n"
            + "    cadenaInvertida = cadenaInvertida + cadena.charAt(x);\n"
            + "    x--;\n"
            + "  }\n"
            + "  return cadenaInvertida;\n"
            + "}\n"
            + "\n"
            + "//metodo para ordenar una cadena de carcteres de forma ascendnete\n"
            + "function ASC(palabra_1) {\n"
            + "	//var dis = palabra_1.sort();\n"
            + "	 var longitud = palabra_1.length;\n"
            + "	var arreglo = new Array(longitud);\n"
            + "  var cadenaInvertida = \"\";\n"
            + "  for (var i = 0; i< longitud; i++) {\n"
            + "    arreglo [i] = palabra_1.charAt(i);\n"
            + "  \n"
            + "  }\n"
            + "       arreglo.sort();\n"
            + "	for (var j = 0; j < longitud; j++) {\n"
            + "    cadenaInvertida = cadenaInvertida + arreglo [j] \n"
            + "  \n"
            + "  }\n"
            + "	return cadenaInvertida;	\n"
            + "}\n"
            + "\n"
            + "//metodo para ordenar una cadena de carcteres de forma descendente\n"
            + "function DESC(palabra_1) {\n"
            + "	//var dis = palabra_1.sort();\n"
            + "	 var longitud = palabra_1.length;\n"
            + "	var arreglo = new Array(longitud);\n"
            + "  var cadenaInvertida = \"\";\n"
            + "  for (var i = 0; i< longitud; i++) {\n"
            + "    arreglo [i] = palabra_1.charAt(i);\n"
            + "  \n"
            + "  }\n"
            + "    	arreglo.sort();\n"
            + "	arreglo.reverse();\n"
            + "	for (var j = 0; j < longitud; j++) {\n"
            + "    cadenaInvertida = cadenaInvertida + arreglo [j] \n"
            + "  \n"
            + "  }\n"
            + "	return cadenaInvertida;	\n"
            + "}\n"
            + "\n"
            + "\n"
            + "//metodo que recibe una cadena y codifica las letras pares de la palabra  en su equivalente a ascci y la retorna como string\n"
            + "function LETIMPAR_NUM(palabra_1) {\n"
            + "	//var dis = palabra_1.sort();\n"
            + "	 var longitud = palabra_1.length;\n"
            + "	var arreglo = new Array(longitud);\n"
            + "  var cadenaInvertida = \"\";\n"
            + "  for (var i = 0; i< longitud; i++) {\n"
            + "    arreglo [i] = palabra_1.charAt(i);\n"
            + "  \n"
            + "  }\n"
            + "    	\n"
            + "	for (var j = 0; j < longitud; j++) {\n"
            + "		let num = arreglo[j].charCodeAt(0);\n"
            + "\n"
            + "		if((num % 2) === 0) {\n"
            + "			cadenaInvertida = cadenaInvertida + num;\n"
            + "		} else {\n"
            + "			cadenaInvertida = cadenaInvertida + arreglo[j];\n"
            + "		}\n"
            + "    \n"
            + "  \n"
            + "  }\n"
            + "	return cadenaInvertida;	\n"
            + "}\n"
            + "\n"
            + "//metodo que recibe una cadena y codifica las letras impares de la palabra  en su equivalente a ascci y la retorna como string\n"
            + "function LETPAR_NUM(palabra_1) {\n"
            + "	//var dis = palabra_1.sort();\n"
            + "	 var longitud = palabra_1.length;\n"
            + "	var arreglo = new Array(longitud);\n"
            + "  var cadenaInvertida = \"\";\n"
            + "  for (var i = 0; i< longitud; i++) {\n"
            + "    arreglo [i] = palabra_1.charAt(i);\n"
            + "  \n"
            + "  }\n"
            + "    	\n"
            + "	for (var j = 0; j < longitud; j++) {\n"
            + "		let num = arreglo[j].charCodeAt(0);\n"
            + "\n"
            + "		if((num % 2) != 0) {\n"
            + "			cadenaInvertida = cadenaInvertida + num;\n"
            + "		} else {\n"
            + "			cadenaInvertida = cadenaInvertida + arreglo[j];\n"
            + "		}\n"
            + "    \n"
            + "  \n"
            + "  }\n"
            + "	return cadenaInvertida;	\n"
            + "}\n"
            + "\n"
            + "</script>";

    public boolean existeId(String id, List<String> ids) {
        if (!ids.isEmpty()) {
            for (int i = 0; i < ids.size(); i++) {
                if (id.equals(ids.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public String scriptLinkRedirigir(String link) {
        direccion = "<script>"
                + "\n function  REDIRECT() {\n"
                + "window.location.href = " + link + ";\n"
                + "}"
                + "\n</script>";
        return direccion;
    }

    public String getFuncionEspecial() {
        return fucionEspecial;
    }

}
