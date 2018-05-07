import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BinaryTree implements Iterable<TreeNode> {

    Deque<Guide> stack = new ArrayDeque<>();
    TreeNode root = null;
    BinaryTree(TreeNode root) {
        this.root = root;
        stack.offerLast(new Guide(root, 1));
    }
    public boolean hasNext() {
        return stack.isEmpty();
    }

    public TreeNode next() {
        while (!stack.isEmpty()) {
            Guide top = stack.pollLast();
            if (top.oper == 0) {
                return top.node;
            } else {
                if (top.node.right != null) {
                    stack.offerLast(new Guide(top.node.right, 1));
                }
                if (top.node.left != null) {
                    stack.offerLast(new Guide(top.node.left, 1));
                }
                stack.offerLast(new Guide(top.node, 0));
            }
        }
        return null;
    }

    @Override
    public Iterator<TreeNode> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super TreeNode> action) {

    }

    @Override
    public Spliterator<TreeNode> spliterator() {
        return null;
    }
}

class Guide {
    TreeNode node;
    int oper;
    Guide(TreeNode node, int oper) {
        this.node = node;
        this.oper = oper;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}