package ua.skillup.part1;

import java.sql.SQLOutput;

public class ToTestClasses {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        array.fillWithNumbers();
        System.out.println("Max array value is: " + array.max());
        System.out.println("Min array value is: " + array.min());
        System.out.println("Sum of array is: " + array.sum());
        System.out.println("Avg of array is: " + array.avg());

        System.out.println("Reversed array is: ");
        array.reverse();
        for (int currentArrayValue : array.getReversedArrayArray()) {
            System.out.print(currentArrayValue + " ");
        }

    }
}
