public class RegexExpression {

    public static boolean isMatch(String s, String p) {
        // corner case
        if (s == null || p == null)
            return false;

        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        int m = P.length;
        int n = S.length;
        boolean [][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        // init dp
        for (int i = 2; i < m + 1; ++ i) {
            dp[i][0] = P[i - 1] == '*' && (dp[i - 1][0] || dp[i - 2][0]);
        }

        for (int i = 1; i < m + 1; ++ i) {
            char charP = P[i - 1];
            for (int j = 1; j < n + 1; ++ j) {
                char charS = S[j - 1];
                if (charP == '*') {
                    // match 0 : abc   <--> aa*bc
                    // match 1 : abc   <--> a*bc
                    // match 1+: abbc  <--> ab*c
                    dp[i][j] = (i - 2 >= 0 && dp[i - 2][j])
                            || dp[i - 1][j]
                            || (dp[i][j - 1] && (charS == P[i - 2] || P[i - 2] == '.'));
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (charP == '.' || charS == charP);
                }
            }
        }

        return dp[m][n];
    }
    public static void main(String [] args) {
        boolean res = isMatch("ab", ".*");
        System.out.println(res);
//        String[] sources = {"abc", "abc", "abbc", "a", "", ""};
//        String[] patterns = {"aa*bc", "a*bc", "ab*c", "b", "a*", ""};
//        int num = Math.min(sources.length, patterns.length);
//        for (int i = 0; i < num; ++ i) {
//            boolean result = isMatch(sources[i], patterns[i]);
//            System.out.println(result);
//        }
    }
}
