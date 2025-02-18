class Solution {
	// int getAns(int []arr, int c, int i, int dp[][]) {
	// 	if(c == 0) return 1;
	// 	if(i >= arr.length || c < 0) return 0;
		
	// 	if(dp[i][c] != -1) return dp[i][c];
	// 	int skip = getAns(arr,c,i+1, dp);
	// 	int take = getAns(arr,c-arr[i], i+1, dp);
		
	// 	if(skip == 1|| take ==1) return dp[i][c]=1;
	// 	return dp[i][c]=0;
	// }

    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for(int e:nums){
    //         sum+=e;
    //     }
    //     if(sum%2 == 1) return false;
    //     int tgt = sum/2;
    //     int dp[][] = new int[nums.length][tgt+1];
    //     for(int row[] : dp){
    //         Arrays.fill(row,-1);
    //     }
    //     if(getAns(nums, tgt, 0, dp) == 1) return true;
    //     else return false; 
    // }


    // int getAns(int []arr, int c, int i, int dp[][]) {
	// 	if(c == 0) return 1;
	// 	if(i < 0 || c < 0) return 0;
		
	// 	if(dp[i][c] != -1) return dp[i][c];
	// 	int skip = getAns(arr,c,i-1, dp);
	// 	int take = getAns(arr,c-arr[i], i-1, dp);
		
	// 	if(skip == 1|| take ==1) return dp[i][c]=1;
	// 	return dp[i][c]=0;
	// }

    // public boolean canPartition(int[] nums) {
    //     int sum = 0;
    //     for(int e:nums){
    //         sum+=e;
    //     }
    //     if(sum%2 == 1) return false;
    //     int tgt = sum/2;
    //     int dp[][] = new int[nums.length][tgt+1];
    //     for(int row[] : dp){
    //         Arrays.fill(row,-1);
    //     }
    //     if(getAns(nums, tgt, nums.length-1, dp) == 1) return true;
    //     else return false; 
    // }


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int e:nums){
            sum+=e;
        }
        if(sum%2 == 1) return false;
        int tgt = sum/2;
        int dp[][] = new int[nums.length][tgt+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(j == 0) dp[i][j] = 1;
                else{
                    int skip = (i-1 >= 0)? dp[i-1][j]:0;
                    int take = (i-1 >= 0 && j-nums[i]>=0)? dp[i-1][j-nums[i]]:0;
                    dp[i][j] = Math.max(take,skip);
                }
            }
        }
        if(dp[dp.length-1][dp[0].length-1] == 1) return true;
        else return false;
    }
}