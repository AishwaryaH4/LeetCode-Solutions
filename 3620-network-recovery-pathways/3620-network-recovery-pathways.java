class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;

        List<int[]>[] graph = new ArrayList[n];
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxEdge = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxEdge = Math.max(maxEdge, e[2]);
        }

        List<Integer> topo = topoSort(graph, indegree);

        int low = 0;
        int high = maxEdge;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, graph, topo, online, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int mid, List<int[]>[] graph,
                          List<Integer> topo,
                          boolean[] online,
                          long k) {

        int n = graph.length;

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {

            if (dist[u] == INF)
                continue;

            if (u != 0 && u != n - 1 && !online[u])
                continue;

            for (int[] edge : graph[u]) {

                int v = edge[0];
                int cost = edge[1];

                if (cost < mid)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                dist[v] = Math.min(dist[v], dist[u] + cost);
            }
        }

        return dist[n - 1] <= k;
    }

    private List<Integer> topoSort(List<int[]>[] graph, int[] indegree) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        int[] deg = indegree.clone();

        for (int i = 0; i < deg.length; i++) {
            if (deg[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {

            int u = q.poll();
            topo.add(u);

            for (int[] edge : graph[u]) {

                int v = edge[0];

                if (--deg[v] == 0)
                    q.offer(v);
            }
        }

        return topo;
    }
}