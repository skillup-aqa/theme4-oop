package ua.skillup.part2.Shape;

public class Triangle extends Shape {
    final protected double a;
    final protected double b;
    final protected double c;

    protected double p;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = a + b + c;

    }

    @Override
    public double area() {
        double halfP = p/2;
        return Math.sqrt((halfP * (halfP - a) * (halfP - b) * (halfP - c)));

    }

    @Override
    public double perimeter() {
        return p;
    }
}
