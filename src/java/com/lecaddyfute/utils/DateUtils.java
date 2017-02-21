package com.lecaddyfute.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple date formatting utility class
 *
 * @author Emre Simtay <emre@simtay.com>
 */
public class DateUtils {

//    public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss"; 
    public static final String DATETIME_FORMAT = "yyy/MM/dd HH:mm:ss";//2014-08-21 12:30:59
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDateTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static void main(String[] args) {

        System.out.println(getCurrentTime());
        System.out.println(getCurrentDateTime());
        System.out.println(getCurrentDate());

    }
}
