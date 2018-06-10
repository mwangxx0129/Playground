package May20_2018;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result.toString());
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            List<String> anagrams = group.getOrDefault(sorted, new LinkedList<>());
            anagrams.add(s);
            group.put(sorted, anagrams);
        }
        System.out.println(group.keySet());
        return new LinkedList<>(group.values());
    }
}
