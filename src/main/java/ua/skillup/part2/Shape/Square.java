package ua.skillup.part2.Shape;

public class Square extends Shape {
    final protected double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return a * a;
    }

    @Override
    public double perimeter() {
        return a * 4;
    }
}
