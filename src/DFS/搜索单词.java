package DFS;

/**
 * @author wangyh
 * @create 2020-02-13 15:44
 */

public class 搜索单词 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 ||
                board[0] == null || board[0].length == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] v = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (search(board, i, j, v, word, 0)) return true;
            }
        }
        return false;
    }


    private boolean search(char[][] board, int i, int j, boolean[][] v, String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                word.charAt(idx) != board[i][j] || v[i][j]) return false;
        v[i][j] = true;
        boolean res =
                search(board, i + 1, j, v, word, idx + 1)
                        || search(board, i - 1, j, v, word, idx + 1)
                        || search(board, i, j + 1, v, word, idx + 1)
                        || search(board, i, j - 1, v, word, idx + 1);
        v[i][j] = false;
        return res;
    }
}
