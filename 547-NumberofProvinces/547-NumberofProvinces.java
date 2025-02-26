class Solution {

    // void BFS(int arr[][], int visited[], int i){
    //     ArrayDeque <Integer> q = new ArrayDeque<>();
    //     q.offer(i);
    //     while(!q.isEmpty()){
    //         int rem = q.poll();
    //         visited[rem] = 1;
    //         for(int j=0; j<arr[0].length; j++){
    //             if(arr[rem][j] != 0 && visited[j] != 1){
    //                 q.add(j);
    //             }
    //         }
    //     }
    // }

    // void DFS(int arr[][], int visited[], int i){
    //     Stack <Integer> st = new Stack<>();
    //     st.push(i);
    //     visited[i] = 1;
    //     while(!st.isEmpty()){
    //         int rem = st.pop();
    //         for(int j=0; j<arr[rem].length; j++){
    //             if(arr[rem][j] == 1 && visited[j] == 0){
    //                 st.push(j);
    //                 visited[j] = 1;
    //             }
    //         }
    //     }
    // }

    // public int findCircleNum(int[][] arr) {
    //     int n = arr.length;
    //     int visited[] = new int[n];
    //     int count = 0;
    //     for(int i=0; i<visited.length; i++){
    //         if(visited[i]!=1){
    //             count++;
    //             BFS(arr,visited,i);
    //             // DFS(arr,visited,i);
    //         }
    //     }
    //     return count;
    // }


    void BFS(int [][]arr, int visited[], int i){
        ArrayDeque<Integer>q = new ArrayDeque<>();
        q.offer(i);
        visited[i] = 1;
        while(!q.isEmpty()){
            int res = q.pop();
            for(int j=0; j<arr[res].length; j++){
                if(arr[res][j] == 1 && visited[j] == 0){
                    q.add(j);
                    visited[j] = 1;
                }
            }
        }

    }

    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int visited[] = new int[n];
        int count = 0;

        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                BFS(arr,visited,i);
                count++;
            }
        }
        return count;
    }


}