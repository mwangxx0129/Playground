import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Twopointers {
    public static void main(String[] args) {
        System.out.println("hello");
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("sand");
        wordDict.add("dog");

        wordBreak("catsanddog", wordDict);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        helper(s, 0, dict, res);
        return res;
    }

    private static void helper(String s, int start, Set<String> dict, List<String> res) {
        List<String> tmp = new ArrayList<>();

        if (start == s.length()) {
            tmp.add("");
        }

        for (int end = start + 1; end <= s.length(); ++ end) {
            if (dict.contains(s.substring(start, end))) {
                helper(s, end, dict, res);
                for (String l : res) {
                    tmp.add(s.substring(start, end) +
                            (l.equals("") ? "" : " ") + l);
                }
            }
        }
        res = new ArrayList<>(tmp);
    }


    public static int subarraysWithKDistinct(int[] A, int K) {
        int[] M = new int[2000];
        int N = A.length;
        int count = 0;
        int unique = 0;

        int L = 0, R = 0, mid = 0;

        for (;R < N && unique < K; ++ R) {
            if (M[A[R]] ++ == 0) ++ unique;
        }

        while (mid < N ) {
            if (unique == K) {
                // found mid and count
                if (M[A[mid]] - 1 == 0) {
                    count += (mid - L + 1);
                    System.out.println("unique == K, mid=" + mid + "R=" + R);
                    if (R == N) return count;
                    if (R < N && M[A[R ++ ]] ++ == 0) ++ unique;

                } else {
                    -- M[A[mid]];
                    mid ++;
                }
            }
            else if (unique > K) {
                System.out.println("unique > K" + mid);
                -- M[A[mid ++]];
                -- unique;
                L = mid;
            }

        }
        return count;

    }

}
