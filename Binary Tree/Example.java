import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Example {
    int data;
    Example left;
    Example right;
    Example(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static List<Integer> reverse(List<Integer> temp){
        int n = temp.size();
        int left = 0;
        int right = n-1;
        while (left < n/2){
            int val = temp.get(0);
            temp.set(left, temp.get(right));
            temp.set(right, val);
            left++;
            right--;
        }
        return temp;
    }
    public static List<List<Integer>> zigZag(Example node, int flag){
        List<List<Integer>> ans = new ArrayList<>();
        if (node == null) return ans;
        Queue<Example> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Example tempNode = queue.poll();
                temp.add(tempNode.data);
                if (tempNode.left != null) queue.offer(tempNode.left);
                if (tempNode.right != null) queue.offer(tempNode.right);
            }
            if (flag == 0){
                ans.add(temp);
                flag = 1;
            }else {
                ans.add(reverse(temp));
                flag = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Example node = new Example(1);
        node.left = new Example(2);
        node.right = new Example(3);
        node.left.left = new Example(4);
        node.left.right = new Example(5);
        node.right.left = new Example(6);
        node.right.right = new Example(7);
        node.left.left.left = new Example(8);
        node.left.left.right = new Example(9);
        node.left.right.left = new Example(10);
        System.out.println(zigZag(node, 0));
    }
}
