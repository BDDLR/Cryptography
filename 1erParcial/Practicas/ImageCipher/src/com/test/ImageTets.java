package com.test;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageTets {

    public static void main(String[] args) throws IOException {
        File originalFile = new File("input.bmp");

        BufferedImage img = null;

        try {
            img = ImageIO.read(originalFile);
            BufferedImage gray = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int i = 0; i < img.getWidth(); i++) {
                for (int j = 0; j < img.getHeight(); j++) {
                    Color c = new Color(img.getRGB(i, j));
                    int r = c.getRed();
                    int g = c.getGreen();
                    int b = c.getBlue();
                    int a = c.getAlpha();

                    int gr = (r + g + b) / 3;

                    Color gColor = new Color(gr, gr, gr, a);

                    gray.setRGB(i, j, gColor.getRGB());
                }
            }
            boolean write = ImageIO.write(gray, "bmp", new File("out.bmp"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
