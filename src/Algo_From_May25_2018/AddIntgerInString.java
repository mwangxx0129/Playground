package Algo_From_May25_2018;

public class AddIntgerInString {
    public static void main(String[] args) {
        System.out.println("hello");
        String a = "12345689";
        String b = "12345689";
        String result = solution(a, b);
        System.out.println(result + "\t" + (Integer.valueOf(a) + Integer.valueOf(b)));
    }

    public static String solution(String a, String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();

        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int ap = A.length - 1, bp = B.length - 1;ap >= 0 || bp >= 0; -- ap, -- bp) {
            int aDigit = ap >= 0 ? A[ap] - '0' : 0;
            int bDigit = bp >= 0 ? B[bp] - '0' : 0;
            sum += aDigit + bDigit;
            sb.insert(0, sum % 10);
            sum /= 10;
        }
        if (sum != 0) sb.insert(0, 1);
        return sb.toString();
    }
}
