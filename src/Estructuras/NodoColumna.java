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
public class NodoColumna {
    private NodoColumna siguiente;
    
    public NodoColumna(){
        this.siguiente = null;
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
}
