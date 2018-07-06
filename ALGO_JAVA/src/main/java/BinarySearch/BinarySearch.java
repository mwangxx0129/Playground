package BinarySearch;

import util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("hi");
        int[] a = {-1,1,3,4,6,7,7};
        int key = 0;
        int result = binarySearch(a, 0, a.length, key);
        System.out.println(result);

    }
    private static int binarySearch(int[]a, int fromIndex, int toIndex, int key) {
        return Arrays.binarySearch(a, fromIndex, toIndex, key);
    }
}
