import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    public static void dfs(int node, int []visited, List<List<Integer>> graph, List<Integer> ans){
        visited[node] = 1;
        ans.add(node);
        for (int it : graph.get(node)){
            if (visited[it] == 0){
                dfs(it, visited, graph, ans);
            }
        }
    }
    public static List<Integer> dfsTraversal(int v, List<List<Integer>> graph){
        List<Integer> ans = new ArrayList<>();
        int []visited = new int[v];
        dfs(0, visited, graph, ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the edge: ");
        int edge = sc.nextInt();
        System.out.print("Enter the vertices: ");
        int vertices = sc.nextInt();;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 1; i <= vertices; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter u & v: ");
        for (int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        sc.close();

        List<Integer> finalAnswer = dfsTraversal(edge, graph);
        for (int i = 0; i < finalAnswer.size(); i++) {
            System.out.print(finalAnswer.get(i)+" ");
        }
    }
}
