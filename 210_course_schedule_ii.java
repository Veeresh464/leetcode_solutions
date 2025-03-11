class Solution {
    void createAdjacencyList(int in[], int arr[][], int row,  ArrayList<ArrayList<Integer>> adj){
        for(int i=0; i<row; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<arr.length; i++){
            adj.get(arr[i][1]).add(arr[i][0]);
            in[arr[i][0]]++;
        }
    }
    void checkForCycleAndBFS(ArrayList<ArrayList<Integer>> adj, int in[],  ArrayList<Integer>ans){
        ArrayDeque<Integer>q = new ArrayDeque<>();
        for(int i=0; i<in.length; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int res = q.poll();
            ans.add(res);
            for(int j=0; j<adj.get(res).size(); j++){
                in[adj.get(res).get(j)]--;
                if(in[adj.get(res).get(j)] == 0){
                    q.add(adj.get(res).get(j));
                }
            }
        }
    }

    void DFS(ArrayList<ArrayList<Integer>> adj,int visited[], int i,ArrayList<Integer>ans1){
        visited[i] = 1;
        for(int j=0; j<adj.get(i).size(); j++){
            if(visited[adj.get(i).get(j)] == 0){
                DFS(adj, visited, adj.get(i).get(j), ans1);
            }
        }
        ans1.add(i);
    }

    public int[] findOrder(int row, int[][] arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int in[] = new int[row];
        createAdjacencyList(in, arr, row, adj);
        int visited[] = new int[row];
        ArrayList<Integer>ans = new ArrayList<>();
        ArrayList<Integer>ans2 = new ArrayList<>();
        checkForCycleAndBFS(adj, in, ans);
        for(int i=0; i<row; i++){
            if(visited[i] == 0){
                DFS(adj, visited, i, ans2);
            }
        }
        // if(adj.size() == ans.size()){
        //     int ans1[] = new int[row];
        //     int idx = 0;
        //     for(int ele: ans){
        //         ans1[idx++] = ele;
        //     }
        //     return ans1;
        // }
        Collections.reverse(ans2);
        if(adj.size() == ans.size()){
            int ans1[] = new int[row];
            int idx = 0;
            for(int ele: ans2){
                ans1[idx++] = ele;
            }
            return ans1;
        }


        return new int[]{};
    }
}