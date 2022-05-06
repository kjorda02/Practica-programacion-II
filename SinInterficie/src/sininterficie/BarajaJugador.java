/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sininterficie;

/**
 *
 * @author kjorda
 */
public class BarajaJugador {
    private final boolean jugadorHumano;
    private Carta[] cartas;
    
    public BarajaJugador(Baraja b, boolean jug){
        cartas = b.repartir();
        jugadorHumano = jug;
    }
    
    public BarajaJugador(Baraja b){
        cartas = b.repartir();
        jugadorHumano = false;
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
