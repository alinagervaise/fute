/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;

/**
 *
 * @author Nono Guy
 */
public class Security {

    static String tab = "@+*-_.,:;!?& 0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static int rot = 32;
    static char[] tabc = tab.toCharArray();
    public Security() {
    }

    public static void init(String password) {
        
    }

    public static char encryptCaracter(char c, int rot) {
        int j = 0;
        char ct = ' ';
        if (tab.contains(c+"")) {
            while (j < tabc.length) {
                int n = (j + rot) % tabc.length;
                if (tabc[j] == c) {
                    ct = tabc[n];
                }
                j++;
            }
        }
        else{
            ct = c;
        }
        return ct;
    }
    public static char decryptCaracter(char c, int rot) {
        int j = 0;
        char ct = ' ';
//        rot-=2*rot;
        if (tab.contains(c+"")) {
            while (j < tabc.length) {
                int n = (j+tabc.length-rot) % tabc.length ;
                if (tabc[j] == c) {
                    ct = tabc[n];
                }
                j++;
            }
        }
        else{
            ct = c;
        }
        return ct;
    }

    public static String crypter(String text) {
        return crypter(text,  rot);
    }
    public static String decrypter(String text) {
        return decrypter(text,  rot);
    }
    public static String crypter(String text, int rot) {
        StringBuilder sb = new StringBuilder();
        char[] textToChar = text.toCharArray();
        char ce = ' ';
        int i = 0;
        while (i < textToChar.length) {
            ce = encryptCaracter(textToChar[i], rot);
            sb.append(ce);
            i++;
        }
        return sb + "";
    }
    public static String decrypter(String text, int rot) {
        StringBuilder sb = new StringBuilder();
        char[] textToChar = text.toCharArray();
        char ce = ' ';
        int i = 0;
        while (i < textToChar.length) {
            ce = decryptCaracter(textToChar[i], rot);
            sb.append(ce);
            i++;
        }
        return sb + "";
    }

    public static void main(String arg[]) {
//        String st = "bonjour comment allez vous?";
        String st = "+ZA89 bonjour VWX Gomez ééé";
        Security crp = new Security();
        
//        System.out.println("texte origine = " + st);
//        String texte_crypte = crp.crypter(st);
//        System.out.println("texte crypté = " + texte_crypte);
        String texte_crypte="QGNUPG";
        System.out.println("texte décrypté = " + crp.decrypter(texte_crypte));
    }
}