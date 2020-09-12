/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3 */

//https://leetcode.com/problems/number-of-islands/

class Solution {
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int r = grid.length;
        if(r == 0 || grid == null) return 0;
        int c = grid[0].length;
        int result = 0;
        
        //iterate through all elements, if its 1 then result++ and make all its neighbour 1's 0
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == '1') {
                    result++;
                    island(grid, i, j);
                }
            }
        }
        return result;
    }
    
    //makes all neighbouring 1's 0 when called
    public void island(char[][] grid, int r, int c) {
        int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        
        grid[r][c] = '0';
        
        for(int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];
            
            if(x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) continue;
            if(grid[x][y] == '1') island(grid, x, y);
        }
    }
}