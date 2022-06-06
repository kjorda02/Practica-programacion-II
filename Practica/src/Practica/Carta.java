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
        posicion = this.getPos();
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
        pos += numero;
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
        if (m.isVacia() && this.numero != 7){ // Si la baraja esta vacia solo se puede colocar un 7
            return false;
        }
        
        if (!m.isNull(posicion-1)){ // Carta de la izquierda
            return true;
        }
        if (!m.isNull(posicion+1)){ // Carta de la derecha
            return true;
        }
        if (!m.isNull(posicion-13)){ // Carta de arriba
            return true;
        }
        if (!m.isNull(posicion+13)){ // Carta de abajo
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
