package ua.skillup.part1;

import java.util.concurrent.Callable;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(real * other.real - imaginary * other.imaginary,
                real * other.imaginary + imaginary * other.real);
    }

    public ComplexNumber multiply(double factor) {
        return new ComplexNumber(real * factor, imaginary * factor);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        return new ComplexNumber((real * other.real + imaginary * other.imaginary) / denominator,
                (imaginary * other.real - real * other.imaginary) / denominator);
    }

    public ComplexNumber divide(double divisor) {
        return new ComplexNumber(real/divisor, imaginary/divisor);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, - imaginary);
    }
    public String toString() {
        return real + "+" + imaginary + "i";
    }
    public static void main(String[] args) {
        ComplexNumber a = new ComplexNumber(1, 5);
        ComplexNumber b = new ComplexNumber(3, 7);

        double abs = a.abs();
        System.out.println("Absolute value " + a.toString() + " is " + abs);

        ComplexNumber c = a.add(b);
        System.out.println("Adding a complex number: " +
                a.toString() + "+" + b.toString() + "=" + c.toString());

        c = a.subtract(b);
        System.out.println("Subtraction of a complex number: " + a.toString() + "-" + b.toString() + "=" + c.toString());

        c = a.multiply(b);
        System.out.println("Multiplication by a complex number: " + a.toString() + " * " + b.toString() + " = " + c.toString());

        c = a.multiply(2);
        System.out.println("Multiplication by number: " + a.toString() + " * 2 = " + c.toString());

        c = a.divide(b);
        System.out.println("Division by a complex number: " + a.toString() + " / " + b.toString() + " = " + c.toString());

        c = a.divide(2);
        System.out.println("Division by number: " + a.toString() + " / 2 = " + c.toString());

        c = a.conjugate();
        System.out.println("The conjugate of " + a.toString() + " is " + c.toString());

    }
}

