// Krishna Jorda Jimenez y Alberto Ruiz
// https://youtu.be/3XDviEPh_M8
package Practica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
        
        // --- Panel botones (crea el del principio de la partida) ---
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
        
        // --- Area texto informativo ---
        texto = new JTextArea("Antes de jugar hay que mezclar la baraja");
        //texto.setFont(new Font("", Font.PLAIN, 15));
        texto.setEditable(false);
        add(texto, BorderLayout.SOUTH);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento){
        switch(evento.getActionCommand()){
            case "Mezclar":
                jugar.setEnabled(true);
                reiniciar.setEnabled(true);
                texto.setText("La baraja esta mezclada");
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
                texto.setText("Antes de jugar hay que mezclar la baraja");
                break;
            case "Jugar":
                turnoHumano();
                texto.setText("Las cartas esta repartidas. Te toca. Empieza con un 7 si lo tienes");
                panelPrincipal.repartir();
                break;
            case "Pasar turno":
                turnoMaquina();
                texto.setText("Has pasado tu turno");
                break;
            case "Turno Jugador":
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
        
        passa = new JButton("Pasar turno");
        passa.addActionListener(this);
        panelBotones.add(passa);
        panelBotones.add(reiniciar);
        
        revalidate();
        repaint();
    }
    
    public void turnoMaquina(){
        estadoPartida = Estado.TURNOCPU0;
        panelBotones.removeAll();
        
        tornJugador = new JButton("Turno Jugador");
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
    
    public void setTexto(String s){
        texto.setText(s);
    }
    
    public void finPartida(){
        passa.setEnabled(false);
        tornJugador.setEnabled(false);
    }
}
