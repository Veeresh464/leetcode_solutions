class Solution {

    int getAns(int n, int dp[]){
        
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(dp[n] != -1) return dp[n];
        int one = getAns(n-1, dp);
        int two = getAns(n-2, dp);
        
        return dp[n]=one+two;
    }

    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return getAns(n, dp);
    }
}