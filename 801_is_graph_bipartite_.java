class Solution {
    class Pair{
        int parity;
        int val;
        Pair(int parity, int val){
            this.parity = parity;
            this.val = val;
        }

        int getParity(){
            return parity;
        }
        int getVal(){
            return val;
        }
    }

    boolean BFS(int [][]graph, int visited[], int i){
        ArrayDeque <Pair> q = new ArrayDeque<>();
        q.add(new Pair(0,i));
        visited[i] = 1;
        Set <Integer> set0 = new LinkedHashSet<>();
        Set <Integer> set1 = new LinkedHashSet<>();

        while(!q.isEmpty()){
            Pair res = q.poll();
            int parity = res.getParity();
            int val = res.getVal();

            if(parity == 0){
                set0.add(val);
            }
            else if(parity == 1){
                set1.add(val);
            }

            for(int j=0; j<graph[val].length; j++){
                if(visited[graph[val][j]] != 1){
                    q.add(new Pair( (parity==1)? 0:1 , graph[val][j]));
                    visited[graph[val][j]] = 1;
                }
            }
        }

        for(int j=0; j<graph.length; j++){
            if(set0.contains(j)){
                for(int k=0; k<graph[j].length; k++){
                    if(set0.contains(graph[j][k])) return false;
                }
            }
            else if(set1.contains(j)){
                for(int k=0; k<graph[j].length; k++){
                    if(set1.contains(graph[j][k])) return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int visited[] = new int[n];
        boolean res = false;
        for(int i=0; i<n; i++){
            if(visited[i] == 0){
                res = BFS(graph,visited,i);
                if(!res) return false;
            }
        }
        return res;
    }
}