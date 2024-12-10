package ua.skillup.part2.Shape;

public class Rectangle extends Shape {
    final protected double a;
    final protected double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }


    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimeter() {
        return 2 * (a + b);
    }
}
