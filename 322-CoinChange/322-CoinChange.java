class Solution {


    int getAns(int arr[], int amt, int idx, int[][]dp){
        if(arr.length == idx){
            if(amt == 0) return 0;
            else return Integer.MAX_VALUE;
        }
        if(dp[idx][amt] != -1) return dp[idx][amt];
        int skip = getAns(arr, amt, idx+1, dp);
        if(amt - arr[idx] < 0) return dp[idx][amt]=skip;
        int take = getAns(arr, amt-arr[idx], idx, dp);
        if(take != Integer.MAX_VALUE){
            take++;
        }
        return dp[idx][amt]=Math.min(skip, take);
    }   

    public int coinChange(int[] arr, int amt) {
        int dp[][] = new int[arr.length][amt+1];
        for(int row[]: dp){
            Arrays.fill(row,-1);
        }
        int ans = getAns(arr,amt, 0, dp);
        System.out.println(ans);
        return (ans <= 2147483000)? ans:-1;
    }
}