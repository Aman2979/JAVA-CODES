public class Traversal {
    int data;
    Traversal next;

    Traversal(int data, Traversal next) {
        this.data = data;
        this.next = next;
    }

    Traversal(int data) {
        this.data = data;
        next = null;
    }

    public static Traversal convertArrayIntoLinkedList(int []arr){
        Traversal head = new Traversal(arr[0]);
        Traversal mover = head;
        for (int i = 1; i < arr.length; i++) {
            Traversal temp = new Traversal(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    //Length of a LinkedList...
    public static int lengthofLL(Traversal head){
        Traversal temp = head;
        int cnt =0;
        while (temp != null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    //Check Element Present or not...
    public static int checkInLL(Traversal head, int val){
        Traversal temp = head;
        while (temp != null){
            if(temp.data == val) return temp.data;
            temp = temp.next;
        }
        return 0;
    }


    public static void main(String[] args) {
        int [] arr = {222, 3, 6, 8};
        Traversal y = new Traversal(arr[2]);
        Traversal head = convertArrayIntoLinkedList(arr);
        Traversal temp = head;

        //Traversal in the LinkedList.....
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        //Print length
        int length = lengthofLL(head);
        System.out.println(length);

        //Check in LL
        System.out.println(checkInLL(head,33));
    }
}
