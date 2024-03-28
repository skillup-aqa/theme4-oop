package ua.skillup.part1;

public class ToTestClasses {
    public static void main(String[] args) {
        IntArray array = new IntArray(10);
        IntArray arrayToCopy;
        IntArray sortedArrayAsc;
        int testValue;


        array.fillWithNumbers();
        System.out.println("Max array value is: " + array.max());
        System.out.println("Min array value is: " + array.min());
        System.out.println("Sum of array is: " + array.sum());
        System.out.println("Avg of array is: " + array.avg());

        System.out.println("Reversed array is: ");
        array.reverse();
        for (int currentArrayValue : array.getArray()) {
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
        array.sort(false);
        array.removeDuplicates();
        System.out.println("Sorted array for binary Search: \n");
        for (int currentArrayValue : array.getArray()) {
            System.out.print(currentArrayValue + " ");
        }

        testValue = array.getArray()[3];

        System.out.print("Test value: " + testValue + "\n");
        System.out.print("Binary search position: " + array.binarySearch(testValue, false) + "\n");
        System.out.print("Binary search position: " + array.binarySearch(2000, false) + "\n");
        System.out.println();
        //---------------------------------------------------------------
        System.out.println("TESTING COMPLEX NUMBER \n");
        ComplexNumber number1 = new ComplexNumber(4, 7);
        ComplexNumber tempNumber;
        System.out.println("The complex number is " + number1.getReal() + " + " + number1.getImaginary() + "i\n");
        System.out.println("abs value of this number is: " + number1.abs() + "\n");

        tempNumber = number1.add(new ComplexNumber(5, 6));
        System.out.println("Sum of complex numbers is: " + tempNumber.getReal() + " + "
                + tempNumber.getImaginary() + "i\n");

        tempNumber = number1.subtract(new ComplexNumber(6, 9));
        System.out.println("Subtract of complex numbers is: " + tempNumber.getReal() + " + "
                + tempNumber.getImaginary() + "i\n");

        tempNumber = number1.multiply(new ComplexNumber(4, 5));
        System.out.println("Multiply complexes number is: " + tempNumber.getReal() + " + "
                + tempNumber.getImaginary() + "i\n");

        tempNumber = number1.multiply(9);
        System.out.println("Multiply complex number on number is: " + +tempNumber.getReal()
                + " + " + tempNumber.getImaginary() + "i\n");

        tempNumber = number1.divide(new ComplexNumber(3,5));
        System.out.println("Divide complexes number is: " + tempNumber.getReal() + " + "
                + tempNumber.getImaginary() + "i\n");

        tempNumber = number1.divide(2);
        System.out.println("Divide complex number on number is: " + tempNumber.getReal() + " + "
                + tempNumber.getImaginary() + "i\n");

        tempNumber = number1.conjugate();
        System.out.println("Conjugate complex number is: " + tempNumber.getReal() + " + "
                + tempNumber.getImaginary() + "i\n");
    }
}
