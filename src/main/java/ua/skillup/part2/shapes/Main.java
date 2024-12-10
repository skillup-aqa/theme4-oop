package ua.skillup.part2.shapes;

public class Main {
    public static void printShapeValue(String name, GeometricFigures geometricFigures) {
        System.out.println("  " + name + "  ");
        System.out.println("Perimeter is: " + geometricFigures.perimeter());
        System.out.println("Area is: " + geometricFigures.area() + "\n");
        System.out.println();
    }

    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Rectangle rectangle = new Rectangle(2, 6);
        Square square = new Square(7);
        Triangle triangle = new Triangle(3, 5, 7);

        printShapeValue("Circle", circle);
        printShapeValue("Rectangle", rectangle);
        printShapeValue("Square", square);
        printShapeValue("Triangle", triangle);
    }

}
