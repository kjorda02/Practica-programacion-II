/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Practica;

import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
public class Practica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new Practica()).prueba2();
    }
    
    private void prueba2(){
        Ventana pr = new Ventana();
        Mesa m = new Mesa(new Baraja());
        m.setBounds(10,100,930,400);
        
        pr.panelContenidos().add(m, BorderLayout.CENTER);
        pr.revalidate();
        pr.repaint();
    }
    
    private void prueba(){
        Carta[] prueba = new Carta[52];
        
        Random r = new Random();
        
        for (int i = 0; i < 52; i++){
            int palo = r.nextInt(4);
            Palo pal = Palo.values()[palo];
            prueba[i] = new Carta(i%13, pal);
        }
        
        Baraja bar = new Baraja();
        System.out.println(bar.toString());
        System.out.println("---------------");
        for (int i = 0; i < 4; i++){
            //System.out.println((new BarajaJugador(bar)).toString());
        }
    }
    
}
