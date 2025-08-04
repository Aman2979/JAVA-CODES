import java.util.Stack;

public class reverseLL {
    int data;
    reverseLL next;

    reverseLL(int data, reverseLL next) {
        this.data = data;
        this.next = next;
    }

    reverseLL(int data) {
        this.data = data;
        next = null;
    }

    public static reverseLL convertArrayIntoLinkedList(int []arr){
        reverseLL head = new reverseLL(arr[0]);
        reverseLL mover = head;
        for (int i = 1; i < arr.length; i++){
            reverseLL temp = new reverseLL(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //Brute force Solution...TC = O(2n), SC = O(n)
    public static reverseLL reverseOfLL(reverseLL head){
        reverseLL temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null){
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null){
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    // Optimal 1 Solution...TC = O(n), SC = O(1)
    public static reverseLL reverseOfTheLL(reverseLL head){
        reverseLL temp = head;
        reverseLL prev = null;
        while (temp != null){
            reverseLL front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    // Optimal 2 Solution...TC = O(n), SC = O(n)...
    public static reverseLL reverseOfALL(reverseLL head){
        if (head == null || head.next == null){
            return head;
        }
        reverseLL newHead = reverseOfALL(head.next);
        reverseLL front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void printLL(int []arr, reverseLL head){
        reverseLL temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 6, 8};
//        reverseLL y = new reverseLL(arr[2]);
        reverseLL head = convertArrayIntoLinkedList(arr);

        head = reverseOfALL(head);

        printLL(arr, head);

    }
}
