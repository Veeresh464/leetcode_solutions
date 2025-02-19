class Solution {
    int getAns(int arr[], int idx, int min){
        if(idx >= arr.length) return 0;

        min = Math.min(min,arr[idx]);
        int profit = Math.max(arr[idx]-min, getAns(arr, idx+1, min));

        return profit;
    }

    public int maxProfit(int[] arr) {
        return getAns(arr,0,Integer.MAX_VALUE);
    }
}