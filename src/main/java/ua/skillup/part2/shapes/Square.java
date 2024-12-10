package ua.skillup.part2.shapes;

public class Square extends GeometricFigures {
    private final double a;

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
