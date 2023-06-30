class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
       
        //binary search
        int i = 1;
        int j = row*col;
        while(i < j) {
            int mid = i+(j-i)/2;
            boolean[][] grid = new boolean[row][col];
            boolean crosses = false;

            //update the grid
            for(int k = 0; k < mid; k++) {
                grid[cells[k][0]-1][cells[k][1]-1] = true;
            }

            //loop through each top layer
            for(int k = 0; k < col; k++) {
                if(!grid[0][k] && dfs(0, k, grid)) {
                    crosses = true;
                    break;
                }
            }

            //adjust
            if(crosses) i = mid+1;
            else j = mid;
        }
        return i-1;
    }

    //DFS
    private boolean dfs(int i, int j, boolean[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j]) return false;
        if(i == grid.length - 1) return true;
        grid[i][j] = true;
        if(dfs(i+1, j, grid) ||
        dfs(i-1, j, grid) ||
        dfs(i, j+1, grid) ||
        dfs(i, j-1, grid)) return true;
        return false;
    } 
}
