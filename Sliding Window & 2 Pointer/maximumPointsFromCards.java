public class maximumPointsFromCards {
    public static int optimalSolution(int []cardPoints, int k){
        //Time Complexity = O(2*k)
        //Scape Complexity = O(1)
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        maxSum = leftSum;
        int rightIndex = n-1;
        for (int i = k-1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex];
            rightIndex= rightIndex - 1;
            maxSum = Math.max(maxSum, leftSum+rightSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int []cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int answer = optimalSolution(cardPoints, k);
        System.out.println(answer);
    }
}
