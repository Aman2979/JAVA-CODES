class Q1{
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long baseProfit = 0;

        // Step 1: Compute base profit
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        // Step 2: Build arrays A and B
        long[] A = new long[n]; // for first half (set to 0)
        long[] B = new long[n]; // for second half (set to 1)
        for (int i = 0; i < n; i++) {
            A[i] = -(long) strategy[i] * prices[i];
            B[i] = (1L - strategy[i]) * prices[i];
        }

        // Step 3: Prefix sums
        long[] preA = new long[n + 1];
        long[] preB = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preA[i + 1] = preA[i] + A[i];
            preB[i + 1] = preB[i] + B[i];
        }

        // Step 4: Try all windows of size k
        long maxGain = 0;
        int half = k / 2;
        for (int L = 0; L + k <= n; L++) {
            int mid = L + half;
            int R = L + k;
            long gain = (preA[mid] - preA[L]) + (preB[R] - preB[mid]);
            maxGain = Math.max(maxGain, gain);
        }
        return baseProfit + maxGain;
    }
}
class Q2{
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int MOD = 1000000007;

        // Store input midway
        int[][] mortavexil = queries;

        // Process each query
        for (int[] q : mortavexil) {
            int li = q[0], ri = q[1], ki = q[2], vi = q[3];
            for (int idx = li; idx <= ri; idx += ki) {
                nums[idx] = (int) ((1L * nums[idx] * vi) % MOD);
            }
        }

        // Compute XOR of all elements
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}

class Q3{

}

class Q4{

}
public class Contest {
    public static void main(String[] args) {
        
    }
}


