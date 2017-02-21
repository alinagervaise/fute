/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;

import java.sql.Timestamp;

/**
 *
 * @author Nono Guy
 */
public class DateTimeFonctions {

    public static Timestamp getCurrentTimeStamp() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        return date;
    }
    
    public static String getCurrentDay() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String day = date.toString().replace("-", "/").substring(0, 10);
        
        return day;
    }
    public static String  getDay(Timestamp date) {
//        long maintenant = System.currentTimeMillis();
//        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String day = date.toString().replace("-", "/").substring(0, 10);
        
        return day;
    }
    String getCurrentHour() {
        long maintenant = System.currentTimeMillis();
        Timestamp date = new Timestamp(maintenant);
        //2014-02-16 22:17:15
        String Hour = date.toString().substring(11, 19);
        return Hour;
    }
    /**
     * Use to get Matricule Curam
     * @param date
     * @return the year as string of 3 characters
     */
    public static String  getYearMatricule(Timestamp date) {
        //2014-02-16 22:17:15
        return getDay(date).substring(1, 4);
    }
    /**
     * Use to get Matricule Curam
     * @param date
     * @return the month as string of 1 character from 1-9 to A-F
     */
    public static String  getMonthMatricule(Timestamp date) {
        //2014-02-16 22:17:15
        int month = Integer.parseInt(getDay(date).substring(5, 7));
        String result = Integer.toHexString(month).toUpperCase();
        return result;
    }
    /**
     *  Use to get Matricule Curam
     * @param date
     * @return the day as string of 2 characters
     */
    public static String  getDayMatricule(Timestamp date) {
        //2014-02-16 22:17:15
        String day = getDay(date);
        int dayInt = Integer.parseInt(day.substring(8, 10));
        if (dayInt < 16){
            return Integer.toHexString(dayInt).toUpperCase();
        }
        switch(dayInt){
            case 16: return "G";
            case 17: return "H";
            case 18: return "I";
            case 19: return "J";
            case 20: return "K";
            case 21: return "L";
            case 22: return "M";
            case 23: return "N";
            case 24: return "O";
            case 25: return "P";
            case 26: return "Q";
            case 27: return "R";
            case 28: return "S";
            case 29: return "T";
            case 30: return "U";
            case 31: return "V";
        }
        return String.valueOf(dayInt);
    }
    public static void main(String arg[]){
        DateTimeFonctions dtf=new DateTimeFonctions();
        String jour = dtf.getCurrentDay();
        String heur = dtf.getCurrentHour();
    }
}
