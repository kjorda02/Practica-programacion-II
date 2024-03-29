// Krishna Jorda Jimenez y Alberto Ruiz
// https://youtu.be/3XDviEPh_M8
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
        
        imagen = new ImageIcon(new ImageIcon(pathImagen).getImage().getScaledInstance(60, 90, Image.SCALE_SMOOTH));
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
        if (this.numero == 7){ // Si el numeor de la carta es un 7 siempre se puede colocar
            return true;
        }
        
        if (!((posicion % 13) == 0) && !m.isNull(posicion-1)){ // Si esta carta no esta en el borde de la izquierda y tiene una carta adyacente a la izquierda
            return true;
        }
        if (!((posicion % 13) == 12) && !m.isNull(posicion+1)){ // Si esta carta no esta en el borde de la derecha y tiene una carta adyacente a la derecha
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        String s = "[";
        s += numero;
        switch(palo){
            case TREBOLES:
                s += " treboles]";
                break;
            case PICAS:
                s += " picas]";
                break;
            case CORAZONES:
                s += " corazones]";
                break;
            case DIAMANTES:
                s += " diamantes]";
                break;
        }
        return s;
    }
}
