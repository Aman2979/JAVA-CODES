public class lengthOfLoop {
    int data;
    lengthOfLoop next;

    public lengthOfLoop(int data, lengthOfLoop next) {
        this.data = data;
        this.next = next;
    }

    public lengthOfLoop(int data) {
        this.data = data;
        next = null;
    }

    public static lengthOfLoop convertArrayIntoLinkedList(int []arr){
        lengthOfLoop head = new lengthOfLoop(arr[0]);
        lengthOfLoop mover = head;
        for (int i = 1; i < arr.length; i++){
            lengthOfLoop temp = new lengthOfLoop(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //Optimal Solution...
    public static int findLengthOfTheLL(lengthOfLoop head){
        lengthOfLoop slow = head;
        lengthOfLoop fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                return length(slow, fast);
            }
        }
        return 0;
    }

    //Find length...
    public static int length(lengthOfLoop slow, lengthOfLoop fast){
        int cnt = 1;
        fast = fast.next;
        while (slow != fast){
            cnt++;
            fast = fast.next;
        }
        return cnt;
    }


    public static void printLL(int []arr, lengthOfLoop head){
        lengthOfLoop temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {3,2,0,-4};
        lengthOfLoop y = new lengthOfLoop(arr[2]);
        lengthOfLoop head = convertArrayIntoLinkedList(arr);


        printLL(arr, head);
    }
}
