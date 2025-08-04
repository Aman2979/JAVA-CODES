public class subStringsContainingAllThreeCharacters {
    public static int bruteSol(String s){
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            int []hashArray = new int[3];
            for (int j = i; j < s.length(); j++) {
                hashArray[s.charAt(j) - 'a'] = 1;
                if (hashArray[0] + hashArray[1] + hashArray[2] == 3){
                    //first idea
                    cnt++;

                    //Second idea
//                    cnt = cnt + (s.length() - j);
//                    break;
                }
            }
        }
        return cnt;
    }

    public static int optimalSol(String s){
        int cnt = 0;
        int []lastSeen = {-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1){
                cnt = cnt + (1+ Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2])));
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String s = "aaacb";
        int answer = optimalSol(s);
        System.out.println(answer);
    }
}
