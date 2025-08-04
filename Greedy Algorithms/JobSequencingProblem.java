import java.util.*;

public class JobSequencingProblem {
    public static ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        return list;
    }
    public static void main(String[] args) {
        int []id = {1, 2, 3, 4};
        int []deadline = {4, 1, 1, 1};
        int []profit = {20, 1, 40, 30};
        ArrayList<Integer> answer = JobSequencing(id, deadline, profit);
        System.out.println(answer);
    }
}
