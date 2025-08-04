import java.util.*;

public class traversal {
    int data;
    traversal left;
    traversal right;

    traversal(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    private static void inOrder(traversal root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    private static void preOrder(traversal root){
        if (root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void post(traversal root){
        if (root == null) return;
        post(root.left);
        post(root.right);
        System.out.print(root.data+" ");
    }

    private static List<List<Integer>> levelOrder(traversal root){
        Queue<traversal> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        queue.add(root);
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                subList.add(queue.poll().data);
            }
            list.add(subList);
        }
        return list;
    }

    public static List<Integer> withoutRecursionPreOrder(traversal root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<traversal>  stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
        }
        return list;
    }

    public static List<Integer> withoutRecursionInOrder(traversal root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<traversal>  stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) list.add(root.data);
            if (root.left != null) list.add(root.data);
        }
        return list;
    }

    public static List<Integer> withoutRecursionPostOrder(traversal root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<traversal>  stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            list.add(root.data);
            if (root.right != null) list.add(root.data);
            if (root.left != null) list.add(root.data);
        }
        return list;
    }

    public static void main(String[] args) {
        traversal root = new traversal(1);
        root.left = new traversal(2);
        root.right = new traversal(3);
        root.left.left = new traversal(4);
        root.left.right = new traversal(5);
        root.right.left = new traversal(6);
        root.right.right = new traversal(7);

        List<Integer> answer = withoutRecursionPreOrder(root);
        System.out.println(answer);
    }
}
