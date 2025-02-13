class Solution {
    //recursion
    // int getAns(int n, int[]dp){
    //     if(n==0) return 0;
    //     if(n==1) return 1;

    //     if(dp[n] != -1) return dp[n];
    //     int ans = getAns(n-1, dp) + getAns(n-2, dp);
    //     return dp[n]=ans;
    // }

    // public int fib(int n) {
    //     int dp[] = new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return getAns(n, dp);
    // }

    //tabulation
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}