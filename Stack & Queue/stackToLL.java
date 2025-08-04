public class stackToLL {
    int data;
    stackToLL next;

    public stackToLL(int data) {
        this.data = data;
        this.next = null;
    }

    //Stack using LinkedList.
    static class st{
        stackToLL top = null;
        int size = 0;

        void push(int x){
            stackToLL temp = new stackToLL(x);
            temp.next = top;
            top = temp;
            size = size + 1;
        }

        void pop(){
            stackToLL temp = top;
            temp = temp.next;
            size = size-1;
        }

        int top(){
            return top.data;
        }
        int size(){
            return size;
        }
    }

    static void printLL(stackToLL head){
        stackToLL temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        stackToLL head = new stackToLL(4);
        head.next = new stackToLL(2);
        head.next.next = new stackToLL(3);
        head.next.next.next = new stackToLL(1);

        printLL(head);
    }
}
