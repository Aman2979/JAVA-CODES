import java.util.LinkedList;
import java.util.Queue;

public class stackUsingQueue {
    static class st{
        Queue<Integer> queue = new LinkedList<>();

        void push(int x){
            int s = queue.size();
            queue.add(x);
            for (int i = 1; i < s; i++) {
                queue.add(queue.peek());
                queue.poll();
            }
        }
        void pop(){
            queue.poll();
        }

        int top(){
            return queue.peek();
        }
    }

    public static void main(String[] args) {

    }
}
