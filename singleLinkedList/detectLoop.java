public class detectLoop {
    int data;
    detectLoop next;

    public detectLoop(int data, detectLoop next) {
        this.data = data;
        this.next = next;
    }

    public detectLoop(int data) {
        this.data = data;
        next = null;
    }

    public static detectLoop convertArrayIntoLinkedList(int []arr){
        detectLoop head = new detectLoop(arr[0]);
        detectLoop mover = head;
        for (int i = 1; i < arr.length; i++){
            detectLoop temp = new detectLoop(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static boolean detectLoopInLL(detectLoop head){
        detectLoop slow = head;
        detectLoop fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void printLL(int []arr, detectLoop head){
        detectLoop temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {3,2,0,-4};
        detectLoop y = new detectLoop(arr[2]);
        detectLoop head = convertArrayIntoLinkedList(arr);

        boolean ans = detectLoopInLL(head);
        System.out.println(ans);

//        printLL(arr, head);
    }
}
