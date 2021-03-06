package lintcode.graph;

import java.util.*;

public class Problem178 {
    /**
     * bfs
     *
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */

    public boolean validTree(int n, int[][] edges) {
        // write your code here

        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }

        // bfs
        Map<Integer, Set<Integer>> graph = GenerateGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (set.contains(neighbor)) {
                    continue;
                }
                set.add(neighbor);
                queue.offer(neighbor);
            }
        }
        return set.size() == n;
    }

    /**
     * dfs
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree2(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }

        // dfs
        Map<Integer, Set<Integer>> graph = GenerateGraph(n, edges);
        boolean[] visited = new boolean[n];

        // 检查连通图有环
        if (!validTreeCore(0, visited, graph)) {
            return false;
        }

        // 非联通图检查
        for (boolean flag : visited) {
            if (!flag) {
                return false;
            }
        }
        return true;
    }

    private boolean validTreeCore(int cur, boolean[] visited, Map<Integer, Set<Integer>> graph) {
        if (visited[cur]) {
            return false;
        }

        visited[cur] = true;
        for (int neighbor : graph.get(cur)) {
            validTreeCore(neighbor, visited, graph);
        }
        return true;
    }

    // 生成图
    private Map<Integer, Set<Integer>> GenerateGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int v = edges[i][0];
            int u = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    class UnionFind {

        private int[] id;
        private int count;

        public UnionFind(int N) {
            id = new int[N];
            count = N;
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public int find(int p) {
            return id[p];
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public int count() {
            return count;
        }

        public void union(int p, int q) {
            int pID = find(p);
            int qID = find(q);
            if (pID == qID)
                return;
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pID) id[i] = qID;
            }
            count--;
        }
    }

    /**
     * union find
     *
     * @param n
     * @param edges
     * @return
     */
    public boolean validTree3(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return false;
        }
        if (edges.length != n - 1) {
            return false;
        }

        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < edges.length; i++) {
            if (uf.find(edges[i][0]) == uf.find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
