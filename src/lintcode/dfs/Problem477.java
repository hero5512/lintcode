package lintcode.dfs;

public class Problem477 {
    /**
     * dfs
     *
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }

        for (int i = 0; i < col; i++) {
            dfs(board, 0, i);
            dfs(board, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        if (board[row][col] != 'O') {
            return;
        }
        board[row][col] = '#';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }
}
