class Solution {
    //recursion
    // int getAns(int[] cost, int idx,int dp[]){
    //     if(idx >= cost.length) return 0;

    //     if(dp[idx]!=-1) return dp[idx];
    //     int one = cost[idx] + getAns(cost, idx+1, dp);
    //     int two = cost[idx] + getAns(cost, idx+2, dp);

    //     return dp[idx]=Math.min(one,two);
    // }

    // public int minCostClimbingStairs(int[] cost) {
    //     int dp[] = new int[cost.length];
    //     Arrays.fill(dp,-1);
    //     int a1 = getAns(cost,0,dp);
    //     Arrays.fill(dp,-1);
    //     int a2 = getAns(cost,1,dp);
    //     return Math.min(a1,a2);
    // }

    //tabulation
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 1) return cost[0];
        if(cost.length == 2) return Math.min(cost[0], cost[1]);
        int dp[] = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.min(cost[i]+dp[i-2], cost[i]+dp[i-1]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }

}