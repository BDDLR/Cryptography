package com.caesar;

import java.util.Arrays;

public class Caesar {

    private String message;
    private int key;
    private int returnKey;
    private final int factor = 123;
    private final int overflowMay = 97;
    private final int overflowMin = 26;
    private final int toUpper = -32;
    private final int toLow = 32;

    public Caesar(String message, int key) {
        this.message = message;
        this.key = key;
        this.returnKey = -key;
    }

    public String caesarEncrypt() {

        String decMessage = new String();

        for (char c : message.toCharArray()) {
            if (c >= 97 && c <= 122) {
                if (c > 119) {
                    decMessage += (char) (((c + key) % factor) + overflowMay + toUpper);
                } else {
                    decMessage += (char) (((c + key) % factor) + toUpper);
                }
            }
        }
        return decMessage;
    }

    public String caesarDecrypt() {

        String decMessage = new String();

        for (char c : message.toCharArray()) {
            if (c >= 65 && c <= 90) {
                if (c < 68) {
                    decMessage += (char) (((c + returnKey) % factor) + toLow + overflowMin);
                } else {
                    decMessage += (char) (((c + returnKey) % factor) + toLow);
                }
            }
        }
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
