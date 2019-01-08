import java.math.BigInteger;

public class TT {
    public static void main(String[] args) {
        BigInteger.valueOf(100);
        System.out.println("hei");
        System.out.println(reverse(-123));
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
}
