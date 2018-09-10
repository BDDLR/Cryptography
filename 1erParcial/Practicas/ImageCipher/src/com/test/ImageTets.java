
package com.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTets {
    public static void main(String[] args) throws IOException {
        File bmpFile = new File("input.bmp");
        BufferedImage image = ImageIO.read(bmpFile);
        
        if(bmpFile == null)
            System.out.println("balio");
        else{
            System.out.println(image);
            
        }
        
    }
}
