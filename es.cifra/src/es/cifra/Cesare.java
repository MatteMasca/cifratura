/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.cifra;
import java.util.Scanner;
/**
 *
 * @author matte
 */
public class Cesare {
    
    public static String cifraMessaggio(String mess, int key){

        char [] vettoreChar0 = mess.toCharArray();
        int lunghezza = mess.length();
        char [] vettoreChar1  = new char [lunghezza];

        for(int i=0; 1 < lunghezza; i++){
            vettoreChar0[i] += key;
        }
        
        String messCifrato = String.valueOf(vettoreChar0);
        
        return messCifrato;
    }
    
public static String decifraMessaggio(String mess, int key){

        char [] vettoreChar0 = mess.toCharArray();
        int lunghezza = mess.length();
        char [] vettoreChar1  = new char [lunghezza];
        char spazio;
        
        for(int i=0; 1 < lunghezza; i++){
            vettoreChar0[i] -= key;
            spazio = vettoreChar0[i];
            if(spazio=='\u001d') //codice dello spazio
                spazio = ' ';
            
            vettoreChar0[i] = spazio;
        }
        
        String messDecifrato = String.valueOf(vettoreChar0);
        
        return messDecifrato;
    }
    
    
}