/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
public class TaulaJoc extends JPanel{
    private Carta[] cartas; // Contiene la carta que hay en cada posicion de la mesa. Null si no hay ninguna.
    private JPanel[] rejilla; // Paneles que componen la "mesa"
    Baraja b = new Baraja();
    
    public TaulaJoc(){ // Constructor - crea todos los subpaneles etc
        setBackground(new Color(00, 102,00));
        setLayout(new GridLayout(4,13));
        cartas = new Carta[52];
        rejilla = new JPanel[52];
        
        
        for (int i=0; i<52;i++){ // Creamos los paneles que constityen la rejilla de la mesa (estos paneles contendran las cartas)
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(76,106));
            p.setBorder(BorderFactory.createLineBorder(new Color(00, 102,00),3));
            p.setBackground(new Color(00,82,00)); //#00520
            rejilla[i] = p;
        }
        
        reiniciar();
        
        for (int i=0; i < 52; i++){ // Añadimos todos los paneles de la rejilla creados previamente al panel principal  
            add(rejilla[i]);
        }
    }
    
    public void reiniciar(){
        for (int i = 0; i < 52; i++){ // Copiamos las cartas de la baraja al array de las cartas que tiene la mesa
            cartas[i] = b.getCarta(i);
        }
        
        actualizar();
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
        actualizar();
    }
    
    public void actualizar(){
        for (int i = 0; i < 52; i++){
            if (cartas[i] != null){
                JLabel carta = new JLabel(cartas[i].getImagen());
                rejilla[i].removeAll();
                rejilla[i].add(carta);
            } else{
                rejilla[i].removeAll();
            }
        }
        
        revalidate();
        repaint();
    }
    
    
    public BarajaJugador[] repartir(){ // Devuelve un array de 4 barajasJugador, que contienen 13 cartas cada una
        
        BarajaJugador[] bar = new BarajaJugador[4];
        Carta[] cartasJugador = new Carta[13];;

        for (int i = 0; i < 4; i++){ // Para cada baraja
            cartasJugador = new Carta[13]; // Importante hacerlo EXACTAMENTE aqui
            for (int j = 0; j < 13; j++){ // Para cada una de las 13 cartas
                cartasJugador[j] = cartas[(i*13) + j]; // Cogerla de el array grande y meterla en el pequeño
                cartas[(i*13) + j] = null; // Borrarla del array grande
            }
            bar[i] = new BarajaJugador(cartasJugador); // Crear una barajaJugador con las cartas del array pequeño
        }
        
        actualizar(); // Borra las cartas que se han puesto a null (todas)
        
        return bar;
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
}
