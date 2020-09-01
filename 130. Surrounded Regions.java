class Solution {
    public void solve(char[][] board) {
        if (board.length < 2 || board[0].length < 2) {
            return;
        }
            
        int h = board.length;
        int w = board[0].length;

        for (int i = 0; i < h; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][w - 1] == 'O') {
                dfs(board, i, w - 1); 
            }     
        }
        for (int j = 0; j < w; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[h - 1][j] == 'O') {
                dfs(board, h - 1, j); 
            }   
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '.') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (!(board[i][j] == 'O')) {
            return;
        }
        
        board[i][j] = '.';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
