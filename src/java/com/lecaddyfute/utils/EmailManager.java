/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.utils;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.security.AccessController.getContext;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;




/**
 *
 * @author Z
 */
public class EmailManager {
    private String AUTH_USER_NAME = "gervaisita@gmail.com";  
    private String SENDER_NAME = "lecaddyfute.com"; 
    private String AUTH_PWD  = "roT47jM#";     
    private String SMTP_HOST = "smtp.gmail.com";     
    private String SMTP_PORT = "587";
    
     public void sendHtmlEmail(String toAddress,
            String subject, String message, Map<String, String> images) throws AddressException,
            MessagingException {
         this.sendHtmlEmail(SMTP_HOST, SMTP_PORT, AUTH_USER_NAME,  AUTH_PWD , 
                            toAddress, subject, message, images);
    }

     public String parseMessageEmail(String message){
        String result = "";
        ClassLoader classLoader = this.getClass().getClassLoader();
        String fullPath = String.join(File.separator, "",
                                        "..","resources","jsp", "emailConfirmations", message);   
        try{
            
        result = new String(Files.readAllBytes(Paths.get(classLoader.getResource(fullPath).toURI())));
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result; 
     }
     
     public String getImagesPath(String path){
        ClassLoader classLoader = this.getClass().getClassLoader();
        String fullPath= String.join(File.separator, "", "..","resources","images", path);   
        return  classLoader.getResource(fullPath).getPath();
     }
     
      public String parseMessageEmail1(String message){
        String result = "";
        String relativePath = String.join(File.separator, "","web",
                                        "WEB-INF","resources",
                "jsp", "emailConfirmations", message); 
        try{
            result = new String(Files.readAllBytes(Paths.get(new File(".").getAbsolutePath()+  relativePath)));
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return result; 
     }
     
    public void sendHtmlEmail(String host, String port,
            final String username, 
            final String password, String toAddress,
            String subject, String message, Map<String, String> images) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.user", username);
        properties.setProperty("mail.smtp.password", password);
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(username));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // Prepare images
        Multipart multipart = new MimeMultipart("related");
        
        BodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(message, "text/html");
        multipart.addBodyPart(htmlPart);
        
        
        BodyPart imgPart = new MimeBodyPart();
        // Loading the image
        for ( Entry<String, String> e: images.entrySet()){
            DataSource ds = new FileDataSource(e.getValue());
            imgPart.setDataHandler(new DataHandler(ds));
             //Setting the header
            imgPart.setHeader("Content-ID", e.getKey());

            multipart.addBodyPart(imgPart);
        }
       
        // attaching the multi-part to the message
        msg.setContent(multipart);
        // set plain text message
        //msg.setContent(message, "text/html");
 
        // sends the e-mail
        Transport.send(msg);
        
 
    }
 
    /**
     * Test the send html e-mail method
     *
     */
    public static void main(String[] args) {
        // SMTP server information
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "gervaisita@gmail.com";
      
        String password = "roT47jM#";
 
        // outgoing message information
        String mailTo = "gervyh@hotmail.com";
        String subject = "Hello my friend";
         
        Map <String, String> images = new <String, String> HashMap();
        String relativePath = String.join(File.separator, "","web",
                           "WEB-INF","resources", "images", "facebook-logo.png"); 
        
        
        String path = new File(".").getAbsolutePath()+  relativePath;
        
        images.put("FACEBOOK_LOGO", path);
        // message contains HTML markups
        try{
       
            EmailManager mailer = new EmailManager();
            String message = mailer.parseMessageEmail1("newUserConfirmation.html");
            mailer.sendHtmlEmail(host, port, mailFrom, password, mailTo,
                    subject, message, images);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
    }    
}