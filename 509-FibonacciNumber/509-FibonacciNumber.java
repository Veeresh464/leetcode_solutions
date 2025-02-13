class Solution {


    int getAns(int n, int[]dp){
        if(n==0) return 0;
        if(n==1) return 1;

        if(dp[n] != -1) return dp[n];
        int ans = getAns(n-1, dp) + getAns(n-2, dp);
        return dp[n]=ans;
    }

    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return getAns(n, dp);
    }
}