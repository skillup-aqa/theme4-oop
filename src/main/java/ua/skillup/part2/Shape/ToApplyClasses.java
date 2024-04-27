package ua.skillup.part2.Shape;

public class ToApplyClasses {

    public static void printInfo(String nameOfShape, Shape a) {
        System.out.println("This is a " + nameOfShape + "\n");
        System.out.println("Area is: " + a.area() + "\n");
        System.out.println("Perimeter is: " + a.perimeter() + "\n");
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(4, 8);
        Square square = new Square(5);
        Triangle triangle = new Triangle(3, 4, 5);
        Circle circle = new Circle(10);
        printInfo("Rectangle", rectangle);
        printInfo("Square", square);
        printInfo("Triangle", triangle);
        printInfo("Circle", circle);


    }
}