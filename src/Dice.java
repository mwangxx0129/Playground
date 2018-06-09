public class Dice {
    public static void main(String[] args) {
        System.out.println("hello");
        int DICES = 2, TARGET = 3;
        Double [][] memo = new Double[DICES + 1][DICES * 6 + 1];
        double result = dfs(0, TARGET, DICES, memo);

//        double resultDP = calculate(TARGET, DICES);
        System.out.println(result);
//        System.out.println(resultDP);
        System.out.println(1.0/ 18);
    }

    public static double dfs(int level, int target, int n) {
        if (level == n && target == 0) return 1;
        if (level == n || target < 0) return 0;
        double sum = 0.;
        for (int i = 1; i <= 6; ++ i) {
            sum += dfs(level + 1, target - i, n) / 6;
        }
        return sum;
    }

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

}
