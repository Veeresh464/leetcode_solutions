class Solution {

    boolean getAns(int nums[], int tgt, int idx, int dp[][]){
        // if(idx == nums.length){
        //     if(tgt == 0) return true;
        //     else return false;
        // }
        if(tgt == 0) return true;
        if(idx >= nums.length || tgt < 0) return false;

        if(dp[idx][tgt] != -1){
            if(dp[idx][tgt] == 1) return true;
            else return false;
        } 
        boolean skip = getAns(nums,tgt,idx+1,dp);
        boolean take = getAns(nums,tgt-nums[idx], idx+1,dp);
        if(skip || take) dp[idx][tgt] = 1;
        else dp[idx][tgt] = 0;
        return skip||take;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
        }
        if(sum%2 == 1) return false;

        int tgt = sum/2;
        int dp[][] = new int[nums.length][tgt+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return getAns(nums,tgt,0,dp);
    }
}