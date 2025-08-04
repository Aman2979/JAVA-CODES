public class deleteNode {
    int data;
    deleteNode next;

    deleteNode(int data, deleteNode next) {
        this.data = data;
        this.next = next;
    }

    deleteNode(int data) {
        this.data = data;
        next = null;
    }

    public static deleteNode changeIntoLL(int [] arr){
        deleteNode head = new deleteNode(arr[0]);
        deleteNode mover = head;
        for (int i = 1; i < arr.length; i++) {
            deleteNode temp = new deleteNode(arr[i]);
            mover.next =  temp;
            mover = temp;
        }
        return head;
    }

    //type 1...
    public static deleteNode deleteHeadElement(deleteNode head){
        deleteNode temp = head;
        head = head.next;
        return head;
    }

    //Type 2...
    public static deleteNode deleteTailElement(deleteNode head){
        if(head == null || head.next == null){
            return null;
        }
        deleteNode temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

//    Type 3...
    public static deleteNode deleteKthElement(deleteNode head, int k){
        if(head == null) return head;
        if (k == 1){
            deleteNode temp = head;
            head = head.next;
            return head;
        }

        int cnt = 0;
        deleteNode temp = head;
        deleteNode previous = null;
        while (temp != null){
            cnt++;
            if (cnt == k){
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }


//    Type 4....
    public static deleteNode deleteElement(deleteNode head, int el){
        if(head == null) return head;
        if (head.data == el){
            deleteNode temp = head;
            head = head.next;
            return head;
        }

        deleteNode temp = head;
        deleteNode previous = null;
        while (temp != null){
            if (temp.data == el){
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void printAfterDelete(int []arr, deleteNode head){
        deleteNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int []arr = {2, 4, 7, 1, 9};
        deleteNode head = changeIntoLL(arr);
        deleteNode temp = head;
        int el = 2;
//        System.out.println(head.data);
        System.out.println();

//        delete Head Element.
//        head = deleteHeadElement(head, arr);
//        System.out.println(head.data);

//        Delete Tail Element.
//        head = deleteTailElement(head);
//        System.out.println(head.data);

//        Delete Kth Element
//        head = deleteKthElement(head, k);
//        System.out.println(head.data);

//        delete Give element.
        head = deleteElement(head,el);
        System.out.println(head.data);

        printAfterDelete(arr, head);
    }
}
