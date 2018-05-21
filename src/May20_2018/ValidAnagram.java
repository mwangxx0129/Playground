package May20_2018;

public class ValidAnagram {
    public static void main(String[] args) {
        String S = "abc";
        String T = "cba";
        boolean result = isValidAnagram(S , T);
        System.out.println(result);
    }
    public static boolean isValidAnagram(String S, String T) {
        // corner case
        if (S.length() != T.length()) return false;
        int[] counts = new int[256];
        for (char c : T.toCharArray()) {
            counts[c] ++;
        }

        for (char c : T.toCharArray()) {
            if (counts[c] --  == 0) return false;
        }
        return true;
    }
}
