/**
 * QueueOperations.java
 * Author: Zainab Faizal - 23DA2-0874
 * MEMBER 2 RESPONSIBILITY (Part B): Queue implementation.
 *
 * A custom circular array-based queue (FIFO) supporting enqueue, dequeue,
 * peek/front, and display. Handles the empty-queue condition gracefully
 * instead of crashing (Requirement: "handle conditions such as attempting
 * to dequeue from an empty queue").
 */
public class QueueOperations {

    private int[] queueArray;
    private int front, rear, count, capacity;

    public QueueOperations() {
        this(10);
    }

    public QueueOperations(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean isEmpty() { return count == 0; }

    private void resizeIfNeeded() {
        if (count == capacity) {
            int[] newArray = new int[capacity * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = queueArray[(front + i) % capacity];
            }
            queueArray = newArray;
            front = 0;
            rear = count - 1;
            capacity *= 2;
        }
    }

    /** Add a value to the back of the queue. */
    public void enqueue(int value) {
        resizeIfNeeded();
        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        count++;
        System.out.println("Enqueued " + value + ".");
    }

    /** Remove and return the value at the front of the queue. Handles empty queue gracefully. */
    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("ERROR: Cannot dequeue - the queue is empty. Enqueue a value first.");
            return null;
        }
        int value = queueArray[front];
        front = (front + 1) % capacity;
        count--;
        System.out.println("Dequeued " + value + ".");
        return value;
    }

    /** View the front value without removing it. Handles empty queue gracefully. */
    public Integer peekFront() {
        if (isEmpty()) {
            System.out.println("ERROR: Cannot peek - the queue is empty. Enqueue a value first.");
            return null;
        }
        System.out.println("Front of queue: " + queueArray[front]);
        return queueArray[front];
    }

    /** Display all elements, front first. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Queue (front -> rear): [ ");
        for (int i = 0; i < count; i++) {
            sb.append(queueArray[(front + i) % capacity]);
            if (i < count - 1) sb.append(", ");
        }
        sb.append(" ]");
        System.out.println(sb);
    }
/** Returns the current number of elements in the queue. */
    public int size() { return count; }
}
