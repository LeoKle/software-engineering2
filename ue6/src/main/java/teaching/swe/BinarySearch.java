package teaching.swe;

public class BinarySearch {
    public static final int NOT_FOUND = -1;

    // public static int binarySearch(int[] a, int k) {
    // int ug = 0, og = a.length - 1, m, pos = NOT_FOUND;
    // while (ug <= og && pos == NOT_FOUND) {
    // m = (ug + og) / 2;
    // if (a[m] == k) {
    // pos = m;
    // } else {
    // if (a[m] < k) {
    // ug = m + 1;
    // } else {
    // og = m - 1;
    // }
    // }
    // }

    // return pos;
    // }

    public static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // prevents overflow

            if (array[mid] == target) {
                return mid; // found
            } else if (array[mid] < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        return -1; // NOT_FOUND
    }
}
