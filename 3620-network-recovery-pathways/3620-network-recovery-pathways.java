import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        long maxCost = 0;

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int cost = e[2];

            graph[u].add(new int[]{v, cost});
            indegree[v]++;

            maxCost = Math.max(maxCost, cost);
        }

        // Topological Sort
        int[] topo = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo[idx++] = u;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        long left = 0;
        long right = maxCost;
        int answer = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canReach(mid, graph, topo, online, k, n)) {
                answer = (int) mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canReach(long minEdgeCost,
                             List<int[]>[] graph,
                             int[] topo,
                             boolean[] online,
                             long k,
                             int n) {

        long INF = Long.MAX_VALUE / 4;
        long[] dp = new long[n];
        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int u : topo) {

            if (dp[u] == INF) continue;

            if (u != 0 && u != n - 1 && !online[u]) {
                continue;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int cost = edge[1];

                if (cost < minEdgeCost) continue;

                if (v != 0 && v != n - 1 && !online[v]) {
                    continue;
                }

                dp[v] = Math.min(dp[v], dp[u] + cost);
            }
        }

        return dp[n - 1] <= k;
    }
}