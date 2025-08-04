import java.util.LinkedList;
import java.util.Queue;

public class basicQue {
    static class que{
        int size = 10;
        int []arr = new int[size];
        int top = -1;
        int currSize = 0;
        int start = top;
        int end = top;

         void push(int x){
            if (currSize == size){
                System.out.println("Space no Available");
            } else if (currSize == 0) {
                start = end = 0;
            }else {
                end = (end+1)%size;
                arr[end] = x;
                currSize++;
            }
         }

         int pop(){
             if (currSize == 0){
                 System.out.println("No Element Available");
             }
             int el = arr[start];
             if (currSize == 1) {
                 start = end = -1;
             }else {
                 start = (start+1)%size;
                 currSize--;
                 return el;
             }
             return -1;
         }

         int top(){
             if(currSize == 0) {
                 return arr[start];
             }
             return -1;
         }

         int sizeAfterOp(){
             return currSize;
         }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println("Popped: " + queue.poll()); // Removes top element
        System.out.println("Top element (peek): " + queue.peek());
        System.out.println("Top element (peek): " + queue.peek());
        System.out.println("Popped: " + queue.poll());
        queue.add(5);
        System.out.println("Top element (peek): " + queue.peek());
        System.out.println("Queue size: " + queue.size());
    }
}
