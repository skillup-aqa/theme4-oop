package ua.skillup.part1;

public class IntArray {
    private int[] array;

    public IntArray(int size) {
        this.array = new int[size];
    }

    public int[] getArray() {
        return this.array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void fillWithNumbers() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(Math.random() * 1000);
        }
    }

    public int max() {
        if(array.length == 0) {
            return 0;
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int min() {
        if(array.length == 0) {
            return 0;
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }


    public int sum() {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum;
    }

    public int avg() {
        if(array.length == 0) {
            return 0;
        }
        return sum() / array.length;
    }

    public void reverse() {
        for (int i = 0; i < array.length / 2; i++) {
            swap(i, array.length - i - 1);
        }
    }

    public IntArray copy() {
        IntArray copy = new IntArray(array.length);
        for (int i = 0; i < array.length; i++) {
            copy.getArray()[i] = array[i];
        }
        return copy;
    }

    public int indexOf(int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void removeDuplicates() {
        IntArray uniqueArr = new IntArray(array.length);
        int[] unique = uniqueArr.getArray();
        int index = 0;
        for (int j : array) {
            if (uniqueArr.indexOf(j) == -1) {
                unique[index++] = j;
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }
        this.array = result;
    }

    public void sort(boolean ascending) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (ascending) {
                    if (array[i] > array[j]) {
                        swap(i, j);
                    }
                } else {
                    if (array[i] < array[j]) {
                        swap(i, j);
                    }
                }
            }
        }
    }

    public boolean isSorted(boolean ascending) {
        if (array.length < 2) {
            return true;
        }

        for(int i = 0; i < array.length - 1; i++) {
            if(ascending) {
                if(array[i] > array[i + 1]) {
                    return false;
                }
            } else {
                if(array[i] < array[i + 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public void append(IntArray arr2) {
        int[] array1 = this.array;
        int[] array2 = arr2.getArray();

        int[] merged = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            merged[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            merged[array1.length + i] = array2[i];
        }

        this.array = merged;
    }

    public int binarySearch(int value, boolean ascending) {
        int left = 0;
        int right = array.length - 1;

        if (!isSorted(ascending)) {
            System.out.println("Array is not sorted");
            return -1;
        }

        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else {
                if (ascending) {
                    if (array[middle] < value) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                } else {
                    if (array[middle] < value) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
            }
        }
        return -1;
    }
}
