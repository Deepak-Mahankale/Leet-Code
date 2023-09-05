class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visit, int curr) {
        visit[curr] = true;
        for (int a : adj.get(curr)) {
            if (!visit[a]) {
                dfs(adj, visit, a);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int cnt = 0;
        boolean[] visit = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visit[i]) {
                cnt++;
                dfs(adj, visit, i);
            }
        }
        return cnt;
    }
}