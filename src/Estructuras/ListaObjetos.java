package Estructuras;

import javax.swing.ImageIcon;

/**
 *
 * @author Juande
 */
public class ListaObjetos {
    private NodoObjeto cabeza;
    
    public ListaObjetos(){
        cabeza = null;
    }
    
    public void InsertarObjeto(NodoObjeto objeto, String nombre, ImageIcon imagen){
        NodoObjeto nuevo = new NodoObjeto(nombre, imagen);
        if(this.getCabeza()==null){
            this.setCabeza(nuevo);
        }else{
            NodoObjeto actual = cabeza;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            actual.setAnterior(actual);
        }
    }

    /**
     * @return the cabeza
     */
    public NodoObjeto getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoObjeto cabeza) {
        this.cabeza = cabeza;
    }
}
