package ua.skillup.part2.shapes;

public class Triangle extends GeometricFigures {
    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double perimeter() {
        return a + b + c;
    }

    @Override
    public double area() {
        double p = this.perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
