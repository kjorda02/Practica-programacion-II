/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sininterficie;

/**
 *
 * @author kjorda
 */
public class Carta {
    private final int numero;
    private final Palo palo;
    
    public Carta(int num, Palo pal){
        numero = num;
        palo = pal;
    }
    
    @Override
    public String toString(){
        String s = "";
        switch(palo){
            case TREBOLES:
                s += "TREBOLES";
                break;
            case PICAS:
                s += "PICAS";
                break;
            case CORAZONES:
                s += "CORAZONES";
                break;
            case DIAMANTES:
                s += "DIAMANTES";
                break;
        }
        
        s += ", ";
        s += numero;
        return s;
    }
}
