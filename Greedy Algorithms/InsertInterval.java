import java.util.Arrays;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] temp = new int[n + 1][2]; // Extra space for the new interval
        int index = 0, i = 0;

        // Step 1: Add all intervals that end before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            temp[index][0] = intervals[i][0];
            temp[index][1] = intervals[i][1];
            index++;
            i++;
        }

        // Step 2: Merge overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        temp[index][0] = newInterval[0];
        temp[index][1] = newInterval[1];
        index++;

        // Step 3: Add the remaining intervals
        while (i < n) {
            temp[index][0] = intervals[i][0];
            temp[index][1] = intervals[i][1];
            index++;
            i++;
        }
        // Copy only the used part of temp into the result array
        int[][] result = new int[index][2];
        for (i = 0; i < index; i++) {
            result[i][0] = temp[i][0];
            result[i][1] = temp[i][1];
        }

        return result;
    }

    public static void main(String[] args) {
        int [][]intervals = {{1, 3}, {6, 9}};
        int []newInterval = {2, 5};
        int [][] answer = insert(intervals, newInterval);

        int n = answer.length;
        int m = answer[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(answer[i][j]+" ");
            }
            System.out.println();
        }
    }
}
