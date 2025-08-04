public class xORNumberLToR {
    public static int bruteSolution(int l, int r){
        int xorNum = 0;
        for (int i = l; i <= r; i++) {
            xorNum = xorNum ^ i;
        }
        return xorNum;
    }

    public static int helper1(int l){
        if(l % 4 == 1) {
            return 1;
        } else if (l % 4 == 2) {
            return l+1;
        }else if (l % 4 == 3){
            return 0;
        }else {
            return l;
        }
    }

    public static int helper2(int r){
        if(r % 4 == 1) {
            return 1;
        } else if (r % 4 == 2) {
            return r+1;
        }else if (r % 4 == 3){
            return 0;
        }else {
            return r;
        }
    }

    public static int optimalSolution(int l, int r){
        return helper1(l-1)^helper2(r);
    }
    public static void main(String[] args) {
        int l = 4;
        int r = 8;
        int answer = optimalSolution(l, r);
        System.out.println(answer);
    }
}
