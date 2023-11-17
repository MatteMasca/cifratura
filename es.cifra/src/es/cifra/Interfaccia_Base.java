/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.cifra;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
    private JButton button_esci;
    private ButtonGroup button_gruppo;
    private JComboBox elenco_messaggi;
    

    public Interfaccia_Base(Secret_Imbox chiamante) {

        super("Base");
        p = new JPanel();
        p.setLayout(null);
        Thread ascolta_Messaggio = new Thread();

        label_chiave = new JLabel("Chiave");
        label_chiave.setBounds(20, 50, 200, 50);

        chiave_cifra = new JTextField();
        chiave_cifra.setBounds(80, 50, 100, 50);

        radio_vigenere = new JRadioButton("Cesare");
        radio_vigenere.setBounds(30, 100, 100, 50);

        radio_cesare = new JRadioButton("Vigenere");
        radio_cesare.setBounds(150, 100, 100, 50);

        label_mess = new JLabel("Messaggio Cifrato");
        label_mess.setBounds(20, 150, 200, 50);

        messaggio = new JTextField();
        messaggio.setBounds(130, 150, 200, 40);

        button_decifra = new JButton("Invia");
        button_decifra.setBounds(30, 250, 140, 40);

        button_gruppo = new ButtonGroup();

        elenco_messaggi = new JComboBox();
        elenco_messaggi.setBounds(30, 300, 140, 40);
        
        button_esci = new JButton("Esci");
        button_esci.setBounds(20, 250, 250, 40);

        p.add(button_esci);
        p.add(label_chiave);
        p.add(chiave_cifra);
        p.add(messaggio);
        p.add(button_decifra);
        p.add(radio_vigenere);
        p.add(radio_cesare);
        p.add(label_mess);
        p.add(messaggio);
        p.add(elenco_messaggi);
        button_gruppo.add(radio_vigenere);
        button_gruppo.add(radio_cesare);
        p.setBackground(Color.gray);
        add(p);

        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int valIncremento, valDecremento;
        InetAddress ip = null;
        String indirizzoServer;
        
        //incremento contatore
        if (button_esci == e.getSource()) {
            dispose();
        }
      

    }

    private void ricevi_Messaggio() {

        String messaggio_Completo;
        String messaggio_Cifrato;

        messaggio_Completo = cod_agente.getText() + ": " + messaggio.getText();
        if (radio_cesare.isSelected()) {
            int intero = Integer.parseInt(chiave_cifra.getText());
            messaggio_Cifrato = Cifratore_Messaggi.cifra_Messaggio_Cesare(messaggio_Completo, intero);
        } else {
            messaggio_Cifrato = Cifratore_Messaggi.cifra_Messaggio_Vigenere(messaggio_Completo, chiave_cifra.getText());
        }
        try {

            PrintWriter outServer = new PrintWriter(chiamante.s.getOutputStream(), true);
            outServer.println(messaggio_Cifrato);

        } catch (Exception ex) {

        }
    }
   
}
