import java.util.HashMap;

public class randomPointer {
    int data;
    randomPointer next;
    randomPointer random;

    public randomPointer(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }

    public static randomPointer bruteForce(randomPointer head){
        HashMap<randomPointer, randomPointer> map = new HashMap<>();
        randomPointer temp = head;
        while (temp != null){
            randomPointer newNode = new randomPointer(temp.data);
            map.put(temp, newNode);
            temp = temp.next;
        }
        temp = head;

        while (temp != null){
            randomPointer copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    public static randomPointer optimalSolution(randomPointer head){
        // Step 1: Interleave copied nodes with original nodes
        randomPointer temp = head;
        while (temp != null) {
            randomPointer nextElement = temp.next;
            randomPointer copy = new randomPointer(temp.data);

            copy.next = nextElement;
            temp.next = copy;

            temp = nextElement;
        }

        // Step 2: Set random pointers for copied nodes
        temp = head;
        while (temp != null) {
            randomPointer copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }

        // Step 3: Separate the copied list from the original list
        temp = head;
        randomPointer dummyNode = new randomPointer(-1); // Dummy node to build the cloned list
        randomPointer res = dummyNode;
        while (temp != null) {
            res.next = temp.next;          // Extract the copied node
            res = res.next;

            temp.next = temp.next.next;    // Restore the original list
            temp = temp.next;
        }

        return dummyNode.next;
    }

    public static void printList(randomPointer head) {
        randomPointer temp = head;
        while (temp != null) {
            // Print the current node's data
            System.out.print("Node data: " + temp.data);

            // Print the random pointer's data if it exists
            if (temp.random != null) {
                System.out.print(", Random points to: " + temp.random.data);
            } else {
                System.out.print(", Random points to: null");
            }

            // Move to the next node
            System.out.println(); // For better formatting
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        randomPointer head = new randomPointer(5);
        head.random = new randomPointer(14);

        head.next = new randomPointer(10);
        head.next.random = new randomPointer(4);

        head.next.next = new randomPointer(12);
        head.next.next.random = new randomPointer(20);
        head.next.next.random.random = new randomPointer(13);

        head.next.next.next = new randomPointer(7);
        head.next.next.next.random = new randomPointer(17);

        head = optimalSolution(head);

        printList(head);
    }
}
