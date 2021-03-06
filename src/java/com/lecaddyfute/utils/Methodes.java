/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;

import java.util.ArrayList;

/**
 *
 * @author M
 */
public class Methodes {
 
    public static int[] IndicesCharDansChaine(String ch, char c){
        if(ch==null){
            return null;
        } else if(!ch.contains(c+"")){
            return new int[0];
        } else {
           int nbre=0, j=0;
            for(int i=0; i<ch.length();i++){
                if (ch.charAt(i)==c) nbre++;
            }
            int[] index = new int [nbre];
            for(int i=0; i<ch.length();i++){
                if (ch.charAt(i)==c) {
                    index[j]=i;
                    j++;
                }
            }
            return index;
        }
    }
    
    
    
    public static String trimChar(String ch, char c){
        if(ch==null) return null;
        else if(ch.isEmpty()) return new String();
        else {
                int sizeo=ch.length()+1;
                while(ch.length()< sizeo && ch.length()>0){
                    sizeo=ch.length();
                    if(ch.charAt(0)==c){
                        ch = ch.substring(1);
                    }
                    if(ch.length()>0 && ch.charAt(ch.length()-1)==c){
                        ch = ch.substring(0, ch.length()-1);
                    }
                }
           return ch; 
        }
        
    }
    
    public static String[] splitChar(String ch, char c){
        String[] list = null, listnonVide = null;
        int nonVide = 0;
        if(ch==null)return list;
        else if(ch.isEmpty()) return new String[0]; 
        else{ 
           //ch = trimChar(ch, c);
           int[] index = IndicesCharDansChaine(ch, c);
           list = new String[index.length+1];
           if (index.length==0) {
               list= new String[]{ch};
               return list;
           }
           else {
            if(!ch.substring(0,index[0]).isEmpty()){
                list[0]=(ch.substring(0,index[0]));
                nonVide++;
            }
            for(int i=1; i<index.length;i++){
                if(!ch.substring(index[i-1]+1, index[i]).isEmpty()){
                    list[nonVide] = (ch.substring(index[i-1]+1, index[i]));
                    nonVide++;
                }
            } if(!ch.substring(index[index.length-1]+1).isEmpty()){
                list[nonVide] = (ch.substring(index[index.length-1]+1));
                nonVide++;
            }
            listnonVide = new String[nonVide];
            for(int i=0; i<listnonVide.length;i++){
                listnonVide[i]=list[i];
            }
           }
           return listnonVide;
        }
    }
    
    public static String replaceCharStr(String ch1, String ch2, char c){
        if(ch2.isEmpty()) return ch1;
        else if(ch1==null) return null;
        else {
            String[] list = splitChar(ch1, c);
            int[] index = IndicesCharDansChaine(ch1, c); 
            String newCh1 = "";
            for(int i=0;i<list.length;i++){
                newCh1 += list[i]+ch2;
                //if(i<list.length-1) newCh1 += ch2;
            }
        return newCh1;
        }
    }
    
    
    //change un tableau d'entier en sa representation en chaine de cararctère
    public static String getTabIntToString(int[] tab){
        String result = "";
        if(tab == null){
            return "null";
        } else if(tab.length==0) {
            return "||";
        }else {
            //result = "|";
            for(int i =0; i<tab.length;i++){
                //result = result+tab[i]+"|";
                result = result+"|"+tab[i]+"|";
            }
        }
        return result;
    }
    
    //change un tableau de string en sa representation en chaine de cararctère
    public static String getTabStringToString(String[] tab){
        String result = "";
        if(tab == null){
            result = "null";
        } else if(tab.length==0) {
            result = "||";
        }else {
            for(int i =0; i<tab.length;i++){
                if (tab[i]!="null")
                result = result+"|"+tab[i]+"|";
                else result = result+"*";
            }
        }
        return result;
    }
    
    
    public static void main(String[] args){
        //Methodes methode = new Methodes();
        //ArrayList<Personnel> listePersonnel = Personnel.getList("");
        //Personnel pers2 = new Personnel();
        
//        for(int i=0; i<listePersonnel.size();i++){
//            methode.comparePersonnel(pers2, listePersonnel.get(i));
//        }
    }
    
}
