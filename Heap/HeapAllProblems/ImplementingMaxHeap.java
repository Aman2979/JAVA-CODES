import java.util.*;

class ImplementingMaxHeap {
    private List<Integer> arr;
    private int count;

    // Constructor
    public ImplementingMaxHeap() {
        arr = new ArrayList<>();
        count = 0;
    }

    private void heapifyUp(int ind) {
        int parentInd = (ind - 1)/2;

        if(ind > 0 && arr.get(ind) > arr.get(parentInd)) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(parentInd));
            arr.set(parentInd, temp);

            heapifyUp(parentInd);
        }

        return;
    }

    private void heapifyDown(int ind) {
        int n = arr.size();

        int largestInd = ind;

        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;

        if(leftChildInd < n && arr.get(leftChildInd) > arr.get(largestInd))
            largestInd = leftChildInd;

        if(rightChildInd < n && arr.get(rightChildInd) > arr.get(largestInd))
            largestInd = rightChildInd;

        if(largestInd != ind) {
            int temp = arr.get(largestInd);
            arr.set(largestInd, arr.get(ind));
            arr.set(ind, temp);

            heapifyDown(largestInd);
        }
        return;
    }

    public void initializeHeap(){
        arr.clear();
        count = 0;
    }

    public void insert(int key){
        arr.add(key);

        heapifyUp(count);
        count = count + 1;

        return;
    }

    public void changeKey(int index, int new_val){
        if(arr.get(index) < new_val) {
            arr.set(index, new_val);
            heapifyUp(index);
        }
        else {
            arr.set(index, new_val);
            heapifyDown(index);
        }

        return;
    }


    public void extractMax(){
        int ele = arr.get(0);

        int temp = arr.get(count - 1);
        arr.set(count - 1, arr.get(0));
        arr.set(0, temp);

        arr.remove(count - 1);
        count = count - 1;

        if(count > 0) {
            heapifyDown(0);
        }
    }

    public boolean isEmpty(){
        return (count == 0);
    }

    public int getMax(){
        return arr.get(0);
    }


    public int heapSize(){
        return count;
    }
    public static void main(String[] args) {
        ImplementingMaxHeap heap = new ImplementingMaxHeap();

        heap.initializeHeap();

        heap.insert(4); System.out.println("Inserting 4 in the max-heap");
        heap.insert(1); System.out.println("Inserting 1 in the max-heap");
        heap.insert(10); System.out.println("Inserting 10 in the max-heap");
        System.out.println("Maximum value in the heap is: " + heap.getMax());
        System.out.println("Size of max-heap is: " + heap.heapSize());
        System.out.println("Is heap empty: " + heap.isEmpty());
        System.out.println("Extracting maximum value from the heap");
        heap.extractMax();
        System.out.println("Changing value at index 0 to 16");
        heap.changeKey(0, 16);
        System.out.println("Maximum value in the heap is: " + heap.getMax());
    }
}
