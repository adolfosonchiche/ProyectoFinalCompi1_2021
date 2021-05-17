package com.adolfo.analizadores.datos;

/**
 *
 * @author hectoradolfo
 */
public class LexemeId {
    
    private String dato;
    private String tipo;
    private String modo;
    private String proceso;
    private String numEjecucion;

    public LexemeId(String dato, String tipo, String modo, String proceso, 
            String numEjecucion) {
        this.dato = dato;
        this.tipo = tipo;
        this.modo = modo;
        this.proceso = proceso;
        this.numEjecucion = numEjecucion;
    }

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the modo
     */
    public String getModo() {
        return modo;
    }

    /**
     * @return the proceso
     */
    public String getProceso() {
        return proceso;
    }

    /**
     * @return the numEjecucion
     */
    public String getNumEjecucion() {
        return numEjecucion;
    }
    
    
    
}
