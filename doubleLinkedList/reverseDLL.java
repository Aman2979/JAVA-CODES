import java.util.Stack;

public class reverseDLL {
    int data;
    reverseDLL next;
    reverseDLL back;

    public reverseDLL(int data1, reverseDLL next1, reverseDLL back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    public reverseDLL(int data1) {
        this.data = data1;
        this.next = null;
        this.back = null;
    }

    public static reverseDLL arrayToDLL(int []arr){
        reverseDLL head = new reverseDLL(arr[0]);
        reverseDLL previous = head;
        for (int i = 1; i < arr.length; i++) {
            reverseDLL temp = new reverseDLL(arr[i], null, previous);
            previous.next = temp;
            previous = temp;
        }
        return head;
    }

    //Brute force Solution...TC = O(2n), SC = O(n)
    public static reverseDLL reverseOfDLL(reverseDLL head){
        reverseDLL temp = head;
        Stack<Integer> st = new Stack<>();
        while (temp != null){
            st.push(temp.data);               //Step 1...
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }


    //Optimal Solution...TC = O(n), SC = O(1)
    public static reverseDLL reverseTheDLL(reverseDLL head){
        if (head == null || head.next == null) {
            return head;
        }
        reverseDLL current = head;
        reverseDLL prev = null;
        while (current != null){
            prev = current.back;
            current.back = current.next;
            current.next = prev;
            current = current.back;
        }
        return prev.back;
    }

    public static void printDLL(reverseDLL head){
        while (head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int []arr = {2, 3, 5, 6, 8};
        reverseDLL head = arrayToDLL(arr);

//         head = reverseOfDLL(head);

        head = reverseTheDLL(head);

        printDLL(head);
    }
}
