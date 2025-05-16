package teaching.swe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    @Test
    public void testOnArrayAndElementAtStart() {
        int[] a = { 1, 2, 3, 4, 5 };
        int k = 1;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(0, result);
    }

    @Test
    public void testOnArrayAndElementInMiddle() {
        int[] a = { 1, 2, 3, 4, 5 };
        int k = 3;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(2, result);
    }

    @Test
    public void testOnArrayAndElementAtEnd() {
        int[] a = { 1, 2, 3, 4, 100 };
        int k = 100;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(4, result);
    }

    @Test
    public void testOnArrayAndElementNotFound() {
        int[] a = { 1, 2, 3, 4, 5 };
        int k = 6;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(BinarySearch.NOT_FOUND, result);
    }

    @Test
    public void testOnEmptyArray() {
        int[] a = {};
        int k = 1;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(BinarySearch.NOT_FOUND, result);
    }

    @Test
    public void testOnArrayWithOneElement() {
        int[] a = { 1 };
        int k = 1;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(0, result);
    }

    @Test
    public void testOnArrayWithOneElementNotFound() {
        int[] a = { 1 };
        int k = 100;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(BinarySearch.NOT_FOUND, result);
    }

    @Test
    public void testOnArrayWithDuplicates() {
        int[] a = { 1, 2, 2, 2, 3, 4, 5 };
        int k = 2;
        int result = BinarySearch.binarySearch(a, k);
        assertEquals(3, result);
    }
}
