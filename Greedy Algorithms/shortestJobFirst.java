import java.util.Arrays;

public class shortestJobFirst {
    public static int findTime(int []bt){
        Arrays.sort(bt);
        int time = 0;
        int waitingTime = 0;
        for (int i = 0; i < bt.length; i++) {
            waitingTime += time;
            time += bt[i];
        }
        return waitingTime/bt.length;
    }
    public static void main(String[] args) {
        int []bt = {1, 2, 3, 4};
        int ans = findTime(bt);
        System.out.println(ans);
    }
}
