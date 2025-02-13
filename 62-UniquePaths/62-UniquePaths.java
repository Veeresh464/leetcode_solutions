class Solution {

    int getAns(int m, int n, int cr, int cc, int [][]dp){
        if(cr == m-1 && cc == n-1) return 1;
        if(cr >= m || cc >= n) return 0;

        if(dp[cr][cc] != -1) return dp[cr][cc];
        int right = getAns(m,n,cr,cc+1,dp);
        int down = getAns(m,n,cr+1,cc,dp);

        return dp[cr][cc]=right+down;
    }

    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[]row : dp){
            Arrays.fill(row,-1);
        }
        return getAns(m,n,0,0,dp);
    }
}