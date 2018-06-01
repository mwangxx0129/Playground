package May25_2018;

public class UpdateTreeNode {
    private static class TreeNode {
        int label;
        TreeNode left, right;
        TreeNode(int label) {
            this.label = label;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(0);

        dfs(root);

        int value = 0;

        solution(root, root.left.right.right, value);

        System.out.println("---");

        dfs(root);
    }

    // assume: target node is in tree
    public static int solution(TreeNode root, TreeNode target, int value) {

        if (root == null) {
            return 0;
        }

        if (root == target) {
            root.label = value;
            return 1;
        }

        int l = solution(root.left, target, value);

        int r = solution(root.right, target, value);

        if (l == 1 || r == 1) {
            root.label = calculate(root.left.label, root.right.label);
            return 1;
        }

        return 0;
    }

    private static int calculate(int l, int r) {
        if( l == 0 && r == 0) {
            return 0;
        } else if (l == 1 && r == 1) {
            return 1;
        } else {
            return 2;
        }
    }


    private static void dfs(TreeNode root) {
        if (root == null) return;
        System.out.println(root.label);
        dfs(root.left);
        dfs(root.right);
    }
}
