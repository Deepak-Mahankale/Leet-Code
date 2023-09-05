class Solution {
    public class pair {
        int row, col;
        int tm;

        public pair(int r, int c, int t) {
            this.row = r;
            this.col = c;
            this.tm = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();
        int[][] vist = new int[n][m];
        int fresh_count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new pair(i, j, 0));
                    vist[i][j] = 2;
                } else {
                    vist[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    fresh_count++;
                }
            }
        }

        int tm = 0;
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };
        int cnt = 0;
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t, tm);
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && vist[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.offer(new pair(nrow, ncol, t + 1));
                    vist[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != fresh_count) {
            return -1;
        }

        return tm;
    }
}