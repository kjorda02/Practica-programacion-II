/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
public class Ventana extends JFrame{
    Container panelContenidos;
    TaulaJoc mesa;
    
    Ventana(){
        panelContenidos = getContentPane();
        setLayout(new BorderLayout());
        this.setTitle("Practica programacion II");
        panelContenidos.setBackground(new Color(00, 102,00)); //#006600

        this.setSize(960,720);
        this.setResizable(false);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //CENTRADO DEL CONTENEDOR ventana EN EL CENTRO DE LA PANTALLA
        this.setLocationRelativeTo(null);
        
        
        mesa = new TaulaJoc(new Baraja());
        PanelInferior panelInf = new PanelInferior(mesa);
        
        panelContenidos.add(mesa, BorderLayout.CENTER);
        panelContenidos.add(panelInf, BorderLayout.SOUTH);

        
        //VISUALIZACIÓN CONTENEDOR JFrame ventana
        this.setVisible(true);
    }
}
