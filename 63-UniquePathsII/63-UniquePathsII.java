class Solution {

    int getAns(int [][]mat, int cr, int cc, int dp[][]){
        if(cr >= mat.length || cc >= mat[0].length) return 0;
        if(mat[cr][cc] == 1) return 0;
        if(cr == mat.length-1 && cc == mat[0].length-1) return 1;

        if(dp[cr][cc] != -1) return dp[cr][cc];
        int right = getAns(mat, cr, cc+1, dp);
        int down = getAns(mat, cr+1, cc, dp);
        return dp[cr][cc]=right+down;
    }

    public int uniquePathsWithObstacles(int[][] mat) {
        int dp[][] = new int[mat.length][mat[0].length];
        for(int row[]:dp){
            Arrays.fill(row, -1);
        }
        return getAns(mat, 0, 0, dp);
    }
}