import java.util.ArrayList;
import java.util.List;

class ImplementingMinHeap {
    static List<Integer> arr;
    static int count;

    ImplementingMinHeap(){
        arr = new ArrayList<>();
        count = 0;
    }

    private void heapifyUp(List<Integer> arr, int ind) {
        int parentInd = (ind - 1)/2;
        if(ind > 0 && arr.get(ind) < arr.get(parentInd)) { // Min Heap: <
            int temp = arr.get(ind);
            arr.set(ind, arr.get(parentInd));
            arr.set(parentInd, temp);
            heapifyUp(arr, parentInd);
        }
    }

    private void heapifyDown(List<Integer> arr, int ind) {
        int n = arr.size();
        int smallest = ind;
        int left = 2*ind + 1;
        int right = 2*ind + 2;

        if(left < n && arr.get(left) < arr.get(smallest))
            smallest = left;
        if(right < n && arr.get(right) < arr.get(smallest))
            smallest = right;

        if(smallest != ind) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(smallest));
            arr.set(smallest, temp);
            heapifyDown(arr, smallest);
        }
    }

    public void initializeHeap() {
        arr.clear();
        count = 0;
    }

    public void insert(int key) {
        arr.add(key);
        heapifyUp(arr, arr.size() - 1);
        count++;
    }

    public void changeKey(int index, int newVal) {
        if(newVal < arr.get(index)) {
            arr.set(index, newVal);
            heapifyUp(arr, index);
        } else {
            arr.set(index, newVal);
            heapifyDown(arr, index);
        }
    }

    public int extractMin() {
        int ele = arr.get(0);
        int last = arr.get(count - 1);
        arr.set(0, last);
        arr.remove(count - 1);
        count--;

        if (count > 0) {
            heapifyDown(arr, 0);
        }
        return ele;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMin() {
        return arr.get(0);
    }

    public int heapSize() {
        return count;
    }

    public static void main(String[] args) {
        ImplementingMinHeap heap = new ImplementingMinHeap();

        heap.initializeHeap();

        heap.insert(4); System.out.println("Inserting 4 in the min-heap");
        heap.insert(5); System.out.println("Inserting 5 in the min-heap");
        heap.insert(10); System.out.println("Inserting 10 in the min-heap");
        System.out.println("Minimum value in the min-heap is: " + heap.getMin());
        System.out.println("Size of min-heap is: " + heap.heapSize());
        System.out.println("Is heap empty: " + heap.isEmpty());
        System.out.println("Extracting minimum value from the heap");
        heap.extractMin();
        System.out.println("Changing value at index 0 to 10");
        heap.changeKey(0, 10);
        System.out.println("Minimum value in the min-heap is: " + heap.getMin());
    }
}
