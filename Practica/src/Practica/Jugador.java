/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

/**
 *
 * @author kjorda
 */
public class Jugador {
    private BarajaJugador baraja;
    private int partidasGanadas;
    private String nombre;
    boolean humano;
    
    public Jugador(String n, boolean JugadorHumano){
        baraja = null;
        partidasGanadas = 0;
        nombre = n;
        humano = JugadorHumano;
    }
    
    public Jugador(String n){
        baraja = null;
        partidasGanadas = 0;
        nombre = n;
        humano = false;
    }
    
    public void repartir(Baraja b){
        baraja = new BarajaJugador(b);
    }
}
