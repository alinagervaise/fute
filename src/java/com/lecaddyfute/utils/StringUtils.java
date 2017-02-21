/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;


public class StringUtils {
    
    
    public static String errormessage(String message){
       if (message.length()==0)  return  "";
      return  "<div class=\"alert alert-error\">"+message+"</div>";
      }
      
    public static void adderrormessage(HttpServletRequest request,Exception  e){
     request.setAttribute(GenericParamName.MESSAGE,errormessage(getStackTrace(e)));
       }
    
   public  static String successmessage(String message){
      if (message.length()==0)  return  "";
      return  "<div class=\"alert alert-success\">"+message+"</div>";
      }
   public static void addsuccessmessage(HttpServletRequest request,String message){
   request.setAttribute(GenericParamName.MESSAGE,successmessage(message));
   }
   public   static   String wrap(String st) {
        return '\'' + st + '\'';
    }
   
   
  public static  String wrap1(String st) {
        return '\"' + st + '\"';
    }
  public static  String wrap2(String st) {
        return "<div class=\"control-group\">" + st + "</div>";
    }
  
  public static String FileToString(File f) throws Exception
  {
      String result="";
      String line;
  BufferedReader  b=new BufferedReader(new FileReader(f));
   while((line=b.readLine())!=null){
       result+=line;
   
   }
   
   return   result;
  
  
  }
  
   ///
   public static String getStackTrace(Exception t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
  
  public  static <T> T valueOf(Class<T> klazz, String arg) {
       
        if (klazz.getSimpleName().equalsIgnoreCase("String")) return (T) arg;
        Exception cause = null;
        T ret = null;
        try {
            ret = klazz.cast(
                klazz.getDeclaredMethod("valueOf", String.class)
                .invoke(null, arg)
            );
            return ret;
        } catch (Exception e) {
            cause = e;
            return  null;
        } 
    }
  
//  public  static  synchronized String encrypt(String plaintext) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
//      MessageDigest md = null;
//  
//  
//      md = MessageDigest.getInstance("SHA");
//
//       md.update(plaintext.getBytes("UTF-8")); 
//
//    
//     byte raw[] = md.digest(); 
//    
//    String hash = (new BASE64Encoder()).encode(raw); 
//    
//    return hash;
//   
//   }
  
  
   public  static  void   main(String[]args) throws NoSuchAlgorithmException, UnsupportedEncodingException, Exception{
   
   
   
   
    String tetst=FileToString(new File("build.xml"));
   System.out.println(tetst);
   
   }
  
  
  }
