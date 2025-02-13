class Solution {

    //recursion
    // int getAns(int[][] grid, int cr, int cc, int m, int n, int dp[][]){

    //     if(cr == m-1 && cc == n-1) return grid[cr][cc];
    //     if(cr >= m || cc >= n) return Integer.MAX_VALUE;

    //     if(dp[cr][cc] != -1) return dp[cr][cc];
    //     int right = getAns(grid, cr, cc+1, m, n, dp);
    //     int down = getAns(grid, cr+1, cc, m, n, dp);
        
    //     return dp[cr][cc]=Math.min(right,down)+grid[cr][cc];
    // }
    // public int minPathSum(int[][] grid) {
    //     int dp[][] = new int[grid.length][grid[0].length];
    //     for(int row[] : dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return getAns(grid, 0, 0, grid.length, grid[0].length, dp);
    // }

    //tabulation
    public int minPathSum(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1) return grid[0][0];
        if(grid.length == 1){
            int s=0;
            for(int i=0; i<grid[0].length; i++){
                s+=grid[0][i];
            }
            return s;
        }

        for(int i=1; i<grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }
        for(int i=1; i<grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i=1; i<grid.length; i++){
            for(int j=1; j<grid[0].length; j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

}