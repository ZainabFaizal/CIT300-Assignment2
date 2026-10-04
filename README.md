# CIT300 – Data Structure and Graph Performance Analyzer

Graded Practical Assignment 2 (Week 12) — Data Structures and Algorithms

## Project Description
A Java console application demonstrating the practical use of arrays, stacks, queues,
linked lists, searching algorithms (linear and binary), and graphs (with BFS/DFS
traversal), along with a performance comparison module that reports step counts and
execution time for different algorithmic approaches.

## Group Members

| Student Name | Student ID | Assigned Responsibility | Individual Contribution |
|---|---|---|---|
| M. R. F. Ramla | 23DA2-0925 | Array and Searching implementation | Implemented ArrayOperations.java (insert/delete/search/display) and SearchOperations.java (Linear Search and Binary Search with step counting) |
| M. F. F. Zainab | 23DA2-0874 | Stack and Queue implementation | Implemented StackOperations.java (push/pop/peek/display, empty-stack handling) and QueueOperations.java (enqueue/dequeue/peek/display, empty-queue handling) |
| M. M. F. Shazna | 23DA2-0639 | Linked List implementation | Implemented LinkedListOperations.java (insert/delete/search/display) |
| J. F. Rifna | 23DA2-0842 | Graph implementation and traversal | Implemented GraphOperations.java (add vertex/edge, display, BFS and DFS traversal with step counting) |
| All members | — | Performance comparison, main menu, integration and testing | Jointly built PerformanceComparison.java and Main.java, tested all menu paths, wrote README |

## Technologies Used
- Java (console-based application)
- No external libraries — all data structures implemented manually

## Main System Features
- Array: insert, delete, search, display
- Stack: push, pop, peek, display (handles empty stack)
- Queue: enqueue, dequeue, peek/front, display (handles empty queue)
- Linked List: insert, delete, search, display
- Searching: Linear Search and Binary Search, with step-count comparison
- Graph: add vertex, add edge, display, BFS traversal, DFS traversal
- Performance Comparison: compares Linear vs Binary Search and BFS vs DFS, reporting
  step counts and execution time, with an explanation of the complexity difference

## How to Compile & Run

```bash
cd src
javac *.java -d ../bin
cd ../bin
java Main
```

## Project Structure

```
CIT300_Assignment2/
├── README.md
└── src/
    ├── ArrayOperations.java        (Member 1 – array)
    ├── SearchOperations.java       (Member 1 – searching)
    ├── StackOperations.java        (Member 2 – stack)
    ├── QueueOperations.java        (Member 2 – queue)
    ├── LinkedListOperations.java   (Member 3 – linked list)
    ├── GraphOperations.java        (Member 4 – graph / BFS / DFS)
    ├── PerformanceComparison.java  (All members – performance/complexity)
    └── Main.java                   (All members – menu & integration)
```
