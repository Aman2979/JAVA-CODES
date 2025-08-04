import java.util.List;
import java.util.*;
import java.util.*;

// Node class for the binary tree
class Node1 {
    int data;
    Node1 left;
    Node1 right;

    // Constructor to initialize
    // the node with a value
    public Node1(int val) {
        data = val;
        left = null;
        right = null;
    }
}
public class verticalOrderTraversal {
    public List<List<Integer>> findVertical(Node1 root) {
        Map<Integer, Map<Integer, TreeSet<Integer>>> nodes = new TreeMap<>();
        Queue<Pair<Node1, Pair<Integer, Integer>>> todo = new LinkedList<>();

        todo.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!todo.isEmpty()) {
            Pair<Node1, Pair<Integer, Integer>> p = todo.poll();
            Node1 temp = p.getKey();

            // x -> vertical, y -> level
            int x = p.getValue().getKey();
            int y = p.getValue().getValue();

            nodes.computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(y, k -> new TreeSet<>())
                    .add(temp.data);

            // Process left child
            if (temp.left != null) {
                todo.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
            }

            // Process right child
            if (temp.right != null) {
                todo.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
            }
        }

        // Convert map to answer format
        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, TreeSet<Integer>> levelMap : nodes.values()) {
            List<Integer> col = new ArrayList<>();
            for (TreeSet<Integer> set : levelMap.values()) {
                col.addAll(set);
            }
            ans.add(col);
        }

        return ans;
    }



    public static void main(String[] args) {
        // Creating a sample binary tree
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.left.left = new Node1(4);
        root.left.right = new Node1(10);
        root.left.left.right = new Node1(5);
        root.left.left.right.right = new Node1(6);
        root.right = new Node1(3);
        root.right.right = new Node1(10);
        root.right.left = new Node1(9);
    }
}
