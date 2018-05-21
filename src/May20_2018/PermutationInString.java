package May20_2018;

public class PermutationInString {
    public static void main(String[] args) {
        String S = "acbdc";
        String T = "dbc";
        boolean result = permutationInString(S, T);
        System.out.println(result);
    }

    public static boolean permutationInString(String S, String T) {
        if (S == null || T == null) return false;
        int[] map = new int [256];
        int m = S.length(), n = T.length();
        int count = T.length();
        for (int i = 0; i < n; ++ i) {
            map[T.charAt(i)] ++;
        }

        for (int i = 0; i < n; ++ i) {
            if (map[S.charAt(i)] -- > 0) count --;
        }
        if (count == 0) return true;

        for (int i = n; i < m; ++ i) {
            if (map[S.charAt(i)] -- > 0) count --;
            if (map[S.charAt(i - n)] ++ >= 0) count ++;
            if (count == 0) return true;
        }
        return false;
    }
}
