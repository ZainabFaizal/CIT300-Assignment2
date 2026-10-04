/**
 * PerformanceComparison.java
 * ALL MEMBERS RESPONSIBILITY: Performance / complexity demonstration.
 *
 * Compares Linear Search vs Binary Search (number of comparison steps and
 * execution time), and BFS vs DFS traversal (number of steps). Results
 * are stored so they can be displayed later via menu option 8.
 */
public class PerformanceComparison {

    private String lastSearchSummary = "No search comparison run yet.";
    private String lastGraphSummary = "No graph traversal comparison run yet.";

    /**
     * Runs Linear Search and Binary Search for the same target on the same
     * data set, and reports steps taken and execution time for each.
     */
    public void compareSearches(int[] data, int target) {
        if (data.length == 0) {
            System.out.println("Cannot compare - the array is empty. Insert some values first.");
            return;
        }

        long startLinear = System.nanoTime();
        SearchOperations.SearchResult linearResult = SearchOperations.linearSearch(data, target);
        long linearTimeNs = System.nanoTime() - startLinear;

        int[] sorted = SearchOperations.sortedCopy(data);
        long startBinary = System.nanoTime();
        SearchOperations.SearchResult binaryResult = SearchOperations.binarySearch(sorted, target);
        long binaryTimeNs = System.nanoTime() - startBinary;

        System.out.println("=============================================");
        System.out.println(" PERFORMANCE COMPARISON - SEARCHING");
        System.out.println("=============================================");
        System.out.printf("%-20s %-15s %-10s %-15s%n", "Operation", "Algorithm", "Steps", "Time (ns)");
        System.out.println("------------------------------------------------");
        System.out.printf("%-20s %-15s %-10d %-15d%n", "Search", "Linear Search", linearResult.steps, linearTimeNs);
        System.out.printf("%-20s %-15s %-10d %-15d%n", "Search", "Binary Search", binaryResult.steps, binaryTimeNs);
        System.out.println("=============================================");

        lastSearchSummary = String.format(
            "Last search comparison (target=%d, n=%d): Linear Search took %d step(s); " +
            "Binary Search took %d step(s) on the sorted array. " +
            "Binary Search uses fewer steps on larger datasets because it discards half " +
            "the remaining elements each comparison (O(log n)), while Linear Search may " +
            "need to check every element (O(n)).",
            target, data.length, linearResult.steps, binaryResult.steps
        );

        System.out.println();
        System.out.println("Explanation: Linear Search checks elements one by one (O(n) worst case),");
        System.out.println("while Binary Search repeatedly halves the search range on a SORTED array");
        System.out.println("(O(log n) worst case) - which is why it typically takes far fewer steps");
        System.out.println("as the dataset grows larger.");
    }

    /**
     * Runs BFS and DFS from the same starting vertex on the same graph,
     * and reports the number of steps (vertices visited) for each.
     */
    public void compareTraversals(GraphOperations graph, String start) {
        if (!graph.hasVertex(start)) {
            System.out.println("ERROR: Starting vertex '" + start + "' does not exist. Add vertices first.");
            return;
        }

        GraphOperations.TraversalResult bfsResult = graph.bfs(start);
        GraphOperations.TraversalResult dfsResult = graph.dfs(start);

        System.out.println("=============================================");
        System.out.println(" PERFORMANCE COMPARISON - GRAPH TRAVERSAL");
        System.out.println("=============================================");
        System.out.printf("%-20s %-15s %-10s%n", "Operation", "Algorithm", "Steps");
        System.out.println("------------------------------------------------");
        System.out.printf("%-20s %-15s %-10d%n", "Graph Traversal", "BFS", bfsResult.steps);
        System.out.printf("%-20s %-15s %-10d%n", "Graph Traversal", "DFS", dfsResult.steps);
        System.out.println("=============================================");
        System.out.println("BFS order: " + bfsResult.order);
        System.out.println("DFS order: " + dfsResult.order);

        lastGraphSummary = String.format(
            "Last graph traversal comparison (start=%s): BFS visited %d vertex/vertices " +
            "in order %s; DFS visited %d vertex/vertices in order %s. Both visit every " +
            "reachable vertex exactly once (O(V + E)), but explore in a different order: " +
            "BFS expands outward level by level using a queue, while DFS goes as deep as " +
            "possible down one path first using recursion/a stack.",
            start, bfsResult.steps, bfsResult.order, dfsResult.steps, dfsResult.order
        );

        System.out.println();
        System.out.println("Explanation: BFS and DFS both visit every reachable vertex exactly once,");
        System.out.println("so their STEP COUNTS are usually identical for the same connected graph.");
        System.out.println("The real difference is the ORDER they visit vertices in and how they use");
        System.out.println("memory - BFS uses a queue (level by level), DFS uses recursion/a stack");
        System.out.println("(goes deep before backtracking). Both run in O(V + E) time.");
    }

    /** Requirement (menu item 8): Display all results gathered so far. */
    public void displayAllResults() {
        System.out.println("=============================================");
        System.out.println(" ALL PERFORMANCE RESULTS");
        System.out.println("=============================================");
        System.out.println(lastSearchSummary);
        System.out.println();
        System.out.println(lastGraphSummary);
    }
}
