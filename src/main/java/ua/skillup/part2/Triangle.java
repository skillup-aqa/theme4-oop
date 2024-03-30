package ua.skillup.part2;

public class Triangle extends Figure {
    final protected double a;
    final protected double b;
    final protected double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return (a + b + c) / 2;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }
}
