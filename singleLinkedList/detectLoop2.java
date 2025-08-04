import java.util.HashMap;
import java.util.Map;

public class detectLoop2 {
    int data;
    detectLoop2 next;

    public detectLoop2(int data, detectLoop2 next) {
        this.data = data;
        this.next = next;
    }

    public detectLoop2(int data) {
        this.data = data;
        next = null;
    }

    public static detectLoop2 convertArrayIntoLinkedList(int []arr){
        detectLoop2 head = new detectLoop2(arr[0]);
        detectLoop2 mover = head;
        for (int i = 1; i < arr.length; i++){
            detectLoop2 temp = new detectLoop2(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

//    Brute Force Solution...
    public static detectLoop2 detectLoopInLL(detectLoop2 head){
        Map<detectLoop2, Integer> map = new HashMap<>();
        detectLoop2 temp = head;
        while (temp != null){
            if (map.equals(temp)){
                return temp;
            }
            map.put(temp,1);
            temp = temp.next;
        }
        return null;
    }

//    Optimal Solution...
    public static detectLoop2 detectLoopInStartingPoint(detectLoop2 head){
        detectLoop2 slow = head;
        detectLoop2 fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }

    public static void printLL(int []arr, detectLoop2 head){
        detectLoop2 temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {3,2,0,-4};
        detectLoop2 y = new detectLoop2(arr[2]);
        detectLoop2 head = convertArrayIntoLinkedList(arr);

        head = detectLoopInLL(head);

//        printLL(arr, head);
    }
}
