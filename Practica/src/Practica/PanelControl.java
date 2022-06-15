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
public class PanelControl extends JPanel implements ActionListener {
    JPanel panelBotones;
    JTextArea texto;
    JButton mezclar, jugar, reiniciar, passa, tornJugador;
    PanelPrincipal panelPrincipal;
    
    Estado estadoPartida = Estado.MENU;
    
    public PanelControl(PanelPrincipal p){
        panelPrincipal = p;
        panelPrincipal.setPanelControl(this);
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
                panelPrincipal.mezclar();
                break;
            case "Reiniciar":
                if (estadoPartida != Estado.MENU){
                    botonesIniciales();
                }
                jugar.setEnabled(false);
                reiniciar.setEnabled(false);
                mezclar.setEnabled(true);
                panelPrincipal.reiniciar();
                break;
            case "Jugar":
                turnoHumano();
                panelPrincipal.repartir();
                break;
            case "Passa":
                turnoMaquina();
                break;
            case "Torn Jugador":
                panelPrincipal.jugarCPU(estadoPartida.ordinal() - 2);
                switch(estadoPartida){
                    case TURNOCPU0:
                        estadoPartida = Estado.TURNOCPU1;
                        break;
                    case TURNOCPU1:
                        estadoPartida = Estado.TURNOCPU2;
                        break;
                    case TURNOCPU2:
                        estadoPartida = Estado.TURNOHUMANO;
                        turnoHumano();
                        break;
                }
        }
    }
    
    public void turnoHumano(){
        estadoPartida = Estado.TURNOHUMANO;
        panelBotones.removeAll();
        
        passa = new JButton("Passa");
        passa.addActionListener(this);
        panelBotones.add(passa);
        panelBotones.add(reiniciar);
        
        revalidate();
        repaint();
    }
    
    public void turnoMaquina(){
        estadoPartida = Estado.TURNOCPU0;
        panelBotones.removeAll();
        
        tornJugador = new JButton("Torn Jugador");
        tornJugador.addActionListener(this);
        panelBotones.add(tornJugador);
        panelBotones.add(reiniciar);
        
        revalidate();
        repaint();
    }
    
    public void botonesIniciales(){
        estadoPartida = Estado.MENU;
        panelBotones.removeAll();
        panelBotones.add(mezclar);
        panelBotones.add(jugar);
        panelBotones.add(reiniciar);
        
        revalidate();
        repaint();
    }
    
    public Estado getEstado(){
        return estadoPartida;
    }
}
