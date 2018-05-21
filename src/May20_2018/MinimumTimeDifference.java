package May20_2018;

import java.util.Arrays;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        String[] strs =  {"23:59","00:00"};
        int result = minimumTimeDifference(strs);
        System.out.println(result);
    }

    public static int minimumTimeDifference(String[] strs) {
        int[] M = new int[strs.length];
        for ( int i = 0; i < strs.length; ++ i) {
            String s = strs[i];
            int h = Integer.valueOf(s.substring(0, 2));
            int m = Integer.valueOf(s.substring(3, 5));
            M[i] = h * 60 + m;
        }
        Arrays.sort(M);
        int minDiff = 1440 + M[0] - M[M.length - 1];
        for (int i = 1; i < M.length; ++ i) {
            int diff = M[i] - M[i - 1];
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
