class Solution {

    long getAns(int arr[], int x, int idx, int p, long dp[][]){

        if(idx >= arr.length) return 0;

        if(dp[idx][p] != -1) return dp[idx][p];
        long skip = getAns(arr,x, idx+1, p,dp);
        long ans = arr[idx];
        if(p != (arr[idx]%2)){
            ans -= x;
        }

        long take = ans+getAns(arr,x,idx+1,arr[idx]%2,dp);

        return dp[idx][p]=Math.max(take,skip);
    }

    public long maxScore(int[] arr, int x) {
        long dp[][] = new long[arr.length][2];
        for(long row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(arr,x,1,arr[0]%2,dp)+arr[0];
    }
}