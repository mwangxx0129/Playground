package Algo_From_May25_2018;

public class FindDuplicateNum {
    public static void main(String[] args) {
        System.out.println("hello");
        int [][] nums = {{3,2,4,2,1}, {2,2,2,2}, {1,2,1}};

        int result = solution(nums[2]);
        System.out.println(result);
    }
    public static int solution(int[] nums) {
        int s = 0, f = 0;
        int n = nums.length;
        while (s < n && f < n) {
            s = nums[s];
            f = nums[f];
            f = nums[f];
            if (s == f) break;
        }
        f = 0;
        while (s < n && s != f) {
            s = nums[s];
            f = nums[f];
        }
        return s;
    }
}
