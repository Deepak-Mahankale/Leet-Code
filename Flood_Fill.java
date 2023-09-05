class Solution {

    public void dfs(int[][] image, int[][] ans, int sr, int sc, int[] delr, int[] delc, int initColor, int newColor) {
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + delr[i];
            int ncol = sc + delc[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initColor
                    && ans[nrow][ncol] != newColor) {
                dfs(image, ans, nrow, ncol, delr, delc, initColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int intiColor = image[sr][sc];
        int newColor = color;
        int[] delr = { -1, 0, +1, 0 };
        int[] delc = { 0, +1, 0, -1 };

        dfs(image, ans, sr, sc, delr, delc, intiColor, newColor);
        return ans;

    }
}