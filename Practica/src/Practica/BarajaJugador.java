/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;


/**
 *
 * @author kjorda
 */
public class BarajaJugador {
    //private final boolean jugadorHumano;
    private Carta[] cartas;
    
    public BarajaJugador(TaulaJoc m, boolean jug){
        cartas = m.repartir();
        //jugadorHumano = jug;
    }
    
    public BarajaJugador(TaulaJoc m){
        cartas = m.repartir();
        //jugadorHumano = false;
    }
    
    public Carta getCarta(int pos){
        return cartas[pos];
    }
    
    public boolean ponerCarta(int idx, TaulaJoc m){
        if (cartas[idx].esPosiblePoner(m)){
            m.ponerCarta(cartas[idx]);
            cartas[idx] = null;
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){ // Comprobar metodo
        String s = "";
        for (int i = 0; i < 13; i++){
            s += "Carta " + (i+1) + ": ";
            s += cartas[i].toString();
            s += "\n";
        }
        return s;
    }
}
