package com.adolfo.analizadores.datos;

import java.util.List;

/**
 *
 * @author hectoradolfo
 */
public class TablaSimbolo {

    public boolean existeId(String id, List<LexemeId> ids) {
        if (!ids.isEmpty()) {
            for (int i = 0; i < ids.size(); i++) {
                if (id.equals(ids.get(i).getDato())) {
                    return true;
                }
            }
        }
        return false;
    }
}
