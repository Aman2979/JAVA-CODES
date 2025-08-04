import java.util.Arrays;

public class DP7 {
    public static int recursion(int [][]points, int index, int last){
        if (index == 0){
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last){
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        int collectPoints = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last){
                collectPoints = points[index][i] + recursion(points, index-1, i);
                maxi = Math.max(maxi, collectPoints);
            }
        }
        return maxi;
    }

    public static int memorization(int [][]points, int [][]dp, int index, int last){
        int collectPoints = 0;
        if (index == 0){
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last){
                    maxi = Math.max(maxi, points[0][i]);
                }
            }
            return maxi;
        }

        if (dp[index][last] != -1) return dp[index][last];
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last){
                collectPoints = points[index][i] + memorization(points, dp, index-1, i);
                maxi = Math.max(maxi, collectPoints);
            }
        }
        return dp[index][last] = maxi;
    }

    public static int tabulation(int [][]points, int [][]dp, int index, int end){
        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < index; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }
        return dp[index - 1][3];
    }

    public static int spaceOptimization(int [][]points,int index){
        // Initialize an array 'prev' to store the maximum points for the previous day
        int prev[] = new int[4];

        // Initialize the first day's maximum points based on the available choices
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < index; day++) {
            int temp[] = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
    public static void main(String[] args) {
        int [][]points = {{10, 40, 70},{20, 50, 80},{30, 60, 90}};
        int n = points.length;
        int [][]dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(recursion(points,points.length-1, 0));
    }
}
