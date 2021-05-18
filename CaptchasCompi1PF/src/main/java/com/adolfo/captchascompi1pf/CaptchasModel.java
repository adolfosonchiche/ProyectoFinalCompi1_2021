package com.adolfo.captchascompi1pf;

import com.adolfo.controladores.CaptId;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hectoradolfo
 */
public class CaptchasModel {

    ArrayList<CaptId> listCaptchas = new ArrayList();
    public static final String PATH = System.getProperty("user.home") + "/captchaWeb";

    public CaptchasModel() {
        this.crearCarpeta();
    }

    public List<CaptId> todosLosCaptcha() throws SQLException {
        this.listCaptchas.clear();
        try (FileReader fileReader = new FileReader(PATH + "/captcha.txt");
                BufferedReader reader = new BufferedReader(fileReader)) {
            String linea = reader.readLine();
            while (linea != null) {
                listCaptchas.add(new CaptId(linea));
                linea = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Excepcion con archivo " + e);
        }
        return listCaptchas;
    }

    public void saveChangedFileCaptchasId(String idnuevos) {
        if (verificarExiste(idnuevos)) {
            System.out.println("el captcha ya existe");
        } else {
            File altoNivel = new File(PATH + "/captcha.txt");
            try (PrintStream impresoraTexto = new PrintStream(new FileOutputStream(altoNivel, true))) {
                impresoraTexto.println(idnuevos);
            } catch (Exception e) {
                System.out.println("Excepcion con archivo ");
            }
        }
    }

    public void saveChangedFileCaptchas(String datoSave, String pat) {

        try (PrintWriter printer = new PrintWriter(PATH + "/" + pat);) {
            printer.print(datoSave);
        } catch (FileNotFoundException ex) {
            System.out.println("error: " + ex);
        }

    }
    
    public void saveChangedFileTableSymbol(String datoSave, String pat) {

        try (PrintWriter printer = new PrintWriter(PATH + "/" + pat + ".id");) {
            printer.print(datoSave);
        } catch (FileNotFoundException ex) {
            System.out.println("error: " + ex);
        }

    }

    public void crearCarpeta() {
        System.out.println(PATH);
        File directorio = new File(PATH);
        boolean er = directorio.mkdir();
        if (er) {
        } else {
            System.out.println("Error al crear directorio");
        }
    }

    public boolean verificarExiste(String idVerificar) {
        try (FileReader fileReader = new FileReader(PATH + "/captcha.txt");
                BufferedReader reader = new BufferedReader(fileReader)) {
            String contenido = "";
            String linea = reader.readLine();
            while (linea != null) {
                contenido = linea;

                if (contenido.equals(idVerificar)) {
                    return true;
                }

                linea = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Excepcion con archivo " + e);
        }
        return false;
    }
}
