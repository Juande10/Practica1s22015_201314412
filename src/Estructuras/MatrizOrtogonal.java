package Estructuras;

/**
 *
 * @author Juande
 */
public class MatrizOrtogonal {
    private NodoOrtogonal base;//Nodo en la posicion (0,0)
    private NodoOrtogonal cabeza;
    
    public MatrizOrtogonal(){
        //Constructor de la matriz
        this.base = base;
        for(int i = 0; i <= 2;i++){
            NodoOrtogonal Aux = new NodoOrtogonal();
            base.setDerecha(Aux);
            Aux.setIzquierda(base);
            base = Aux;
        }
        
    }
    
    public void InsertarFila(){
        
    }
    
    public void InsertarColumna(){
        
    }
    
    public void BuscarNodo(){
        
    }
    
    public void EliminarNodo(){
    }
}
