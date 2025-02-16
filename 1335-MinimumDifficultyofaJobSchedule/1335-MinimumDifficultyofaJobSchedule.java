class Solution {
    int getAns(int []arr, int d, int idx, int dp[][]){
        if(d == 1){
            int max = arr[idx];
            for(int i=idx; i<arr.length; i++){
                if(arr[i]>max) max = arr[i];
            }
            return max;
        }
        
        if(dp[idx][d] != -1) return dp[idx][d];

        int maxD = arr[idx];
        int finalD = Integer.MAX_VALUE;
        for(int i=idx; i<=arr.length-d; i++){
            maxD = Math.max(maxD, arr[i]);
            int res = getAns(arr,d-1,i+1,dp);
            finalD = Math.min(finalD, res+maxD);
        }
        return dp[idx][d] = finalD;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d>jobDifficulty.length) return -1;
        int dp[][] = new int[jobDifficulty.length][d+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(jobDifficulty,d,0,dp);
    }
}