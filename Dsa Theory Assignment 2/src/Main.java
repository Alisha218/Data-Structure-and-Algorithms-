public class Main {
    // Helper method to find the index of a vertex
    public static int index(String[] vertices, String vertex) {
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i].equals(vertex)) {
                return i;
            }
        }
        return -1; // Not found
    }
    public static String BFS(int[][] adjMatrix, String[] vertices, String startVertex, String endVertex) {
        int n = vertices.length;
        boolean[] visited = new boolean[n];  // Tracks visited vertices
        int[] queue = new int[n];            // Array-based queue
        int front = 0, rear = 0;             // Queue pointers
        int[] prev = new int[n];             // To store the path
        int[] dist = new int[n];             // Distance from start vertex
        for (int i = 0; i < n; i++) {
            prev[i] = -1;  // Initialize previous vertices as -1 (no path yet)
            dist[i] = -1;  // Initialize distances as -1 (infinity)
        }

        // Find the starting and ending vertex indices
        int startIndex = index(vertices, startVertex);
        int endIndex = index(vertices, endVertex);

        if (startIndex == -1 || endIndex == -1) {
            return "Start or End vertex not found.";
        }

        // Initialize BFS
        queue[rear++] = startIndex; // Enqueue the starting vertex
        visited[startIndex] = true;
        dist[startIndex] = 0;  // Distance from start to start is 0

        // Perform BFS
        while (front < rear) {
            int current = queue[front++]; // Dequeue the vertex

            // If we reached the end vertex, stop the BFS
            if (current == endIndex) {
                break;
            }

            // Explore all neighbors of the current vertex
            for (int i = 0; i < n; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) { // Check for unvisited neighbors
                    queue[rear++] = i;  // Enqueue the neighbor
                    visited[i] = true;  // Mark as visited
                    prev[i] = current;  // Track the path
                    dist[i] = dist[current] + 1; // Update the distance
                }
            }
        }

        // Reconstruct the path from the end vertex to the start vertex
        String path = "";
        int current = endIndex;
        while (current != -1) {
            path = vertices[current] + " " + path;
            current = prev[current];
        }

        // If the start vertex is not in the path, there is no path from start to end
        if (path.trim().startsWith(startVertex)) {
            return "Shortest Path: " + path.trim() + "\nLength: " + dist[endIndex];
        } else {
            return "No path found between " + startVertex + " and " + endVertex;
        }
    }


    // DFS for traversal
    public static void DFS(int[][] adjMatrix, String[] vertices, String sVertex) {
        int n = vertices.length;
        boolean[] visited = new boolean[n]; // Tracks visited vertices
        int[] stack = new int[n];           // Array-based stack
        int top = -1;                       // Stack pointer
        String[] tOrder = new String[n];    // Array to store traversal order
        int orderIndex = 0;                 // Index to track the order of visited vertices

        // Find the starting vertex index
        int startIndex = index(vertices, sVertex);
        if (startIndex == -1) {
            System.out.println("Start vertex not found.");
            return;
        }

        // Initialize the stack with the start vertex
        stack[++top] = startIndex;

        // Perform DFS
        while (top >= 0) {
            int current = stack[top--]; // Pop the vertex from the stack

            // If not visited, visit the vertex
            if (!visited[current]) {
                visited[current] = true;
                tOrder[orderIndex++] = vertices[current]; // Store the visited vertex

                // Push all unvisited neighbors onto the stack (in reverse order to maintain correct DFS order)
                for (int i = n - 1; i >= 0; i--) {
                    if (adjMatrix[current][i] == 1 && !visited[i]) {
                        stack[++top] = i;
                    }
                }
            }
        }

        // Print the traversal order
        System.out.print("DFS Order starting from " + sVertex + ": ");
        for (int i = 0; i < orderIndex; i++) {
            System.out.print(tOrder[i] + (i < orderIndex - 1 ? " " : ""));
        }
        System.out.println();
    }

    // Cycle detection using DFS
    public static boolean hasCycle(int[][] adjMatrix, String[] vertices) {
        int n = vertices.length;
        boolean[] visited = new boolean[n];  // Tracks visited vertices
        boolean[] inRecursionStack = new boolean[n];  // Tracks vertices in the current DFS stack

        // Helper function for DFS to detect cycles
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (dfsCycleDetect(i, adjMatrix, visited, inRecursionStack)) {
                    return true;  // Cycle detected
                }
            }
        }

        return false;  // No cycle detected
    }

    // DFS helper function to detect cycles
    private static boolean dfsCycleDetect(int current, int[][] adjMatrix, boolean[] visited, boolean[] inRecursionStack) {
        // Mark the current node as visited and part of the recursion stack
        visited[current] = true;
        inRecursionStack[current] = true;

        // Check all neighbors of the current node
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[current][i] == 1) {  // If there is an edge
                if (!visited[i] && dfsCycleDetect(i, adjMatrix, visited, inRecursionStack)) {
                    return true;  // Cycle detected
                } else if (inRecursionStack[i]) {
                    return true;  // Cycle detected
                }
            }
        }

        // Backtrack: remove the current node from recursion stack
        inRecursionStack[current] = false;
        return false;
    }

    public static void main(String[] args) {
        // Vertices
        String[] vertices = {"A", "B", "C", "D", "E"};
        int n = vertices.length;

        // Initialize adjacency list as a 2D array of strings
        String[][] adjList = new String[n][n];
        int[] sizes = new int[n]; // Tracks the size of each vertex's adjacency list

        // Define edges
        String[][] edges = {
                {"A", "B"}, {"A", "C"},
                {"B", "C"}, {"B", "D"},
                {"C", "E"}
        };

        // Populate adjacency list
        for (String[] edge : edges) {
            int from = index(vertices, edge[0]);
            int to = index(vertices, edge[1]);

            adjList[from][sizes[from]++] = vertices[to];
            adjList[to][sizes[to]++] = vertices[from]; // Add reverse since it's undirected
        }

        // Print adjacency list
        System.out.println("Adjacency List:");
        for (int i = 0; i < n; i++) {
            System.out.print(vertices[i] + " -> ");
            for (int j = 0; j < sizes[i]; j++) {
                System.out.print(adjList[i][j] + " ");
            }
            System.out.println();
        }



        // Initialize adjacency matrix
        int[][] adjMatrix = new int[n][n];

        // Define edges
        String[][] edge = {
                {"A", "B"}, {"A", "C"},
                {"B", "C"}, {"B", "D"},
                {"C", "E"}
        };

        // Populate adjacency matrix
        for (String[] e : edge) {
            int from = index(vertices, e[0]);
            int to = index(vertices, e[1]);

            adjMatrix[from][to] = 1;
            adjMatrix[to][from] = 1; // Undirected graph
        }

        // Print adjacency matrix
        System.out.println("Adjacency Matrix:");


        System.out.print("  "); // Space for aligning rows and columns
        for (String vertex : vertices) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        // Print adjacency matrix with row labels
        for (int i = 0; i < n; i++) {
            System.out.print(vertices[i] + " "); // Row label
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Perform BFS
        String startVertex = "A"; String endVertex = "E";
        String traversalOrder = BFS(adjMatrix, vertices, startVertex,endVertex);
        System.out.println("BFS Order starting from " + startVertex + ":");
        System.out.println(traversalOrder);

        // Perform DFS
        String sVertex = "A";
        DFS(adjMatrix, vertices, sVertex);

        // Cycle Detection
        boolean cycleDetected = hasCycle(adjMatrix, vertices);
        System.out.println("Cycle detected: " + cycleDetected);
    }
}
