class Solution {
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length]; 
        
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                dfs(M, visited, i);    
            }
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}

T: O(M*M)
S: dfs stack
