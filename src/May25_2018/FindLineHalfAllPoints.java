package May25_2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FindLineHalfAllPoints {
    public static void main(String[] args) {
        System.out.println("hello");
//        int[][] points = {{-1,0}, {1,0}, {-2, 0}, {2,0}};
        int[][] points = {{4,0}, {6,0}, {3, 4}, {7,4}, {5, 0}};
        boolean result = solution(points);
        System.out.println(result);
    }

    public static boolean solution(int[][] points) {
        // get line x, which parallel with Y axis
        int sumX = 0;
        int n = points.length;
        for (int[] p : points) {
            sumX += p[0];
        }
        int x = sumX / n;
        System.out.println(x);

        // verify x
        Map<String, Integer> map = new HashMap<>();
        for (int[] p : points) {
            if (p[0] == x) continue;
            String key = (2 * x - p[0]) + "#" + p[1];
            String mapKey = p[0] + "#" + p[1];

            if (map.containsKey(mapKey)) {
                int val = map.get(mapKey);
                map.put(mapKey, val - 1);
            } else if (map.containsKey(key)) {
                int val = map.get(mapKey);
                map.put(mapKey, val + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) return false;
        }
        return true;
    }
}
