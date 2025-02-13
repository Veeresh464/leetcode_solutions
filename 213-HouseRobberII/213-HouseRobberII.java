class Solution {


    int getAns(int []nums, int idx, int n, int dp[]){
        if(idx > n) return 0;

        if(dp[idx] != -1) return dp[idx];
        int skip = getAns(nums, idx+1, n, dp);
        int take = nums[idx] + getAns(nums, idx+2, n, dp);

        return dp[idx] = Math.max(skip, take);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        int a1 = getAns(nums, 0, nums.length-2, dp);
        Arrays.fill(dp,-1);
        int a2 = getAns(nums, 1, nums.length-1, dp);
        return Math.max(a1,a2);
    }
}