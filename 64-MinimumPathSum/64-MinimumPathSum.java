class Solution {


    int getAns(int[][] grid, int cr, int cc, int m, int n, int dp[][]){

        if(cr == m-1 && cc == n-1) return grid[cr][cc];
        if(cr >= m || cc >= n) return Integer.MAX_VALUE;

        if(dp[cr][cc] != -1) return dp[cr][cc];
        int right = getAns(grid, cr, cc+1, m, n, dp);
        int down = getAns(grid, cr+1, cc, m, n, dp);
        
        return dp[cr][cc]=Math.min(right,down)+grid[cr][cc];
    }

    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return getAns(grid, 0, 0, grid.length, grid[0].length, dp);

    }
}