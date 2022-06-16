// Krishna Jorda Jimenez y Alberto Ruiz
// https://youtu.be/3XDviEPh_M8
package Practica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
// Este es el panel principal, que contiene los paneles de las cartas en la mesa, el de las cartas del jugador, y el del numero de cartas de los jugadores artificiales
public class PanelPrincipal extends JPanel implements MouseListener{
    JPanel panelSuperior, panelInferior;
    TaulaJoc mesa;
    PanelControl panelControl;
    
    int numCartasHumano = 0;
    int[] numCartasCPUs = {0, 0, 0};
    BarajaJugador[] barajas;
    
    JLabel indicadorCartasHumano;
    JLabel[] etiquetasNumCartasCPU;
    JPanel[] arrayCasillasJugador = new JPanel[13]; // Estos JPanels formaran las casillas donde se podran colocar las cartas del jugador
    ImageIcon dorsoCarta = new ImageIcon(new ImageIcon("imagenes/card_back_blue.png").getImage().getScaledInstance(60, 90, Image.SCALE_SMOOTH));
    
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
        
        for (int i = 0; i < 13; i++){ // Creamos los 13 JPanel de las casillas donde se meteran las cartas
            JPanel p = new JPanel();
            p.setPreferredSize(new Dimension(76,106));
            p.setBorder(BorderFactory.createLineBorder(new Color(00, 102,00),3));
            p.setBackground(new Color(00,i==0?82:102,00)); //#006600 / #00520
            arrayCasillasJugador[i] = p;
        }

        panelCartasHumano.setBackground(new Color(00,102,00));
        panelCartasHumano.addMouseListener(this);
        for (int i = 0; i < 13; i++){ // Añadimos las casillas al panel
            panelCartasHumano.add(arrayCasillasJugador[i]);
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
        
        /////////////// PANEL SUPERIOR - CARTAS JUGADORES CPU //////////////////
        panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER,150,0));
        panelSuperior.setBackground(new Color(00, 102,00));
        
        JPanel[] casillasNumCartasCPU = new JPanel [3];
        for (int i = 0; i < 3; i++){
            casillasNumCartasCPU[i] = new JPanel();
            casillasNumCartasCPU[i].setBackground(new Color(00,82,00));
            casillasNumCartasCPU[i].setPreferredSize(new Dimension(76,106));
            casillasNumCartasCPU[i].setBorder(BorderFactory.createLineBorder(new Color(00, 102,00),3));
            panelSuperior.add(casillasNumCartasCPU[i]);
        }
        
        etiquetasNumCartasCPU = new JLabel[3];
        for (int i = 0; i < 3; i++){
            etiquetasNumCartasCPU[i] = new JLabel("0");
            etiquetasNumCartasCPU[i].setFont(new Font("", Font.BOLD, 40));
            etiquetasNumCartasCPU[i].setForeground(Color.WHITE);
            etiquetasNumCartasCPU[i].setHorizontalAlignment(JLabel.CENTER);
            etiquetasNumCartasCPU[i].setPreferredSize(new Dimension(60,90));
            etiquetasNumCartasCPU[i].setHorizontalTextPosition(JLabel.CENTER);
            etiquetasNumCartasCPU[i].setVerticalTextPosition(JLabel.CENTER);
            //etiquetasNumCartasCPU[i].setOpaque(true);
            casillasNumCartasCPU[i].add(etiquetasNumCartasCPU[i]);
        }
        
        add(panelSuperior, BorderLayout.NORTH);
    }
    
    public void setPanelControl(PanelControl pan){
        panelControl = pan;
    }
    
    public void mezclar(){
        mesa.mezclar();
    }
    
    public void reiniciar(){
        mesa.reiniciar();
        for (int i = 0; i < 13; i++){
            arrayCasillasJugador[i].removeAll();
        
        }
        barajas = null;
        
        numCartasHumano = 0;
        actIndicadorHumano();
        
        for (int i = 0; i < 3; i++){
            numCartasCPUs[i] = 0;
            actIndicadorCPU(i);
        }
        
        revalidate();
        repaint();
    }
    
    public void repartir(){
        barajas = mesa.repartir();
        
        for (int i = 0; i < 13; i++){  // Añadir las cartas repartidas a las casillas de abajo
            arrayCasillasJugador[i].add(new JLabel(barajas[0].getCarta(i).getImagen()));
        }
        numCartasHumano = 13;
        actIndicadorHumano();
        
        for (int i = 0; i < 3; i++){
            numCartasCPUs[i] = 13;
            actIndicadorCPU(i);
        }
        
        revalidate();
        repaint();
    }
    
    public void actIndicadorHumano(){
        indicadorCartasHumano.setText(String.valueOf(numCartasHumano));
        revalidate();
        repaint();
    }
    
    public void actIndicadorCPU(int CPU){
        if (numCartasCPUs[CPU] > 0){
            etiquetasNumCartasCPU[CPU].setIcon(dorsoCarta);
        }
        
        etiquetasNumCartasCPU[CPU].setText(String.valueOf(numCartasCPUs[CPU]));
        
        revalidate();
        repaint();
    }
    
    public void jugarCPU(int CPU){
        boolean jugar = true;
        for (int i = 0; i < 13 && jugar; i++){
            if (barajas[CPU+1] != null && barajas[CPU+1].getCarta(i) != null){ // CPU+1 ya que la barajas 0 esta reservada para el jugador humano
                if (barajas[CPU+1].getCarta(i).esPosiblePoner(mesa)){
                    if (numCartasCPUs[CPU] == 1){
                        VentanaFinPartida v = new VentanaFinPartida(CPU+1);
                    }
                    mesa.ponerCarta(barajas[CPU+1].getCarta(i));
                    panelControl.setTexto("El jugador " + (CPU+1) + " pone el " + barajas[CPU+1].getCarta(i).toString());
                    barajas[CPU+1].borrarCarta(i);
                    
                    numCartasCPUs[CPU] = numCartasCPUs[CPU] - 1;
                    actIndicadorCPU(CPU); // Ya hace el revalidate y repaint
                    if (numCartasCPUs[CPU] == 0){
                        panelControl.finPartida();
                    }
                    jugar = false;
                }
            }
        }
        
        if (jugar == true){
            panelControl.setTexto("El jugador " + (CPU+1) + " pasa");
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e){
        int x = e.getX();
        if (panelControl.getEstado() == Estado.TURNOHUMANO && barajas != null && barajas[0] != null){ // Si es el turno del jugador humano y la carta que ha clickeado no es null
            int idxCarta = (x*13/this.getWidth());
            if (barajas[0].getCarta(idxCarta) != null && barajas[0].getCarta(idxCarta).esPosiblePoner(mesa)){
                if (numCartasHumano == 1){
                    VentanaFinPartida v = new VentanaFinPartida(0);
                }
                mesa.ponerCarta(barajas[0].getCarta(idxCarta));
                panelControl.setTexto("Has puesto el " + barajas[0].getCarta(idxCarta).toString());
                barajas[0].borrarCarta(idxCarta);
                arrayCasillasJugador[idxCarta].removeAll();
                
                numCartasHumano--;
                actIndicadorHumano();
                
                if (numCartasHumano == 0){
                    panelControl.finPartida();
                }else{
                    panelControl.turnoMaquina();
                }
            } else{
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e){
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e){
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
