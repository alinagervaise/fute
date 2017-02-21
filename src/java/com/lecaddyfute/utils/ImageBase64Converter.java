package com.lecaddyfute.utils;

import java.io.IOException;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.nio.file.Files;
import javax.imageio.ImageIO;

public class ImageBase64Converter{

    /**
     * Decode string to image
     * @param imageString The string to decode
     * @return decoded image
     */
    public static BufferedImage decodeToImage(String imageString) {

        BufferedImage image = null;
        byte[] imageByte;
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }

    /**
     * Encode image to string
     * @param image The image to encode
     * @param type jpeg, bmp, ...
     * @return encoded string
     */
    public static String encodeToString(BufferedImage image, String type) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageString;
    }

    public static void main (String args[]) throws IOException {
        /* Test image to string and string to image start */
        BufferedImage img = ImageIO.read(new File(
                "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\Youtube_Logo-email.jpg"));
//        BufferedImage newImg;
        String imgstr;
        imgstr = encodeToString(img, "jpg");
//        System.out.println(imgstr);
         FileOutputStream imageOutFile = new FileOutputStream(
                "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\Youtube_Logo-email-base64code.txt");
         
        // new file
        String path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\shutterstock_139280537-email.jpg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpg");
        imageOutFile.write(imgstr.getBytes());
        String pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\shutterstock_139280537-email-base64code.txt";
        
        // new file
        path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\offizrenov-email.jpg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpg");
        imageOutFile.write(imgstr.getBytes());
        pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\offizrenov-email-base64code.txt";
        
        // new file
        path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\moquettes-email.jpg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpg");
        imageOutFile.write(imgstr.getBytes());
        pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\moquettes-email-base64code.txt";
        
        // new file
        path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\MOBILIER-email.jpg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpg");
        imageOutFile.write(imgstr.getBytes());
        pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\MOBILIER-email-base64code.txt";
        
        // new file
        path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\logo f-email.jpeg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpeg");
        imageOutFile.write(imgstr.getBytes());
        pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\logo f-email-base64code.txt";
        
        // new file
        path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\CARRELAGE 2-email.jpg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpg");
        imageOutFile.write(imgstr.getBytes());
        pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\CARRELAGE 2-email-base64code.txt";
        
         // new file
        path = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\2bf707_7b5f27a7e9954bc3a00b008ead6074c4-email.jpg";
        img = ImageIO.read(new File(path));
        imgstr = encodeToString(img, "jpg");
        imageOutFile.write(imgstr.getBytes());
        pathCode = "C:\\Users\\Z\\Desktop\\JULES_SIGNATURE\\2bf707_7b5f27a7e9954bc3a00b008ead6074c4-email-base64code.txt";
    }
}