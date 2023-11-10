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
public class Cifratore_Messaggi {

    public static String cifra_Messaggio_Cesare(String mess, int key) {

        char[] vettoreChar0 = mess.toCharArray();
        int lunghezza = mess.length();
        char[] vettoreChar1 = new char[lunghezza];

        for (int i = 0; 1 < lunghezza; i++) {
            vettoreChar0[i] += key;
        }

        String messCifrato = String.valueOf(vettoreChar0);

        return messCifrato;
    }

    public static String decifra_Messaggio_Cesare(String mess, int key) {

        char[] vettoreChar0 = mess.toCharArray();
        int lunghezza = mess.length();
        char[] vettoreChar1 = new char[lunghezza];
        char spazio;

        for (int i = 0; 1 < lunghezza; i++) {
            vettoreChar0[i] -= key;
            spazio = vettoreChar0[i];
            if (spazio == '\u001d') //codice dello spazio
            {
                spazio = ' ';
            }

            vettoreChar0[i] = spazio;
        }

        String messDecifrato = String.valueOf(vettoreChar0);

        return messDecifrato;
    }

    public static String cifra_Messaggio_Vigenere(String mess, String key) {

        char vettoreChar[] = mess.toCharArray();
        char vettoreKeyChar[] = key.toCharArray();
        int j = 0;
        int vettoreInt[];
        int vettoreKeyInt[] = new int[vettoreChar.length];
        for (int i = 0; i < vettoreKeyChar.length; i++) {

            vettoreKeyInt[i] = vettoreKeyChar[i];

        }

        for (int i = 0; i < vettoreChar.length; i++) {
            vettoreChar[i] += vettoreKeyInt[j];
            j += 1;

            if (j == vettoreKeyChar.length) {
                j = 0;
            }

        }

        String messCifrato = String.valueOf(vettoreChar);
      
        return messCifrato;
    }

    public static String decifra_Messaggio_Vigenere(String mess, String key) {
        char space;
        char vettoreChar[] = mess.toCharArray();
        char vettoreKeyChar[] = key.toCharArray();
        int j = 0;
        int vettoreKeyInt[] = new int[vettoreChar.length];
        for (int i = 0; i < vettoreKeyChar.length; i++) {

            vettoreKeyInt[i] = vettoreKeyChar[i];

        }

        for (int i = 0; i < vettoreChar.length; i++) {
            vettoreChar[i] -= vettoreKeyInt[j];
            j += 1;
            space = vettoreChar[i];
            if (j == vettoreKeyChar.length) {
                j = 0;
            }
            if (space == '\u001d') {
                space = ' ';
            }

            vettoreChar[i] = space;
        }

        String messCifrato = String.valueOf(vettoreChar);
       return messCifrato;
    }
}