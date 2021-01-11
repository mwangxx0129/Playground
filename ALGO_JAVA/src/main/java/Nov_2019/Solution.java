package Nov_2019;

import util.Arrays;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] A = new int[] {5,4,3,2,1,2,1,1,2};
        shuffle(A);
        System.out.println(Arrays.toString(A));
        quickSort(A, 0, A.length - 1);
//        mergeSort(A, new int[A.length], 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        int index = binarySearch(A, 3);
        System.out.println(index);
    }

    public static int binarySearch(int[] A, int target) {
        int l = 0, r = A.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (A[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if (A[l] == target) return l;
        if (A[r] == target) return r;
        return -1;
    }

    public static void mergeSort(int[] A, int[] B, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >>> 1;
        mergeSort(A, B, start, mid);
        mergeSort(A, B,mid + 1, end);
        merge(A, B, start, mid, mid + 1, end);

    }

    private static void merge(int[] A, int[] B, int firstStart, int firstEnd, int secondStart, int secondEnd) {
        int cur = firstStart, f = firstStart, s = secondStart;
        while (f <= firstEnd && s <= secondEnd) {
            if (A[f] <= A[s]) {
                B[cur ++] = A[f ++];
            } else {
                B[cur ++] = A[s ++];
            }
        }

        while (f <= firstEnd) {
            B[cur ++] = A[f ++];
        }
        while (s <= secondEnd) {
            B[cur ++] = A[s ++];
        }

        for (int i = firstStart; i <= secondEnd; ++ i) {
            A[i] = B[i];
        }
    }

    public static void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        int[] res = quickSelect(A, start, end, A[(start + end)>>>1]);
        quickSort(A, start, res[0] - 1);
        quickSort(A, res[1] + 1, end);
    }

    public static int[] quickSelect(int[] A, int start, int end, int pivot) {
        int c = start, l = start, r = end;
        while (c <= r) {
            if (A[c] < pivot) {
                swap(A, l ++, c ++);
            } else if (A[c] > pivot) {
                swap(A, c, r --);
            } else {
                ++ c;
            }
        }
        return new int[] {l, r};
    }

    public static void shuffle(int[] A) {
        int len = A.length;
        while (len > 0) {
            Random rand = new Random();
            int index = rand.nextInt(len);
            swap(A, index, --len);
        }
    }

    private static void swap(int[] A, int l, int r) {
        if (A[l] == A[r]) return;
        int temp = A[l];
        A[l] = A[r];
        A[r] = temp;
    }
}
