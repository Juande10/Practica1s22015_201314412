/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Grafico.InterfazPrincipal;
import Grafico.Tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.TransferHandler;

/**
 *
 * @author Juande
 */
public class NodoOrtogonal extends JLabel{
    public NodoOrtogonal arriba;
    public NodoOrtogonal abajo;
    public NodoOrtogonal siguiente;
    public NodoOrtogonal anterior;
    private NodoFila anteriorFil;
    private NodoColumna abajoCol;
    private int tamanox;
    private int tamanoy;
    private int posx;
    private int posy;
    public  JButton imagen;
    
    private boolean estado;
    private NodoObjeto objeto;
    
    public NodoObjeto objetoaux;
    
    public NodoOrtogonal(int posx, int posy){
        this.abajo=null;
        this.arriba=null;
        this.anterior=null;
        this.siguiente=null;
        this.estado = false;
        this.posx=posx;
        this.posy=posy;
        this.tamanox=0;
        this.tamanoy=0;
        this.anteriorFil = null;
        this.abajoCol = null;
        this.imagen = new JButton();
        this.objeto = null;
        imagen.setTransferHandler(new TransferHandler("icon"));     
    }
       
    //Metodo para insertar el objeto en el boton, este llamada desde el boton mismo
    public void Click(Tablero tablero, int ID){
        imagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Insertar(ID);
                tablero.PintarMatriz();
                tablero.MostrarObjeto();
            }
        });
        
    }
    
    public void Insertar(int ID){
        if(InterfazPrincipal.ListaPila == true){
            this.setObjeto(InterfazPrincipal.pila.getCabeza());
            InterfazPrincipal.pila.Eliminar(ID);
            System.out.println("Se inserto un "+this.getObjeto().getTipo()+" en este nodo");
 
        }else{
            this.setObjeto(InterfazPrincipal.ListaObj.getCabeza());
            InterfazPrincipal.ListaObj.Eliminar(ID);
            System.out.println("Se inserto un "+this.getObjeto().getTipo()+" en este nodo");

        }
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
     * @return the siguiente
     */
    public NodoOrtogonal getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoOrtogonal siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoOrtogonal getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoOrtogonal anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the tamanox
     */
    public int getTamanox() {
        return tamanox;
    }

    /**
     * @param tamanox the tamanox to set
     */
    public void setTamanox(int tamanox) {
        this.tamanox = tamanox;
    }

    /**
     * @return the tamanoy
     */
    public int getTamanoy() {
        return tamanoy;
    }

    /**
     * @param tamanoy the tamanoy to set
     */
    public void setTamanoy(int tamanoy) {
        this.tamanoy = tamanoy;
    }

    /**
     * @return the posx
     */
    public int getPosx() {
        return posx;
    }

    /**
     * @param posx the posx to set
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * @return the posy
     */
    public int getPosy() {
        return posy;
    }

    /**
     * @param posy the posy to set
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

    /**
     * @return the anteriorFil
     */
    public NodoFila getAnteriorFil() {
        return anteriorFil;
    }

    /**
     * @param anteriorFil the anteriorFil to set
     */
    public void setAnteriorFil(NodoFila anteriorFil) {
        this.anteriorFil = anteriorFil;
    }

    /**
     * @return the abajoCol
     */
    public NodoColumna getAbajoCol() {
        return abajoCol;
    }

    /**
     * @param abajoCol the abajoCol to set
     */
    public void setAbajoCol(NodoColumna abajoCol) {
        this.abajoCol = abajoCol;
    }

    /**
     * @return the objeto
     */
    public NodoObjeto getObjeto() {
        return objeto;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(NodoObjeto objeto) {
        this.objeto = objeto;
    }
    
}
