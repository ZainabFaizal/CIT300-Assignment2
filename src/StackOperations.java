import java.util.EmptyStackException;

/**
 * StackOperations.java
 * Author: Zainab Faizal - 23DA2-0874
 * Member 2 Responsibility: Stack and Queue implementation.
 *
 * A custom array-based stack (LIFO) supporting push, pop, peek, and
 * display. Handles the empty-stack condition gracefully instead of
 * crashing (Requirement: "handle conditions such as attempting to pop
 * from an empty stack").
 */
public class StackOperations {

    private int[] stackArray;
    private int top;      // index of the top element, -1 when empty
    private int capacity;

    public StackOperations() {
        this(10);
    }

    public StackOperations(int capacity) {
        this.capacity = capacity;
        this.stackArray = new int[capacity];
        this.top = -1;
    }

    public boolean isEmpty() { return top == -1; }

    private void resizeIfNeeded() {
        if (top + 1 == capacity) {
            capacity *= 2;
            int[] newArray = new int[capacity];
            System.arraycopy(stackArray, 0, newArray, 0, stackArray.length);
            stackArray = newArray;
        }
    }

    /** Push a value onto the top of the stack. */
    public void push(int value) {
        resizeIfNeeded();
        stackArray[++top] = value;
        System.out.println("Pushed " + value + " onto the stack.");
    }

    /** Pop (remove and return) the top value. Handles empty stack gracefully. */
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("ERROR: Cannot pop - the stack is empty. Push a value first.");
            return null;
        }
        int value = stackArray[top--];
        System.out.println("Popped " + value + " from the stack.");
        return value;
    }

    /** Peek at the top value without removing it. Handles empty stack gracefully. */
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("ERROR: Cannot peek - the stack is empty. Push a value first.");
            return null;
        }
        System.out.println("Top of stack: " + stackArray[top]);
        return stackArray[top];
    }

    /** Display all elements, top first. */
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("Stack (top -> bottom): [ ");
        for (int i = top; i >= 0; i--) {
            sb.append(stackArray[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append(" ]");
        System.out.println(sb);
    }
/** Returns the current number of elements in the stack. */
    public int size() { return top + 1; }
}