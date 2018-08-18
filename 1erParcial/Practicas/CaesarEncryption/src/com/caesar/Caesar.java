package com.caesar;

import java.util.Arrays;

public class Caesar {

    private String message;
    private int key;
    private int returnKey;
    private final int factor1 = 97;
    private final int factor2 = 65;
    private final int toUpper = 65;
    private final int toLow = 97;

    public Caesar(String message, int key) {
        this.message = message;
        this.key = key;
        this.returnKey = -key;
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
                if(c - factor2 + returnKey >= 0){
                    decMessage += (char) (((c - factor2 + returnKey) % 26) + toLow);
                }else{
                    decMessage += (char) (((c + factor2 + returnKey) % 26) + toLow);
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
