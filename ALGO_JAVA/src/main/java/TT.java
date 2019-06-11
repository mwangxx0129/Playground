import util.Arrays;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class TT {
    public static void main(String[] args) {
        int[] A = {3,2,5,6,1};
        int index = binarySearch(A, 1);
        System.out.println(index);
    }

    public static int binarySearch(int[] A, int target) {
        int l = 0, r = A.length - 1;
        java.util.Arrays.sort(A);
        while (l + 1 < r) {
            int m = (l + r) >> 1;
            if (A[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }

        if (target == A[l]) {
            return l;
        } else if(target == A[r]) {
            return r;
        } else {
            return -1;
        }
    }

    public static void insertionSort(int[] A) {
        if (A == null || A.length <= 1) return;

        for (int i = 1; i < A.length; ++ i) {
            int insertValue = A[i];
            int j = i - 1;
            while (j >= 0 && A[j] > insertValue) {
                A[j + 1] = A[j];
                -- j;
            }
            A[j + 1] = insertValue;
        }
    }

    public static void mergeSort(int[] A) {
        int[] B = new int[A.length];
        helper(A, B, 0, A.length - 1);
        System.out.println(Arrays.toString(B));
    }

    private static void helper(int[] A, int[] B, int first, int last) {
        if (first >= last)  {
            return;
        }
        int mid = (first + last) / 2;
        helper(A, B, first, mid);
        helper(A, B, mid + 1, last);
        mergeTwoArray(A, B, first, mid, last);
    }

    private static void mergeTwoArray(int []A, int[] B, int first, int mid, int last) {
        int cur = first;
        int left = first, right = mid + 1;
        while (left <= mid && right <= last) {
            if (A[left] < A[right]) {
                B[cur ++] = A[left ++];
            } else {
                B[cur ++] = A[right ++];
            }
        }
        while (left <= mid) {
            B[cur ++] = A[left ++];
        }
        while (right <= last) {
            B[cur ++] = A[right ++];
        }
        copy(B, A, first, last);
    }

    private static void copy(int[] src, int[] des, int first, int last) {
        if (src == null || des == null ||src.length != des.length) return;
        for (int i = first; i <= last; ++ i) {
            des[i] = src[i];
        }
    }


    public static void quickSort(int[] A, int first, int last) {
        if (A == null || last - first + 1 <= 1) {
            return; //handle null or length  less equal 1
        }

        // quick select
        int[] scopeEqualsPivot = quickSelect(A, first, last, A[first]);
        quickSort(A, first, scopeEqualsPivot[0] - 1);
        quickSort(A, scopeEqualsPivot[1] + 1, last);
    }

    private static int[] quickSelect(int[] A, int first, int last, int pivot) {
        if (A == null || last - first + 1 <= 1) {
            return new int[] {-1, -1}; // should not reach here
        }

        int left = first, right = last, cur = left;

        while (left < right) {
            if (A[cur] < pivot) {
                swap(A, left, cur);
                left ++;
                cur ++;
            } else if (A[cur] ==  pivot) {
                cur ++;
            } else {
                swap(A, cur, right);
                right --;
            }
        }

        return new int[] {left, right};
    }

    private static void swap(int[] A, int left, int right) {
        if (left != right) {
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
        }
    }

    public static  int reverse(int x) {
        if (x == 0) return 0;

        boolean neg = false;
        if (x < 0) neg = true;

        long l = x;
        long r = 0;
        while (l != 0) {
            r = r * 10 + l % 10;
            l /= 10;
        }

        if (r >Integer.MAX_VALUE || r < Integer.MIN_VALUE) return 0;
        return (int) r * (neg ? -1 : 1);
    }

    static String longest = "";
    public static String longestPalindromicString(String s) {
        if (s == null) {
            return null;
        }

        helper(s, 0, "");
        return longest;
    }

    public static void helper(String s, int i, String c) {
        if (i >= s.length()) return;
        if (isPalindrome(c) && c.length() > longest.length()) {
            longest = c;
        }
        helper(s, i + 1, c);
        helper(s, i + 1, c + s.charAt(i));
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            -- left;
            ++ right;
        }
        return true;
    }
}
