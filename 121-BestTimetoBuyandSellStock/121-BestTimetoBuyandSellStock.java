class Solution {


    int getAns(int []arr, int idx, int min){
        if(idx >= arr.length) return 0;

        min = Math.min(arr[idx], min);
        int profit = Math.max(arr[idx]-min, getAns(arr,idx+1, min));
        
        return profit;
    }

    public int maxProfit(int[] arr) {
        return getAns(arr,1,arr[0]);
    }


    // public int maxProfit(int[] arr) {
    //     int min = arr[0];
    //     int profit = 0;
    //     for(int i=1; i<arr.length; i++){
    //         min = Math.min(min, arr[i]);
    //         profit = Math.max(profit, arr[i] - min);
    //     }
    //     return profit;
    // }
}