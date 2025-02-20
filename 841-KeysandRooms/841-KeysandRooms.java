class Solution {
    void BFS(List<List<Integer>> arr, int []visited, int idx){
        ArrayDeque <Integer> q = new ArrayDeque<>();
        q.offer(idx);
        visited[idx]++;
        while(!q.isEmpty()){
            int rem = q.poll();
            for(int i=0; i<arr.get(rem).size(); i++){
                if(visited[arr.get(rem).get(i)] == 0){
                    q.offer(arr.get(rem).get(i));
                    visited[arr.get(rem).get(i)]++;
                }
            }
        }
    }

    void DFS(List<List<Integer>> arr, int visited[], int idx){
        Stack <Integer> st = new Stack<>();
        st.push(idx);
        visited[idx]++;
        while(!st.isEmpty()){
            int rem = st.pop();
            for(int i=0; i<arr.get(rem).size(); i++){
                if(visited[arr.get(rem).get(i)] == 0){
                    st.push(arr.get(rem).get(i));
                    visited[arr.get(rem).get(i)]++;
                }
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> arr) {
        int n = arr.size();
        int visited[] = new int[n];

        // BFS(arr, visited, 0);
        DFS(arr, visited, 0);
        boolean allTraversed = true;
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                allTraversed = false;
                break;
            }
        }
        return allTraversed;
    }
}