class Solution {


    // public int getAns(int[] coins, int amount, int idx, int sum){

    //     if(idx >= coins.length || amount <= 0) return sum;
        
    //     int skip = getAns(coins, amount, idx+1, sum+1);
    //     int take = getAns(coins, amount-coins[idx], idx, sum+1);

    //     return Math.min(skip, take);
    // }
    // public int coinChange(int[] coins, int amount) {
    //     return getAns(coins, amount, 0, 0);
    // }

    public int getAns(int[] coins, int amount, int idx, int dp[][]){

        if(idx == coins.length){
            if(amount == 0) return 0;
            else return Integer.MAX_VALUE-1;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];
        int skip = getAns(coins, amount, idx+1, dp);
        if(amount-coins[idx] < 0) return skip;
        int take = 1 + getAns(coins, amount-coins[idx], idx, dp);

        return dp[idx][amount] = Math.min(take,skip);
        
    }


    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans=getAns(coins, amount, 0, dp);
        return ans>214740000 ? -1: ans;
    }
}