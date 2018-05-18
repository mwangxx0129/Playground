import java.util.*;

public class isBipartite {
    public static void main(String [] args) {
        System.out.println("hello");
    }
    public static boolean isValid(int[][] graph) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] visited = new int[100];
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; ++ i) {
            if (visited[i] != -1) continue;
            queue.offerLast(i);
            visited[i] = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; ++ j) {
                    int cur = queue.pollFirst();
                    for (int nx : graph[cur]) {
                        if (visited[nx] == visited[cur]) return false;
                        if (visited[nx] == -1) {
                            visited[nx] = visited[cur] ^ 0x1;
                            queue.offerLast(nx);
                        }
                    }
                }
            }
        }
        return true;
    }
}
