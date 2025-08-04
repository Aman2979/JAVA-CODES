public class rotateLL {
    int data;
    rotateLL next;

    public rotateLL(int data, rotateLL next) {
        this.data = data;
        this.next = next;
    }

    public rotateLL(int data) {
        this.data = data;
        next = null;
    }

    //Helper function...
    public static rotateLL findNthNode(rotateLL temp , int k){
        int cnt = 1;
        while (temp != null){
            if (cnt == k){
                return temp;
            }
            cnt++;
            temp = temp.next;
        }
        return temp;
    }

    public static rotateLL rotateTheLLInKthTimes(rotateLL head){
        rotateLL temp = head;
        int len = 1;
        int k = 2;
        while (temp.next != null){
            temp = temp.next;
            len++;
        }
        if (k % len == 0){
            return head;
        }
        k = k % len;

        //Attach the tail to the head...
        temp.next = head;

        rotateLL newLastNode = findNthNode(head, len-k);
        head = newLastNode.next;
        newLastNode.next = null;
        return head;
    }

    public static void print(rotateLL head){
        rotateLL temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        rotateLL head = new rotateLL(1);
        head.next = new rotateLL(2);
        head.next.next = new rotateLL(3);
        head.next.next.next = new rotateLL(4);
        head.next.next.next.next = new rotateLL(5);

        head = rotateTheLLInKthTimes(head);

        print(head);
    }
}
