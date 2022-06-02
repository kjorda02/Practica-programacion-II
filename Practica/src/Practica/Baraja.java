/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.util.Random;

/**
 *
 * @author kjorda
 */
// Esta clase no representa el conjunto de cartas sino la mesa donde se colocan las cartas.
// Por lo tanto, la baraja podra tener posiciones sin cartas (null)

public class Baraja {
    private Carta[] cartas;
    
    public Baraja(){
        cartas = new Carta[52];
        for (int i = 0; i < 52; i++){
            cartas[i] = new Carta((i%13)+1, Palo.values()[i/13]);
        }
    }
    
    public Carta getCarta(int num){
        return cartas[num];
    }
    
    public Carta[] getCartas(){
        return cartas;
    }
    
    @Override
    public String toString(){ // Comprobar metodo
        String s = "";
        for (int i = 0; i < 52; i++){
            s += "Carta " + (i+1) + ": ";
            s += cartas[i].toString();
            s += "\n";
        }
        return s;
    }
}
