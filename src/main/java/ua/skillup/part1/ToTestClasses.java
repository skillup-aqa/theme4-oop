package ua.skillup.part1;

public class ToTestClasses {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        IntArray arrayToCopy;
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

        System.out.println("Sorted by ascending");
        System.out.println();
        array.sort(true);
        for (int currentArrayValue : array.getArray()) {
            System.out.print(currentArrayValue + " ");
        }

        System.out.println();
        System.out.println("Sorted by descending");
        System.out.println();
        array.sort(false);
        for (int currentArrayValue : array.getArray()) {
            System.out.print(currentArrayValue + " ");
        }

        System.out.println();
        System.out.print("Is sorted by descending: " + array.isSorted(false) + "\n");
        System.out.println("Appended array: ");
        array.append(arrayToCopy);
        for (int currentArrayValue : array.getArray()) {
            System.out.print(currentArrayValue + " ");
        }
    }
}
