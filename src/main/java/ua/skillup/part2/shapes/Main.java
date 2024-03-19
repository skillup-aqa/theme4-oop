package ua.skillup.part2.shapes;

public class Main {

    public static void printShapeInfo(String name, Shape shape) {
        System.out.println("=== " + name + " ===");
        System.out.println("Perimeter: " + shape.perimeter());
        System.out.println("Area: " + shape.area());
        System.out.println();
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(3, 4);
        Square square = new Square(5);

        printShapeInfo("Triangle", triangle);
        printShapeInfo("Circle", circle);
        printShapeInfo("Rectangle", rectangle);
        printShapeInfo("Square", square);
    }
}
