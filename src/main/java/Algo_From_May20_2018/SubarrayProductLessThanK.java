package Algo_From_May20_2018;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        int result = subarrayProductLessThanK(nums, k);
        System.out.println(result);
    }

    public static int subarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int n = nums.length;
        int count = 0;
        for (int r = 0, l = 0; r < n; ++ r) {
            product *= nums[r];
            // l <= r [1,1,1]
            while (product >= k && l <= r) product /= nums[l ++];
            count += r - l + 1;
        }
        return count;
    }
}
