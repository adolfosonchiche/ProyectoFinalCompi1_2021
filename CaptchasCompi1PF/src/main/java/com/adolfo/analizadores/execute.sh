#! /bin/bash 
echo "STARTING JFLEX COMPILING"
java -jar jflex-full-1.8.2.jar Lexico.jflex
echo "STARTING JFLEX COMPILING"
javac Lexico.java
echo "EJECUTANDO "
java Lexico entrada.txt
