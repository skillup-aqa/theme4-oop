package ua.skillup;

import org.testng.annotations.Test;
import ua.skillup.part1.IntArray;

import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;

public class IntArrayTests {
    private void fillArrayWithNumbers(int[] array, boolean ascending) {
        for (int i = 0; i < array.length; i++) {
            if (ascending)  {
                array[i] = i + 1;
            } else {
                array[i] = array.length - i;
            }
        }
    }

    private void fillArrayWithNumbers(int[] array) {
        fillArrayWithNumbers(array, true);
    }

    private boolean arraysEqual(int [] array1, int [] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean arraysEqual(IntArray arr1, IntArray arr2) {
        return arraysEqual(arr1.getArray(), arr2.getArray());
    }


    @Test
    public void testArrayCreation() {
        IntArray array = new IntArray(10);
        int[] actual = array.getArray();
        int[] expected = new int[10];
        assertTrue(arraysEqual(actual, expected));
    }

    @Test
    public void testFillWithNumbers() {
        IntArray array = new IntArray(10);
        array.fillWithNumbers();
        IntArray arrayCopy = array.copy();

        array.fillWithNumbers();
        assertFalse(arraysEqual(array, arrayCopy));
    }

    @Test
    public void testMaxLast() {
        IntArray array = new IntArray(10);
        fillArrayWithNumbers(array.getArray(), true);
        assertEquals(array.max(), 10);
    }

    @Test
    public void testMaxFirst() {
        IntArray array = new IntArray(10);
        fillArrayWithNumbers(array.getArray(), false);
        assertEquals(array.max(), 10);
    }

    @Test
    public void testMaxForEmptyArray() {
        IntArray array = new IntArray(0);
        assertEquals(array.max(), 0);
    }

    @Test
    public void testMinFirst() {
        IntArray array = new IntArray(10);
        fillArrayWithNumbers(array.getArray(), true);
        assertEquals(array.min(), 1);
    }

    @Test
    public void testMinLast() {
        IntArray array = new IntArray(10);
        fillArrayWithNumbers(array.getArray(), false);
        assertEquals(array.min(), 1);
    }

    @Test
    public void testMinForEmptyArray() {
        IntArray array = new IntArray(0);
        assertEquals(array.min(), 0);
    }

    @Test
    public void testSum() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.sum(), 15);
    }

    @Test
    public void testSumForEmptyArray() {
        IntArray array = new IntArray(0);
        assertEquals(array.sum(), 0);
    }

    @Test
    public void testAverage() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.avg(), 3);
    }

    @Test
    public void testAverageForEmptyArray() {
        IntArray array = new IntArray(0);
        assertEquals(array.avg(), 0);
    }

    @Test
    public void testReverse() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        array.reverse();
        assertTrue(arraysEqual(array.getArray(), new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testCopy() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        IntArray copy = array.copy();
        assertTrue(arraysEqual(copy.getArray(), array.getArray()));
    }

    @Test
    public void testIndexOf() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.indexOf(3), 2);
    }

    @Test
    public void testIndexOfNotFound() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.indexOf(6), -1);
    }

    @Test
    public void testRemoveDuplicates() {
        IntArray array = new IntArray(10);
        int[] arrayVal = array.getArray();
        for (int i = 0; i < 5; i++) {
            arrayVal[i] = i + 1;
            arrayVal[arrayVal.length - i - 1] = i + 1;
        }

        array.removeDuplicates();
        assertTrue(arraysEqual(array.getArray(), new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testRemoveDuplicatesForEmptyArray() {
        IntArray array = new IntArray(0);
        array.removeDuplicates();
        assertEquals(array.getArray(), new int[]{});
    }

    @Test
    public void testIsSortedAsc() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), true);
        assertTrue(array.isSorted(true));
    }

    @Test
    public void testIsSortedDesc() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), false);
        assertTrue(array.isSorted(false));
    }

    @Test
    public void testIsSortedForEmptyArray() {
        IntArray array = new IntArray(0);
        assertTrue(array.isSorted(true));
        assertTrue(array.isSorted(false));
    }

    @Test
    public void testIsSortedForSingleElementArray() {
        IntArray array = new IntArray(1);
        fillArrayWithNumbers(array.getArray());
        assertTrue(array.isSorted(true));
        assertTrue(array.isSorted(false));
    }

    @Test
    public void testIsSortedForArrayOfEquals() {
        IntArray array = new IntArray(5);
        int[] arrayVal = array.getArray();
        for (int i = 0; i < 5; i++) {
            arrayVal[i] = 1;
        }
        assertTrue(array.isSorted(true));
        assertTrue(array.isSorted(false));
    }

    @Test
    public void testIsSortedForUnsortedArray() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        array.getArray()[2] = 0;
        assertFalse(array.isSorted(true));
        assertFalse(array.isSorted(false));
    }

    @Test
    public void testSortAsc() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), false);
        array.sort(true);
        assertTrue(arraysEqual(array.getArray(), new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void testSortDesc() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), true);
        array.sort(false);
        assertTrue(arraysEqual(array.getArray(), new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testSortForEmptyArray() {
        IntArray array = new IntArray(0);
        array.sort(true);
        assertTrue(arraysEqual(array.getArray(), new int[]{}));
    }

    @Test
    public void testSortForSingleElementArray() {
        IntArray array = new IntArray(1);
        fillArrayWithNumbers(array.getArray());
        array.sort(true);
        assertTrue(arraysEqual(array.getArray(), new int[]{1}));
    }

    @Test
    public void testAppend() {
        IntArray array1 = new IntArray(5);
        fillArrayWithNumbers(array1.getArray(), true);
        IntArray array2 = new IntArray(5);
        fillArrayWithNumbers(array2.getArray(), false);
        array1.append(array2);
        assertTrue(arraysEqual(array1.getArray(), new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2, 1}));
    }

    @Test
    public void testAppendAnEmptyArray() {
        IntArray array1 = new IntArray(0);
        IntArray array2 = new IntArray(0);
        array1.append(array2);
        assertTrue(arraysEqual(array1.getArray(), new int[]{}));
    }

    @Test
    public void testBinarySearchMiddleVal() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.binarySearch(3, true), 2);
    }

    @Test
    public void testBinarySearchAscLeftVal() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.binarySearch(1, true), 0);
    }

    @Test
    public void testBinarySearchAscRightVal() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.binarySearch(5, true), 4);
    }

    @Test
    public void testBinarySearchDescMiddleVal() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), false);
        assertEquals(array.binarySearch(3, false), 2);
    }

    @Test
    public void testBinarySearchDescLeftVal() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), false);
        assertEquals(array.binarySearch(5, false), 0);
    }

    @Test
    public void testBinarySearchDescRightVal() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray(), false);
        assertEquals(array.binarySearch(1, false), 4);
    }

    @Test
    public void testBinarySearchForUnsortedArray() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        array.getArray()[2] = 0;
        assertEquals(array.binarySearch(1, true), -1);
    }

    @Test
    public void testBinarySearchNotFound() {
        IntArray array = new IntArray(5);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.binarySearch(6, true), -1);

    }

    @Test
    public void testBinarySearchForEmptyArray() {
        IntArray array = new IntArray(0);
        assertEquals(array.binarySearch(6, true), -1);
    }

    @Test
    public void testBinarySearchForSingleElementArray() {
        IntArray array = new IntArray(1);
        fillArrayWithNumbers(array.getArray());
        assertEquals(array.binarySearch(1, true), 0);
    }
}
