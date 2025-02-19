class Solution {

    void BFS(int arr[][], int visited[], int i){
        ArrayDeque <Integer> q = new ArrayDeque<>();
        q.offer(i);
        while(!q.isEmpty()){
            int rem = q.poll();
            visited[rem] = 1;
            for(int j=0; j<arr[0].length; j++){
                if(arr[rem][j] != 0 && visited[j] != 1){
                    q.add(j);
                }
            }
        }
    }

    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        int visited[] = new int[n];
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(visited[i]!=1){
                count++;
                BFS(arr,visited,i);
            }
        }
        return count;
    }
}