class Solution {
    // recursive
    // int getAns(int [][]mat, int cr, int cc, int dp[][]){
    //     if(cr >= mat.length || cc >= mat[0].length) return 0;
    //     if(mat[cr][cc] == 1) return 0;
    //     if(cr == mat.length-1 && cc == mat[0].length-1) return 1;
    //     if(dp[cr][cc] != -1) return dp[cr][cc];
    //     int right = getAns(mat, cr, cc+1, dp);
    //     int down = getAns(mat, cr+1, cc, dp);
    //     return dp[cr][cc]=right+down;
    // }
    // public int uniquePathsWithObstacles(int[][] mat) {
    //     int dp[][] = new int[mat.length][mat[0].length];
    //     for(int row[]:dp){
    //         Arrays.fill(row, -1);
    //     }
    //     return getAns(mat, 0, 0, dp);
    // }


    //tabulation
    public int uniquePathsWithObstacles(int[][] mat) {
        if(mat[0][0] == 1) return 0;
        int dp[][] = new int[mat.length][mat[0].length];
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = dp[i][j-1];
                else if(j == 0) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }   
        return dp[mat.length-1][mat[0].length-1];     
    }

}