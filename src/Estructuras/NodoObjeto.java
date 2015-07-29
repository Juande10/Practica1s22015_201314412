package Estructuras;

import javax.swing.Icon;

/**
 *
 * @author Juande
 */
public class NodoObjeto {
    private NodoObjeto siguiente;
    private NodoObjeto anterior;
    private String nombre;
    private Icon imagen;
    private String tipo;
    
    public NodoObjeto(String nombre, String tipo, Icon imagen){
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    /**
     * @return the siguiente
     */
    public NodoObjeto getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoObjeto siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoObjeto getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoObjeto anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the imagen
     */
    public Icon getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
}
