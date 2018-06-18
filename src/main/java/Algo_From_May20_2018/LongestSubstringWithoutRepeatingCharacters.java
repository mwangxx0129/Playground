package Algo_From_May20_2018;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String S = "acbdc";
        int result = longestSubstringWithoutRepeatingCharacters(S);
        System.out.println(result);
    }
    public static int longestSubstringWithoutRepeatingCharacters(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int count = 0;
        int[] map = new int[256];
        int maxLen = 0;

        for (int l = 0, r = 0; l < n; ++ l) {
            while (r < n && count ==0) {
                if (map[s.charAt(r ++ )] ++ == 1) count ++;
                if (count == 0 && r - l > maxLen) maxLen = r - l;
            }
            if (map[s.charAt(l)] -- == 2) count --;
        }

        return maxLen;
    }
}
