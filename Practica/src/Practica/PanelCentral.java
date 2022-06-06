/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
public class PanelCentral extends JPanel implements ActionListener{
    JPanel panelPuntosCPU, panelCartasHumano;
    BarajaJugador[] barajas;
    TaulaJoc mesa;
    
    public PanelCentral(TaulaJoc m, BarajaJugador[] bars){
        mesa = m;
        barajas = bars;
        setLayout(new BorderLayout());
        add(mesa, BorderLayout.CENTER);
        
        panelCartasHumano = new JPanel(new GridLayout(1,13));
        for (int i=0; i<13; i++){
            panelCartasHumano.add(new JLabel(barajas[0].getCarta(i).getImagen()));
        }
        add(panelCartasHumano, BorderLayout.SOUTH);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        
    }
    
}
