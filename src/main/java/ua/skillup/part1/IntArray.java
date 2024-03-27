package ua.skillup.part1;

public class IntArray {
    private int[] arrayForClass;
    private int[] reversedArray;

    public IntArray(int size) {
        this.arrayForClass = new int[size];
    }

    public int[] getArray() {
        return this.arrayForClass;
    }

    public int[] getReversedArray() {
        return reversedArray;
    }


    public void fillWithNumbers() {
        for (int i = 0; i < this.arrayForClass.length; i++) {
            this.arrayForClass[i] = (int) (Math.random() * 1000);
            System.out.println("Array index is: " + i);
            System.out.println(this.arrayForClass[i]);
        }
    }

    public int max() {
        if (arrayForClass.length == 0) {
            return 0;
        }
        int max = arrayForClass[0];
        for (int i = 0; i < arrayForClass.length; i++) {
            if (arrayForClass[i] > max) {
                max = arrayForClass[i];
            }
        }
        return max;
    }

    public int min() {
        if (arrayForClass.length == 0) {
            return 0;
        }
        int min = arrayForClass[0];
        for (int j : arrayForClass) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }


    public int sum() {
        int sum = 0;
        for (int currentArrayValue : arrayForClass) {
            sum += currentArrayValue;
        }
        return sum;
    }

    public int avg() {
        if (arrayForClass.length == 0) {
            return 0;
        }
        return sum() / arrayForClass.length;
    }

    public void reverse() {
        reversedArray = new int[arrayForClass.length];
        for (int i = 0; i < arrayForClass.length; i++) {
            reversedArray[arrayForClass.length - 1 - i] = arrayForClass[i];
        }
    }

    public IntArray copy() {
        IntArray copiedArray = new IntArray(arrayForClass.length);
        for (int i = 0; i < arrayForClass.length; i++) {
            copiedArray.getArray()[i] = arrayForClass[i];
        }
        return copiedArray;
    }

    public int indexOf(int value) {
        for (int i = 0; i < arrayForClass.length; i++) {
            if (arrayForClass[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void removeDuplicates() {
        IntArray withNoDuplicates = new IntArray(arrayForClass.length);
        int newArrayLength = 0;
        for (int currentArrayValue : arrayForClass) {
            if (withNoDuplicates.indexOf(currentArrayValue) == -1) {
                withNoDuplicates.getArray()[newArrayLength] = currentArrayValue;
                newArrayLength++;
            }

        }
        int[] removedDuplicatesArray = new int[newArrayLength];
        for (int i = 0; i < newArrayLength; i++) {
            removedDuplicatesArray[i] = withNoDuplicates.getArray()[i];
        }
        arrayForClass = removedDuplicatesArray;
    }

    public void sort(boolean ascending) {

    }

    public boolean isSorted(boolean ascending) {
        // TODO: Implement solution here
        return false;
    }

    public void append(IntArray arr2) {
        // TODO: Implement solution here
    }

    public int binarySearch(int value, boolean ascending) {
        // TODO: Implement solution here
        return -1;
    }
}
