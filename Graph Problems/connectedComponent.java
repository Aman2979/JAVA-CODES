import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class ConnectedComponent {

    // DFS helper function
    public static void helper(int starting, List<List<Integer>> edges, int[] visited) {
        visited[starting] = 1;
        for (int it : edges.get(starting)) {
            if (visited[it] == 0) {
                helper(it, edges, visited);
            }
        }
    }

    // Function to count connected components
    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        int[] visited = new int[V];
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                cnt++;
                helper(i, edges, visited);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        // Initialize adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); // undirected
        }

        sc.close();

        // Use correct V value
        int V = vertices;
        System.out.println("Number of connected components: " + findNumberOfComponent(V, graph));
    }
}
