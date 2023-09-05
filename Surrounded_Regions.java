class Solution {

    public void dfs(char[][] board, int[][] visit, int[] delr, int[] delc, int n, int m, int row, int col) {
        visit[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delr[i];
            int ncol = col + delc[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visit[nrow][ncol] == 0 && board[nrow][ncol] == 'O') {
                dfs(board, visit, delr, delc, n, m, nrow, ncol);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] delr = { -1, 0, +1, 0 };
        int[] delc = { 0, +1, 0, -1 };
        int[][] visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (visit[i][0] == 0 && board[i][0] == 'O') {
                dfs(board, visit, delr, delc, n, m, i, 0);
            }

            if (visit[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                dfs(board, visit, delr, delc, n, m, i, m - 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (visit[0][j] == 0 && board[0][j] == 'O') {
                dfs(board, visit, delr, delc, n, m, 0, j);
            }
            if (visit[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                dfs(board, visit, delr, delc, n, m, n - 1, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visit[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}