//写一个函数float sumPossibility(int dice, int target)，就是投dice个骰子，求最后和为target的概率。
//        因为总共的可能性是6^dice，所以其实就是combination sum， 求dice个骰子有多少种组合，使其和为target。
//        先用brute force的dfs来一个O(6^dice)指数复杂度的，
//        然后要求优化，用dp，最后结束代码写的是两者结合的memorized search吧 ，
//        面试官走的时候还说了句such a good solution。
public class Dice {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; ++ i) {
            for (int j = 0; j <= i * 6; ++ j) {
                int DICES = i;
                int TARGET = j;
                Double [][] memo = new Double[DICES + 1][j * DICES + 1];
                System.out.println(dfs(0, TARGET, DICES, memo));
                System.out.println(method_dp(TARGET, DICES));
            }
        }

    }

    // brute force dfs
    public static double dfs(int level, int target, int n) {
        if (level == n && target == 0) return 1;
        if (level == n || target < 0) return 0;
        double sum = 0.;
        for (int i = 1; i <= 6; ++ i) {
            sum += dfs(level + 1, target - i, n) / 6;
        }
        return sum;
    }

    // dfs + memo
    public static double dfs(int level, int target, int n, Double[][] memo) {
        if (memo[level][target] != null) return memo[level][target];
        if (level == n && target == 0) return memo[level][target] = 1.0;
        if (level == n || target < 0) return memo[level][target] = 0.0;
        double sum = 0.;
        for (int i = 1; i <= 6; ++ i) {
            sum += dfs(level + 1, target - i, n) / 6;
        }
        return memo[level][target] = sum;
    }

    // dp
    public static double method_dp(int target, int dices) {
        double[][] dp = new double[dices + 1][dices * 6 + 1];
        for (int i = 1; i <= 6; ++ i) {
            dp[1][i] = 1.0 / 6;
        }

        for (int i = 2; i <= dices; ++ i) {
            for (int j = 1; j <=  6 * dices; ++ j) {
                for (int p = 1; p <= 6; ++ p) {
                    if (j - p < 0) {
                        dp[i][j] += 0;
                    } else {
                        dp[i][j] += (1.0 / 6) * dp[i - 1][j - p];
                    }
                }
            }
        }
        return dp[dices][target];
    }

}
