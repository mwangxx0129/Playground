package Algo_From_May25_2018;
import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        List<List<Integer>> res = permutation(nums);
        System.out.println(res);
    }
    public static List<List<Integer>> permutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[len];
        dfs(new ArrayList<>(), visited, res, len, nums);
        return res;
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
