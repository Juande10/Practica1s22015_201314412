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
public class NodoFila {
    private NodoFila arriba;
    
    public NodoFila(){
        this.arriba = null;
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
