import java.util.*;
//input : String str1, String str2
//
//        function: replaceAll(char a, char b)
//
//
//        output : boolean , whether str1 can transfer to str2

// Q1: return true or false

// follow up: how to make str1 can transfer to str2

// follow up: save all path

class canReplaceAll {
    public static void main (String[] args) {
        String [][] inputs = {
                {"aaa","bbb"},
                {"aac","caa"},
                {"aab","cca"},
                {"avv","vvv"},
                {"a","bb"},
                {"ava", "vvv"},
                {"aaacc", "bbbdd"},
                {"avb", "vvv"},
                {"avb", "vva"},
                {"avb","vxv"},
                {"abcde","xbcde"},
                {"abcdea","xbcdex"},
                {"",""},
                {"avv","vva"}
        };

        for(String[] str : inputs){
            System.out.println(str[0] + " " + str[1] + " " + isValid(str[0], str[1]));
        }

    }

    public static boolean isValid(String a, String b) {
        if (a == null || b== null || a.length() != b.length()) return false;

        char[] map = new char[128];

        return buildGraph(a, b, map) && detectCycle(map);
    }

    public static boolean buildGraph(String a, String b, char[] map) {

        Arrays.fill(map, '0');

        for (int i = 0 ; i < a.length(); ++ i) {
            char from = a.charAt(i);
            char to = b.charAt(i);
            // fail case: "a - > b, a -> c"
            if (map[from] != '0' && map[from] != to) {
                return false;
            }

            map[from] = to;
        }
        return true;
    }

    public static boolean detectCycle(char[] map) {

        // the start char in: [a,  z]
        for (char i = 'a'; i <= 'z' && map[i] != '0'; ++ i) {

            Deque<Character> queue  = new ArrayDeque<>();

            boolean[] isVisited = new boolean[128];

            queue.offerLast(i);

            while(!queue.isEmpty()) {

                Character c = queue.pollFirst();

                isVisited[c] = true;

                // success case: self cycle a -> a
                if (c == map[c]) return true;

                // fail case: cycle a -> b, b-> c, c -> a
                if (isVisited[map[c]]) return false;

                queue.offerLast(map[c]);
            }
        }
        return true;
    }

}
