/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author kjorda
 */
public class VentanaFinPartida extends JDialog implements ActionListener{
    public VentanaFinPartida(int jugadorGanador){
        JDialog partidaGanada = new JDialog();
        setModal(true);
        setResizable(false);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        // --- Panel central ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageIcon cara = new ImageIcon(new ImageIcon("imagenes/Jug" + jugadorGanador + "Riu.png").getImage().getScaledInstance(60, 90, Image.SCALE_SMOOTH));
        JLabel texto = new JLabel((jugadorGanador == 0) ? "Has ganado la partida" : "El jugador artificial " + jugadorGanador + " ha ganado la partida");
        panelCentral.add(new JLabel(cara));
        panelCentral.add(texto);
        c.add(panelCentral, BorderLayout.CENTER);
        
        // -- Panel inferior (boton aceptar) ---
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(this);
        panelInferior.add(aceptar);
        c.add(panelInferior, BorderLayout.SOUTH);
        
        
        pack();
        setLocationRelativeTo(getParent());
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand() == "Aceptar"){
            System.out.println("DIPOSEEEEE");
            dispose();
        }
    }
}
