class Solution {
    boolean dfs(int[][] graph, int[] colors, int node, int col) {
        if (colors[node] != 0) {
            return colors[node] == col;
        }
        colors[node] = col;
        for (int n : graph[node]) {
            if (!dfs(graph, colors, n, -col)) {
                return false;
            }
        }
        return true;

    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(graph, colors, i, 1)) {
                return false;
            }
        }
        return true;
    }
}