package com.caesar;

import java.util.Arrays;

public class Caesar {

    private String message;
    private int key;
    private static final String upC = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    private static final String lowC = "abcdefghijklmnñopqrstuvwxyz";

    public Caesar(String message, int key) {
        this.message = message;
        this.key = key;
    }

    public String caesarEncrypt() {
        char[] aux = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < upC.length(); j++) {
                if (message.charAt(i) == upC.charAt(j) || message.charAt(i) == lowC.charAt(j)) {
                    aux[i] = upC.toCharArray()[(j + key) % upC.length()];
                    j = upC.length();
                } else {
                    aux[i] = message.charAt(i);
                }
            }
        }
        String encMessage = new String(aux);
        return encMessage;
    }

    public String caesarDecrypt() {
        char[] aux = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            for (int j = 0; j < upC.length(); j++) {
                if (message.charAt(i) == upC.charAt(j) || message.charAt(i) == lowC.charAt(j)) {
                    aux[i] = upC.toCharArray()[(j - key + upC.length()) % upC.length()];
                    j = upC.length();
                } else {
                    aux[i] = message.charAt(i);
                }
            }
        }
        String decMessage = new String(aux);
        return decMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

}
