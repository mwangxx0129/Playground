package Algo_From_May25_2018;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MultipleRecursive {
    public static void main(String[] args) {
        System.out.println("hello");
        int[][] inputs = {{1,6,8,4,9,13,12},{1,2,3,2}};
        int factor = 3;
        int[] result = solution(inputs[1], factor);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] nums, int factor) {
        int [] result = new int[nums.length];
        Map<Integer, Integer> h = new HashMap<>();
        for (int e : nums) {
            h.put(e, -1);
        }
        for (int i = 0; i < nums.length; ++ i) {
            result[i] = calculateRecursive(h, nums[i], factor);
        }

        return result;
    }

    public static int calculateRecursive(Map<Integer, Integer> h, int e, int f) {
        if (h.containsKey(f * e)) {
            h.put(e, calculateRecursive(h, f * e, f));
            return h.get(e);
        }
        return f * e;
    }
}
