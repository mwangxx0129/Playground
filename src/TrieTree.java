public class TrieTree {

    private static int NUM_ALPHBAT = 26;

    static class TrieNode {
        TrieNode[] children;
        String word;
        int freq;
        TrieNode() {
            children = new TrieNode[NUM_ALPHBAT];
        }
    }

    TrieNode root;

    TrieTree() {// TODO is Constructor need a explicitly permission
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] W = word.toCharArray();
        TrieNode cur = root;
        for (char c : W) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.word = word;
        cur.freq = 1;
    }

    public TrieNode locate(String word) {
        char[] W = word.toCharArray();
        TrieNode cur = root;
        for (int i = 0; i < W.length && cur != null; ++ i) {
            cur = cur.children[W[i] - 'a'];
        }
        return cur;
    }

    public boolean isWord(String word) {
        TrieNode cur = locate(word);
        return cur != null && cur.word != null;
    }

    public boolean isPrefix(String word) {
        TrieNode cur = locate(word);
        return cur != null;
    }

    public static void main(String[] args) {
        System.out.println("Hello Trie Tree");
        System.out.println("Round #1: insert words");
        TrieTree trieTree = new TrieTree();
        String[] words = {"apple", "app", "zero"};
        for(String word : words) {
            trieTree.insert(word);
        }

        System.out.println("Round #2: check");
        System.out.println(trieTree.isWord("ap"));
        System.out.println(trieTree.isWord("app"));
    }
}
