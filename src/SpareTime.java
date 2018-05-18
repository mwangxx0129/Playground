import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpareTime {
    public static void main(String[] args) {
        System.out.println("hello");
        testConvert();
    }

    public static void testConvert() {
        for (int i = 0; i < 1000; ++ i) {
            String time = MMToHHmm(i);
            int test = HHmmToMinute(time);
            System.out.println(i + "\t" + time + "\t" + test);
        }
    }

    public static void test() {
        int[][] busyTimes = {
                {1,4},
                {2,5},
                {7,8}
        };
        List<int[]> result = getSpareTime(busyTimes);
        for (int[] e : result) {
            System.out.println(e[0] + "\t" + e[1]);
        }
    }

    public static List<int[]> getSpareTime(int[][] busyTimes) {
        Arrays.sort(busyTimes, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int last = busyTimes[0][1];
        for (int i = 1; i < busyTimes.length; ++ i) {
            if (last >= busyTimes[i][0]) {
                last = Math.max(last, busyTimes[i][1]);
            } else {
                result.add(new int[] {last, busyTimes[i][0]});
                last = busyTimes[i][1];
            }

        }
        return result;
    }

    // 10:00
    static int HHmmToMinute(String time) {
        String[] tokens = time.split(":");
        return Integer.valueOf(tokens[0]) * 60  + Integer.valueOf(tokens[1]);
    }

    static String MMToHHmm(int minute) {
        int h = minute / 60;
        int m = minute % 60;
        return "" + (h >= 10 ? h : "0" + h) + ":" + (m >= 10 ? m : "0" + m);
    }
}
