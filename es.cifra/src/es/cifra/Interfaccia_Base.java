/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.cifra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author matte
 */
public class Interfaccia_Base extends JFrame implements ActionListener {

    public static String a;
    public JPanel p;
    public ServerSocket ss;
    public Socket s;
    private Secret_Imbox chiamante;
    
    private JTextField cod_agente;
    private JTextField chiave_cifra;
    private JTextField messaggio;
    private JRadioButton radio_vigenere;
    private JRadioButton radio_cesare;
    private JButton button_decifra;
    private JLabel label_agente;
    private JLabel label_chiave;
    private JLabel label_mess;

    public Interfaccia_Base(Secret_Imbox chiamante) {

        super("Agente");
        p = new JPanel();
        p.setLayout(null);

        label_chiave = new JLabel("Chiave");
        label_chiave.setBounds(20, 50, 190, 40);
        
        radio_vigenere = new JRadioButton("Cesare");
        radio_vigenere.setBounds(30, 100, 90, 40);
        
        radio_cesare = new JRadioButton("Vigenere");
        radio_cesare.setBounds(150, 100, 90, 40);
        
        label_mess = new JLabel("Messaggio Cifrato");
        label_mess.setBounds(20, 150, 190, 40);
        
        messaggio = new JTextField();
        messaggio.setBounds(300, 150, 100, 40);
        
        
        button_decifra = new JButton("Invia");
        button_decifra.setBounds(30, 250, 140, 40);

        p.add(label_agente);
        p.add(label_chiave);
        p.add(label_mess);
        p.add(cod_agente);
        p.add(chiave_cifra);
        p.add(messaggio);
        p.add(button_decifra);
        p.add(radio_vigenere);
        p.add(radio_cesare);
       // p.add(button_invia);
        p.setBackground(Color.gray);
        add(p);

       // ospita.addActionListener(this);
       // collegati.addActionListener(this);
       // esci.addActionListener(this);

        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int valIncremento, valDecremento;
        InetAddress ip = null;
        String indirizzoServer;
/*
        //incremento contatore
        if (esci == e.getSource()) {
            dispose();
        }
        //decremento contatore
        if (collegati == e.getSource()) {

            uniscitiGame();

        }

        if (ospita == e.getSource()) {

            ospitaGame();

        }
*/

    }

}

