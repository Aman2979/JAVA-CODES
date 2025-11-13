import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class numberOfProvinces {

    public static void dfs(int node, List<List<Integer>> adjList, int[] visited) {
        visited[node] = 1;
        for (int it : adjList.get(node)) {
            if (visited[it] == 0) {
                dfs(it, adjList, visited);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();

        // initialize adjacency list
        for (int i = 0; i < m; i++) {
            adjList.add(new ArrayList<>());
        }

        // convert matrix to adjacency list
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] visited = new int[m];
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            if (visited[i] == 0) {
                cnt++;
                dfs(i, adjList, visited);
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

        int[][] graph = new int[vertices][vertices];

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        sc.close();

        System.out.println("Number of Provinces: " + findCircleNum(graph));
    }
}
