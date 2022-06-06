/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author kjorda
 */
public class PanelInferior extends JPanel implements ActionListener {
    JPanel panelBotones;
    JTextArea texto;
    JButton mezclar, jugar, reiniciar;
    TaulaJoc mesa;
    
    public PanelInferior(TaulaJoc m){
        mesa = m;
        this.setLayout(new BorderLayout());
        
        // Panel botones (crea el del principio de la partida)
        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        mezclar = new JButton("Mezclar");
        mezclar.addActionListener(this);
        panelBotones.add(mezclar);
        
        jugar = new JButton("Jugar");
        jugar.addActionListener(this);
        jugar.setEnabled(false);
        panelBotones.add(jugar);
        
        reiniciar = new JButton("Reiniciar");
        reiniciar.addActionListener(this);
        reiniciar.setEnabled(false);
        panelBotones.add(reiniciar);
        add(panelBotones, BorderLayout.CENTER);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        switch(evento.getActionCommand()){
            case "Mezclar":
                jugar.setEnabled(true);
                reiniciar.setEnabled(true);
                mesa.mezclar();
        }
    }
}
