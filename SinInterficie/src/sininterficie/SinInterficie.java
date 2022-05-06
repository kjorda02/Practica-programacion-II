/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sininterficie;

import java.util.Random;

/**
 *
 * @author kjorda
 */
public class SinInterficie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        (new SinInterficie()).prueba();
    }
    
    private void prueba(){
        Carta[] prueba = new Carta[52];
        
        Random r = new Random();
        
        for (int i = 0; i < 52; i++){
            int palo = r.nextInt(4);
            Palo pal = Palo.values()[palo];
            prueba[i] = new Carta(i%13, pal);
        }
        
        Baraja bar = new Baraja(prueba);
        bar.reset();
        System.out.println(bar.toString());
        System.out.println("---------------");
        for (int i = 0; i < 4; i++){
            System.out.println((new BarajaJugador(bar)).toString());
        }
    }
    
}