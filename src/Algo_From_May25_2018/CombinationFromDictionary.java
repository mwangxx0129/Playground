package Algo_From_May25_2018;

import java.util.HashSet;
import java.util.Set;

public class CombinationFromDictionary {
    public static void main(String[] args) {
        System.out.println("hello");
        String[] dictionary = {"bit", "tiger", "silly", "boy", "dog"};
        boolean result = combinationFromDictionary("sillyb", dictionary);
        System.out.println(result);
    }

    public static boolean combinationFromDictionary(String target, String[] dictionary) {
        Set<String> dict = new HashSet<>();
        for (String s : dictionary) dict.add(s);
        Boolean[] memo = new Boolean[target.length()];
        return helper(target,0, dict, memo);
    }

    private static boolean helper(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        for (int end = start + 1; end <= s.length(); ++ end) {
            if (dict.contains(s.substring(start, end)) && helper(s, end, dict, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
    // T O(n ^ 2)
}
