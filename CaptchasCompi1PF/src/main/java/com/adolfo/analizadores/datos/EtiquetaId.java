package com.adolfo.analizadores.datos;

import java.util.List;

/**
 *
 * @author hectoradolfo
 */
public class EtiquetaId {

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

}
