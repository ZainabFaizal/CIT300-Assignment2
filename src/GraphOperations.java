import java.util.*;

/**
 * GraphOperations.java
 * Author: Jawhitu Fathim Rifna - 23DA2-0842
 * Member 4 Responsibility: Graph implementation and traversal (BFS/DFS).
 */
public class GraphOperations {

    private final Map<String, LinkedHashSet<String>> adjList = new LinkedHashMap<>();

    /** Add a vertex to the graph. */
    public boolean addVertex(String vertex) {
        if (vertex == null || vertex.trim().isEmpty()) {
            System.out.println("ERROR: Vertex name cannot be empty.");
            return false;
        }
        if (adjList.containsKey(vertex)) {
            System.out.println("ERROR: Vertex '" + vertex + "' already exists.");
            return false;
        }
        adjList.put(vertex, new LinkedHashSet<>());
        System.out.println("Vertex '" + vertex + "' added.");
        return true;
    }

    /** Add an undirected edge between two vertices. */
    public boolean addEdge(String vertexA, String vertexB) {
        if (vertexA == null || vertexB == null || vertexA.trim().isEmpty() || vertexB.trim().isEmpty()) {
            System.out.println("ERROR: Vertex names cannot be empty.");
            return false;
        }
        if (!adjList.containsKey(vertexA) || !adjList.containsKey(vertexB)) {
            System.out.println("ERROR: Both vertices must exist before adding an edge.");
            return false;
        }
        if (vertexA.equals(vertexB)) {
            System.out.println("ERROR: A vertex cannot connect to itself.");
            return false;
        }
        adjList.get(vertexA).add(vertexB);
        adjList.get(vertexB).add(vertexA);
        System.out.println("Edge added between '" + vertexA + "' and '" + vertexB + "'.");
        return true;
    }

    /** Display the whole graph as an adjacency list. */
    public void display() {
        if (adjList.isEmpty()) {
            System.out.println("Graph has no vertices yet.");
            return;
        }
        System.out.println("---- Graph (Adjacency List) ----");
        for (String vertex : adjList.keySet()) {
            System.out.println(vertex + " -> " + adjList.get(vertex));
        }
    }

    /** Result of a traversal: the order visited, and the number of steps (vertices processed). */
    public static class TraversalResult {
        public final List<String> order;
        public final int steps;
        public TraversalResult(List<String> order, int steps) {
            this.order = order;
            this.steps = steps;
        }
    }

    /** Breadth-First Search traversal from a start vertex. */
    public TraversalResult bfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adjList.containsKey(start)) {
            System.out.println("ERROR: Starting vertex '" + start + "' does not exist.");
            return new TraversalResult(order, 0);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int steps = 0;
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            steps++;
            order.add(current);
            for (String neighbour : adjList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        return new TraversalResult(order, steps);
    }

    /** Depth-First Search traversal from a start vertex. */
    public TraversalResult dfs(String start) {
        List<String> order = new ArrayList<>();
        if (!adjList.containsKey(start)) {
            System.out.println("ERROR: Starting vertex '" + start + "' does not exist.");
            return new TraversalResult(order, 0);
        }
        Set<String> visited = new HashSet<>();
        int[] steps = {0};
        dfsHelper(start, visited, order, steps);
        return new TraversalResult(order, steps[0]);
    }

    private void dfsHelper(String current, Set<String> visited, List<String> order, int[] steps) {
        visited.add(current);
        steps[0]++;
        order.add(current);
        for (String neighbour : adjList.get(current)) {
            if (!visited.contains(neighbour)) {
                dfsHelper(neighbour, visited, order, steps);
            }
        }
    }

    public boolean hasVertex(String vertex) {
        return adjList.containsKey(vertex);
    }

    public Set<String> getAllVertices() {
        return new LinkedHashSet<>(adjList.keySet());
    }
}
