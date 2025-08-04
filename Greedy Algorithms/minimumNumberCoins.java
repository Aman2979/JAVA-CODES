public class minimumNumberCoins {
    private static int findMin(int []coins, int sum) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            while (sum >= coins[i]){
                sum -= coins[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []coins = {25, 10, 5};
        int sum = 30;
        int ans = findMin(coins, sum);
        System.out.println(ans);
    }
}
