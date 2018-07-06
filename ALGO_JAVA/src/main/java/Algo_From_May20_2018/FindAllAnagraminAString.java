package Algo_From_May20_2018;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagraminAString {
    public static void main(String[] args) {
        String S = "abcaccbadcba";
        String T = "abc";
        List<Integer> result = findAllAnagraminAString(S, T);
        System.out.println(result);
    }

    public static List<Integer> findAllAnagraminAString(String S, String T) {
        List<Integer> result = new ArrayList<>();
        if (S == null || T == null) return result;
        int m = S.length();
        int n = T.length();
        if (m < n) return result;

        int[] map = new int[256];
        int count = T.length();
        for (char c : T.toCharArray()) {
            map[c] ++;
        }

        for (int i = 0; i < n; ++ i) {
            if (map[S.charAt(i)] -- > 0)
                count --;
        }
        if (count == 0) result.add(0);

        for (int i = n; i < m; ++ i) {
            if (map[S.charAt(i)] -- > 0) count --;
            if (map[S.charAt(i - n)] ++ >= 0) count ++;
            if (count == 0) result.add(i - n + 1);
        }
        return result;
    }
}
