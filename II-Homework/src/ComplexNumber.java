import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.*;

/**
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 */
public final class ComplexNumber implements Comparable<ComplexNumber> {
    private double im;
    private double re;

    public ComplexNumber() {
        this.im = 0.0;
        this.re = 0.0;
    }

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        this.im = complexNumber.im;
        this.re = complexNumber.re;
    }

    public synchronized double getRe() {
        return this.re;
    }

    public synchronized double getIm() {
        return this.im;
    }

    public synchronized void setRe(double re) {
        this.re = re;
    }

    public synchronized void setIm(double im) {
        this.im = im;
    }

    public synchronized ComplexNumber conjugate() {
        ComplexNumber conjugate = new ComplexNumber();
        conjugate.setRe(this.re);
        conjugate.setIm(this.im * -1);
        return conjugate;
    }

    public synchronized ComplexNumber reciprocal() {
        return new ComplexNumber((this.re / (Math.pow(this.re, 2) + Math.pow(this.im, 2))),
                -1.0 * ((this.im) / ((Math.pow(this.re, 2) + Math.pow(this.im, 2)))));

    }

    public synchronized ComplexNumber add(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        ComplexNumber addition = new ComplexNumber();
        addition.setRe(this.re + complexNumber.getRe());
        addition.setIm(this.im + complexNumber.getIm());
        return addition;
    }

    public synchronized ComplexNumber subtract(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        ComplexNumber subtraction = new ComplexNumber();
        subtraction.setRe(this.re - complexNumber.getRe());
        subtraction.setIm(this.im - complexNumber.getIm());
        return subtraction;
    }

    public synchronized ComplexNumber multiply(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        ComplexNumber multiply = new ComplexNumber();
        multiply.setRe((this.re * complexNumber.getRe()) - (this.im * complexNumber.getIm()));
        multiply.setIm((this.im * complexNumber.getRe()) + (this.re * complexNumber.getIm()));
        return multiply;
    }

    public synchronized ComplexNumber divide(ComplexNumber complexNumber) throws IllegalArgumentException {
        if (complexNumber == null) {
            throw new IllegalArgumentException();
        }
        ComplexNumber divide = new ComplexNumber();
        divide.setRe(((this.re * complexNumber.getRe()) + (this.im * complexNumber.getIm())) /
                ((Math.pow(complexNumber.getRe(), 2)) + (Math.pow(complexNumber.getIm(), 2))));
        divide.setIm(((this.im * complexNumber.getRe()) - (this.re * complexNumber.getIm())) /
                ((Math.pow(complexNumber.getRe(), 2)) + (Math.pow(complexNumber.getIm(), 2))));
        return divide;
    }

    public synchronized int compareTo(ComplexNumber complexNumber) throws NullPointerException {
        if (((this != null) && (complexNumber == null))) {
            return -1;
        }
        if ((this == null) && (complexNumber != null)) {
            return 1;
        }
        if ((this == null) && (complexNumber == null)) {
            return 0;
        }
        if ((this.re < complexNumber.getRe()) && (this.im < complexNumber.getIm())) {
            return -1;
        }
        if ((this.re > complexNumber.getRe()) && (this.im > complexNumber.getIm())) {
            return 1;
        }
        if ((this.re == complexNumber.getRe()) && (this.im == complexNumber.getIm())) {
            return 0;
        }
        if ((this.re > complexNumber.getRe()) && (this.im < complexNumber.getIm())) {
            return 1;
        }
        if ((this.re == complexNumber.getRe()) && (this.im < complexNumber.getIm())) {
            return -1;
        }
        return 0;
    }

    public synchronized boolean equals(Object object) {
        int count = 0;
        if (object instanceof ComplexNumber) {
            ComplexNumber complexNumber = (ComplexNumber) object;
            if (this.re == complexNumber.getRe()) {
                count++;
            }
            if (this.im == complexNumber.getIm()) {
                count++;
            }
        }
        return (count == 2);
    }

    public synchronized String toString() {
        if (this.im < 0.0) {
            return String.format("%.6f", this.re) + " - " + String.format("%.6f", (this.im * -1)) + "i";
        } else {
            return String.format("%.6f", this.re) + " + " + String.format("%.6f", (this.im)) + "i";
        }
    }
}
