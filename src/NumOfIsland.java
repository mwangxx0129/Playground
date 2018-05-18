public class NumOfIsland {
    public static void main(String[] args) {
        test();
    }

    public static void test () {
        char [][] island= {
                {'1','1','0'},
                {'0','1','0'},
                {'0','0','1'}
        };
        int result = dfs_numOfIsland(island);
        System.out.println(result);
    }


    public static int bfs_numOfIsland(char[][] grid) {
//        ...
        return -1;
    }

    public static int dfs_numOfIsland(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; ++ i) {
            for (int j = 0; j < n; ++ j) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num ++;
                }
            }
        }
        return num;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]  == '0') return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}
