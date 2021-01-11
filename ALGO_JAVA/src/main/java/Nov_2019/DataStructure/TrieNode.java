package Nov_2019.DataStructure;

public class TrieNode {
    TrieNode[] children;
    boolean isWord;
    TrieNode () {
        children = new TrieNode[128];
    }
    
    public void insert(TrieNode root, String s) {
        char[] sChars = s.toCharArray();
        TrieNode cur = root;
        for (char c : sChars) {
            if (cur.children[c] == null)
                cur.children[c] = new TrieNode();
            cur = cur.children[c];
        }
        cur.isWord = true;
    }

    public TrieNode search(TrieNode root, String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur == null) return null;
            cur = cur.children[c];
        }
        return cur;
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode();
        root.insert(root,"aaa");
        root.insert(root, "aa");
        root.insert(root, "b");
        root.sea
    }
    
}
