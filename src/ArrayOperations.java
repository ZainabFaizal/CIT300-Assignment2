/**
 * ArrayOperations.java
 * Author: Ramla Rishad - 23DA2-0925
 * MEMBER 1 RESPONSIBILITY: Array implementation.
 *
 * A dynamically resizing integer array supporting insert, delete, search,
 * and display. Built on a raw int[] (not ArrayList) to demonstrate manual
 * array management as required by the assignment.
 */
public class ArrayOperations {

    private int[] data;
    private int size;

    public ArrayOperations() {
        this(10);
    }

    public ArrayOperations(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    private void resizeIfNeeded() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    /** Insert a value at the end of the array. */
    public void insert(int value) {
        resizeIfNeeded();
        data[size++] = value;
        System.out.println("Inserted " + value + " at index " + (size - 1) + ".");
    }

    /** Delete the first occurrence of a value. Shifts remaining elements left. */
    public boolean delete(int value) {
        int idx = linearIndexOf(value);
        if (idx == -1) {
            System.out.println("ERROR: Value " + value + " not found in array.");
            return false;
        }
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println("Deleted " + value + " from the array.");
        return true;
    }

    /** Linear search for a value. Returns its index, or -1 if not found. */
    public int search(int value) {
        int idx = linearIndexOf(value);
        if (idx == -1) System.out.println("Value " + value + " not found.");
        else System.out.println("Value " + value + " found at index " + idx + ".");
        return idx;
    }

    private int linearIndexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    /** Display all current elements. */
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append(" ]");
        System.out.println("Array contents: " + sb);
    }

    /** Returns a copy of the current elements (used by SearchOperations / PerformanceComparison). */
    public int[] toArray() {
        int[] copy = new int[size];
        System.arraycopy(data, 0, copy, 0, size);
        return copy;
    }

    public int size() { return size; }
}
