public class queueToLL {
    int data;
    queueToLL next;

    public queueToLL(int data) {
        this.data = data;
        this.next = null;
    }

    static class que{
        queueToLL start = null;
        queueToLL end = null;
        int size = 0;

        void push(int x){
            queueToLL temp = new queueToLL(x);
            if (start == null){
                start = end = null;
            }else {
                end.next = temp;
                size++;
            }
        }

        void pop(){
            if (start == null){
                System.out.print("your LL is empty");
            }else {
                queueToLL temp = start;
                start = start.next;
                size--;
            }
        }

        int top(){
            if (start == null){
                System.out.print("your LL is empty");
            }
            return start.data;
        }

        int size(){
            return size;
        }
    }

    static void print(queueToLL head){
        queueToLL temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        queueToLL head = new queueToLL(4);
        head.next = new queueToLL(1);
        head.next.next = new queueToLL(6);
        head.next.next.next = new queueToLL(8);
        head.next.next.next.next = new queueToLL(5);

        print(head);


    }
}
