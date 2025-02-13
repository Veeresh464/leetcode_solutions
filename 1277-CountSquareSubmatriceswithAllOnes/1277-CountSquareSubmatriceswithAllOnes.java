class Solution {

    //tabulation
    // public int countSquares(int[][] matrix) {
    //     int m = matrix.length;
    //     int n = matrix[0].length;
    //     if(m == 1 && n == 1) return matrix[0][0];

    //     for(int i=1; i<m; i++){
    //         for(int j=1; j<n; j++){
    //             if(matrix[i][j] != 0)matrix[i][j] += Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
    //         }
    //     }
    //     int s =0;
    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             s+=matrix[i][j];
    //         }
    //     }
    //     return s;
    // }


    int getAns(int [][]m, int cr, int cc, int[][]dp){

        if(cr < 0 || cc < 0) return 0;
        if(m[cr][cc] == 0) return 0;

        if(dp[cr][cc] != -1) return dp[cr][cc];
        int top = getAns(m, cr-1, cc, dp);
        int left = getAns(m, cr, cc-1, dp);
        int diag = getAns(m,cr-1,cc-1,dp);

        return dp[cr][cc]=1+Math.min(Math.min(top,left),diag);
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dp[][] = new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                ans+= getAns(matrix,i,j,dp);
            }
        }
        return ans;
    }


}