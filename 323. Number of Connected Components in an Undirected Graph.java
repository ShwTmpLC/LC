class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        
        // build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // add edges
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        // dfs
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                dfs(graph, visited, i);
            }
        }
        return count;
    }
    
    private void dfs(List<List<Integer>> graph, boolean[] visited, int i) {
        for (int neighbor : graph.get(i)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                dfs(graph, visited, neighbor);
            }
        }
    }
    
    
}
