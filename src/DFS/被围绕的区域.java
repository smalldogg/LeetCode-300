package DFS;

/**
 * @author wangyh
 * @create 2020-08-11 22:16
 */

public class 被围绕的区域 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        //与边界相连的 o 不会变
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < n; ++i) {
            dfs(0, i, board);
            dfs(m - 1, i, board);
        }

        for (int i = 0; i < m; ++i) {
            dfs(i, 0, board);
            dfs(i, n - 1, board);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'P') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length
                || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'P';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
