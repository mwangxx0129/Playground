# Playground

## Graph
### Def. of graph
```
Map<String, List<String>>
```

## Tree
### Def. of tree
```
// directions: {left, right}
class BinaryTreeNode {
    int val;
    BinaryTreeNode left, right;
}

// directions: {neighbors[0], neighbors[1], ...}
class KthTreeNode {
    int val;
    KthTreeNode[] neighbors;
}

// directions: {children[0], children[1], ..., children[25]}
class TrieNode {
    int freq;
    boolean isWord;
    TrieNode[] neighbors;
}

// directions: {<K, V>, <K,V>, ...}
class Node {
    Map<String, Node> neighbors;
}
```


