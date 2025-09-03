import java.util.LinkedList;
import java.util.Queue;

public class WidthBT {
    int data;
    WidthBT left;
    WidthBT right;
    WidthBT(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    static class Pair{
        WidthBT node;
        int num;
        Pair(WidthBT node, int num){
            this.node = node;
            this.num = num;
        }
    }

    public static int width(WidthBT root){
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int curr = queue.peek().num - min;
                WidthBT node = queue.peek().node;
                queue.poll();
                if (i == 0) first = curr;
                if (i == size-1) last = curr;
                if (node.left != null){
                    queue.offer(new Pair(node.left, curr*2+1));
                }
                if (node.right != null){
                    queue.offer(new Pair(node.right, curr*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        WidthBT root = new WidthBT(5);
        root.left = new WidthBT(1);
        root.right = new WidthBT(2);
        root.left.left = new WidthBT(8);
        root.right.left = new WidthBT(4);
        root.right.right = new WidthBT(5);
        root.left.left.right = new WidthBT(6);
        System.out.println(width(root));
    }
}
