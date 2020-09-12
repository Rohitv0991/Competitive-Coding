/*Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's 
(representing land) connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)*/

//https://leetcode.com/problems/max-area-of-island/

class Solution {
    int max = 0;
    int currMax = 0;
    int[][] dir = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        if(r == 0 || grid == null) return 0;
        int c = grid[0].length;
        
        for(int i  = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(grid[i][j] == 0) continue;
				//if 1 then call countSize
                countSize(grid, i, j);
				//after every call here set max value and reset currMax
                max = currMax > max ? currMax : max;
                currMax = 0;
            }
            
        }
        return max;
    }
    
    public void countSize(int[][] grid, int r, int c) {
        currMax++;
        grid[r][c] = 0;
        //check all neighbours of grid[r][c]
        for(int[] d : dir) {
            int x = r + d[0];
            int y = c + d[1];
            //if x or y is out of bounds then skip one iteration
            if(x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) continue;
			// if x and y are valid and grid[x][y] contains 1 then calls itself
            if(grid[x][y] == 1) countSize(grid, x, y);
        }
    }
}