(1) dfs recursive
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // init graph (adjList)
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        // make sure there's no cycle
        if (dfsCycle(adjList, 0, visited, -1)) {
            return false;
        }
        
        // check if all nodes are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    // dfs checking if there is cycle
    boolean dfsCycle(List<List<Integer>> adjList, int cur, boolean[] visited, int prev) {
        visited[cur] = true;
        
        for (int i = 0; i < adjList.get(cur).size(); i++) {
            int neighbor = adjList.get(cur).get(i);

            if (neighbor == prev) {
                continue;
            }
            else if (visited[neighbor]) {
                return true;
            }
            else {
                if (dfsCycle(adjList, neighbor, visited, cur)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

(2) dfs stack:
class Solution {
    private class NodeWithParent {
        int id;
        int parentId;
        
        public NodeWithParent(int id, int parentId) {
            this.id = id;
            this.parentId = parentId;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        // init graph (adjList)
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        // dfs
        boolean[] visited = new boolean[n]; 
        
        Deque<NodeWithParent> stack = new ArrayDeque<NodeWithParent>();
        stack.push(new NodeWithParent(0, -1));
        visited[0] = true;
        
        while (!stack.isEmpty()) {
            NodeWithParent cur = stack.pop();
            for (int neighborId: adjList.get(cur.id)) {
                if (neighborId == cur.parentId) {
                    continue;
                }
                else if ((visited[neighborId])) {
                    return false;
                }
                else {
                    stack.push(new NodeWithParent(neighborId, cur.id));
                    visited[neighborId] = true;
                }
            }
        }
        
        // check if all nodes are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        return true;
    }
}
