package May25_2018;

public class StealCake {
    public static void main(String[] args) {
        System.out.println("hello");
        dp_test();
    }

    public static void dfs_test() {
        int[] weights = {7,3,2};
        int[] values = {160, 90,100};
        int maxWeight = 13;
        int result = dfs(weights, values, 2, maxWeight);
        System.out.println(result);
    }

    public static void dfsMemo_test() {
        int[] weights = {7,3,2};
        int[] values = {160, 90,100};
        int length = 2;
        int maxWeight = 13;

        Integer[] Memo = new Integer[maxWeight + 1];
        int result = dfsMemo(weights, values, length, maxWeight, Memo);
        System.out.println(result);
    }

    public static void dp_test() {
        int[] weights = {7,3,2};
        int[] values = {160, 90,100};
        int length = 2;
        int maxWeight = 13;

        int result = dp(weights, values, length, maxWeight);
        System.out.println(result);
    }


    public static int dfs(int[] weights, int[] values, int n, int maxWeight) {
        int max = 0;
        for (int i = 0; i < n; ++ i) {
            if (maxWeight > weights[i])
                max = Math.max(max, values[i] + dfs(weights, values, n, maxWeight - weights[i]));
        }
        return max;
    }

    public static int dfsMemo(int[] weights, int[] values, int n, int maxWeight, Integer[] Memo) {
        if (Memo[maxWeight] != null) return Memo[maxWeight];
        int max = 0;
        for (int i = 0; i < n; ++ i) {
            if (maxWeight > weights[i])
                max = Math.max(max, values[i] + dfsMemo(weights, values, n, maxWeight - weights[i], Memo));
        }
        return Memo[maxWeight] = max;
    }

    public static int dp(int[] weights, int[] values, int n, int maxWeight) {
        int[] dp = new int[maxWeight + 1];

        for (int weight = 1; weight <= maxWeight; ++ weight) {
            int max = 0;
            for (int i = 0; i < n; ++ i) {
                if (weight >= weights[i]) {
                    max = Math.max(max, values[i] + dp[weight - weights[i]]);
                }
            }
            dp[weight] = max;
        }
        return dp[maxWeight];
    }
}
