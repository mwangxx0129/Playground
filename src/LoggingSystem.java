import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggingSystem {
    private Node root = new Node();
    class Node {
        int freq;
        Map<Character, Node> neighbors;
        Node() {
            this.freq = 0;
            this.neighbors = new HashMap<>();
        }
    }

    public void insert(char[] logs) {
        Node cur = root;
        ++ cur.freq;
        for (char c : logs) {
            cur.neighbors.putIfAbsent(c, new Node());
            cur = cur.neighbors.get(c);
            ++ cur.freq;
        }
    }

    public void dfs(Node root, StringBuilder sb, List<String> res) {
//        for (Map.Entry<Character, Node> cur : root.neighbors.entrySet()) {
//            cur.getValue()
//        }
        // |-
        // |-|-A(2)
        // |-|-|-B(2)
        // |-|-|-|-C(1)
        // |-|-|-|-A(1)
    }

    public static void main(String[] args) {
        LoggingSystem loggingSystem = new LoggingSystem();
        loggingSystem.insert("ABC".toCharArray());
        loggingSystem.insert("ABA".toCharArray());
        System.out.println("...");
    }


}
