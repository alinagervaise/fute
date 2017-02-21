/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nono
 */
public class ObjectUtils {

    public static Object getCode(Object o) {
        try {
            return o.getClass().getMethod("getCode", null).
                    invoke(o, null);
        } catch (Exception ex) {
            Logger.getLogger(ObjectUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static Object getFieldValue(Field f, Object o) {
        try {
            f.setAccessible(true);
            return f.get(o);
        } catch (Exception ex) {
            Logger.getLogger(ObjectUtils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void setFieldValue(Field f, Object o, Object value) {
        try {
            f.setAccessible(true);
            f.set(o, value);
        } catch (Exception ex) {
            Logger.getLogger(ObjectUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static Object getLibelle(Object o) {
//        Field flibelle = DefaultEntityModel.getfieldlibelle(o.getClass().getSimpleName());
//        return getFieldValue(flibelle, o);
//    }

    public static void main(String[] args) {
//        Aircon a = new Aircon();
//        a.setCode(Integer.SIZE);
//        //a.setLibelleEtiquette("Nono");
//        a.setMarque("mercedes");
//        setFieldValue(null, a, a);
//        System.out.println(a);

    }

}
