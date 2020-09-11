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
