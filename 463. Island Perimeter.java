class Solution {
    public int islandPerimeter(int[][] grid) {
        int numIsland = 0;
        int numNeighbor = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) { 
                if (grid[i][j] == 1) {
                    numIsland++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        numNeighbor++;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        numNeighbor++;
                    }
                }
            }
        }
        return numIsland * 4 - numNeighbor * 2;
    }
}


T: O(mn)
S: O(1)
