import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordinDictionary {
    public static void main(String[] args) {
        String[] words = {
                "word",
                "wor",
                "wo",
                "w",
                "doog"
        };
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        System.out.println(longestWord(words));

    }

    public static String longestWord(String[] words) {
        Set<String> dict = new HashSet<>();
        String result = "";
        dict.add("");
        Arrays.sort(words);
        for (String word : words) {
            if (dict.contains(word.substring(0, word.length() - 1))) {
                dict.add(word);
                if (result.length() < word.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
}
