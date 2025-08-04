import java.util.*;
// Node structure for the binary tree
class Node2 {
    int data;
    Node2 left;
    Node2 right;

    // Constructor to initialize
    // the node with a value
    public Node2(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Pair<U, V> {
    U first;
    V second;

    Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    U getKey() { return first; }
    V getValue() { return second; }
}

public class topView {
    public static List<Integer> topView1(Node2 root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair<Node2, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty()) {
            Pair<Node2, Integer> pair = q.poll();
            Node2 node = pair.getKey();
            int line = pair.getValue();

            if (!mpp.containsKey(line)) {
                mpp.put(line, node.data);
            }

            // Process left child
            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }
        for (int value : mpp.values()) {
            ans.add(value);
        }
        return ans;
    }
    public static void main(String[] args) {
        // Creating a sample binary tree
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.left.left = new Node2(4);
        root.left.right = new Node2(10);
        root.left.left.right = new Node2(5);
        root.left.left.right.right = new Node2(6);
        root.right = new Node2(3);
        root.right.right = new Node2(10);
        root.right.left = new Node2(9);

        List<Integer> answer = topView1(root);

        System.out.println("Vertical Traversal: ");
        for (int node : answer) {
            System.out.print(node + " ");
        }
    }
}
