package Estructuras;

/**
 *
 * @author Juande
 */
public class MatrizOrtogonal {
    NodoRaiz cabeza;
    NodoColumna columna;
    NodoFila fila;
    
    public MatrizOrtogonal(){
        this.cabeza = new NodoRaiz();
        this.InsertarColumnaBase(4);
        this.InsertarFilaBase(2);
    }
    
    public void Insertar(int columnas, int filas){
        
    }
    
    
    //recibe el entero para saber cuantas veces hacer esta insersion
    public void InsertarColumnaBase(int columnas){
        for(int i = 1; i<=columnas;i++){
            NodoColumna nuevacolumna = new NodoColumna();
        //Si el siguiente de la raiz es nulo entonces inserta el primer nodo columna ahi
        if(this.cabeza.getSiguiente() == null){
            this.cabeza.setSiguiente(nuevacolumna);
        }else{
            //Recorre los nodos columna hasta que el siguiente sea null he inserta ahi el nuevo
            NodoColumna actual = this.cabeza.getSiguiente();
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
                }
            actual.setSiguiente(nuevacolumna);
            }
        }  
    }
    
    public void InsertarFilaBase(int filas){
        for(int i = 1; i<= filas;i++){
            NodoFila nuevafila = new NodoFila();
        //Si el siguiente de la raiz es nulo entonces inserta el primer nodo fila ahi
        if(this.cabeza.getArriba() == null){
            this.cabeza.setArriba(nuevafila);
        }else{
            //Recorre los nodos fila hasta que el siguiente sea null he inserta ahi el nuevo
            NodoFila actual = this.cabeza.getArriba();
            while(actual.getArriba() != null){
                actual = actual.getArriba();
                }
            actual.setArriba(nuevafila);
            }
        }
    }
    
    public void Visualizar(){
        int col = 0;
        int fil = 0;
        NodoRaiz auxR = this.cabeza;
        NodoColumna auxC;
        NodoFila auxF;
        for(auxC = auxR.getSiguiente(); auxC!= null; auxC = auxC.getSiguiente()){
            col=col+1;
        }
        for(auxF = auxR.getArriba();auxF != null; auxF = auxF.getArriba()){
            fil = fil+1;
        }
        System.out.println("Se tienen "+ fil + " filas y "+ col + " columnas");
    }
}
