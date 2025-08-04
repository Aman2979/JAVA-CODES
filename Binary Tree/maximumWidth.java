import java.util.LinkedList;
import java.util.Queue;

class node1{
    int data;
    node1 left;
    node1 right;

    node1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class pair<U, V>{
    U first;
    V second;

    pair(U first, V second) {
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

class findTheAns{
//    public static int function(node1 root){
//        if (root == null) return 0;
//        int ans = 0;
//        Queue<pair<U, V> queue = new LinkedList<>();
//        queue.offer(new pair(root,0));
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            int min = queue.peek().num;
//            int first = 0, last = 0;
//            for (int i = 0; i < size; i++) {
//                pair currentPair = queue.poll();  // Use poll() only once
////                int currentIndex = currentPair.num - min; // Normalize index
////                node1 node = currentPair.node;
//                if (i == 0) first = currentIndex;
//                if (i == size-1) last = currentIndex;
//                if (node.left != null){
//                    queue.offer(new pair(node.left, currentIndex*2+1));
//                }
//                if (node.right != null){
//                    queue.offer(new pair(node.right, currentIndex*2+2));
//                }
//                ans = Math.max(ans, last-first+1);
//            }
//        }
//        return ans;
//    }
}
public class maximumWidth {
    public static void main(String[] args) {
        node1 root = new node1(1);
        root.left = new node1(2);
        root.right = new node1(3);
        root.left.left = new node1(4);
        root.left.right = new node1(5);
        root.left.right.left = new node1(8);
        root.left.right.right = new node1(9);
        root.right.left = new node1(6);
        root.right.right = new node1(7);

//        System.out.println(findTheAns.function(root));
    }
}
