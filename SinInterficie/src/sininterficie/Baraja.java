/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sininterficie;

import java.util.Random;

/**
 *
 * @author kjorda
 */
public class Baraja {
    private Carta[] cartas;
    private int indice;
    
    public Baraja(){
        cartas = new Carta[52];
        indice = 0;
        this.reset();
    }
    
    public Baraja(Carta[] car){
        cartas = new Carta[52];
        indice = 0;
        for (int i = 0; i < 52; i++){
            cartas[i] = car[i];
        }
    }
    
    public void reset(){
        for (int i = 0; i < 52; i++){
            cartas[i] = new Carta((i%13)+1, Palo.values()[i/13]);
        }
    }
    
    public void mezclar(){
        Random r = new Random();
        for (int i = 51; i > 0; i--){ // Algoritmo Fisher-Yates
            int rand = r.nextInt(i+1); // i+i ya que nextInt es exclusivo con el limite especificado
            
            // Intercambiar cartas[i] y cartas[rand]
            Carta tmp = cartas[i];
            cartas[i] = cartas[rand];
            cartas[rand] = tmp;
        }
    }
    
    public Carta[] repartir(){
        if (indice > 3){
            return null;
        }
        Carta[] barajaJugador = new Carta[13];
        
        for (int i = 0; i < 13; i++){
            barajaJugador[i] = cartas[(indice*13) + i];
            cartas[(indice*13) + i] = null;
        }
        indice++;
        return barajaJugador;
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
