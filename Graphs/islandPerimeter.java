/*You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
*/

//https://leetcode.com/problems/island-perimeter/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        int directions[][] = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; //  4 directions to search
        
        for(int i = 0; i < grid.length; i++) {
            for( int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    for(int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        // if x or y are out of bounds or grid[x][y] == 0 then +1 perimeter
                        if(x < 0 || x == grid.length || y < 0 || y == grid[i].length || grid[x][y] == 0) result++;
                    }
                }
            }
        }
        return result;
    }
}