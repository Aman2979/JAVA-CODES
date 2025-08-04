import java.util.*;

class node{
    int data;
    node left;
    node right;

    node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Pair1<U, V>{
    U first;
    V second;

    Pair1(U first, V second) {
        this.first = first;
        this.second = second;
    }

    U getKey(){
        return first;
    }

    V getValue(){
        return second;
    }
}

class bottomViewFinder{
    public static ArrayList<Integer> function(node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair1<node, Integer>> queue = new LinkedList<>();

        queue.add(new Pair1<>(root, 0));

        while (!queue.isEmpty()){
            Pair1<node, Integer> pair1 = queue.poll();
            node temp = pair1.getKey();
            int line = pair1.getValue();
            map.put(line, temp.data);
            if (temp.left != null) {
                queue.add(new Pair1<>(temp.left, line - 1));
            }
            if (temp.right != null) {
                queue.add(new Pair1<>(temp.right, line + 1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}

public class bottomView {
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.left.right.left = new node(8);
        root.left.right.right = new node(9);
        root.right.left = new node(6);
        root.right.right = new node(7);

        System.out.println(bottomViewFinder.function(root));
    }
}
