/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author kjorda
 */
public class Carta {
	//Pruebaaqaaa---sa
	//asaffsanhibiaAAAA
    private final int pruebaaaaa;
    private final int numero;
    private final Palo palo;
    private final int posicion;
    private String pathImagen;
    
    public Carta(int num, Palo pal){
        numero = num;
        palo = pal;
        posicion = this.getPos();
        pathImagen = numero+"_of_";
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
    
    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }
    
    public int getPos(){
        return posicion;
    }
    
    public boolean esPosiblePoner(Baraja b){ // Devuelve true si la carta se puede colocar en la mesa, y false en caso contrario
        if (b.isVacia() && this.numero != 7){
            return false;
        }
        
        if (!b.isNull(posicion-1)){ // Carta de la izquierda
            return true;
        }
        if (!b.isNull(posicion+1)){ // Carta de la derecha
            return true;
        }
        if (!b.isNull(posicion-13)){ // Carta de arriba
            return true;
        }
        if (!b.isNull(posicion+13)){ // Carta de abajo
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
        
        s += ", ";
        s += numero;
        s += "     path="+pathImagen;
        return s;
    }
}
