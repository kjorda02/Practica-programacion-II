/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author kjorda
 */
public class Carta {
    private final int numero;
    private final Palo palo;
    private final int posicion;
    ImageIcon imagen;
    //private String pathImagen;
    
    public Carta(int num, Palo pal){
        numero = num;
        palo = pal;
        posicion = calcPos();
        String pathImagen = "imagenes/"+numero+"_of_";
        switch(palo){
            case TREBOLES:
                pathImagen += "clubs.png";
                break;
            case PICAS:
                pathImagen += "spades.png";
                break;
            case CORAZONES:
                pathImagen += "hearts.png";
                break;
            case DIAMANTES:
                pathImagen += "diamonds.png";
                break;
        }
        
        imagen = new ImageIcon(new ImageIcon(pathImagen).getImage().getScaledInstance(60, 90, Image.SCALE_DEFAULT));
    }

    public int calcPos(){ // Donde se deberia colocar la carta en la baraja
        int pos = 0;
        for (int i = 0; i < 4; i++){
            if (Palo.values()[i] == palo){
                pos = i*13;
            }
        }
        pos += numero - 1; // -1 Porque empezamos a contar por 0 y las cartas empiezan por 1
        return pos;
    }
    
    public ImageIcon getImagen(){
        return imagen;
    }
    
    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }
    
    public int getPos(){
        return posicion;
    }
    
    public boolean esPosiblePoner(TaulaJoc m){ // Devuelve true si la carta se puede colocar en la mesa, y false en caso contrario
        //System.out.println(numero);
        //System.out.println(m.isVacia());
        if (m.isVacia() && this.numero != 7){ // Si la baraja esta vacia solo se puede colocar un 7
            return false;
        } else if (m.isVacia()){
            return true;
        }
        
        if (!((posicion % 13) == 0) && !m.isNull(posicion-1)){ // Si esta carta no esta en el borde de la izquierda y tiene una carta adyacente a la izquierda
            return true;
        }
        if (!((posicion % 13) == 12) && !m.isNull(posicion+1)){ // Si esta carta no esta en el borde de la derecha y tiene una carta adyacente a la derecha
            return true;
        }
        if (!(posicion < 13) && !m.isNull(posicion-13)){ // Si esta carta no esta en el borde de arriba y tiene una carta adyacente encima
            return true;
        }
        if (!(posicion > 38) && !m.isNull(posicion+13)){ // Si esta carta no esta en el borde de abajo y tiene una carta adyacente abajo
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        String s = "";
        switch(palo){
            case TREBOLES:
                s += "TREBOLES";
                break;
            case PICAS:
                s += "PICAS";
                break;
            case CORAZONES:
                s += "CORAZONES";
                break;
            case DIAMANTES:
                s += "DIAMANTES";
                break;
        }
        return s;
    }
}
