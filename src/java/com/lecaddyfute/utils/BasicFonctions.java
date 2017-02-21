/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecaddyfute.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Nono Guy
 */
public class BasicFonctions{
    public static final String DATETIME_FORMAT = "MM/dd/yy HH:mm:ss";//2014-08-21 12:30:59
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_FORMAT2 = "yyyy-mm-dd";
    
    public static boolean estVide(String val){
        return ((val==null)||(val.equals(""))||(val.equalsIgnoreCase("null")));
    }
    
    // fonction de base concernant les fichiers
    
    public static boolean copieFichier(File source, File destination, Boolean deleteSource) {

        boolean resultat = false;

        if (!destination.exists()) {
            try {
                destination.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
// Declaration des flux
        FileInputStream sourceFile = null;
        FileOutputStream destinationFile = null;

        try {
// Création du fichier :
            destination.createNewFile();
// Ouverture des flux
            sourceFile = new FileInputStream(source);
            destinationFile = new FileOutputStream(destination);
// Lecture par segment de 0.5Mo
            byte buffer[] = new byte[512 * 1024];
            int nbLecture;
            while ((nbLecture = sourceFile.read(buffer)) != -1) {
                destinationFile.write(buffer, 0, nbLecture);
            }

// Copie réussie
            resultat = true;
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
// Quoi qu'il arrive, on ferme les flux
            try {
                sourceFile.close();
            } catch (Exception e) {
            }
            try {
                destinationFile.close();
            } catch (Exception e) {
            }
        }

        if (deleteSource) {
            source.delete();
        }
        return (resultat);

    }

    public static void ajouterElementFichier(String fichier, String element) throws Exception {

        if (!new File(fichier).exists()) {
            System.err.println("Le fichier " + fichier + " n'existe pas !");
            return;
        }

        FileOutputStream destinationFile = null;
        try {
            destinationFile = new FileOutputStream(fichier, true);
            destinationFile.write((element + "\n").getBytes());
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                destinationFile.close();
            } catch (Exception e) {
            }
        }
    }

    public static void supprimerLigneFichier(String fichier, String ligne) {

        try {

            File file = new File(fichier);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            String oldtext = "";

            while ((line = reader.readLine()) != null) {
                if (!line.equals(ligne)) {
                    oldtext += line + "\r\n";
                }
            }
            reader.close();

            FileWriter writer = new FileWriter(fichier);
            writer.write(oldtext);
            writer.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

//    public static Set listeElements(String fichier) {
//
//        Set<String> liste = new HashSet<>();
//        try {
//            File file = new File(fichier);
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            BufferedReader reader = new BufferedReader(new FileReader(file));
//            String line = "";
//
//            while ((line = reader.readLine()) != null) {
//                liste.add(line);
//            }
//            reader.close();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return liste;
//    }

    public static String LectureFichier(String fichier) throws IOException {

        BufferedReader reader = null;
        String oldtext = "";
        try {
            File file = new File(fichier);
            reader = new BufferedReader(new FileReader(file));
            String line = "";
//            System.out.println("Debut de lecture ");
            while ((line = reader.readLine()) != null) {
//                System.out.println("Ligne lue : " + line);
                oldtext += line + "\r\n";
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return oldtext;
    }

    public static void replace(String fichier, String source, String destination) {
        try {
            File file = new File(fichier);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            String oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            // replace a word in a file
//            System.out.println(Matcher.quoteReplacement(destination)+"\n\n\n"+oldtext);
//            String newtext = oldtext.replace(source, Matcher.quoteReplacement(destination));
            String newtext = oldtext.replace(source, destination);

            FileWriter writer = new FileWriter(fichier);
            writer.write(newtext);
            writer.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void ecritureFichier(String fichier, String texte) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fichier);
            fw.write(texte);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FileUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // date time fonctions
    
     public static Timestamp getCurrentTimeStamp() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        return date;
    }
    
    public static String getToday() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String day = date.toString().replace("-", "/").substring(0, 10);
        
        return day;
        
    }
    public static String getCurrentDay() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String day = date.toString().replace("-", "/").substring(0, 10);
        return day;
    }
    public static String getCurrentMonth() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String month = date.toString().substring(5, 7);
        return month;
    }
    public static String getCurrentDayId() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String month = date.toString().substring(8, 10);
        return month;
    }
    public static String getCurrentHourId() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String month = date.toString().substring(11, 13);
        return month;
    }
    public static String getCurrentYear() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
//        String year=date.getYear()+"";
        String year = date.toString().substring(0, 4);
        return year;
    }
    public static String getCurrentHour() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String Hour = date.toString().substring(11, 19);
        return Hour;
    }
    public static String  getTimestampsString(String d2) {
        DateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        java.util.Date date2 = new java.util.Date(d2);
        String d1=dateFormat.format(date2);
//        getDateDistance(d1, d2);
        return d1;
    }
    public static Timestamp  getTimestamps(String d2) {
        DateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        java.util.Date date2 = new java.util.Date(d2);
        String d1=dateFormat.format(date2);
        Timestamp tst= new Timestamp(date2.getTime());
        return tst;
    }
    public  static boolean isCameroonianNumber(String number) {
        boolean val=false;
        Pattern p1 = Pattern.compile("(\\d){8,12}");//77777777 ou 99999999
        Pattern p2 = Pattern.compile("^(237)([1234567890])");//+237
        Pattern p3 = Pattern.compile("^[(+237)]([1234567890])");//237
//        val = Pattern.compile("^[+237][1234567890]").matcher(number).find();
            boolean m1 = p1.matcher(number).find();
            boolean m2 = p2.matcher(number).find(); 
            boolean m3 = p3.matcher(number).find();
            if (m2) {
                val = true;
            }
        return val;
    }
    public boolean isOrange_Number(String sim_number) {
        boolean val = Pattern.compile("^[9][1234567890]").matcher(sim_number).find();
        return val;
    }

    public boolean isCamtel_Number(String sim_number) {
        return Pattern.compile("^[2][1234567890]").matcher(sim_number).find() || Pattern.compile("^[3][1234567890]").matcher(sim_number).find();
    }

    public boolean isMTN_Number(String sim_number) {
        boolean val = Pattern.compile("^[7][1234567890]").matcher(sim_number).find();
        return val;

    }
    /**
     * 
     * @param stringToAdd:Prefix  to repeat if Word is shorter than max 
     * @param max: The maximun length of result
     * @param word: the string to process
     * @return  a word of length max 
     */
    public static String tranformString(String stringToAdd, int max, String word){
        
        String result = "";
        int nb = max - word.length();
        if (nb > 0){
           String prefix = "";
           for (int i = 0; i < nb; i++){
              prefix += stringToAdd;
           }
           result = prefix + word;
        }else if (nb < 0){
            result = word.substring(-1 * nb);
        }
        else{
            result = word;
        }
        return result;
    }
    
    public static Date getDateFromString(String dateInString, String format) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = date = formatter.parse(dateInString);
        return date;
    }
    public void main(String arg[]){
        
        boolean val=BasicFonctions.isCameroonianNumber("23775396044");
    }
}
