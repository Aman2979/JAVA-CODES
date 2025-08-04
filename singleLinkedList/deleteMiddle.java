public class deleteMiddle {
    int data;
    deleteMiddle next;

    public deleteMiddle(int data, deleteMiddle next) {
        this.data = data;
        this.next = next;
    }

    public deleteMiddle(int data) {
        this.data = data;
        next = null;
    }

    public static deleteMiddle convertArrayIntoLinkedList(int []arr) {
        deleteMiddle head = new deleteMiddle(arr[0]);
        deleteMiddle mover = head;
        for (int i = 1; i < arr.length; i++) {
            deleteMiddle temp = new deleteMiddle(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //Brute force
    public static deleteMiddle deleteTheOfTheLL(deleteMiddle head){
        if (head == null || head.next == null){
            return null;
        }
        deleteMiddle temp = head;
        int n = 0;
        while (temp != null){
            n = n+1;
            temp = temp.next;
        }
        int ans = n/2;
        temp = head;
        while (temp != null){
            ans = ans-1;
            if(ans == 0){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


//    Optimal solution
    public static deleteMiddle deleteTheOfTheLL2(deleteMiddle head) {
        if (head == null || head.next == null) {
            return null;
        }
        deleteMiddle slow = head;
        deleteMiddle fast = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void printLL(int []arr, deleteMiddle head){
        deleteMiddle temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 4};
        deleteMiddle y = new deleteMiddle(arr[2]);
        deleteMiddle head = convertArrayIntoLinkedList(arr);

        head = deleteTheOfTheLL2(head);

        printLL(arr, head);
    }
}
