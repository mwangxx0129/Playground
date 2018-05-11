import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("word");
        boolean result = wordBreak("leetword", dict);
        System.out.println(result);
    }



    // 方法一：
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        return dfs(s, dict, 0);
    }

    public static boolean dfs(String word, Set<String> dict, int start) {
        if (start == word.length()) return true;
        for (int end = start + 1; end <= word.length(); ++ end) {
            if (dict.contains(word.substring(start, end)) && dfs(word, dict, end)) {
                return true;
            }
        }
        return false;
    }


    // 方法二：
    public static boolean wordBreak_method2(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean[] MM = new Boolean[s.length()];
        return dfs(s, dict, 0, MM);
    }

    public static boolean dfs(String word, Set<String> dict, int start, Boolean[] MM) {
        if (start == word.length()) return true;
        if (MM[start] != null) return MM[start];
        for (int end = start + 1; end <= word.length(); ++ end) {
            if (dict.contains(word.substring(start, end)) && dfs(word, dict, end, MM)) {
                return MM[start] = true;
            }
        }
        return MM[start] = false;
    }
}
