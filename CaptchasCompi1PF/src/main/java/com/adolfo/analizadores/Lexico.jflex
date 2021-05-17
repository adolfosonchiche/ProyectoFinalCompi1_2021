package com.adolfo.analizadores;
/*primera seccion: codigo usuario*/
import java_cup.runtime.*;
import static com.adolfo.analizadores.sym.*;
import com.adolfo.analizadores.Token;
import java.util.ArrayList;
import java.util.List;

%%

/*segunda seccion: configuaracion*/
%class Lexico
%cup
%cupdebug
//%standalone
%line
%column
%public 
%ignorecase
%init{
  yyline = 1; 
  yycolumn = 1;
%init}

/*datos de los simbolos a utilizar*/
ESPACIOS =     [ \r\t\n]+
NUMENTERO = [\-]?[0-9]+
APOSTROFO = [']
COMILLA = [\"]
NUMDECIMAL = [\-]? ([0]|[0]?[1-9][0-9]*)("."[0-9][0-9]?[0-9]?[0-9]?)?
COMENTUNILINEA =("!!".*\r\n)|("!!".*\n)|("!!".*\r)
COMENTMULTILINEA ="<!--""<!--"*([^*/]|[^*]">"|"*"[^/])*"*"*"-->"
BOOLEANOS = "true"|"false"
ID = [_$-]*[a-zA-Z]+([a-zA-Z]*[_$-]*[0-9]*)+ /*para obtener un id*/
CARACTER = [']([^\"\n]|(\\\")[.])[']
HEXADECIMAL = #[0-9a-fA-F0]{6}
//CADENACOMILLA = [\"]([^\"]|(\\\")[.])*[\"]
//CADENA = ([^|[ \n] ])+
PROCESOS = "PROCESS_"{ID}
CADENA = ([A-Za-zñÑáéíóúÁÉÍÓÚ]*[¡¿?%\.]*)+[0-9_]*


%{
private List<String> errorList;
private List<String> listIdEtiqueta;
private String erroresIn = "", lexErr = "";
private int lineErr = 0, columnErr = 0;

%}

%{
	private Symbol symbol(int type) {
        String lexeme = yytext();
        //System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        return new Symbol(type, new Token(lexeme, yyline, yycolumn));
    }

    private Symbol symbol(int type, String lexeme) {
        //System.out.printf("Token tipo %d, lexeme %s, en linea %d, columna %d\n", type, lexeme == null ? "" : lexeme, yyline + 1, yycolumn + 1);
        if(type == ID){
          System.out.println("VIIIIDAAAALLLIAAA" + type);
        }
        return new Symbol(type, new Token(lexeme, yyline, yycolumn + 1));
    }

    private void error(String lexeme) {

      if(lineErr == 0){
        lineErr = yyline;
        columnErr = yycolumn;
        erroresIn = lexeme;
        lexErr = lexeme;
      } else {
        if(lineErr == yyline){
          erroresIn += " " + lexeme;
        } else {
            errorList.add(String.format("Error Lexico, no se reconoce el lexema: %s  linea %d,  . y los lexemas: %s no reconocidos en la misma linea\n", lexErr, lineErr, erroresIn));
            System.out.printf("Error Lexico en el Texto: %s  linea %d,  columna %d. y los token: %s en la misma linea\n", lexErr, lineErr, columnErr, erroresIn);
            lineErr = yyline;
            columnErr = yycolumn;
            erroresIn = lexeme;
            lexErr = lexeme;
        }

      }

       //System.out.printf("Error Lexico en el Texto: %s  linea %d,  columna %d. \n", lexeme, yyline + 1, yycolumn + 1);
        //errorList.add(String.format("Error Lexico del simbolo: %s , linea %d, columna %d,  no reconocido, resuelva!.", lexeme, yyline + 1, yycolumn + 1));
    }

    public List<String> getErrorList() {
        return errorList;
    }
    public int dat (){ return lineErr;}
%}

%init{
    errorList = new  ArrayList<>();
%init}




%%

<YYINITIAL> {
  //comentarios
  {COMENTMULTILINEA} { /*ignorar*/}
{COMENTUNILINEA}  { /*ignorar*/}
  //etiquetas
  "C_GCIC"			{ return symbol(HTML, yytext());} 
  "C_HEAD"			{ return symbol(HEAD, yytext());}
  "C_TITLE"			{ return symbol(TITLE, yytext());}
  "C_LINK"			{ return symbol(LINK, yytext());}
  "C_BODY"			{ return symbol(BODY, yytext());}
  "C_SPAM"			{ return symbol(SPAM, yytext());}
  "C_INPUT"			{ return symbol(INPUT, yytext());}
  "C_TEXTAREA"	{ return symbol(TEXTAREA, yytext());}
  "C_SELECT"		{ return symbol(SELECTED, yytext());}
  "C_OPTION"		{ return symbol(OPTION, yytext());}
  "C_DIV"				{ return symbol(DIV, yytext());}
  "C_IMG"			{ return symbol(IMG, yytext());}
  "C_BR"				{ return symbol(BR, yytext());}
  "C_BUTTON"		{ return symbol(BUTTON, yytext());}
  "C_H1"				{ return symbol(H1, yytext());}
  "C_P"				 { return symbol(P, yytext());}	
    "C_SCRIPTING"				 { return symbol(SCRIPT, yytext());}		
  //parametros de etiquetas
"href"				{ return symbol(REFERENCIA, yytext());}
"background"	{ return symbol(BACKGROUND, yytext());}
"color"				{ return symbol(COLOR, yytext());}
"font-size"		{ return symbol(FONTSZ, yytext());}
"font-family"	 { return symbol(FONTFY, yytext());}
"text-align"		{ return symbol(ALINGN, yytext());}
"type"				{ return symbol(TYPE, yytext());}
"id"				{ return symbol(IDCM, yytext());}
"name"				{ return symbol(NAME, yytext());}
"cols"				{ return symbol(COLUMNA, yytext());}
"rows"				{ return symbol(FILA, yytext());}
"class"				{ return symbol(CLASE, yytext());}
"src"				{ return symbol(SRC, yytext());}
"width"				{ return symbol(WIDTH, yytext());}
"height"			{ return symbol(HEIGHT, yytext());}
"alt"				{ return symbol(ALT, yytext());}
"onclick"			{ return symbol(ONCLICK, yytext());}
//tipo de datos
"integer"			{ return symbol(ENTERO, yytext());}
"decimal"			{ return symbol(DECIMAL, yytext());}
"boolean"			{ return symbol(BOOLEANO, yytext());}
"char"				{ return symbol(CHAR, yytext());}
"string"			{ return symbol(STRING, yytext());}
"@global"			{ return symbol(GLOBAL, yytext());}
//operadores relacioneales
"=" 				{ return symbol(IGUAL, yytext());}
"<"			{ return symbol(MEQ, yytext());}
">"				{ return symbol(MAQ, yytext());}
//logicos
"|"			{ return symbol(OR, yytext());}
"&"			{ return symbol(AND, yytext()); }
"!"			{ return symbol(NOT, yytext());}
//aritmeticos
"+"			{ return symbol(SUMA, yytext());}
"-"			{ return symbol(RESTA, yytext());}
"*"			{ return symbol(PRODUCTO, yytext());}
"/"			{ return symbol(DIVISION, yytext());}
//simbolos
"["			{ return symbol(CORIN, yytext());}
"]"			{ return symbol(COROUT, yytext());}
"("			{ return symbol(PARIN, yytext());}
")"			{ return symbol(PAROUT, yytext());}
","			{ return symbol(COMA, yytext());} 
";"    	{ return symbol(PUNTOCOMA, yytext());}
"{"			{ return symbol(LLAVEIN, yytext());}
"}"			{ return symbol(LLAVEOUT, yytext());}
":"			{ return symbol(DOSP, yytext());}
//procedimientos
"ON_LOAD"		{ return symbol(LOAD, yytext());}
//funciones especiales
"ASC"				{ return symbol(ASCF, yytext());}
"DESC"			{ return symbol(DESCF, yytext());}
"LETPAR_NUM"		{ return symbol(LETPF, yytext());}
"LETIMPAR_NUM"		{ return symbol(LETIMF, yytext());}
"REVERSE"			{ return symbol(REVERSEF, yytext());}
"CARACTER_ALEATORIO"	{ return symbol(CARALEF, yytext());}
"NUM_ALEATORIO"		{ return symbol(NUMALEF, yytext());}
"ALERT_INFO"		{ return symbol(ALERTF, yytext());}
"EXIT"				{ return symbol(EXIT, yytext());}
"getElemenById"		{ return symbol(GETID, yytext());}
"INSERT"			{ return symbol(INSERT, yytext());}
"INIT"				{ return symbol(INIT, yytext());}
"END"				{ return symbol(END, yytext());}
//sentencias
"IF"				{ return symbol(IF, yytext());}
"THEN"				{ return symbol(THEN, yytext());}
"ELSE"				{ return symbol(ELSE, yytext());}
"REPEAT"			{ return symbol(REPEAT, yytext());}
"HUNTIL"			{ return symbol(HUNTIL, yytext());}
"WHILE"			{ return symbol(WHILE, yytext());}
"THENWHILE"		{ return symbol(THENWHILE, yytext());}

{COMILLA}     { return symbol(COMILLA, yytext());}
{APOSTROFO}   { return symbol(APOSTROFO, yytext());}
{PROCESOS}   { return symbol(PROCESOS, yytext());}
{BOOLEANOS}  {  return symbol(BOOLEANOS, yytext()); }
{ID}         { return symbol(ID, yytext());}

{NUMENTERO}    {  return symbol(NUMENTERO, yytext()); }
{NUMDECIMAL}   {  return symbol(NUMDECIMAL, yytext()); }
   
{CARACTER}     { return symbol(CARACTER, yytext());}
{HEXADECIMAL}   { return symbol(HEXADECIMAL, yytext());}
{CADENA}      { return symbol(CADENA, yytext());}
{ESPACIOS}    { /*Ignoramos*/}

[^]          { error(yytext());} 
}
