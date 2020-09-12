/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X*/

//https://leetcode.com/problems/surrounded-regions/

class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board.length == 2 || board == null) return;
        
        int r = board.length;
        int c  =board[0].length;
        
        //check first and last rows
        for(int i = 0; i < c; i++) {
            if(board[0][i] == 'O') search(board, 0, i);
            if(board[r-1][i] == 'O') search(board, r-1, i);
        }
        //check first and last column
        for(int i = 0; i < r; i++) {
            if(board[i][0] == 'O') search(board, i, 0);
            if(board[i][c-1] == 'O') search(board, i, c-1);
        }
        //in the end set O to X and * to O 
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    public void search(char[][] board, int r, int c) {
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        //set not surrounded O to *
        board[r][c] = '*';
        
        //check neighbours of board[r][c] if they are O then make them * as well
        for(int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];
            
            if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) continue;
            if(board[x][y] == 'O') search(board, x, y);
        }
    }
}