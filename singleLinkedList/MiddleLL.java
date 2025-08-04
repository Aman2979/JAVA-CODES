public class MiddleLL {
    int data;
    MiddleLL next;

    MiddleLL(int data, MiddleLL next) {
        this.data = data;
        this.next = next;
    }

    MiddleLL(int data) {
        this.data = data;
        next = null;
    }

    public static MiddleLL convertArrayIntoLinkedList(int []arr){
        MiddleLL head = new MiddleLL(arr[0]);
        MiddleLL mover = head;
        for (int i = 1; i < arr.length; i++){
            MiddleLL temp = new MiddleLL(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //Brute force Solution...TC = O(n+n/2), SC = O(1)
    public static MiddleLL findMiddleOfTheLL(MiddleLL head){
        int cnt = 0;
        MiddleLL temp = head;
        while (temp != null){
            cnt++;
            temp = temp.next;
        }

        temp = head;
        int middleNode = (cnt/2) + 1;
        while (temp != null){
            middleNode = middleNode -1;
            if (middleNode == 0){
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    //Optimal Solution...TC = O(), SC = O()
    public static MiddleLL middleOfTheLL(MiddleLL head){
        MiddleLL slow =  head;
        MiddleLL fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printLL(int []arr, MiddleLL head){
        MiddleLL temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 3, 5, 6, 8};
        NodeBasics y = new NodeBasics(arr[2]);
        MiddleLL head = convertArrayIntoLinkedList(arr);

//        head = findMiddleOfTheLL(head);
//        System.out.println(head.data);

        head = middleOfTheLL(head);
        System.out.println(head.data);

//        printLL(arr, head);

    }
}
