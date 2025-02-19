class Solution {

    int getAns(List<Integer>arr, int tgt, int idx, int dp[][]){

        if(idx >= arr.size()){
            if(tgt == 0) return 0;
            else return Integer.MIN_VALUE;
        }

        if(dp[idx][tgt] != -1) return dp[idx][tgt];
        int skip = getAns(arr, tgt, idx+1,dp);
        if(tgt-arr.get(idx) < 0) return dp[idx][tgt] = skip;
        int take = 1 + getAns(arr, tgt-arr.get(idx), idx+1,dp);

        return dp[idx][tgt] = Math.max(skip,take);
    }

    public int lengthOfLongestSubsequence(List<Integer> arr, int tgt) {
        int dp[][] = new int[arr.size()][tgt+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans = getAns(arr, tgt, 0, dp);
        return (ans > 0)? ans:-1;
    }
}