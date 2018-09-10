package com.algorithm;

public class EuclidesValidation {

    private int a;
    private int b;
    private int n;
    private double inv_a;
    private int inv_b;

    public EuclidesValidation() {
    }

    public EuclidesValidation(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
        this.inv_b = n - b;
    }

    public int gdc() {
        int aAux = getA();
        int nAux = getN();

        while (aAux != nAux) {
            if (aAux < nAux) {
                nAux = nAux - aAux;
            } else {
                aAux = aAux - nAux;
            }
        }
        return (aAux);
    }

    public void euclidesExtendido() {
        double aAux = getA();
        double nAux = getN();

        double x = 0, y = 0, d = 0;
        double x2 = 1, x1 = 0, y2 = 0, y1 = 1;
        double q = 0, r = 0;

        while (nAux > 0) {
            q = Math.floor(aAux / nAux);
            r = aAux - q * nAux;
            x = x2 - q * x1;
            y = y2 - q * y1;
            aAux = nAux;
            nAux = r;
            x2 = x1;
            x1 = x;
            y2 = y1;
            y1 = y;
        }
        inv_a = x2;
    }

    public int getInv_b() {
        return (this.n - b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getInv_a() {
        return inv_a;
    }

    public void setInv_a(int inv_a) {
        this.inv_a = inv_a;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

}
