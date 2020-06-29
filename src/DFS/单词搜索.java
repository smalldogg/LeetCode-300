package DFS;

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        boolean[][] v = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, v, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;

    }

    //1.递归的定义：找到word
    private boolean dfs(char[][] board, String word, boolean[][] v,
                        int index, int i, int j) {
        //3.递归的出口
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                word.charAt(index) != board[i][j] || v[i][j]) {
            return false;
        }
        v[i][j] = true;
        boolean exist =
                dfs(board, word, v, index + 1, i - 1, j) ||
                        dfs(board, word, v, index + 1, i + 1, j) ||
                        dfs(board, word, v, index + 1, i, j - 1) ||
                        dfs(board, word, v, index + 1, i, j + 1);
        //2.递归的拆解
        v[i][j] = false;
        return exist;
    }
}
