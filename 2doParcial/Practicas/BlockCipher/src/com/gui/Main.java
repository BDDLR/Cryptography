package com.gui;

import com.filemanager.FileManager;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class Main extends javax.swing.JFrame {

    private static Cipher enc;
    private static Cipher dec;
    //InitializationVector DES
    private static final byte[] initialVectorDES = {10, 20, 30, 40, 50, 60, 70, 80};
    //InitializationVector AES
    private static final byte[] initialVectorAES = {10, 20, 30, 40, 50, 60, 70, 80, 10, 20, 30, 40, 50, 60, 70, 80};
    //Header size of a bmp file
    private static final int headerBMP = 54;

    private AlgorithmParameterSpec algorithmParameterSpec;
    private AlgorithmParameterSpec algorithmParameterSpecAES;
    private String fileInput;
    private String fileOutput;

    public Main() throws NoSuchAlgorithmException {
        initComponents();

        setTitle("DES/AES");
        //Initialization of vectors
        algorithmParameterSpec = new IvParameterSpec(initialVectorDES);
        algorithmParameterSpecAES = new IvParameterSpec(initialVectorAES);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        outFile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        originalFile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        originalLabel = new javax.swing.JLabel();
        outLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("OCR A Extended", 1, 18)); // NOI18N
        jLabel1.setText("Image cipher using DES or AES and modes of operation");

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel5.setText("* Output Image:");

        outFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outFileActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel2.setText("* Input Image:");

        originalFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originalFileActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel3.setText("* Mode of operation:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ECB", "CBC", "CFB", "OFB" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Encrypt", "Decrypt" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        jLabel4.setText("* Action:");

        jButton1.setText("DES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("AES");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        originalLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        outLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton3.setText("Browse");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Clear All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Input image");

        jLabel7.setText("Output image");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(outFile, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(originalFile, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel4))
                                            .addGap(32, 32, 32)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(originalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(outLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jLabel7)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(originalFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(outFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(originalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void originalFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originalFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_originalFileActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed
    private boolean doValidations() {
        return !(originalFile.getText().isEmpty() || outFile.getText().isEmpty());
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (doValidations()) {
            String keyDES = "";
            int a = 0;

            while (a != 8) {
                keyDES = JOptionPane.showInputDialog(null, "Enter an 8 characters key");
                a = keyDES.length();
            }

            SecretKeySpec skeySpec = new SecretKeySpec(keyDES.getBytes(), "DES");
            fileOutput = outFile.getText();
            if (!fileOutput.contains(".bmp")) {
                fileOutput += ".bmp";
            }
            int chooseMetod = jComboBox1.getSelectedIndex();
            int chooseAlgorithm = jComboBox2.getSelectedIndex();
            try {
                switch (chooseMetod) {
                    case 0:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("DES/ECB/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("DES/ECB/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec);
                                descifrar(dec);
                            }
                        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException
                                | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                        }
                        break;
                    case 1:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("DES/CBC/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec, algorithmParameterSpec);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("DES/CBC/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec, algorithmParameterSpec);
                                descifrar(dec);
                            }
                        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException
                                | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                                | NoSuchPaddingException e) {
                        }
                        break;
                    case 2:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("DES/CFB/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec, algorithmParameterSpec);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("DES/CFB/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec, algorithmParameterSpec);
                                cifrar(dec);
                            }
                        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException
                                | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                                | NoSuchPaddingException e) {
                        }
                        break;
                    case 3:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("DES/OFB/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec, algorithmParameterSpec);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("DES/OFB/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec, algorithmParameterSpec);
                                cifrar(dec);
                            }
                        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException
                                | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                                | NoSuchPaddingException e) {
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "All fields are required",
                    "Error", JOptionPane.ERROR_MESSAGE, null);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (doValidations()) {
            String keyAES = "";
            int a = 0;
            while (a != 16) {
                keyAES = JOptionPane.showInputDialog(null, "Enter a 16 characters key");
                a = keyAES.length();
            }
            SecretKeySpec skeySpec = new SecretKeySpec(keyAES.getBytes(), "AES");
            fileOutput = outFile.getText();
            if (!fileOutput.contains(".bmp")) {
                fileOutput += ".bmp";
            }
            int chooseMetod = jComboBox1.getSelectedIndex();
            int chooseAlgorithm = jComboBox2.getSelectedIndex();
            try {
                switch (chooseMetod) {
                    case 0:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("AES/ECB/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("AES/ECB/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec);
                                descifrar(dec);
                            }
                        } catch (IOException | InvalidKeyException | NoSuchAlgorithmException
                                | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
                        }
                        break;
                    case 1:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("AES/CBC/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec, algorithmParameterSpecAES);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("AES/CBC/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec, algorithmParameterSpecAES);
                                descifrar(dec);
                            }
                        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException
                                | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                                | NoSuchPaddingException e) {
                        }
                        break;
                    case 2:
                        try {
                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("AES/CFB/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec, algorithmParameterSpecAES);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("AES/CFB/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec, algorithmParameterSpecAES);
                                cifrar(dec);
                            }
                        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException
                                | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                                | NoSuchPaddingException e) {
                        }
                        break;
                    case 3:
                        try {

                            if (chooseAlgorithm == 0) {
                                enc = Cipher.getInstance("AES/OFB8/NoPadding");
                                enc.init(Cipher.ENCRYPT_MODE, skeySpec, algorithmParameterSpecAES);
                                cifrar(enc);
                            } else {
                                dec = Cipher.getInstance("AES/OFB8/NoPadding");
                                dec.init(Cipher.DECRYPT_MODE, skeySpec, algorithmParameterSpecAES);
                                cifrar(dec);
                            }
                        } catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException
                                | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                                | NoSuchPaddingException e) {
                        }
                        break;
                    default:
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "All fields are required",
                    "Error", JOptionPane.ERROR_MESSAGE, null);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FileManager fm = new FileManager();
        fm.openFile();
        fileInput = fm.getFileName();
        originalFile.setText(fileInput);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        originalFile.setText("");
        outFile.setText("");
        originalLabel.setIcon(null);
        outLabel.setIcon(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void outFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outFileActionPerformed

    private void cifrar(Cipher encr) throws IOException, IllegalBlockSizeException, BadPaddingException {
        BufferedImage img = ImageIO.read(new File(fileInput));
        ImageIcon imagen = new ImageIcon(img);
        ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(originalLabel.getWidth(), originalLabel.getHeight(), Image.SCALE_DEFAULT));
        originalLabel.setIcon(icono);
        this.repaint();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "bmp", baos);
        baos.flush();
        byte[] imgByte = baos.toByteArray();
        baos.close();
        byte[] totalBytes = new byte[(int) imgByte.length];
        byte[] encrypBytes = new byte[(int) imgByte.length - headerBMP];

        for (int x = 0, y = 0; x < imgByte.length; x++) {
            if (x < headerBMP) {
                totalBytes[x] = imgByte[x];
            } else {
                encrypBytes[y++] = imgByte[x];
            }
        }

        byte[] newImage = encr.doFinal(encrypBytes);

        for (int i = headerBMP, j = 0; i < imgByte.length; i++, j++) {
            totalBytes[i] = newImage[j];
        }
        InputStream in = new ByteArrayInputStream(totalBytes);
        BufferedImage bImageFromConvert = ImageIO.read(in);
        ImageIO.write(bImageFromConvert, "bmp", new File(fileOutput));
        BufferedImage imgn = ImageIO.read(new File(fileOutput));
        ImageIcon imag = new ImageIcon(imgn);
        ImageIcon ic = new ImageIcon(imag.getImage().getScaledInstance(outLabel.getWidth(), outLabel.getHeight(), Image.SCALE_DEFAULT));
        outLabel.setIcon(ic);
        this.repaint();
    }

    private void descifrar(Cipher desc) throws IOException, IllegalBlockSizeException, BadPaddingException {
        BufferedImage img2 = ImageIO.read(new File(fileInput));
        ImageIcon imagen = new ImageIcon(img2);
        ImageIcon icono = new ImageIcon(imagen.getImage().getScaledInstance(originalLabel.getWidth(), originalLabel.getHeight(), Image.SCALE_DEFAULT));
        originalLabel.setIcon(icono);
        this.repaint();
        ByteArrayOutputStream bO2 = new ByteArrayOutputStream();
        ImageIO.write(img2, "bmp", bO2);
        bO2.flush();
        byte[] imgByte2 = bO2.toByteArray();
        bO2.close();

        byte[] totalBytes2 = new byte[(int) imgByte2.length];
        byte[] encrypBytes2 = new byte[(int) imgByte2.length - headerBMP];

        for (int x = 0, y = 0; x < imgByte2.length; x++) {
            if (x < headerBMP) {
                totalBytes2[x] = imgByte2[x];
            } else {
                encrypBytes2[y++] = imgByte2[x];
            }
        }

        byte[] newImage2 = desc.doFinal(encrypBytes2);

        for (int i = headerBMP, j = 0; i < imgByte2.length; i++, j++) {
            totalBytes2[i] = newImage2[j];
        }
        InputStream in2 = new ByteArrayInputStream(totalBytes2);
        BufferedImage bImageFromConvert2 = ImageIO.read(in2);
        ImageIO.write(bImageFromConvert2, "bmp", new File(fileOutput));
        BufferedImage imgn2 = ImageIO.read(new File(fileOutput));
        ImageIcon imag2 = new ImageIcon(imgn2);
        ImageIcon ic2 = new ImageIcon(imag2.getImage().getScaledInstance(outLabel.getWidth(), outLabel.getHeight(), Image.SCALE_DEFAULT));
        outLabel.setIcon(ic2);
        this.repaint();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField originalFile;
    private javax.swing.JLabel originalLabel;
    private javax.swing.JTextField outFile;
    private javax.swing.JLabel outLabel;
    // End of variables declaration//GEN-END:variables
}
