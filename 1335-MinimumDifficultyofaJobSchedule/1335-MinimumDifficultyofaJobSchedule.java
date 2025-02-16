class Solution {


    int getAns(int[] arr, int d, int idx, int [][] dp){

        if(d==1){
            int m = arr[idx];
            for(int j=idx; j<arr.length; j++){
                if(arr[j]>m) m=arr[j];
            }
            return m;
        }
        if(dp[idx][d] != -1) return dp[idx][d];
        int maxD=arr[idx];
        int f = Integer.MAX_VALUE;
        for(int i=idx; i<=arr.length-d; i++){
           maxD = Math.max(arr[i], maxD);
            int res = maxD+getAns(arr, d-1, i+1, dp);
            f = Math.min(f,res);
        }
        return dp[idx][d]=f;
    }

    public int minDifficulty(int[] arr, int d) {
        if(d>arr.length) return -1;
        if(d == 1){
            int max = arr[0];
            for(int i=1; i<arr.length; i++){
                if(arr[i] > max) max=arr[i];
            }
            return max;
        }
        int dp[][] = new int[arr.length][d+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(arr,d,0,dp);
    }
}