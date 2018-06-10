public class CanWin {
    public static void main(String[] args) {

    }

    public static boolean canWin(int[] board, int pos) {
        boolean[] isVisited = new boolean[board.length];
        return dfs(board, isVisited, pos);
    }

    private static boolean dfs(int[] board, boolean[] isVisited, int pos) {
        if (pos < 0 || pos >= board.length) return false;
        if (isVisited[pos]) return false;
        isVisited[pos] = true;
        if (board[pos] == 0) return true;
        return dfs(board, isVisited,pos + board[pos]) && dfs(board, isVisited, pos - board[pos]);
    }
}
