import java.util.*;

public class BFS {
    public static List<Integer> bfs(int vertices, List<List<Integer>> graph) {
        int[] visited = new int[vertices + 1];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);

            for (int it : graph.get(node)) {
                if (visited[it] == 0) {
                    visited[it] = 1;
                    queue.offer(it);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of edges: ");
        int edge = sc.nextInt();
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        sc.close();

        List<Integer> ans = bfs(vertices, graph);
        System.out.println("BFS traversal:");
        for (int node : ans) {
            System.out.print(node + " ");
        }
    }
}
