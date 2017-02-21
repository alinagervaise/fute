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
import java.net.InetAddress;
import java.security.Key;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AESCrypto {

    static Logger logger = Logger.getLogger(AESCrypto.class.getName());
    private static final String ALGO = "AES";
    private static byte[] keyValue = new byte[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'N', 'G',
        'O', 'M', 'E', 'Z'};
    private static String CLE = "CURAM"; 

    public static String encrypt1(String Data) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();
        System.out.println("Generated key: " + key);
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes("UTF8"));

        String encryptedValue = ConvertionHelper.bytesToHex(encVal);
//        String encryptedValue = new String(Base64.encodeBase64(encVal));
        return encryptedValue;
    }

    public static String decrypt1(String encryptedData) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGO);
        keyGen.init(128);
        SecretKey key = keyGen.generateKey();
        Cipher c = Cipher.getInstance(ALGO);

        c.init(Cipher.DECRYPT_MODE, key);
//        byte[] decordedValue = Base64.decodeBase64(encryptedData.getBytes());
//        byte[] decValue = c.doFinal(decordedValue);
        byte[] decValue = c.doFinal(encryptedData.getBytes("UTF8"));
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new String(Base64.encodeBase64(encVal));
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.decodeBase64(encryptedData.getBytes());
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }

    public static Key generateKey() throws Exception {

        String cle = CLE;
        try {
            if (cle.isEmpty()) {
                InetAddress adrLocale;
                adrLocale = InetAddress.getLocalHost();
                cle = adrLocale.getHostName();
            }
            if (cle.length() > 16) {
                cle = cle.substring(0, 16);
            }
            if (cle.length() < 16) {
                int chartocomplete = 16 - cle.length();
                for (int i = 0; i < chartocomplete; i++) {
                    cle = cle + i;
                }
            }
            logger.log(Level.INFO, "cle par defaut {0}", cle);
            keyValue = cle.getBytes();
        } catch (Exception e) {
            e.printStackTrace();

        }
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
    
    public static void main(String[] args) throws Exception {

//        try {
//            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//            keyGen.init(128);
//            SecretKey secretKey = keyGen.generateKey();
//            Cipher aesCipher = Cipher.getInstance("AES");
//            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
//            byte[] byteCipherText = aesCipher.doFinal("nono".getBytes("UTF8"));
//            System.out.println(ConvertionHelper.bytesToHex(byteCipherText));
//
//            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, aesCipher.getParameters());
//            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
//            System.out.println(new String(byteDecryptedText));
//        } catch (Exception e) {
//            System.out.println("Erreur " + e);
//        }
        String password = "NONO";
        String passwordEnc = AESCrypto.encrypt(password);
        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        
        String passwordDec = AESCrypto.decrypt(passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
    }

}
