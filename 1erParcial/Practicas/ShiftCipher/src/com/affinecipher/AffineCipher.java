package com.affinecipher;

public class AffineCipher {

    private String message;
    private final int factor1 = 97;
    private final int factor2 = 65;
    private final int toUpper = 65;
    private final int toLow = 97;
    private final int alpha;
    private int inverseAlpha;
    private final int betha;
    private int inverseBetha;

    public AffineCipher(String message, int alpha, int betha) {
        this.message = message;
        this.alpha = alpha;
        this.betha = betha;
        this.inverseAlpha = doInverseAlpha();
        this.inverseBetha = doInverseBetha();
    }

    private int doInverseAlpha() {
        int alphabet = 26;
        int res;
        for (int i = 0; i < alphabet; i++) {
            res = (alpha * i) % alphabet;
            if (res == 1) {
                inverseAlpha = i;
                break;
            }
        }
        return inverseAlpha;
    }

    private int doInverseBetha() {
        inverseBetha = 26 - (betha % 26);
        return inverseBetha;
    }

    public String encrypt() {

        String encMessage = new String();

        for (char c : message.toCharArray()) {
            if (c > 96 && c < 123) {
                c -= factor1;
                c = (char) (((alpha * c) + betha) % 26);
                c += toUpper;
                encMessage += c;
            }
        }

        return encMessage;
    }

    public String decrypt() {

        String decMessage = new String();

        for (char c : message.toCharArray()) {
            if (c > 64 && c < 91) {
                c -= factor2;
                c = (char) ((inverseAlpha * (c + inverseBetha)) % 26);
                c += toLow;
                decMessage += c;
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

}
