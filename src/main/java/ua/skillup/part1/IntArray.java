package ua.skillup.part1;

import java.util.Arrays;

public class IntArray {
    private int[] arrayForThisClass;
    private int[] reversedArray;

    public IntArray(int size) {
        this.arrayForThisClass = new int[size];
    }

    public int[] getArray() {
        return this.arrayForThisClass;
    }

    public int[] getReversedToThisArray() {
        return reversedArray;
    }

    public void fillWithNumbers() {
        for (int i = 0; i < arrayForThisClass.length; i++) {
            arrayForThisClass[i] = (int) (Math.random() * 1000);
            System.out.println(this.arrayForThisClass[i]);
        }
    }

    public int max() {
        if (arrayForThisClass.length == 0) {
            return 0;
        }
        int max = arrayForThisClass[0];
        for (int i = 1; i < arrayForThisClass.length; i++) {
            if (arrayForThisClass[i] > max) {
                max = arrayForThisClass[i];
            }
        }
        return max;
    }

    public int min() {
        if (arrayForThisClass.length == 0) {
            return 0;
        }
        int min = arrayForThisClass[0];
        for (int i = 1; i < arrayForThisClass.length; i++) {
            if (arrayForThisClass[i] < min) {
                min = arrayForThisClass[i];
            }
        }
        return min;
    }

    public int sum() {
        int sum = 0;
        for (int num : arrayForThisClass) {
            sum += num;
        }
        return sum;
    }

    public int avg() {
        if (arrayForThisClass.length == 0) {
            return 0;
        }
        return sum() / arrayForThisClass.length;
    }

    private void swap(int i, int k) {
        int temp = arrayForThisClass[i];
        arrayForThisClass[i] = arrayForThisClass[k];
        arrayForThisClass[k] = temp;
    }

    public void reverse() {
        reversedArray = new int[arrayForThisClass.length];
        for (int i = 0; i < arrayForThisClass.length; i++) {
            reversedArray[arrayForThisClass.length - 1 - i] = arrayForThisClass[i];
            // System.out.println(arrayForThisClass[i] + " ");
        }
    }

    public IntArray copy() {
        IntArray copied = new IntArray(arrayForThisClass.length);
        for (int i = 0; i < arrayForThisClass.length; i++) {
            copied.getArray()[i] = arrayForThisClass[i];
        }
        return copied;
    }

    public int indexOf(int value) {
        for (int i = 0; i < arrayForThisClass.length; i++) {
            if (arrayForThisClass[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void removeDuplicates() {
        IntArray primaryForThisArray = new IntArray(arrayForThisClass.length);
        int[] primary = primaryForThisArray.getArray();
        int index = 0;
        for (int k : arrayForThisClass) {
            if (primaryForThisArray.indexOf(k) == -1) {
                primary[index++] = k;
            }
        }
        int[] newArray = new int[index];
        for (int i = 0; i < index; i++) {
            newArray[i] = primary[i];
        }
        this.arrayForThisClass = newArray;
    }

    public void sort(boolean ascending) {
        for (int i = 0; i < arrayForThisClass.length; i++) {
            for (int k = i + 1; k < arrayForThisClass.length; k++) {
                if (ascending) {
                    if (arrayForThisClass[i] > arrayForThisClass[k]) {
                        swap(i, k);
                    }
                } else {
                    if (arrayForThisClass[i] < arrayForThisClass[k]) {
                        swap(i, k);
                    }
                }
            }
        }
    }

    public boolean isSorted(boolean ascending) {
        if (arrayForThisClass.length < 2) {
            return true;
        }
        for (int i = 0; i < arrayForThisClass.length - 1; i++) {
            if (ascending) {
                if (arrayForThisClass[i] > arrayForThisClass[i + 1]) {
                    return false;
                }
            } else {
                if (arrayForThisClass[i] < arrayForThisClass[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void append(IntArray arr2) {
        int[] array1 = this.arrayForThisClass;
        int[] array2 = arr2.getArray();
        int[] mergedArrays = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            mergedArrays[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            mergedArrays[array1.length + i] = array2[i];
        }
        this.arrayForThisClass = mergedArrays;
    }

    public int binarySearch(int value, boolean ascending) {
        int low = 0;
        int high = arrayForThisClass.length - 1;

        if (!isSorted(ascending)) {
            System.out.println("Array not sorted");
            return -1;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arrayForThisClass[mid] == value) {
                return mid;
            } else {
                if (ascending) {
                    if (arrayForThisClass[mid] < value) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    if (arrayForThisClass[mid] < value) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        IntArray array = new IntArray(7);
        array.fillWithNumbers();
        array.reverse();
        IntArray copiedArray = array.copy();
        IntArray newArray = new IntArray(7);
        newArray.removeDuplicates();
        System.out.println("Max value is: " + array.max());
        System.out.println("Min value is: " + array.min());
        System.out.println("Sum is: " + array.sum());
        System.out.println("Avg value is: " + array.avg());

        System.out.println("Reversed Array is: ");
        for (int arrayValue : array.getReversedToThisArray()) {
            System.out.println(arrayValue + " ");
        }
        System.out.print("Copied Array: ");
        for (int i = 0; i < copiedArray.getArray().length; i++) {
            System.out.print(copiedArray.getArray()[i] + " ");
        }
        System.out.println();
        System.out.println("Checking for the presence of an element in the array: " + array.indexOf(500));
        System.out.println("Sorted by ascending");
        array.sort(true);
        for (int primaryArray : array.getArray()) {
            System.out.print(primaryArray + " ");
        }
        System.out.println();
        System.out.println("Sorted by descending");
        array.sort(false);
        for (int primaryArray : array.getArray()) {
            System.out.print(primaryArray + " ");
        }
        System.out.println();
        System.out.println("Sort check: ");

        array.isSorted(false);
        for (int primaryArray : array.getArray()) {
            System.out.print(primaryArray + " ");
        }
        System.out.println();
        System.out.print("Is sorted by descending: " + array.isSorted(false) + "\n");

        System.out.println("Appended array: ");
        array.append(copiedArray);
        for (int primaryArray : array.getArray()) {
            System.out.print(primaryArray + " ");
        }
        System.out.println();

        System.out.println("Binary search in an unsorted array: ");
        array.binarySearch(50, true);

    }
}
