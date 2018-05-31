package May25_2018;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("hello");
        int result = reverseIntegerByHex(0x123);
        System.out.println(Integer.toHexString(result));
    }

    //  reverse integer
    //   input: 0x12345678
    //   output: 0x78563412
    public static int reverseIntegerByHex(int num) {
        int result = 0;
        while (num != 0) {
            result <<= 8;
            result |= num & 0x000000FF;
            num >>>= 8;
        }
        return result;
    }
}
