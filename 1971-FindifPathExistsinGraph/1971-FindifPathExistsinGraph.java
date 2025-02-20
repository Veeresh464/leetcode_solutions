class Solution {

    void BFS(ArrayList<ArrayList<Integer>> graph, int visited[], int src){
        ArrayDeque <Integer> q = new ArrayDeque<>();
        q.offer(src);
        visited[src]++;
        while(!q.isEmpty()){
            int rem = q.poll();
            for(int i=0; i<graph.get(rem).size(); i++){
                if(visited[graph.get(rem).get(i)] ==0){
                    q.add(graph.get(rem).get(i));
                    visited[graph.get(rem).get(i)]++;
                }
            }
        }
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // int graph[][] = new int[n][n];
        // for(int i=0; i<edges.length; i++){
        //     graph[edges[i][0]][edges[i][1]]++;
        //     graph[edges[i][1]][edges[i][0]]++;
        // }
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int visited[] = new int[n];
        BFS(graph, visited, source);
        for(int i=0; i<n; i++){
            if(i == destination && visited[i] == 0) return false;
        }
        return true;
    }
}