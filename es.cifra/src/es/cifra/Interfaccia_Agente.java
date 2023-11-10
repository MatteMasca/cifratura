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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author matte
 */
public class Interfaccia_Agente extends JFrame implements ActionListener {

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
    private JLabel label_agente;
    private JLabel label_chiave;
    private JLabel label_mess;
    private JButton button_invia;
    private JButton button_esci;
    private ButtonGroup button_gruppo;

    public Interfaccia_Agente(Secret_Imbox chiamante) {

        super("Agente");
        System.out.println("avviato utente");
        p = new JPanel();
        p.setLayout(null);

        label_agente = new JLabel("Agente");
        label_agente.setBounds(20, 50, 190, 40);

        label_chiave = new JLabel("Chiave");
        label_chiave.setBounds(20, 100, 190, 40);

        label_mess = new JLabel("Messaggio");
        label_mess.setBounds(20, 150, 190, 40);

        cod_agente = new JTextField();
        cod_agente.setBounds(100, 50, 100, 40);

        chiave_cifra = new JTextField();
        chiave_cifra.setBounds(100, 100, 100, 40);

        messaggio = new JTextField();
        messaggio.setBounds(100, 150, 100, 40);

        radio_cesare = new JRadioButton("Vigenere");
        radio_cesare.setBounds(150, 200, 90, 40);
        radio_cesare.setSelected(true);

        radio_vigenere = new JRadioButton("Cesare");
        radio_vigenere.setBounds(30, 200, 90, 40);

        button_esci = new JButton("Esci");
        button_esci.setBounds(30, 250, 100, 40);

        button_invia = new JButton("Invia");
        button_invia.setBounds(150, 250, 100, 40);

        button_gruppo = new ButtonGroup();

        p.add(label_agente);
        p.add(label_chiave);
        p.add(label_mess);
        p.add(cod_agente);
        p.add(chiave_cifra);
        p.add(messaggio);
        p.add(radio_vigenere);
        p.add(radio_cesare);
        p.add(button_invia);
        p.add(button_esci);
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
         System.out.println(e.getSource().toString());
        int valIncremento, valDecretmento;
        InetAddress ip = null;
        String indirizzoServer;

        //incremento contatore
        if (button_esci == e.getSource()) {
            dispose();
        }

        if (button_invia == e.getSource()) {
            invia_Messaggio();
        }

    }

    private void invia_Messaggio() {

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

        System.out.println(messaggio_Cifrato);
    }

}
