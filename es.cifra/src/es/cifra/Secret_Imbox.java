/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.cifra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matte
 */
public class Secret_Imbox extends JFrame implements ActionListener {

    public static String a;
    public JPanel p;
    public ServerSocket ss;
    public Socket s;
    JButton ospita, collegati, esci;
    ButtonGroup gruppoBottoni;

    JTextField indirizzo_Mio;
    JTextField indirizzo_Destinatario;

    public Secret_Imbox() {

        super("Secret Imbox");
        p = new JPanel();
        p.setLayout(null);

        ospita = new JButton("Sono La Base");
        ospita.setBounds(20, 50, 150, 40);

        indirizzo_Mio = new JTextField();
        indirizzo_Mio.setBounds(250, 50, 190, 40);
        indirizzo_Mio.setText(getMyIp());

        indirizzo_Destinatario = new JTextField();
        indirizzo_Destinatario.setBounds(250, 150, 190, 40);
        indirizzo_Destinatario.setText(getMyIp());

        collegati = new JButton("Sono L' Agente");
        collegati.setBounds(20, 150, 150, 40);

        esci = new JButton("Esci");
        esci.setBounds(20, 250, 100, 40);

        gruppoBottoni = new ButtonGroup();

        p.add(ospita);
        p.add(collegati);
        p.add(esci);
        p.add(indirizzo_Destinatario);
        p.add(indirizzo_Mio);
        p.setBackground(Color.gray);
        add(p);

        ospita.addActionListener(this);
        collegati.addActionListener(this);
        esci.addActionListener(this);

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

    }

    private String getMyIp() {
        String risultato = "";
        try {
            risultato = InetAddress.getLocalHost().getHostAddress();

        } catch (Exception ex) {

        }
        return risultato;
    }

    public void ospitaGame() {
        try {

            ss = new ServerSocket(50000);
            ss.setSoTimeout(30000);
            s = ss.accept();
            Interfaccia_Base base = new Interfaccia_Base(this);

        } catch (SocketTimeoutException toe) {
            JOptionPane.showMessageDialog(null, "Non si è connesso nessuno");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void uniscitiGame() {

        try {
            s = new Socket(indirizzo_Destinatario.getText(), 50000);
            PrintWriter outServer = new PrintWriter(s.getOutputStream(), true);
            String clienMsg = "Ok:" + indirizzo_Mio.getText();
            outServer.println(clienMsg);

            Interfaccia_Agente agente = new Interfaccia_Agente(this);

        } catch (Exception ex) {

        }

    }

    private void inviaParolaDaIndovinare(String parola) {
        try {
            PrintWriter outServer = new PrintWriter(s.getOutputStream(), true);
            String msg = "ParolaDaIndovinare:" + parola;
            outServer.println(msg);
        } catch (Exception e) {
        }
    }

    private String riceviParolaDaIndovinare() {
        String parolaDaIndovinare = "";
        int i = 0;

        try {
            BufferedReader inClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = "";

            while ((msg == "") && (i < 50)) {   //Finche non ricevo il messaggio o sono passati 50 cicli ovvero 5 secondi
                msg = inClient.readLine();
                Thread.sleep(100);              //Attesa di un decimo di secondo tra un ciclo e l'altro
                i++;
            }
            if (msg.startsWith("ParolaDaIndovinare:")) {
                parolaDaIndovinare = msg.substring(19);
            }
        } catch (Exception e) {
        }
        return parolaDaIndovinare;
    }
}
