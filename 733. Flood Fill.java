class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        boolean[][] visited = new boolean[image.length][image[0].length];
       
        if (sr < 0 || sr > image.length - 1 || sc < 0 || sc > image[0].length - 1) {
            return image;
        }
        
        dfs(image, visited, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, boolean[][] visited, int sr, int sc, int newColor) {
        
        if (visited[sr][sc]) {
            return;
        }
        
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        visited[sr][sc] = true;
        
        if (sr > 0 && image[sr - 1][sc] == oldColor) {
            dfs(image, visited, sr - 1, sc, newColor);
        }
        if (sr < image.length - 1 && image[sr + 1][sc] == oldColor) {
            dfs(image, visited, sr + 1, sc, newColor);
        }
        if (sc > 0 && image[sr][sc - 1] == oldColor) {
            dfs(image, visited, sr, sc - 1, newColor);
        }
        if (sc < image[0].length - 1 && image[sr][sc + 1] == oldColor) {
            dfs(image, visited, sr, sc + 1, newColor);
        }
    }
}


T: O(mn)
S: dfs stack
