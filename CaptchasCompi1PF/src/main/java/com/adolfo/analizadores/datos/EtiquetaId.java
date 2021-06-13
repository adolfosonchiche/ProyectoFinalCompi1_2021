package com.adolfo.analizadores.datos;

import java.util.List;

/**
 *
 * @author hectoradolfo
 */
public class EtiquetaId {

    String direccion = "";
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
                + "window.location.href = "+link+";\n"
                + "}"
                + "\n</script>";
        return direccion;
    }

}
