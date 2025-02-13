class Solution {

    //recursion
    // int getAns(int n, int dp[]){    
    //     if(n < 0) return 0;
    //     if(n == 0) return 1;

    //     if(dp[n] != -1) return dp[n];
    //     int one = getAns(n-1, dp);
    //     int two = getAns(n-2, dp);
        
    //     return dp[n]=one+two;
    // }
    // public int climbStairs(int n) {
    //     int dp[] = new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return getAns(n, dp);
    // }

    //tabulation
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}