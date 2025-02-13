class Solution {

    int getAns(int[] cost, int idx,int dp[]){
        if(idx >= cost.length) return 0;

        if(dp[idx]!=-1) return dp[idx];
        int one = cost[idx] + getAns(cost, idx+1, dp);
        int two = cost[idx] + getAns(cost, idx+2, dp);

        return dp[idx]=Math.min(one,two);
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        int a1 = getAns(cost,0,dp);
        Arrays.fill(dp,-1);
        int a2 = getAns(cost,1,dp);

        return Math.min(a1,a2);
    }
}