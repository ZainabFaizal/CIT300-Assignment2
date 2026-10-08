/**
 * Author: MMF.Shazna - 23DA2-0639
 * LinkedListOperations.java
 * MEMBER 3 RESPONSIBILITY: Linked List implementation.
 *
 * A custom singly linked list of integers supporting insert, delete,
 * search, and display.
 */
public class LinkedListOperations {

    private static class Node {
        // Each node stores one integer and a reference to the next node.
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public int size() { return size; }

    /** Insert a value at the end of the list. */
    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
        System.out.println("Inserted " + value + " into the linked list.");
    }

    /** Delete the first occurrence of a value. */
    public boolean delete(int value) {
        Node prev = null, temp = head;
        while (temp != null) {
            if (temp.data == value) {
                if (prev == null) head = temp.next;
                else prev.next = temp.next;
                size--;
                System.out.println("Deleted " + value + " from the linked list.");
                return true;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println("ERROR: Value " + value + " not found in linked list.");
        return false;
    }

    /** Search for a value. Returns its position (0-indexed), or -1 if not found. */
    public int search(int value) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Value " + value + " found at position " + position + ".");
                return position;
            }
            temp = temp.next;
            position++;
        }
        System.out.println("Value " + value + " not found in linked list.");
        return -1;
    }

    /** Display all elements in order. */
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Linked List: ");
        Node temp = head;
        while (temp != null) {
            sb.append(temp.data);
            if (temp.next != null) sb.append(" -> ");
            temp = temp.next;
        }
        System.out.println(sb);
    }
}
