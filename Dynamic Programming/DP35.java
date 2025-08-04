public class DP35 {
    // Why Dp here? >>>
    // Because this step remembering the past > maxPro = Math.max(maxPro, cost);
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i <n;i++){
            int cost = prices[i] - minPrice;
            minPrice = Math.min(minPrice, prices[i]);
            maxPro = Math.max(maxPro, cost);
        }
        return maxPro;
    }
    public static void main(String[] args) {
        int []prices = {7, 1, 3, 4, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
