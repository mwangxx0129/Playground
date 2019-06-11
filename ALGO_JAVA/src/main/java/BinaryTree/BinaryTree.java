package BinaryTree;

import java.util.*;

/**
 * 1. Define TreeNode
 * 2. generate binary tree
 * 3. DFS
 */
public class BinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        System.out.println("main");
        TreeNode root = generateBinaryTree();
//        inorder(root);
//        preorder(root);
//        postorder(root);

//        BFS(root);
//        BFSZ(root);
//        BFSZ_solution_2(root);
//        BFSZto2DList(root);

        BFSZ_solution_3(root);

    }


    public static TreeNode generateBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        return root;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public static void preorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    public static void postorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        inorder(root.right);
        System.out.println(root.val);
    }

    public static void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.offer(root);
        while (! queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
    }

    public static void BFSZ(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        boolean isFromLeft = true;
        queue.offer(root);
        while (! queue.isEmpty()) {
            int size = queue.size();
            if (isFromLeft) {
                for (int i = 0; i < size; ++ i) {
                    TreeNode cur = queue.poll();
                    System.out.println(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

            } else {
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < size; ++ i) {
                    TreeNode cur = queue.poll();
                    tmp.add(cur.val);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }

                for (int i = tmp.size() - 1; i >= 0; -- i) {
                    System.out.println(tmp.get(i));
                }

            }
            isFromLeft = !isFromLeft;
        }
    }

    public static List<List<Integer>> BFSZto2DList(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            result.add(new ArrayList<>());
            for (int i = 0; i < size; ++ i) {
                TreeNode cur = queue.poll();
                if (level % 2 == 0) {
                    result.get(level).add(cur.val);
                } else {
                    result.get(level).add(0, cur.val);
                }

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            level ++;
        }

        for (List<Integer> r : result)
            System.out.println(r.toString());

        return result;
    }

    public static void BFSZ_solution_2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isFromLeft = true;
        while (!queue.isEmpty()) {

            int size = queue.size();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < size; ++ i) {
                TreeNode cur = queue.poll();
                if (isFromLeft) sb.append(" " + cur.val);
                else sb.insert(0, " " + cur.val);

                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            System.out.println(sb.toString());
            isFromLeft = !isFromLeft;

        }
    }

    public static List<List<Integer>> BFSZ_solution_3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int level = 0;
        helper(root, result, level);
        System.out.println(result.toString());
        return result;
    }

    public static void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

        if (level % 2 == 0)
            result.get(level).add(root.val);
        else
            result.get(level).add(0, root.val);

        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
