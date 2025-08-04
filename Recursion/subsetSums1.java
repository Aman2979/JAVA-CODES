import java.util.ArrayList;
import java.util.Collections;

public class subsetSums1 {
    private static void findPossibleSubSets(int index, int sum,int []arr,int N, ArrayList<Integer> subSets){
        if (index == N){
            subSets.add(sum);
            return;
        }

        //pick the element
        findPossibleSubSets(index+1,sum+arr[index],arr,N,subSets);

        //Do-not pick the element
        findPossibleSubSets(index+1,sum,arr,N,subSets);
    }
    public static ArrayList<Integer> optimizeCode(int[] arr){
        ArrayList<Integer> subSets = new ArrayList<>();
        int N = arr.length;
        findPossibleSubSets(0,0,arr,N,subSets);
        Collections.sort(subSets);
        return subSets;
    }
    public static void main(String[] args) {
        int []arr = {3, 2};
        ArrayList<Integer> answer = optimizeCode(arr);
        System.out.println(answer);
    }
}
