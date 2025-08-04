public class convertAToB {
    public static int optimalCode(int start, int goal){
        int count = 0;
        int ans = start ^ goal;
        for (int i = 0; i < 32; i++) {
            if ((ans & (1 << i)) != 0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int start = 4;
        int goal = 3;
        int ans = optimalCode(start, goal);
        System.out.println(ans);
    }
}
