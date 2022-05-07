/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author kjorda
 */
public class GUIFrame extends JFrame{
    GUIFrame(){
        this.setTitle("MI PRIMERA VENTANA");
        //DECLARACIÓN OBJETO Dimension PARA OBTENER LA DIMENSIÓN DE LA PANTALLA
        //EN LA QUE ESTEMOS EJECUTANDO
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        //DECLARACIÓN VARIABLES ENTERAS Y ASIGNACIÓN EN ELLAS DE LA RESOLUCIÓN
        //HORIZONTAL Y VERTICAL DE LA PANTALLA
        int dimensionX=(int) dimension.getWidth();
        int dimensionY=(int) dimension.getHeight();
        //DIMENSIONAR EL CONTENEDOR JFrame ventana CON LA MITAD DE LA RESOLUCIÓN
        //DE LA PANTALLA
        this.setSize(dimensionX/2, dimensionY/2);  
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        this.setLocationRelativeTo(null);
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        this.setVisible(true);
    }
}
