class Solution {
    // public int numIslands(char[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int [][] visited = new int[m][n];

    //     int count = 0;

    //     for(int i=0; i<m; i++){
    //         for(int j=0; j<n; j++){
    //             if(visited[i][j] == 0 && grid[i][j] != '0'){
    //                 if(isPossiable(grid, visited, i, j)){
    //                     count++;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }

    // boolean isPossiable(char [][] grid, int visited[][], int cr, int cc){
    //     if(cr < 0 || cr >= grid.length || cc < 0 || cc >= grid[0].length) return true;
        
    //     if(visited[cr][cc] == 1 || grid[cr][cc] == '0') return true;

    //     visited[cr][cc] = 1;

    //     boolean top = isPossiable(grid, visited, cr-1, cc);
    //     boolean down  = isPossiable(grid, visited, cr+1, cc);
    //     boolean left = isPossiable(grid, visited, cr, cc-1);
    //     boolean right = isPossiable(grid, visited, cr, cc+1);

    //     return top && down && left && right;
    // }
    
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        int getI(){
            return i;
        }

        int getJ(){
            return j;
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] visited = new int[m][n];
        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != '0' && visited[i][j] == 0){
                    BFS(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    void BFS(char[][]grid, int visited[][], int cr, int cc){
        ArrayDeque <Pair> q = new ArrayDeque<>();
        q.offer(new Pair(cr,cc));
        visited[cr][cc] = 1;
        while(!q.isEmpty()){
            Pair res = q.poll();
            //top
            if(res.getI()-1 >= 0 && grid[res.getI()-1][res.getJ()] != '0' && visited[res.getI()-1][res.getJ()] == 0){
                q.add(new Pair(res.getI()-1, res.getJ()));
                visited[res.getI()-1][res.getJ()] = 1;
            }
            //down
            if(res.getI()+1 < grid.length && grid[res.getI()+1][res.getJ()] != '0' && visited[res.getI()+1][res.getJ()] == 0){
                q.add(new Pair(res.getI()+1,res.getJ()));
                visited[res.getI()+1][res.getJ()] = 1;
            }
            //left
            if(res.getJ()-1 >= 0 && grid[res.getI()][res.getJ()-1] != '0' && visited[res.getI()][res.getJ()-1] == 0){
                q.add(new Pair(res.getI(),res.getJ()-1));
                visited[res.getI()][res.getJ()-1] = 1;
            }
            //right
            if(res.getJ()+1 < grid[res.getI()].length && grid[res.getI()][res.getJ()+1] != '0' && visited[res.getI()][res.getJ()+1] == 0){
                q.add(new Pair(res.getI(),res.getJ()+1));
                visited[res.getI()][res.getJ()+1] = 1;
            }
        }
    }


}