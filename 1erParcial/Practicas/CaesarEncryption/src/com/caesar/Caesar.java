package com.caesar;

public class Caesar {

    private String message;
    private int key;
    private final int keyInv;
    private final int factor1 = 97;
    private final int factor2 = 65;
    private final int toUpper = 65;
    private final int toLow = 97;

    public Caesar(String message, int key) {
        this.message = message;
        this.key = key;
        this.keyInv = (26 - key);
    }

    public String caesarEncrypt() {

        String decMessage = new String();

        for (char c : message.toCharArray()) {
            if (c >= 97 && c <= 122) {
                decMessage += (char) (((c - factor1 + key) % 26) + toUpper);
            }
        }
        return decMessage;
    }

    public String caesarDecrypt() {

        String decMessage = new String();

        for (char c : message.toCharArray()) {
            if (c >= 65 && c <= 90) {
                c -= factor2;
                c = (char) ((c+keyInv)%26);
                decMessage += (char) (c + toLow);
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
