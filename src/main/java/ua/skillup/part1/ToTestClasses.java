package ua.skillup.part1;

public class ToTestClasses {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        array.fillWithNumbers();
        System.out.println("Max array value is: " + array.max());
        System.out.println("Min array value is: " + array.min());

    }
}
