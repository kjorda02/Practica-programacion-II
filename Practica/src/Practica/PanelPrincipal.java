/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
// Este es el panel principal, que contiene los paneles de las cartas en la mesa, el de las cartas del jugador, y el del numero de cartas de los jugadores artificiales
public class PanelPrincipal extends JPanel implements ActionListener{
    JPanel panelSuperior, panelInferior;
    TaulaJoc mesa;
    
    int numCartasHumano = 0, numCartasCPU1 = 0, numCartasCPU2 = 0, numCartasCPU3 = 0;
    BarajaJugador[] barajas;
    
    JLabel indicadorCartasHumano;
    JPanel[] ArrayCasillas = new JPanel[13]; // Estos JPanels formaran las casillas donde se podran colocar las cartas del jugador
    
    public PanelPrincipal(TaulaJoc m){
        ////////////////    TAULAJOC - PANEL CENTRAL////////////////////////////
        mesa = m;
        setLayout(new BorderLayout());
        add(mesa, BorderLayout.CENTER);
        
        ///////////////////     PANEL INFERIOR    //////////////////////////////
        panelInferior = new JPanel(new BorderLayout()); // Creamos el panel que mostrara la baraja y la puntuación del jugador
        JPanel panelIndicador = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Este panel contendra la etiqueta que mustra la puntuacion del jugador
        JPanel panelCartasHumano = new JPanel(new GridLayout(0,13)); // Este panel contendra las 13 casillas donde se colocaran las cartas
        
        // --- PANEL CARTAS HUMANO --- //
        
        for (int i = 0; i < 13; i++){ // Creamos los JPanel de las casillas donde se meteran las cartas
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(76,106));
            p.setBorder(BorderFactory.createLineBorder(new Color(00, 102,00),3));
            p.setBackground(new Color(00,i==0?82:102,00)); //#006600 / #00520
            ArrayCasillas[i] = p;
        }

        panelCartasHumano.setBackground(new Color(00,102,00));
        for (int i = 0; i < 13; i++){ // Añadimos las casillas al panel
            panelCartasHumano.add(ArrayCasillas[i]);
        }
        panelInferior.add(panelCartasHumano, BorderLayout.CENTER);
        
        // --- Indicador numero de cartas humano --- //
        indicadorCartasHumano = new JLabel("0");
        indicadorCartasHumano.setFont(new Font("", Font.BOLD, 25));
        indicadorCartasHumano.setForeground(Color.WHITE);
        indicadorCartasHumano.setHorizontalAlignment(JLabel.CENTER);
        indicadorCartasHumano.setPreferredSize(new Dimension(60,20));
        //indicadorCartasHumano.setOpaque(true);
        panelIndicador.setBackground(new Color(00,102,00));
        panelIndicador.add(indicadorCartasHumano);
        panelInferior.add(panelIndicador, BorderLayout.NORTH);
        
        add(panelInferior, BorderLayout.SOUTH);
        
    }
    
    public void repartir(){
        for (int i = 0; i < 13; i++){
            ArrayCasillas[i].add(new JLabel(barajas[0].getCarta(i).getImagen()));
        }
        revalidate();
        repaint();
    }
    
    
    public void mezclar(){
        mesa.mezclar();
    }
    
    public void reiniciar(){
        mesa.reiniciar();
    }
    
    public void actIndicadorCartasHumano(){
        indicadorCartasHumano.setText(String.valueOf(numCartasHumano));
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        
    }
    
}
