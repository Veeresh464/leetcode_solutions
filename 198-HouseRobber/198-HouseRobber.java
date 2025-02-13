class Solution {

    //recursion
    // int getAns(int []nums, int idx, int[] dp){
    //     if(idx >= nums.length) return 0;

    //     if(dp[idx] != -1) return dp[idx];
    //     int skip = getAns(nums, idx+1, dp);
    //     int take = nums[idx] + getAns(nums, idx+2, dp);

    //     return dp[idx] = Math.max(skip, take);
    // }
    // public int rob(int[] nums) {
    //     int dp[] = new int[nums.length];
    //     Arrays.fill(dp,-1);
    //     return getAns(nums, 0, dp);
    // }

    //tabulation
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[dp.length -1];
    }

}