class Solution {
    int mod;
    public int dfs(int r,int c,int[][] dp,int[][] grid,int m, int n){
        if (dp[r][c] != -1){
            return dp[r][c];
        }
        int cellValue = 1;
        int[][] direction = {{r-1,c},{r,c+1},{r+1,c},{r,c-1}};
        for(int[] d : direction){
            int nr = d[0] ; int nc = d[1];
            if((nr >= 0 && nr < m) && (nc >= 0 && nc < n) && (grid[nr][nc] > grid[r][c])){
                cellValue = cellValue % mod + dfs(nr,nc,dp,grid,m,n) % mod;
            }
        }
        return dp[r][c] = cellValue;
    }
    public int countPaths(int[][] grid) {
        int m = grid.length ; int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int ans = 0 ; mod = 1_00_00_00_007;
        for(int i = 0 ; i < m ; i ++){
            for(int j = 0 ; j < n ; j++){
                ans = ans % mod + dfs(i,j,dp,grid,m,n) % mod;
            }
        }
        return ans;
    }
}
