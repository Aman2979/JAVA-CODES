import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    List<Integer> arr = new ArrayList<>();

    public StockSpanner() {
        // Constructor can remain empty
    }

    public int next(int price) {
        arr.add(price); // Add the price to the list
        int cnt = 1;    // Minimum span is always 1 (current price itself)

        // Start from the previous element and go backward
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (arr.get(i) <= price) {
                cnt++;
            } else {
                break; // Stop when a higher price is encountered
            }
        }
        return cnt;
    }
}

