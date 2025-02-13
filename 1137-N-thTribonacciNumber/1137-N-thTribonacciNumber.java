class Solution {
    //recursion
    // int getAns(int n, int dp[]){
    //     if(n==0) return 0;
    //     if(n==1 || n==2) return 1;

    //     if(dp[n] != -1) return dp[n];
    //     int a = getAns(n-1, dp) + getAns(n-2, dp) + getAns(n-3, dp);
    //     return dp[n]=a;
    // }
    // public int tribonacci(int n) {
    //     int dp[] = new int[n+1];
    //     Arrays.fill(dp,-1);
    //     return getAns(n,dp);
    // }

    //tabulation
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3; i<dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[dp.length-1];
    }

}