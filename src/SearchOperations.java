import java.util.Arrays;

/**
 * SearchOperations.java
 * MEMBER 1 RESPONSIBILITY: Searching implementation (Linear and Binary search).
 *
 * Operates on the data currently stored in ArrayOperations. Both search
 * methods count and report the number of comparison steps taken, so the
 * user can directly observe the difference in efficiency between the two
 * approaches (Requirement E, and feeds into Performance Comparison).
 */
public class SearchOperations {

    /** Result of a search: whether found, its index (in the SORTED array for binary search), and steps taken. */
    public static class SearchResult {
        public final boolean found;
        public final int index;
        public final int steps;
        public SearchResult(boolean found, int index, int steps) {
            this.found = found;
            this.index = index;
            this.steps = steps;
        }
    }

    /** Linear Search: checks every element one by one. O(n) worst case. */
    public static SearchResult linearSearch(int[] arr, int target) {
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            steps++;
            if (arr[i] == target) {
                return new SearchResult(true, i, steps);
            }
        }
        return new SearchResult(false, -1, steps);
    }

    /**
     * Binary Search: requires a SORTED array. Repeatedly halves the search
     * range. O(log n) worst case - far fewer steps than linear search on
     * large arrays.
     */
    public static SearchResult binarySearch(int[] sortedArr, int target) {
        int low = 0, high = sortedArr.length - 1;
        int steps = 0;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (sortedArr[mid] == target) {
                return new SearchResult(true, mid, steps);
            } else if (sortedArr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(false, -1, steps);
    }

    /** Convenience: returns a sorted copy of the array (binary search requires sorted data). */
    public static int[] sortedCopy(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
        return copy;
    }
}
