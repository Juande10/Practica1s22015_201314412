/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author Juande
 */
public class NodoRaiz {
    private NodoColumna siguiente;
    private NodoFila arriba;
    
    public NodoRaiz(){
        this.siguiente = null;
        this.arriba = null;
    }

    /**
     * @return the siguiente
     */
    public NodoColumna getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoColumna siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the arriba
     */
    public NodoFila getArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoFila arriba) {
        this.arriba = arriba;
    }
    
}
