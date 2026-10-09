import java.util.Scanner;

/**
 * Main.java
 * ALL MEMBERS RESPONSIBILITY: Main menu, integration, input validation.
 *
 * Wires together everyone's components:
 *   Member 1 -> ArrayOperations, SearchOperations
 *   Member 2 -> StackOperations, QueueOperations     (this file's author on your team)
 *   Member 3 -> LinkedListOperations
 *   Member 4 -> GraphOperations
 *   All      -> PerformanceComparison
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    private static final ArrayOperations arrayOps = new ArrayOperations();
    private static final StackOperations stackOps = new StackOperations();
    private static final QueueOperations queueOps = new QueueOperations();
    private static final LinkedListOperations linkedListOps = new LinkedListOperations();
    private static final GraphOperations graphOps = new GraphOperations();
    private static final PerformanceComparison performance = new PerformanceComparison();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> arrayMenu();
                case 2 -> stackMenu();
                case 3 -> queueMenu();
                case 4 -> linkedListMenu();
                case 5 -> searchMenu();
                case 6 -> graphMenu();
                case 7 -> performanceMenu();
                case 8 -> performance.displayAllResults();
                case 9 -> {
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please select a number between 1 and 9.");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void printMainMenu() {
        System.out.println("=============================================");
        System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("=============================================");
        System.out.println("1. Array Operations");
        System.out.println("2. Stack Operations");
        System.out.println("3. Queue Operations");
        System.out.println("4. Linked List Operations");
        System.out.println("5. Searching Operations");
        System.out.println("6. Graph Operations");
        System.out.println("7. Performance Comparison");
        System.out.println("8. Display All Results");
        System.out.println("9. Exit");
    }

    // ---------------- Array submenu (Member 1) ----------------
    private static void arrayMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> arrayOps.insert(readInt("Enter value to insert: "));
                case 2 -> arrayOps.delete(readInt("Enter value to delete: "));
                case 3 -> arrayOps.search(readInt("Enter value to search: "));
                case 4 -> arrayOps.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Stack submenu (Member 2) ----------------
    private static void stackMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> stackOps.push(readInt("Enter value to push: "));
                case 2 -> stackOps.pop();
                case 3 -> stackOps.peek();
                case 4 -> stackOps.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Queue submenu (Member 2) ----------------
    private static void queueMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek/Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> queueOps.enqueue(readInt("Enter value to enqueue: "));
                case 2 -> queueOps.dequeue();
                case 3 -> queueOps.peekFront();
                case 4 -> queueOps.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Linked List submenu (Member 3) ----------------
    private static void linkedListMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("------------ LINKED LIST OPERATIONS ---------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> linkedListOps.insert(readInt("Enter value to insert: "));
                case 2 -> linkedListOps.delete(readInt("Enter value to delete: "));
                case 3 -> linkedListOps.search(readInt("Enter value to search: "));
                case 4 -> linkedListOps.display();
                case 5 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Searching submenu (Member 1) ----------------
    private static void searchMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("------------- SEARCHING OPERATIONS ----------");
            System.out.println("1. Linear Search (uses current Array data)");
            System.out.println("2. Binary Search (uses current Array data, sorted)");
            System.out.println("3. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            int[] data = arrayOps.toArray();
            switch (choice) {
                case 1 -> {
                    int target = readInt("Enter value to search for: ");
                    SearchOperations.SearchResult r = SearchOperations.linearSearch(data, target);
                    System.out.println(r.found
                            ? "Found at index " + r.index + " (" + r.steps + " step(s))."
                            : "Not found (" + r.steps + " step(s)).");
                }
                case 2 -> {
                    int target = readInt("Enter value to search for: ");
                    int[] sorted = SearchOperations.sortedCopy(data);
                    SearchOperations.SearchResult r = SearchOperations.binarySearch(sorted, target);
                    System.out.println(r.found
                            ? "Found at index " + r.index + " in sorted array (" + r.steps + " step(s))."
                            : "Not found (" + r.steps + " step(s)).");
                }
                case 3 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Graph submenu (Member 4) ----------------
    private static void graphMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("--------------- GRAPH OPERATIONS ------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> graphOps.addVertex(readNonEmpty("Enter vertex name: "));
                case 2 -> {
                    String a = readNonEmpty("Enter first vertex: ");
                    String b = readNonEmpty("Enter second vertex: ");
                    graphOps.addEdge(a, b);
                }
                case 3 -> graphOps.display();
                case 4 -> {
                    String start = readNonEmpty("Enter starting vertex: ");
                    GraphOperations.TraversalResult r = graphOps.bfs(start);
                    if (!r.order.isEmpty()) System.out.println("BFS order: " + r.order + " (" + r.steps + " step(s))");
                }
                case 5 -> {
                    String start = readNonEmpty("Enter starting vertex: ");
                    GraphOperations.TraversalResult r = graphOps.dfs(start);
                    if (!r.order.isEmpty()) System.out.println("DFS order: " + r.order + " (" + r.steps + " step(s))");
                }
                case 6 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Performance Comparison submenu (All members) ----------------
    private static void performanceMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("---------- PERFORMANCE COMPARISON -----------");
            System.out.println("1. Compare Linear vs Binary Search (uses current Array data)");
            System.out.println("2. Compare BFS vs DFS Traversal (uses current Graph data)");
            System.out.println("3. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> {
                    int target = readInt("Enter value to search for: ");
                    performance.compareSearches(arrayOps.toArray(), target);
                }
                case 2 -> {
                    String start = readNonEmpty("Enter starting vertex: ");
                    performance.compareTraversals(graphOps, start);
                }
                case 3 -> back = true;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ---------------- Input validation helpers ----------------

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
