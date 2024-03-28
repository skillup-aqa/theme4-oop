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
        arrayForClass = reversedArray;
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

    public void swap(int i, int j) {
        int temp = arrayForClass[i];
        arrayForClass[i] = arrayForClass[j];
        arrayForClass[j] = temp;
    }

    public void sort(boolean ascending) {
        for (int i = 0; i < arrayForClass.length; i++) {
            for (int j = i + 1; j < arrayForClass.length; j++) {
                if (ascending) {
                    if (arrayForClass[i] > arrayForClass[j]) {
                        swap(i, j);
                    }
                } else {
                    if (arrayForClass[i] < arrayForClass[j]) {
                        swap(i, j);
                    }
                }
            }
        }
    }

    public boolean isSorted(boolean ascending) {
        if (arrayForClass.length < 2) {
            return true;
        }

        for (int i = 0; i < arrayForClass.length - 1; i++) {
            if (ascending) {
                if (arrayForClass[i] > arrayForClass[i + 1]) {
                    return false;
                }
            } else {
                if (arrayForClass[i] < arrayForClass[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void append(IntArray arr2) {
        int lengthOfMergedArray = arrayForClass.length + arr2.getArray().length;
        int[] mergedArray = new int[lengthOfMergedArray];
        int array1Length = arrayForClass.length;
        for (int i = 0; i < array1Length; i++) {
            mergedArray[i] = arrayForClass[i];
        }

        for (int n = 0; n < arr2.getArray().length; n++) {
            mergedArray[array1Length + n] = arr2.getArray()[n];
        }
        arrayForClass = mergedArray;
    }

    public int binarySearch(int value, boolean ascending) {
        int low = 0;
        int high = arrayForClass.length - 1;
        int mid;
        if (!isSorted(ascending)) return -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arrayForClass[mid] == value) {
                return mid;
            } else {
                if (ascending) {
                    if (arrayForClass[mid] < value) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }

                } else {
                    if (arrayForClass[mid] < value) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
