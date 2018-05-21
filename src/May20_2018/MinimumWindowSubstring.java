package May20_2018;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "acbdc";
        String T = "acc";
        String result = minmumWindowSubstring(S, T);
        System.out.println(result);
    }
    public static String minmumWindowSubstring(String S, String T) {
        if (S == null || T == null) return "";
        int m = S.length();
        int n = T.length();
        if (m < n) return "";
        int [] counts = new int[256];
        int uniqueCount = 0;
        for (int i = 0; i < n; ++ i) {
            if (counts[T.charAt(i)] ++ == 0) {
                uniqueCount ++;
            }
        }

        int minLen = Integer.MAX_VALUE;
        int L = 0;
        for (int l = 0, r = 0; l < m; ++ l) {
            while (r < m && uniqueCount > 0) {
                if (counts[S.charAt(r)] -- == 1) {
                    uniqueCount --;
                }
                r ++;
            }
            if (uniqueCount == 0) {
                if (minLen > r - l) {
                    minLen = r - l;
                    L = l;
                }
            }
            if (counts[S.charAt(l)] ++ == 0) {
                uniqueCount ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(L, L + minLen);
    }
}
