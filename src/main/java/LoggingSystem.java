import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggingSystem {
    class Node {
        Character c;
        int freq;
        Map<Character, Node> neighbors;
        Node () {
            this.freq = 0;
            this.neighbors = new HashMap<>();
        }

        @Override
        public String toString() {
            return this.c + "(" + this.freq + ")";
        }
    }

    private Node root = new Node();

    public void insert(char[] logs) {
       Node cur = root;
       for (char c : logs) {
           cur.neighbors.putIfAbsent(c, new Node());
           cur = cur.neighbors.get(c);
           cur.c = c;
           ++ cur.freq;
       }
    }

    public void dfs(Node cur, StringBuilder sb) {
        System.out.println(sb.toString() + cur.toString());
        sb.append("|-");
        for (Map.Entry<Character, Node> next : cur.neighbors.entrySet()) {
            dfs(next.getValue(), sb);
        }
        sb.delete(sb.length() - 2, sb.length());
    }

//    private Node root = new Node();
//    class Node {
//        Character c;
//        int freq;
//        Map<Character, Node> neighbors;
//        Node() {
//            this.freq = 0;
//            this.neighbors = new HashMap<>();
//        }
//        @Override
//        public String toString() {
//            return this.c + "(" + this.freq + ")";
//        }
//    }

//    public void insert(char[] logs) {
//        Node cur = root;
//        ++ cur.freq;
//        for (char c : logs) {
//            cur.neighbors.putIfAbsent(c, new Node());
//            cur = cur.neighbors.get(c);
//            cur.c = c;
//            ++ cur.freq;
//        }
//    }

//    public void dfs(Node cur, StringBuilder sb) {
//        System.out.println(sb.toString() + cur.toString());
//        sb.append("|-");
//        for (Map.Entry<Character, Node> next : cur.neighbors.entrySet()) {
//            dfs(next.getValue(), sb);
//        }
//        sb.delete(sb.length() - 2, sb.length());
//    }

    public static void main(String[] args) {
        LoggingSystem loggingSystem = new LoggingSystem();
        loggingSystem.insert("ABC".toCharArray());
        loggingSystem.insert("ABA".toCharArray());
        loggingSystem.insert("BBA".toCharArray());
        loggingSystem.dfs(loggingSystem.root, new StringBuilder());
    }
}
