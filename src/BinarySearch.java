import java.util.Arrays;

public class BinarySearch {
    public int binarySearch(int[] A, int T) {
        Arrays.binarySearch(A, T);
        int l = 0, r = A.length - 1;
        while (l + 1 < r) {
            int m = (l + r) >>> 1;
            if (A[m] > T) {
                r = m;
            } else {
                l = m;
            }
        }
        return A[l] == T ? l : r;
    }
}
