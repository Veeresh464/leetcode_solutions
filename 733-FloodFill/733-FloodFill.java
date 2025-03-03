class Solution {
    //dfs
    // void DFS(int arr[][], int cr, int cc, int color, int orgColor){
    //     if(cr < 0 || cr >= arr.length || cc < 0 || cc >= arr[0].length) return;
    //     if(arr[cr][cc] == color) return;
    //     if(arr[cr][cc] != orgColor) return;
    //     if(arr[cr][cc] == orgColor) arr[cr][cc]=color;

    //     DFS(arr,cr-1,cc,color,orgColor);
    //     DFS(arr,cr+1,cc,color,orgColor);
    //     DFS(arr,cr,cc-1,color,orgColor);
    //     DFS(arr,cr,cc+1,color,orgColor);

    // }

    // public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
    //     DFS(arr,sr,sc,color,arr[sr][sc]);
    //     return arr;
    // }

    //bfs

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

    void BFS(int arr[][], int cr, int cc, int color, int orgColor){
        if(arr[cr][cc] == color) return;
        ArrayDeque <Pair> q = new ArrayDeque<>();
        if(arr[cr][cc] == orgColor) {
            arr[cr][cc] = color;
            q.offer(new Pair(cr,cc));
        }

        while(!q.isEmpty()){
            Pair res = q.poll();
            int row = res.getI();
            int col = res.getJ();
            //top
            if(row-1 >= 0 && arr[row-1][col] == orgColor){
                q.offer(new Pair(row-1,col));
                arr[row-1][col] = color;
            }
            //bottom
            if(row+1 < arr.length && arr[row+1][col] == orgColor){
                q.offer(new Pair(row+1,col));
                arr[row+1][col] = color;
            }
            //left
            if(col-1 >= 0 && arr[row][col-1] == orgColor){
                q.offer(new Pair(row,col-1));
                arr[row][col-1] = color;
            }
            //right
            if(col+1 < arr[0].length && arr[row][col+1] == orgColor){
                q.offer(new Pair(row,col+1));
                arr[row][col+1] = color;
            }
        }
    }

    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        BFS(arr, sr, sc, color, arr[sr][sc]);
        return arr;
    }

}