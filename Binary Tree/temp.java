public class temp {
    public static int maxContainers(int n, int w, int maxWeight) {
        int totalContainers = n * n;
        int count = 0;
        int tempWeight = 0;

        for (int i = 0; i < totalContainers; i++) {
            if (tempWeight + w > maxWeight) break; // Stop if adding another container exceeds the limit
            tempWeight += w;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int n = 2;
        int w = 3;
        int maxWeight = 15;
        System.out.println(maxContainers(n, w, maxWeight));
    }
}
