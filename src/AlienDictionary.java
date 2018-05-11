import java.util.*;

public class AlienDictionary {

    public static void main(String[] args) {
        String[] inputs = {
                "cab",
                "abc",
                "bbc",
                "bz"
        };
        System.out.println(getOrder(inputs));
    }

    public static List<Character> getOrder(String[] inputs) {
        List<Character> result = new ArrayList<>();
        // corner case

        // create nodes
        Map<Character, List<Character>> graph = new HashMap<>();
        int[] inDegree = new int[128];
        Arrays.fill(inDegree, -1);

        for (String s : inputs) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree[c] = 0;
            }
        }

        // create edges
        for (int i = 0; i < inputs.length - 1; ++ i) {
            String first = inputs[i];
            String second = inputs[i + 1];

            int minLen = Math.min(first.length(), second.length());
            for (int j = 0; j < minLen; ++ j) {
                char from = first.charAt(j);
                char to = second.charAt(j);
                if (from == to) continue;
                graph.get(from).add(to);
                break;
            }
        }

        // init queue
        Deque<Character> queue = new ArrayDeque<>();
        for (char c = 'a'; c <= 'z'; ++ c) {
            if (inDegree[c] == 0) {
                queue.offerLast(c);
                result.add(c);
            }
        }

        while (!queue.isEmpty()) {
            Character top = queue.pollLast();
            for (Character c : graph.get(top)) {
                inDegree[c] --;
                if (inDegree[c] == 0) {
                    queue.offerLast(c);
                    result.add(c);
                }
            }
        }
        return result;
    }
}
