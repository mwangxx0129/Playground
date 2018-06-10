package util;

public class Arrays {
    public static void main(String[] args) {
//        rangeCheck(5, 2, 1);

        System.out.println("");
    }

    /**
     * Checks that {@code fromIndex} and {@code toIndex} are in the
     * range and throws an exception if they are not.
     * */
    static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException(
                    "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    public static int binarySearch(int[] a, int fromIndex, int toIndex, int key) {
        rangeCheck(a.length, fromIndex, toIndex);
        return binarySearch_without_rangeCheck(a, fromIndex, toIndex, key);
    }

    private static int binarySearch_without_rangeCheck(int[] a, int fromIndex, int toIndex, int key) {
        int l = fromIndex;
        int r = toIndex - 1;

        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a[m] < key) {
                l = m + 1;
            } else if(a[m] > key) {
                r = m - 1;
            } else {
                return m;
            }
        }
        return - (l + 1);
    }
}
