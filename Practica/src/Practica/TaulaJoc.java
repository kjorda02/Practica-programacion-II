/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
public class TaulaJoc extends JPanel{
    private Carta[] cartas;
    private int indice; // Indica que cartas han sido repartidas    
    
    public TaulaJoc(Baraja b){ // Constructor - crea todos los subpaneles etc
        setLayout(new GridLayout(4,13));
        cartas = new Carta[52];
        
        for (int i = 0; i < 52; i++){
            cartas[i] = b.getCarta(i);
            JButton boton = new JButton(cartas[i].getImagen());
            boton.setOpaque(false);
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            add(boton);
        }
        setBackground(new Color(00, 102,00));
    }
    
    public boolean isVacia(){
        return false;
    }
    
    public boolean isNull(int idx){ // Indica si hay una carta en una posicion concreta de la baraja
        return (cartas[idx] == null);
    }
    
    public void ponerCarta(Carta c){
        cartas[c.getPos()] = c;
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
    
    public Carta[] repartir(){ // Devuelve un array de cartas repartidas y las quita de la Mesa
        if (indice > 3){ // Si indice = 4 no quedan cartas para repartir
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
}
