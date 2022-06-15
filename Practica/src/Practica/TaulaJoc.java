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
    private Carta[] cartas;
    private int indice; // Indica que cartas han sido repartidas   
    private JPanel[] rejilla; // Paneles que componen la "mesa"
    
    public TaulaJoc(Baraja b){ // Constructor - crea todos los subpaneles etc
        setBackground(new Color(00, 102,00));
        setLayout(new GridLayout(4,13));
        cartas = new Carta[52];
        rejilla = new JPanel[52];
        
        for (int i = 0; i < 52; i++){ // Copiamos las cartas de la baraja al array de las cartas que tiene la mesa
            cartas[i] = b.getCarta(i);
        }
        
        for (int i=0; i<52;i++){ // Creamos los paneles que constityen la rejilla de la mesa (estos paneles contendran las cartas)
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(76,106));
            p.setBorder(BorderFactory.createLineBorder(new Color(00, 102,00),3));
            p.setBackground(new Color(00,82,00)); //#00520
            rejilla[i] = p;
        }
        
        
        for (int i = 0; i < 52; i++){ // Añadimos las cartas a los paneles creados previamente (no deberia haber ninguna aun)
            JLabel carta = new JLabel(cartas[i].getImagen());
            rejilla[i].removeAll();
            rejilla[i].add(carta);
        }
        
        for (int i=0; i < 52; i++){ // Añadimos todos los paneles de la rejilla creados previamente al panel principal  
            add(rejilla[i]);
        }
        
    }
    
    public boolean isVacia(){
        return false;
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
