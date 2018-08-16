package com.filemanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileManager {

    private String dirPath = System.getProperty("user.dir");
    private File inputFile;
    String sourceData = "";

    public FileManager() {
    }

    public String openFile() {
        String aux = "";

        try {

            JFileChooser fileChooser = new JFileChooser(dirPath);
            fileChooser.showOpenDialog(null);
            inputFile = fileChooser.getSelectedFile();

            if (inputFile != null) {
                FileReader archivos = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(archivos);
                while ((aux = br.readLine()) != null) {
                    sourceData += aux + "\n";
                }
                br.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return sourceData;
    }

    public void saveToFile(String encData) {
        try {
            JFileChooser fileChooser = new JFileChooser(dirPath);
            fileChooser.showSaveDialog(null);
            File outputFile = fileChooser.getSelectedFile();

            if (outputFile != null) {
                FileWriter fw = new FileWriter(outputFile + ".txt");
                fw.write(encData);
                fw.close();
                JOptionPane.showMessageDialog(null,
                        "File " + outputFile.getName() + ".txt has been successfully saved",
                        "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Su archivo no se ha outputFiledo",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public String getFileName() {
        return inputFile.getName();
    }

    public String getFilePath() {
        return inputFile.getAbsolutePath();
    }
}
