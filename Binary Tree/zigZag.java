import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigZag {
    int data;
    zigZag left;
    zigZag right;

    zigZag(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static List<List<Integer>> zigZagTraversal(zigZag root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<zigZag> queue = new LinkedList<>();
        boolean flag = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                zigZag node = queue.poll();

                // Insert in normal or reverse order
                if (flag) {
                    row.add(node.data);
                } else {
                    row.add(0, node.data);
                }

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            flag = !flag;
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        zigZag root = new zigZag(1);
        root.left = new zigZag(2);
        root.right = new zigZag(3);
        root.left.left = new zigZag(4);
        root.left.right = new zigZag(5);
        root.right.left = new zigZag(6);
        root.right.right = new zigZag(7);

        List<List<Integer>> answer = zigZagTraversal(root);
        System.out.println(answer);
    }
}