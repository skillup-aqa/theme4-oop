package ua.skillup.part1;

public class ToTestClasses {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        IntArray arrayToCopy = new IntArray(array.getArray().length);
        int testValue;


        array.fillWithNumbers();
        System.out.println("Max array value is: " + array.max());
        System.out.println("Min array value is: " + array.min());
        System.out.println("Sum of array is: " + array.sum());
        System.out.println("Avg of array is: " + array.avg());

        System.out.println("Reversed array is: ");
        array.reverse();
        for (int currentArrayValue : array.getReversedArray()) {
            System.out.print(currentArrayValue + " ");
        }
        System.out.println();
        System.out.println("Copied array is: ");
        arrayToCopy = array.copy();

        for (int currentArrayValue : arrayToCopy.getArray()) {
            System.out.print(currentArrayValue + " ");
        }

        testValue = array.getArray()[3];
        System.out.println();
        System.out.println("Index of value is: " + array.indexOf(testValue));
        System.out.println("Index of value is: " + array.indexOf(2000));

    }
}
