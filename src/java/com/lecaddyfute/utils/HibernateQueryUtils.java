/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Nono Guy
 */
public class HibernateQueryUtils {

    public static String req_field = "";
    public static String req_field_value = "";
    public static String req_field_update = "";
    public static String field_value_update_query_part_ = "";
    private static String select_fiel_value = "";

//    public static void buildInsertQuery(Map params) throws Exception {
//        Map preq = new HashMap();
////        String numero_repertoire = (String) params.get("numero_repertoire");
//        String req = "";
//        req_field = "";
//        req_field_value = "";
//
//        Set<String> set = params.keySet();
//        java.util.Iterator<String> _enum = set.iterator();
//
//        //_enum.next();
//        while (_enum.hasNext()) {
//            String nextElement = _enum.next();
//            if (nextElement.equalsIgnoreCase("entity")) {
//                continue;
//            }
////            Logger.global.info(nextElement + "=" + params.get(nextElement));
////            if (params.get(nextElement) != null && !params.get(nextElement).equals("")) {
//            if (params.get(nextElement) != null) {
//                req_field += nextElement + ",";
//                req_field_value += params.get(nextElement).toString().replace("'", "''") + "','";
////                Logger.global.info(nextElement + "=" + params.get(nextElement));
//            }
//
//        }
//    }
//
//    public static void buildUpdateQuery(Map params) throws Exception {
//        Map preq = new HashMap();
////        String numero_repertoire = (String) params.get("numero_repertoire");
//        String req = "";
//        field_value_update_query_part_ = "";
//        Set<String> set = params.keySet();
//        java.util.Iterator<String> _enum = set.iterator();
//
//        //_enum.next();
//        while (_enum.hasNext()) {
//            String nextElement = _enum.next();
//            if (nextElement.equalsIgnoreCase("entity")) {
//                continue;
//            }
//            if (params.get(nextElement) != null) {
//                field_value_update_query_part_ += nextElement + " = '" + params.get(nextElement).toString().replace("'", "''") + "',";
////                Logger.global.info(nextElement + "=" + params.get(nextElement).toString().replace("'", "''"));
//            }
//
//        }
//    }
//
//    public static String buildUpdateQuery(String entity, String[] fields_to_set, String[] values_to_set) throws Exception {
//        Map preq = new HashMap();
////        String numero_repertoire = (String) params.get("numero_repertoire");
//        String req = "";
//        field_value_update_query_part_ = "";
//        String dynamiqueQuery = "update " + entity + " set " + field_value_update_query_part_ + " where 1=1 ";
//
//        for (int i = 0; i < fields_to_set.length; i++) {
//            field_value_update_query_part_ += " and e." + fields_to_set[i] + " = '" + values_to_set[i].toString().replace("'", "''") + "',";
//        }
//        return field_value_update_query_part_;
//    }
//
//    public static String buildSelectQuery(Map params) throws Exception {
//        Map preq = new HashMap();
////        String numero_repertoire = (String) params.get("numero_repertoire");
//        String req = "";
//        select_fiel_value = "";
//        Set<String> set = params.keySet();
//        java.util.Iterator<String> _enum = set.iterator();
//        //_enum.next();
//        while (_enum.hasNext()) {
//            String nextElement = _enum.next();
//            if (nextElement.equalsIgnoreCase("entity")) {
//                continue;
//            }
//            if (params.get(nextElement) != null) {
//                select_fiel_value += "e." + nextElement + " like '" + params.get(nextElement).toString().replace("'", "''") + "' and ";
////                Logger.global.info(nextElement + "=" + params.get(nextElement).toString().replace("'", "''"));
//            }
//
//        }
//        return select_fiel_value;
//    }
    public static String buildSelectQuery(String fields[], String operators[], String values[], boolean alloEmptyString) throws Exception {
        select_fiel_value = "";
        for (int i = 0; i < fields.length - 1; i++) {
            if (alloEmptyString) {
                select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
            } else {
                if (!BasicFonctions.estVide(values[i])) {
                    select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                }
            }
        }
        select_fiel_value += "e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
        return select_fiel_value;
    }

    public static String buildSelectQuery(String entity, String fields[], String operators[], String values[], boolean allowEmptyString) throws Exception {
        select_fiel_value = " 1=1";
        select_fiel_value = "select e from " + entity + " e where " + select_fiel_value;
        if (fields.length > 0) {

            for (int i = 0; i < fields.length - 1; i++) {
                if (allowEmptyString) {
                    select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                } else {
                    if (!BasicFonctions.estVide(values[i])) {
                        select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                    }
                }
            }
            if (allowEmptyString) {
                select_fiel_value += " and e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
            } else {
                if (!BasicFonctions.estVide(values[fields.length - 1])) {
                    select_fiel_value += " and e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
                }
            }
        }
        return select_fiel_value;
    }

    public static String buildSelectDistinctQuery(String entity, String distintValues[], String fields[], String operators[], String values[], String order[], boolean allowEmptyString) throws Exception {
        select_fiel_value = " 1=1";
        select_fiel_value = " from " + entity + " e where " + select_fiel_value;
        if (fields.length > 0) {

            for (int i = 0; i < fields.length - 1; i++) {
                if (allowEmptyString) {
                    select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                } else {
                    if (!BasicFonctions.estVide(values[i])) {
                        select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                    }
                }
            }
            if (allowEmptyString) {
                select_fiel_value += " and e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
            } else {
                if (!BasicFonctions.estVide(values[fields.length - 1])) {
                    select_fiel_value += " and e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
                }
            }
        }
        String distintValues__ = "";
        if (distintValues.length > 0) {
            distintValues__ = " distinct " + distintValues[0];
            for (int i = 1; i < distintValues.length; i++) {
                distintValues__ += ", e." + distintValues[i];
            }
        }
        
        select_fiel_value += " order by e." + order[0];
        for (int i = 1; i < order.length - 1; i++) {
            select_fiel_value += ", e." + order[i];
        }
        
        return select_fiel_value = "select " + distintValues__ + select_fiel_value;
    }

    public static String buildSelectQuery(String entity, String fields[], String operators[], String values[], String order[], boolean allowEmptyString) throws Exception {
        select_fiel_value = " 1=1";
        select_fiel_value = "select e from " + entity + " e where " + select_fiel_value;
        if (fields.length > 0) {
            for (int i = 0; i < fields.length - 1; i++) {
                if (allowEmptyString) {
                    select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                } else {
                    if (!BasicFonctions.estVide(values[i])) {
                        select_fiel_value += " and e." + fields[i] + " " + operators[i] + " '" + values[i].replace("'", "''") + "'";
                    }
                }
            }
            if (allowEmptyString) {
                select_fiel_value += " and e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
            } else {
                if (!BasicFonctions.estVide(values[fields.length - 1])) {
                    select_fiel_value += " and e." + fields[fields.length - 1] + " " + operators[fields.length - 1] + " '" + values[fields.length - 1].replace("'", "''") + "'";
                }
            }
            select_fiel_value += " order by e." + order[0];
            for (int i = 1; i < order.length - 1; i++) {
                select_fiel_value += ", e." + order[i];
            }
        }
        return select_fiel_value;
    }

}
