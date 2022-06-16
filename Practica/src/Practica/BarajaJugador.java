// Krishna Jorda Jimenez y Alberto Ruiz
// https://youtu.be/3XDviEPh_M8
package Practica;


/**
 *
 * @author kjorda
 */
public class BarajaJugador {
    //private final boolean jugadorHumano;
    private Carta[] cartas;
    
    public BarajaJugador(Carta[] c){
        cartas = c;
        //jugadorHumano = false;
    }
    
    public Carta getCarta(int pos){
        return cartas[pos];
    }
    
    public void borrarCarta(int pos){
        cartas[pos] = null;
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
