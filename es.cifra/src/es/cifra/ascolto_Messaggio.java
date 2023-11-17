/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.cifra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author iMalo
 */
public class ascolto_Messaggio extends Thread {
    Secret_Imbox chiamante;
    Socket s;
    Interfaccia_Base interfaccia;
            
    public ascolto_Messaggio(Secret_Imbox chiamante, Interfaccia_Base interfaccia) {
        this.chiamante = chiamante;
        this.s = chiamante.s;
        this.interfaccia = interfaccia;
    }
    
    public void run(){
        System.out.println("entrato nella run");
         while (true) {
             System.out.println("entrato nel while");
            try {
                
                BufferedReader inClient = new BufferedReader(new InputStreamReader(interfaccia.s.getInputStream()));
                String msg = inClient.readLine();
                System.out.println(msg);
                chiamante.ricevuto_mess.addItem(msg);
                 System.out.println("aggiunto");
                
                
            }catch(Exception ex){
                System.out.println("entrato in errore");
                System.out.println(ex.getMessage());
                 System.out.println(ex.getStackTrace());
                 break;
            }
        
    }
    

}
}

