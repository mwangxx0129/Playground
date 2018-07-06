package Algo_From_May25_2018;
import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        int[][] res = solution(nums);
        System.out.println(res);
        System.out.println(Arrays.deepToString(res));
    }


    public static int[][] solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0][];
        }
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(new ArrayList<>(), visited, res, len, nums);
        int[][] result = new int[res.size()][nums.length];
        for (int index = 0; index < res.size(); ++ index) {
            List<Integer> row = res.get(index);
            for (int j = 0; j < nums.length; ++j) {
                result[index][j] = row.get(j);
            }
        }
        return result;
    }

    public static void dfs(List<Integer> list, boolean[] isVisited, List<List<Integer>> res, int len, int[] nums) {
        if (list.size() == len) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (isVisited[i]) continue;
            list.add(nums[i]);
            isVisited[i] = true;
            dfs(list, isVisited, res, len, nums);
            isVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
