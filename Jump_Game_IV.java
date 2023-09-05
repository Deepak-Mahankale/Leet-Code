import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        int steps = 0;
        int n = arr.length;
        Map<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(arr[i])) {
                // if not present in hm currently
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                hm.put(arr[i], temp);
            } else {
                List<Integer> temp = hm.get(arr[i]);
                temp.add(i);
                hm.put(arr[i], temp);
            }
        }
        // bfs
        boolean vis[] = new boolean[n];
        vis[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // intial index in queue
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currentidx = q.poll();
                // base case
                if (currentidx == n - 1) {
                    return steps;
                }
                // pushing the adj elements in adj list
                List<Integer> adj = hm.get(arr[currentidx]);
                // left and right
                adj.add(currentidx + 1);
                adj.add(currentidx - 1);

                // traversing the adj list
                for (int r : adj) {
                    if (r >= 0 && r < n && !vis[r]) {
                        vis[r] = true;
                        q.add(r);
                    }
                }
                adj.clear();
            }
            steps++; // after evey one layer
        }
        return steps;
    }
}