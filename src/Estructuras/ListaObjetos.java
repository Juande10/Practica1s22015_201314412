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
    
    public void InsertarObjeto(NodoObjeto objeto, int ID, String nombre, String tipo, Icon imagen){
        NodoObjeto nuevo = new NodoObjeto(ID,nombre,tipo,imagen);
        if(this.getCabeza()==null){
            this.setCabeza(nuevo);
        }else{
            NodoObjeto actual = cabeza;
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual);
        }
    }
    
    public void Visualizar(){
        NodoObjeto visual;
        for(visual = getCabeza(); visual != null; visual=visual.getSiguiente()){
            System.out.println(visual.getNombre() + " De tipo: " + visual.getTipo());
        }
    }

    public void Eliminar(int ID){
        if(this.getCabeza().getID()==ID){
            if(this.getCabeza().getSiguiente() == null){
                this.cabeza = null;
            }else{
                NodoObjeto aux = this.getCabeza().getSiguiente();
                this.setCabeza(aux);
                aux.setAnterior(null);
            }
        }else{
            NodoObjeto aux;
            for(aux = this.getCabeza(); aux != null; aux = aux.getSiguiente()){
                if(aux.getID() == ID && aux.getSiguiente() != null){
                    NodoObjeto temp1 = aux.getAnterior();
                    NodoObjeto temp2 = aux.getSiguiente();
                    temp1.setSiguiente(temp2);
                    temp2.setAnterior(temp1);
                    aux.setSiguiente(null);
                    aux.setAnterior(null);
                    break;
                }
                else if(aux.getID() == ID && aux.getSiguiente() == null){
                    NodoObjeto temp1 = aux.getAnterior();
                    temp1.setSiguiente(null);
                    aux.setAnterior(null);
                }
            }
        }
    }
    
    public void EliminarCabeza(){
        NodoObjeto aux = this.getCabeza().getSiguiente();
        if(aux != null){
            aux.setAnterior(null);
            this.setCabeza(aux);
        }else{
            this.cabeza = null;
        }
    }
    
    public Boolean Personas(NodoObjeto personaje){
        NodoObjeto recorrer;
        Boolean resp;
        Boolean result = true;
        for(recorrer = this.cabeza; recorrer != null; recorrer = recorrer.getSiguiente()){    
            if(personaje.getTipo().equals(recorrer.getTipo())){
                resp = true;
                result = resp;
            }else{
                resp = false;
                result = resp;
            }
        }
        return result;
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
