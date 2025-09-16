import java.util.Stack;

public class Example {
    int data;
    Example next;
    Example prev;

    Example(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Example(int data, Example next, Example prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public static Example arrayToDll(int []arr){
        Example newHead = new Example(arr[0]);
        Example current = newHead;
        for (int i = 1; i < arr.length; i++) {
            Example newNode = new Example(arr[i]);
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        return newHead;
    }

    public static Example reverseDll(Example head){
        if (head == null || head.next == null) return head;
        Stack<Integer> stack = new Stack<>();
        Example temp = head;

        // For my stack
        while (temp != null){
            stack.add(temp.data);
            temp = temp.next;
        }

        // Now real logic
        Example temp1 = head;
        while (temp1 != null){
            temp1.data = stack.pop();
            temp1 = temp1.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3};
        Example head = arrayToDll(arr);
        Example newHead = reverseDll(head);
        Example temp = head;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
