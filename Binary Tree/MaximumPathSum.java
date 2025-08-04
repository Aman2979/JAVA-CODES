public class MaximumPathSum {
    int data;
    MaximumPathSum left;
    MaximumPathSum right;

    // Constructor to initialize a node
    MaximumPathSum(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Helper function to compute the maximum path sum
    public static int height(MaximumPathSum root, int[] maxValue) {
        // Base case: If the node is null, return 0
        if (root == null) return 0;

        // Recursively compute the maximum sum of the left and right subtrees
        int lhSum = Math.max(0, height(root.left, maxValue)); // Ignore negative values by taking max(0, value)
        int rhSum = Math.max(0, height(root.right, maxValue)); // Ignore negative values

        // Update maxValue[0] to store the maximum path sum seen so far
        // The possible maximum path sum passes through the current node and includes both left and right subtrees
        maxValue[0] = Math.max(maxValue[0], lhSum + rhSum + root.data);

        // Return the maximum path sum of either left or right subtree including the current node
        return Math.max(lhSum, rhSum) + root.data;
    }

    // Function to find the maximum path sum in the binary tree
    public static int MaximumPathSumBTree(MaximumPathSum root) {
        int[] maxValue = new int[1];  // Array is used to store the max value across recursive calls
        maxValue[0] = Integer.MIN_VALUE; // Initialize with the smallest possible value
        height(root, maxValue); // Call the helper function to compute max path sum
        return maxValue[0]; // Return the final maximum path sum
    }

    public static void main(String[] args) {
        // Creating a sample binary tree:
        //         -10
        //        /    \
        //       9      20
        //            /    \
        //          15      7

        MaximumPathSum root = new MaximumPathSum(-10);
        root.left = new MaximumPathSum(9);
        root.right = new MaximumPathSum(20);
        root.right.left = new MaximumPathSum(15);
        root.right.right = new MaximumPathSum(7);

        // Compute the maximum path sum and print it
        int answer = MaximumPathSumBTree(root);
        System.out.println(answer);  // Expected output: 42
    }
}
