package lintcode.array;

import java.util.Arrays;

public class Problem389 {
    /**
     * @param board: the board
     * @return: whether the Sudoku is valid
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        // cow
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!process(visited, board[i][j])) {
                    return false;
                }
            }
        }
        // row
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (!process(visited, board[j][i])) {
                    return false;
                }
            }
        }

        // sub matrix
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Arrays.fill(visited, false);
                for (int k = 0; k < 9; k++) {
                    if (!process(visited, board[i + k / 3][j + k % 3])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean process(boolean[] visited, char digit) {
        if (digit == '.') {
            return true;
        }
        int num = digit - '0';
        if (num <= 0 || num > 9 || visited[num - 1]) {
            return false;
        }
        visited[num - 1] = true;
        return true;
    }
}
