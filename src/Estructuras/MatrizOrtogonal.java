package Estructuras;


/**
 *
 * @author Juande
 */
public class MatrizOrtogonal {
    private NodoRaiz cabeza;
    private NodoColumna columna;
    private NodoFila fila;
    private NodoOrtogonal raiz;
    
    public MatrizOrtogonal(){
        this.cabeza = new NodoRaiz();
        this.InsertarColumnaBase(3);
        this.InsertarFilaBase(3);
        raiz = new NodoOrtogonal(1,1);
        this.LlenarMatriz(3,3);
    }
    
    public void Insertar(int columnas, int filas){
        
    }
    
    
    //recibe el entero para saber cuantas veces hacer esta insersion
    public void InsertarColumnaBase(int columnas){
        for(int i = 1; i<=columnas;i++){
            NodoColumna nuevacolumna = new NodoColumna();
        //Si el siguiente de la raiz es nulo entonces inserta el primer nodo columna ahi
        if( this.getCabeza().getSiguiente() == null){
            this.getCabeza().setSiguiente(nuevacolumna);          
        }else{
            //Recorre los nodos columna hasta que el siguiente sea null he inserta ahi el nuevo
            NodoColumna actual = this.getCabeza().getSiguiente();
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
        if( this.getCabeza().getArriba() == null){
            this.getCabeza().setArriba(nuevafila);
        }else{
            //Recorre los nodos fila hasta que el siguiente sea null he inserta ahi el nuevo
            NodoFila actual = this.getCabeza().getArriba();
            while(actual.getArriba() != null){
                actual = actual.getArriba();
                }
            actual.setArriba(nuevafila);
            }
        }
    }
    
    public void LlenarMatriz(int filas, int columnas){ 
        getRaiz().setAbajoCol(this.getCabeza().getSiguiente());
        getRaiz().setAnteriorFil(this.getCabeza().getArriba());
        System.out.println("Se creo el nodo raiz");
        NodoOrtogonal nuevo;
        NodoOrtogonal nuevo2;
        for(int j = 1; j <= filas; j++){
            for(int x = 1; x <= columnas ; x++){               
                //Si x=1 y j=1
                if(x==1 && j==1){
                   
                }
                //si x es mayor que 1 pero sigue estan en j= 1 es decir la misma fila
                else if(x>1 && j==1){
                    NodoOrtogonal actual;
                    nuevo = new NodoOrtogonal(x,1);
                    
                    System.out.println("Se creo el nodo de la posicion que esta en la columna: "+ x +" y en la fila: "+j);
                    actual = getRaiz();
                    while(actual.getSiguiente() != null){
                        actual = actual.getSiguiente();
                    }
                    actual.setSiguiente(nuevo);
                    nuevo.setAnterior(actual);
                    //System.out.println("El nodo que tiene atras esta en la columna:"+nuevo.getAnterior().getPosx());
                }
                //si estamos en la columna 1 pero en j > 1 es decir alguna fila mas arriba de la raiz
                else if(x==1 && j > 1){
                    NodoOrtogonal actual;
                    nuevo2 = new NodoOrtogonal(1,j);                 
                    System.out.println("Se creo el nodo de la posicion que esta en la columna: "+ x +" y en la fila: "+j);
                    actual = getRaiz();
                    
                    while(actual.getArriba() != null){
                        actual = actual.getArriba();
                    }
                    actual.setArriba(nuevo2);
                    nuevo2.setAbajo(actual);
                    //System.out.println("El nodo que tiene abajo esta en la fila:"+nuevo2.getAbajo().getPosy());
                }
                //si ya no estamos ni en la primera columna ni en la primera fila
                if(x>1 && j>1){
                    //Nodo para buscar la columna
                    NodoOrtogonal tempx;
                    //Nodo para buscar la fila
                    NodoOrtogonal tempy;
                    //Nodo para buscar la columna de insersion
                    NodoOrtogonal tempx2;
                    //Nodo para buscar la fila de insersion
                    NodoOrtogonal tempy2;
                    nuevo = new NodoOrtogonal(x,j);
                    System.out.println("Se inserto el nodo de la columna: "+nuevo.getPosx()+" y fila: "+nuevo.getPosy());
                    for(tempx = getRaiz(); tempx!=null;tempx = tempx.getSiguiente() ){
                        if(tempx.getPosx() == nuevo.getPosx()){
                            for(tempy = getRaiz(); tempy !=null; tempy = tempy.getArriba()){
                                if(tempy.getPosy() == nuevo.getPosy()){
                                    for(tempx2 = tempx; tempx2 != null; tempx2 = tempx2.getArriba()){
                                        if(tempx2.getPosy() == nuevo.getPosy()-1){
                                            tempx2.setArriba(nuevo);
                                            nuevo.setAbajo(tempx2);
                                            System.out.println("Abajo: "+nuevo.getAbajo().getPosy());
                                            for(tempy2 = tempy; tempy2 != null; tempy2 = tempy2.getSiguiente()){
                                                if(tempy2.getPosx() == nuevo.getPosx()-1){
                                                    tempy2.setSiguiente(nuevo);
                                                    nuevo.setAnterior(tempy2);
                                                    System.out.println("Atras: "+nuevo.getAnterior().getPosx());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                } 
            }
        }
    }
    
    public void Visualizar(){
        int col = 0;
        int fil = 0;
        NodoRaiz auxR = this.getCabeza();
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
    
    public void ImprimirMatriz(){
        NodoOrtogonal aux;
        NodoOrtogonal aux2;
        for(aux = this.getRaiz() ; aux != null; aux = aux.getArriba()){
            for(aux2 = aux.siguiente; aux2 != null; aux2 = aux2.getSiguiente()){
                System.out.println("Nodo en la posicion: "+aux2.getPosx()+ " en X y en "+aux2.getPosy()+" en Y");
            }
        }
    }

    public static int ObtenerFilas(MatrizOrtogonal matriz){
        NodoOrtogonal R = matriz.getRaiz();
        NodoOrtogonal aux;
        int F = 1;
        for(aux = R; aux != null; aux = aux.siguiente){
            F ++;
        }
        return F;
    }
    
    public static int ObtenerColumnas(MatrizOrtogonal matriz){
        NodoOrtogonal R = matriz.getRaiz();
        NodoOrtogonal aux;
        int C =1;
        for(aux = R; aux!=null; aux = aux.getArriba()){
            C++;
        }
        return C;
    }
    
    
    public void InsertarColumna(){
        NodoOrtogonal aux1 = this.getRaiz();
        NodoOrtogonal aux2;
        NodoOrtogonal nuevo;
        NodoOrtogonal nuevo2;
        NodoOrtogonal ultimo;
        //mientras que el siguiente del aux1 sea diferente de null
        while( aux1.getSiguiente() != null){
            //aux1 va a ser su siguiente
            aux1 = aux1.getSiguiente();
        }
        nuevo = new NodoOrtogonal(aux1.getPosx()+ 1, 1);
        nuevo.setAnterior(aux1);
        aux1.setSiguiente(nuevo);
        
        aux2 = aux1;
        while(aux2.getArriba() != null){
            aux2 = aux2.getArriba();
            nuevo2 = new NodoOrtogonal(nuevo.getPosx(),aux2.getPosy());
            aux2.setSiguiente(nuevo2);
            nuevo2.setAnterior(aux2);
            nuevo2.setAbajo(nuevo);
            nuevo.setArriba(nuevo2);
            nuevo = nuevo.getArriba();
        }
        /*ultimo = new NodoOrtogonal(nuevo.getPosx(), aux2.getPosy());
        ultimo.setAnterior(aux2);
        aux2.setSiguiente(ultimo);
        ultimo.setAbajo(nuevo);*/
    }
    
    public void InsertarFila(){
        NodoOrtogonal aux1 = this.getRaiz();
        NodoOrtogonal aux2;
        NodoOrtogonal nuevo;
        NodoOrtogonal nuevo2;
        while(aux1.getArriba() != null){
            aux1 = aux1.getArriba();
        }
        nuevo = new NodoOrtogonal (1,aux1.getPosy()+1);
        nuevo.setAbajo(aux1);
        aux1.setArriba(nuevo);
        
        aux2 = aux1;
        while(aux2.getSiguiente() != null){
            aux2 = aux2.getSiguiente();
            nuevo2 = new NodoOrtogonal(aux2.getPosx(), nuevo.getPosy());
            aux2.setArriba(nuevo2);
            nuevo2.setAbajo(aux2);
            nuevo2.setAnterior(nuevo);
            nuevo.setSiguiente(nuevo2);
            nuevo = nuevo.getSiguiente();
        } 
    }
    
    /**
     * @return the cabeza
     */
    public NodoRaiz getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NodoRaiz cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the columna
     */
    public NodoColumna getColumna() {
        return columna;
    }

    /**
     * @param columna the columna to set
     */
    public void setColumna(NodoColumna columna) {
        this.columna = columna;
    }

    /**
     * @return the fila
     */
    public NodoFila getFila() {
        return fila;
    }

    /**
     * @param fila the fila to set
     */
    public void setFila(NodoFila fila) {
        this.fila = fila;
    }

    /**
     * @return the raiz
     */
    public NodoOrtogonal getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoOrtogonal raiz) {
        this.raiz = raiz;
    }
}
