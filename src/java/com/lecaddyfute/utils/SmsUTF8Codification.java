/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Nono Guy
 */
public class SmsUTF8Codification {

    public static String TexteMessageWriter(String message) throws IOException {

//        String fichier = "g:\\textotrad1.bin";
        String fichier = "textotrad.txt";
        FileWriter fw = new FileWriter(fichier, true);
        fw.write(message);
        fw.write("\n");
        fw.close();

        return null;
    }

    public static void TexteMessageWriter2(String message) throws IOException {

        final String chemin = "textotrad.bin";
        final File fichier = new File(chemin);
        try {
            // Creation du fichier
            fichier.createNewFile();
            // creation d'un writer (un écrivain)
            final FileWriter writer = new FileWriter(fichier);
            try {
                writer.write(message + "\n");

            } finally {
                // quoiqu'il arrive, on ferme le fichier
                writer.close();
            }
        } catch (Exception e) {
            System.out.println("Impossible de creer le fichier");
        }
    }

    public static String specialCaracterFormater(String message) {
         
        String newTextMessage;
        /*
         * 
         à = Ã 
         á = Ã¡ 
         â = Ã¢
         ä = Ã¤
         ç = Ã§
         Ç = Ã‡

         ï = Ã¯
         Ï = Ã
         î = Ã®
         Î = ÃŽ

         É = Ã‰
         é = Ã©
         è = Ã¨
         ê = Ãª
         * 
         */

        /*
         *
         * 
         * 
         à - Ã 
         â - Ã¢
         é - Ã©
         è - Ã¨
         ê - Ãª
         ë - Ã«
         î - Ã®
         ï - Ã¯
         ô - Ã´
         ö - Ã¶
         ù - Ã¹
         û - Ã»
         ü - Ã¼
         ç - Ã§
         œ - Å
         € - â¬
         */
        HashMap pcs1 = new HashMap();
        HashMap pcs2 = new HashMap();
	
	int i1=1;	int i2=1;	
        
        
	pcs1.put(i1++, "É");	pcs2.put(i2++, "Ãƒâ€°");	// Ï = Ã 
	pcs1.put(i1++, "È");	pcs2.put(i2++, "Ãƒâ€¹");	// Ï = Ã 
	pcs1.put(i1++, "§");	pcs2.put(i2++, "Â§");	// § - Â§
	pcs1.put(i1++, "¨");	pcs2.put(i2++, "Â¨");	// ¨ - Â¨
	pcs1.put(i1++, "ê");	pcs2.put(i2++, "Ãª");	// ê - Ãª
	pcs1.put(i1++, "è");	pcs2.put(i2++, "Ã¨");	// è = Ã¨
        pcs1.put(i1++, "é");	pcs2.put(i2++, "Ã©");	// é - Ã©
	pcs1.put(i1++, "ç");	pcs2.put(i2++, "Ã§");	// ç - Ã§
	pcs1.put(i1++, "Ç");	pcs2.put(i2++, "Ã‡");	// Ç = Ã‡
	pcs1.put(i1++, "ï");	pcs2.put(i2++, "Ã¯");	// ï = Ã¯
	pcs1.put(i1++, "î");	pcs2.put(i2++, "Ã®");	// î - Ã® 
	pcs1.put(i1++, "Î");	pcs2.put(i2++, "ÃŽ");	// Î = ÃŽ
	pcs1.put(i1++, "É");	pcs2.put(i2++, "Ã‰");	// É = Ã‰
	pcs1.put(i1++, "'");	pcs2.put(i2++, "â€™");	// É = Ã‰
        
	
	pcs1.put(i1++, "€");	pcs2.put(i2++, "â¬");	// € - â¬
	pcs1.put(i1++, "ā");	pcs2.put(i2++, "Ä?");	// ā = Ä? // au niveau du serveur, c'est ainsi qu'on reçoit ce caractère. 
	pcs1.put(i1++, "ā");	pcs2.put(i2++, "Ä");	// ā = Ä
        
	pcs1.put(i1++, "ô");	pcs2.put(i2++, "Ã´");	// ô - Ã´
	pcs1.put(i1++, "ö");	pcs2.put(i2++, "Ã¶");	// ö - Ã¶
        
	pcs1.put(i1++, "ó");	pcs2.put(i2++, "Ã³");	// 
	pcs1.put(i1++, "ò");	pcs2.put(i2++, "Ã²");	// 
	pcs1.put(i1++, "ì");	pcs2.put(i2++, "Ã¬");	// 
        pcs1.put(i1++, "ÿ");	pcs2.put(i2++, "Ã¿");	// 
        pcs1.put(i1++, "ñ");	pcs2.put(i2++, "Ã±");	// 
        pcs1.put(i1++, "¡");	pcs2.put(i2++, "Â¡");	// 
        
	pcs1.put(i1++, "ù");	pcs2.put(i2++, "Ã¹");	// ù - Ã¹
	pcs1.put(i1++, "û");	pcs2.put(i2++, "Ã»");	// û - Ã»
	pcs1.put(i1++, "ü");	pcs2.put(i2++, "Ã¼");	// ü - Ã¼
	pcs1.put(i1++, "œ");	pcs2.put(i2++, "Å");	// œ - Å
        
	
			
			
        // le cas de à doit etre traité en dernière position
	pcs1.put(i1++, "á");	pcs2.put(i2++, "Ã¡");	// á = Ã¡ 
	pcs1.put(i1++, "â");	pcs2.put(i2++, "Ã¢");	// â - Ã¢
	pcs1.put(i1++, "ä");	pcs2.put(i2++, "Ã¤");	// ä = Ã¤
	pcs1.put(i1++, "à");	pcs2.put(i2++, "Ã^");	// à = Ã 
	pcs1.put(i1++, "à");	pcs2.put(i2++, "Ã ");	// à = Ã  // ne pas changer le caractère qui est après le Ã pensent que c'est un espace
        
	pcs1.put(i1++, "Í");	pcs2.put(i2++, "Ã");	// Í = Ã 
	pcs1.put(i1++, "Ï");	pcs2.put(i2++, "Ã?");	// Ï = Ã 


        int nbcs = pcs1.size();// nombre de caractère spéciaux
//        String[] cs1 = new String[]{"Ã ",};
//        String[] cs2 = new String[]{"à",};
//        int n = message.length();
//        StringBuilder sb = new StringBuilder();
//        String[] st_message = new String[n];
        CharSequence cs1, cs2;
//        message = message.replace("  ", "%%");
        if(BasicFonctions.estVide(message)) message="";
        message = message.replace(" ", "^");
//        cs2 = (String) pcs2.get(11);
//        cs1 = (String) pcs1.get(11);
//        if (message.contains(cs2)) {
//            message = message.replace(cs2, cs1);
//        }
//        cs2 = (String) pcs2.get(23);
//        cs1 = (String) pcs1.get(23);
//        if (message.contains(cs2)) {
//            message = message.replace(cs2, cs1);
//        }

        String[] st_message1 = new String[nbcs];// on crée le tableau de chaine de caractère des caractères spéciaux
        for (int j = 1; j <= nbcs; j++) {
            cs2 = (String) pcs2.get(j);
            cs1 = (String) pcs1.get(j);
            if (message.contains(cs2)) {
                message = message.replace(cs2, cs1);
            }
        }
        message = message.replace("^", " ");


        return message;
    }
    
    public static String specialCaracterCleaner(String message) {
         
        String newTextMessage=message;
        
        HashMap pcs1 = new HashMap();
        HashMap pcs2 = new HashMap();
	
	int i1=1;	int i2=1;	
        try{
            
        
	pcs1.put(i1++, "ê");	pcs2.put(i2++, "e");	// ê - Ãª
	pcs1.put(i1++, "è");	pcs2.put(i2++, "e");	// è = Ã¨
        pcs1.put(i1++, "é");	pcs2.put(i2++, "e");	// é - Ã©
	pcs1.put(i1++, "ç");	pcs2.put(i2++, "c");	// ç - Ã§
	pcs1.put(i1++, "Ç");	pcs2.put(i2++, "C");	// Ç = Ã‡
	pcs1.put(i1++, "ï");	pcs2.put(i2++, "i");	// ï = Ã¯
	pcs1.put(i1++, "î");	pcs2.put(i2++, "i");	// î - Ã®
	pcs1.put(i1++, "Î");	pcs2.put(i2++, "I");	// Î = ÃŽ
	pcs1.put(i1++, "É");	pcs2.put(i2++, "E");	// É = Ã‰
	
	pcs1.put(i1++, "€");	pcs2.put(i2++, "e");	// € - â¬
	pcs1.put(i1++, "ā");	pcs2.put(i2++, "a");	// ā = Ä? // au niveau du serveur, c'est ainsi qu'on reçoit ce caractère. 
	pcs1.put(i1++, "ā");	pcs2.put(i2++, "a");	// ā = Ä
        
	pcs1.put(i1++, "ô");	pcs2.put(i2++, "o");	// ô - Ã´
	pcs1.put(i1++, "ö");	pcs2.put(i2++, "o");	// ö - Ã¶
	pcs1.put(i1++, "ù");	pcs2.put(i2++, "u");	// ù - Ã¹
	pcs1.put(i1++, "û");	pcs2.put(i2++, "u");	// û - Ã»
	pcs1.put(i1++, "ü");	pcs2.put(i2++, "u");	// ü - Ã¼
	pcs1.put(i1++, "œ");	pcs2.put(i2++, "oe");	// œ - Å
			
			
        // le cas de à doit etre traité en dernière position
	pcs1.put(i1++, "á");	pcs2.put(i2++, "a");	// á = Ã¡ 
	pcs1.put(i1++, "â");	pcs2.put(i2++, "a");	// â - Ã¢
	pcs1.put(i1++, "ä");	pcs2.put(i2++, "a");	// ä = Ã¤
	pcs1.put(i1++, "à");	pcs2.put(i2++, "a");	// à = Ã 
	pcs1.put(i1++, "à");	pcs2.put(i2++, "a");	// à = Ã  // ne pas changer le caractère qui est après le Ã pensent que c'est un espace
        
	pcs1.put(i1++, "Í");	pcs2.put(i2++, "I");	// Í = Ã 
	pcs1.put(i1++, "Ï");	pcs2.put(i2++, "I");	// Ï = Ã 
	pcs1.put(i1++, "Ï");	pcs2.put(i2++, "I");	// Ï = Ã 
	pcs1.put(i1++, "É");	pcs2.put(i2++, "E");	// E = E 
	pcs1.put(i1++, "È");	pcs2.put(i2++, "E");	// È = E


        int nbcs = pcs1.size();// nombre de caractère spéciaux
//        String[] cs1 = new String[]{"Ã ",};
//        String[] cs2 = new String[]{"à",};
//        int n = message.length();
//        StringBuilder sb = new StringBuilder();
//        String[] st_message = new String[n];
        CharSequence cs1, cs2;
//        message = message.replace("  ", "%%");
//        message = message.replace(" ", "^");
//        cs2 = (String) pcs2.get(11);
//        cs1 = (String) pcs1.get(11);
//        if (message.contains(cs2)) {
//            message = message.replace(cs2, cs1);
//        }
//        cs2 = (String) pcs2.get(23);
//        cs1 = (String) pcs1.get(23);
//        if (message.contains(cs2)) {
//            message = message.replace(cs2, cs1);
//        }

        String[] st_message1 = new String[nbcs];// on crée le tableau de chaine de caractère des caractères spéciaux
        for (int j = 1; j <= nbcs; j++) {
            cs2 = (String) pcs2.get(j);
            cs1 = (String) pcs1.get(j);
            if (message.contains(cs1)) {
                message = message.replace(cs1, cs2);
            }
            }
//        message = message.replace("^", " ");
            message = message.replace(" ", "+");
            message = message.replace("¥", "+");
            message = message.replace("&", "+");
            message = message.replace("(", "");
            message = message.replace(")", "");
            String auth_caracter2 = "[^ \\w&&[^ $@,'<>+.*_-]]";
            message = message.replaceAll(auth_caracter2, "");
        
        } catch (Exception e) {
            try {
                message = message.substring(0, 11);
            } catch (Exception ex) {
                return newTextMessage;
            }
        }
        
        try{
            message=message.substring(0,11);
        }catch(Exception ex){
            
        }
        return message;
    }
    
    
    public static String specialCaracterMessageCleaner(String message) {
         
        String newTextMessage=message;
        
        HashMap pcs1 = new HashMap();
        HashMap pcs2 = new HashMap();
	
	int i1=1;	int i2=1;	
        try{
            
        //à ä @ é, ö ù ü ñ
	pcs1.put(i1++, "ê");	pcs2.put(i2++, "e");	// ê - Ãª
	//pcs1.put(i1++, "è");	pcs2.put(i2++, "e");	// è = Ã¨
//        pcs1.put(i1++, "é");	pcs2.put(i2++, "e");	// é - Ã©
	pcs1.put(i1++, "ç");	pcs2.put(i2++, "c");	// ç - Ã§
	pcs1.put(i1++, "Ç");	pcs2.put(i2++, "C");	// Ç = Ã‡
	pcs1.put(i1++, "ï");	pcs2.put(i2++, "i");	// ï = Ã¯
	pcs1.put(i1++, "î");	pcs2.put(i2++, "i");	// î - Ã®
	pcs1.put(i1++, "Î");	pcs2.put(i2++, "I");	// Î = ÃŽ
	pcs1.put(i1++, "É");	pcs2.put(i2++, "E");	// É = Ã‰
	
	pcs1.put(i1++, "€");	pcs2.put(i2++, "e");	// € - â¬
	pcs1.put(i1++, "ā");	pcs2.put(i2++, "a");	// ā = Ä? // au niveau du serveur, c'est ainsi qu'on reçoit ce caractère. 
	pcs1.put(i1++, "ā");	pcs2.put(i2++, "a");	// ā = Ä
        
	pcs1.put(i1++, "ô");	pcs2.put(i2++, "o");	// ô - Ã´
	pcs1.put(i1++, "ó");	pcs2.put(i2++, "o");	// ó - Ã´ 
//	pcs1.put(i1++, "ö");	pcs2.put(i2++, "o");	// ö - Ã¶
//	pcs1.put(i1++, "ù");	pcs2.put(i2++, "u");	// ù - Ã¹
	pcs1.put(i1++, "û");	pcs2.put(i2++, "u");	// û - Ã»
//	pcs1.put(i1++, "ü");	pcs2.put(i2++, "u");	// ü - Ã¼
	pcs1.put(i1++, "œ");	pcs2.put(i2++, "oe");	// œ - Å
			
	//à ä @ é, ö ù ü ñ		
        // le cas de à doit etre traité en dernière position
	pcs1.put(i1++, "á");	pcs2.put(i2++, "a");	// á = Ã¡ 
	pcs1.put(i1++, "â");	pcs2.put(i2++, "a");	// â - Ã¢
//	pcs1.put(i1++, "ä");	pcs2.put(i2++, "a");	// ä = Ã¤
	//pcs1.put(i1++, "à");	pcs2.put(i2++, "a");	// à = Ã 
	//pcs1.put(i1++, "à");	pcs2.put(i2++, "a");	// à = Ã  // ne pas changer le caractère qui est après le Ã pensent que c'est un espace
        
	pcs1.put(i1++, "Í");	pcs2.put(i2++, "I");	// Í = Ã 
	pcs1.put(i1++, "Ï");	pcs2.put(i2++, "I");	// Ï = Ã 
	pcs1.put(i1++, "Ï");	pcs2.put(i2++, "I");	// Ï = Ã 

	pcs1.put(i1++, "É");	pcs2.put(i2++, "E");	// E = E 
	pcs1.put(i1++, "È");	pcs2.put(i2++, "E");	// È = E

        
        pcs1.put(i1++, "ó");	pcs2.put(i2++, "o");	// 
	pcs1.put(i1++, "ò");	pcs2.put(i2++, "o");	// 
	pcs1.put(i1++, "ì");	pcs2.put(i2++, "i");	// 
        pcs1.put(i1++, "ÿ");	pcs2.put(i2++, "y");	// 
//        pcs1.put(i1++, "ñ");	pcs2.put(i2++, "n");	// 
        pcs1.put(i1++, "¡");	pcs2.put(i2++, "i");	// 
        
        
        int nbcs = pcs1.size();// nombre de caractère spéciaux
//        String[] cs1 = new String[]{"Ã ",};
//        String[] cs2 = new String[]{"à",};
//        int n = message.length();
//        StringBuilder sb = new StringBuilder();
//        String[] st_message = new String[n];
        CharSequence cs1, cs2;
//        message = message.replace("  ", "%%");
//        message = message.replace(" ", "^");
//        cs2 = (String) pcs2.get(11);
//        cs1 = (String) pcs1.get(11);
//        if (message.contains(cs2)) {
//            message = message.replace(cs2, cs1);
//        }
//        cs2 = (String) pcs2.get(23);
//        cs1 = (String) pcs1.get(23);
//        if (message.contains(cs2)) {
//            message = message.replace(cs2, cs1);
//        }

        String[] st_message1 = new String[nbcs];// on crée le tableau de chaine de caractère des caractères spéciaux
        for (int j = 1; j <= nbcs; j++) {
            cs2 = (String) pcs2.get(j);
            cs1 = (String) pcs1.get(j);
            if (message.contains(cs1)) {
                message = message.replace(cs1, cs2);
            }
            }
        
        } catch (Exception e) {
            try {
                message = message.substring(0, 11);
            } catch (Exception ex) {
                return newTextMessage;
            }
        }
        
        return message;
    }

    
}
