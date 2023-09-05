class Solution {
    class node {
        int first;
        int second;
        int third;

        public node(int f, int s, int t) {
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] visit = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new node(i, j, 0));
                    visit[i][j] = 1;
                } else {
                    visit[i][j] = 0;
                }
            }
        }

        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int dt = q.peek().third;
            q.remove();
            dist[row][col] = dt;
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visit[nrow][ncol] == 0) {
                    visit[nrow][ncol] = 1;
                    q.add(new node(nrow, ncol, dt + 1));
                }
            }
        }

        return dist;
    }
}