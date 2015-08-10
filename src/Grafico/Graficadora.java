/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafico;

import Estructuras.ListaObjetos;
import Estructuras.MatrizOrtogonal;
import Estructuras.NodoObjeto;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Juande
 */
public class Graficadora {
    ListaObjetos objetos;
    MatrizOrtogonal matriz;
    
    public Graficadora(){
        
    }
    
    private void save(String cadena, String salida) {
        String texto = cadena;//variable para comparacion

        if (texto.matches("[[ ]*[\n]*[\t]]*")) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "No hay texto para guardar!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
        } else {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.dot", "dot", "Dot"));//filtro para ver solo archivos .edu
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    try (PrintWriter printwriter = new PrintWriter(JFC)) {
                        printwriter.print(texto);
                    }

                    //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                    if (!(PATH.endsWith(".dot"))) {
                        File temp = new File(PATH + ".dot");
                        JFC.renameTo(temp);//renombramos el archivo
                        crear(PATH+".dot", salida);
                    }

                    JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {//por alguna excepcion salta un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public final void escribir(String cadena, String nombre) {

        try {
            File archivo = new File(nombre);
            archivo.delete();
            archivo = new File(nombre);
            try (FileWriter escribir = new FileWriter(archivo, true)) {
                escribir.write(cadena);
            }catch(Exception e){
                JOptionPane.showInputDialog("error al escribir datos");
            }

        } catch (Exception e) {
            
            JOptionPane.showInputDialog("error al escribir datos");
        }
    }
    
    public void dibujar_personajes(ListaObjetos objetos, String perso) {
        NodoObjeto aux = objetos.getCabeza();
        NodoObjeto aux2, aux3;
        aux2 = aux;
        String texto = "";
        while (aux != null) {
            texto = texto + aux.getTipo().trim() +";\n";
            aux = aux.getSiguiente();
        }
        aux = objetos.getCabeza();
        while (aux != null) {
            texto = texto + aux.getTipo().trim();
            if (aux.getSiguiente() != null) {
                texto = texto + "->";
                
            }
            
            aux = aux.getSiguiente();
        }
        texto = texto + ";\n";
        
        while(aux2.getSiguiente() != null){
            aux2 = aux2.getSiguiente();
        }
        aux3 = aux2;
        while (aux3 != null){
            texto = texto + aux3.getTipo().trim();
            if (aux3.getAnterior() != null) {
                texto = texto + "->";
            }
            aux3 = aux3.getAnterior();
        }
        texto = texto + ";\n";
        texto = "digraph G\n{\n node [shape=rectangule];\n"
                + "node [style=filled];\n"
                + "node [fillcolor=\"#EEEEEE\"]\n;"
                + "node [color=\"#EEEEEE\"]\n"
                + "edge [color=\"#31CEF0\"]\n"
                + "" + texto + ""
                + "\n}";
        //escribir(texto, "ListaObjetos" + perso + ".dot");
        //crear("ListaObjetos" + perso + ".dot", "ListaPersonajes" + perso + ".png");
        save(texto, "ListaObjetos"+perso+".png");
    }
    
    public void crear(String entrada, String Salida) {
        try {
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", "C:/Users/JuandeDios/Desktop/" + Salida,entrada);
            pbuilder.redirectErrorStream(true);
            pbuilder.start();

        } catch (Exception e) {
            JOptionPane.showInputDialog("error al escribir datos crear");
        } finally {
        }
    }
}
