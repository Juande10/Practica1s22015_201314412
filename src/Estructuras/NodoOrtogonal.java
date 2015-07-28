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
public class NodoOrtogonal {
    private NodoOrtogonal arriba;
    private NodoOrtogonal abajo;
    private NodoOrtogonal derecha;
    private NodoOrtogonal izquierda;
    
    private boolean estado;
    private NodoObjeto objeto;
    
    public NodoOrtogonal(){
        this.estado = false;
        
    }

    
    
    /**
     * @return the arriba
     */
    public NodoOrtogonal getArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(NodoOrtogonal arriba) {
        this.arriba = arriba;
    }

    /**
     * @return the abajo
     */
    public NodoOrtogonal getAbajo() {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(NodoOrtogonal abajo) {
        this.abajo = abajo;
    }

    /**
     * @return the derecha
     */
    public NodoOrtogonal getDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(NodoOrtogonal derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the izquierda
     */
    public NodoOrtogonal getIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(NodoOrtogonal izquierda) {
        this.izquierda = izquierda;
    }
}
