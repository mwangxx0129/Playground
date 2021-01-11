package Google;

import java.util.Arrays;
import java.util.Random;

public class Solutions {
    public static void main(String[] args) {
        int[] A = new int[] {1,2,3,5,-1,-5,9};
        System.out.println(maxSumWithoutAdj(A));
        A = new int[] {-100,-10,3,5,-1,-5,9};
        System.out.println(maxSumWithoutAdj(A));
        A = new int[] {1,-10,3,5,7,-1,-5,9};
        System.out.println(maxSumWithoutAdj(A));
    }

    public static int maxSumWithoutAdj(int[] A) {

        if (A.length == 0) return 0;
        if (A.length == 1) return Math.max(0, A[0]);

        // 初始化 位置index = 0
        // excludeCur 表示不含 index = 0 的局部最大值
        // includeCur 表示包含 index = 0 的局部最大值
        int excludeCur = 0;
        int includeCur = A[0];
        int max = Math.max(excludeCur, includeCur);

        for (int i = 1; i < A.length; ++ i) {
            // 记下 上一个状态
            int preExcludeCur = excludeCur;
            int preIncludeCur = includeCur;

            // 跟新 当前index 对应状态
            excludeCur = Math.max(preExcludeCur, preIncludeCur);
            includeCur = A[i] + preExcludeCur;

            // 更新 全局最大值
            max = Math.max(Math.max(excludeCur, includeCur), max);
        }
        return max;
    }

    public static void test() {

        Random ran = new Random();
        TreeNode root = generateTree(0, 62, ran.nextInt(63));
        int count = 0;
        int total = 10000000;
        while (total -- > 0)
            if (preorder(root, ran.nextInt(63)))
                ++ count;
        System.out.println("count / total = " + count + " / " + 10000000);
    }

    public static boolean preorder(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target) return true;
        if (root.status) return false;

        return preorder(root.left, target) || preorder(root.right, target);

    }

    static class TreeNode {
        int val;
        boolean status;
        TreeNode left, right;
        TreeNode(int val, boolean s) {
            this.val = val;
            this.status = s;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode generateTree(int l, int r, int random) {
        if (l > r) return null;
        if (l == r) return new TreeNode(l, random == l);
        int mid = (l + r) >>> 1;
        TreeNode root = new TreeNode(mid, mid == random);
        root.left = generateTree(l, mid, random);
        root.right = generateTree(mid + 1, r,  random);
        return root;
    }



    private static int scheduleFlowers(int k, int a, int b) {
        int[]  dp = new int[k];
        dp[0] = 1;
        dp[1] = 1;
        int lastCount = 0;

        for (int i = 2; i <= b; ++ i) {
            int tmp = dp[k - 1];
            for (int j = k - 1; j >= 0; -- j) {
                if (j != 0) dp[j] = dp[j - 1];
                if (j == 0) dp[0] = tmp + dp[0];
            }
            if (i == a - 1) {
                lastCount = dp[0];
            }
            System.out.println(dp[0]);
        }
        return dp[0] - lastCount;
    }

    private static int ff(int k, int a, int b) {
        int[] dp = new int[10];
        dp[0] = 1;
        int mod = 1000000007;
        for (int i = 0; i < dp.length; ++ i) {
            if (i + 1 < dp.length) dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
            if (i + k < dp.length) dp[i + k] = (dp[i + k] + dp[i]) % mod;
        }
        System.out.println(Arrays.toString(dp));
        int[] prefix = new int[10];
        Arrays.fill(prefix, 1);
        for (int i = 1; i < dp.length; ++ i) {
            prefix[i] = (prefix[i - 1] + dp[i]) % mod;
        }
        return prefix[b] - prefix[a - 1];
    }
}
