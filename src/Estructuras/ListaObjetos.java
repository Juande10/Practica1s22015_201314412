package Estructuras;

import javax.swing.Icon;
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
    
    public void InsertarObjeto(NodoObjeto objeto, String nombre, String tipo, Icon imagen){
        NodoObjeto nuevo = new NodoObjeto(nombre,tipo,imagen);
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
    
    public void Visualizar(){
        NodoObjeto visual;
        for(visual = getCabeza(); visual != null; visual=visual.getSiguiente()){
            System.out.println(visual.getNombre() + " De tipo: " + visual.getTipo());
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
