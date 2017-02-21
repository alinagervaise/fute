/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils.security;

/**
 *
 * @author author Nono Guy
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MacFileCrypto {

    /**
     * Message authentication code
     */
    static Logger logger = Logger.getLogger(MacFileCrypto.class.getName());

    public static String MAC(String nomFichier, String cle, String algorithme)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, FileNotFoundException, IOException {
        String resultat;
        SecretKey secretKey = new SecretKeySpec(cle.getBytes("UTF-8"), algorithme);
        System.out.println("cle : " + ConvertionHelper.bytesToHex(secretKey.getEncoded()));
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] buffer = new byte[1024];
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(nomFichier));
        int nbLus = 0;

        try {
            while ((nbLus = in.read()) != -1) {
                mac.update(buffer, 0, nbLus);
            }
            byte[] digest = mac.doFinal();
            resultat = ConvertionHelper.bytesToHex(digest);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultat;

    }

    public static void main(String[] args) throws Exception {

        String password = "non gomez";
        String key = "maCle";

        String resultat = MAC(password, key, "HmacSHA256");
        System.out.println("HmacSHA256 digest : " + resultat);
        resultat = MAC(password, key, "HmacMD5");
        System.out.println("HmacMD5 digest : " + resultat);

    }

}
