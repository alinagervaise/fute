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
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MacCrypto {

    public static String cle = "Celylog@Curam";
    static Logger logger = Logger.getLogger(MacCrypto.class.getName());

    public static String MAC(String message, String cle, String algorithme)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String resultat;
        SecretKey secretKey = new SecretKeySpec(cle.getBytes("UTF-8"), algorithme);
        System.out.println("cle : " + ConvertionHelper.bytesToHex(secretKey.getEncoded()));
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] b = message.getBytes("UTF-8");
        byte[] digest = mac.doFinal(b);
        resultat = ConvertionHelper.bytesToHex(digest);
        return resultat;

    }
    public static String MACSHA256(String message)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String resultat;
        SecretKey secretKey = new SecretKeySpec(cle.getBytes("UTF-8"), "HmacSHA256");
        System.out.println("cle : " + ConvertionHelper.bytesToHex(secretKey.getEncoded()));
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] b = message.getBytes("UTF-8");
        byte[] digest = mac.doFinal(b);
        resultat = ConvertionHelper.bytesToHex(digest);
        return resultat;

    }
    public static String MACSHA512(String message)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String resultat;
        SecretKey secretKey = new SecretKeySpec(cle.getBytes("UTF-8"), "HmacSHA512");
        System.out.println("cle : " + ConvertionHelper.bytesToHex(secretKey.getEncoded()));
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] b = message.getBytes("UTF-8");
        byte[] digest = mac.doFinal(b);
        resultat = ConvertionHelper.bytesToHex(digest);
        return resultat;
    }
    public static String MACMD5(String message)
            throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        String resultat;
        SecretKey secretKey = new SecretKeySpec(cle.getBytes("UTF-8"), "HmacMD5");
        System.out.println("cle : " + ConvertionHelper.bytesToHex(secretKey.getEncoded()));
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        byte[] b = message.getBytes("UTF-8");
        byte[] digest = mac.doFinal(b);
        resultat = ConvertionHelper.bytesToHex(digest);
        return resultat;

    }


    public static void main(String[] args) throws Exception {

        String texte = "";
        String key = "ngsgroup";
        String resultat = MAC(texte, key, "HmacSHA512");
        System.out.println("HmacSHA256 digest : " + resultat);
        resultat = MAC(texte, key, "HmacMD5");
        System.out.println("HmacMD5 digest : " + resultat);
        System.out.println("HmacMD5 digest : " + MACMD5(texte));
        System.out.println("HmacSHA256 digest : " + MACSHA256(texte));
        
    }

}
