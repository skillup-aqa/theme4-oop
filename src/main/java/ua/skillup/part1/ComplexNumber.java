package ua.skillup.part1;


public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {

        return real;
    }

    public double getImaginary() {
        // TODO: Implement method here
        return imaginary;
    }

    public double abs() {

        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary, 2));
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {

        return new ComplexNumber((real * other.real - imaginary * other.imaginary),
                (real * other.imaginary + other.real * imaginary));
    }

    public ComplexNumber multiply(double factor) {

        return new ComplexNumber(real * factor, imaginary * factor);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);
        return new ComplexNumber((real * other.real + imaginary * other.imaginary) / denominator,
                (imaginary * other.real - real * other.imaginary) / denominator);
    }

    public ComplexNumber divide(double divisor) {
        return new ComplexNumber(real / divisor, imaginary / divisor);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imaginary);
    }

}
