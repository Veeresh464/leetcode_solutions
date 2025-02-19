class Solution {

    int getAns(int arr[], int target, int idx, int sum){
        
        if(idx == arr.length){
            if(sum == target) return 1;
            else return 0;
        }

        int add = getAns(arr, target, idx+1, sum+arr[idx]);
        int sub = getAns(arr,target, idx+1, sum-arr[idx]);

        return add+sub;

    }

    public int findTargetSumWays(int[] nums, int target) {
        return getAns(nums,target,0,0);
    }
}