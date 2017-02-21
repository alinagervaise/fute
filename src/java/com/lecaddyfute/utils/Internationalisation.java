package com.lecaddyfute.utils;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.beunderstood.utilis;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import utils.MyEntityManager;
//
///**
// *
// * @author Nono Guy
// */
//public class Internationalisation {
//
////    Utilisateur user = new Utilisateur();
//    Utilisateur user = MyEntityManager.getUtilisateur_courant();
//    String currentApplicationLang;
//    String dico_message_lang;
//    Statement instruction;
//    public void init_translation() throws SQLException{
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_patrimoine?", "root", "");
//        instruction = conn.createStatement();
//    }
//    
//    public String getCurrentApplicationLang() throws SQLException {
//        /*
//         cette methode permet de retourner la langue courante de l'application
//         */
//        
//        String query = "select * from parametre where code like \"currentApplicationLang\"";
//        ResultSet rs = instruction.executeQuery(query);
//        currentApplicationLang = rs.getString("valeur"); // on récupère la valeur correspondante à la langue courante du systeme
//        return currentApplicationLang != null ? currentApplicationLang : user.getLangue_par_defaut();
//
//    }
//
//    public String translate(String text) {
//
//        String userLang = user.getLangue_par_defaut();
//        if (!userLang.equals(currentApplicationLang)) {
//            return text;
//        } else {
//            //...
//            getTranslation(text, currentApplicationLang);
//            return ""; // pas terminé ...
//        }
//    }
//
//    public String getTranslation(String text, String lang) {
//        try {
//            lang = currentApplicationLang;
//            String query2 = "select * from dicomessagelang where code like "+text+" and code_langue like "+lang;
//            ResultSet rs = instruction.executeQuery(query2);
//            String text_translated = rs.getString("valeur"); // on récupère la valeur correspondante à la langue courante du systeme
//            return text_translated != null ? text_translated : text;
//        } catch (SQLException ex) {
//            Logger.getLogger(Internationalisation.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return ""; // pas terminé ...
//
//    }
//}
