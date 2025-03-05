class Solution {

    class Pair{
        int i;
        int j;
        int l;

        Pair(int i, int j, int l){
            this.i = i;
            this.j = j;
            this.l = l;
        }

        int getI(){
            return i;
        }
        int getJ(){
            return j;
        }
        int getL(){
            return l;
        }
    }


    void BFS(int [][]arr, int visited[][], int ans[][], int row, int col){
        ArrayDeque <Pair> q = new ArrayDeque<>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(arr[i][j] == 1){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair res = q.poll();
            int i = res.getI();
            int j = res.getJ();
            int l = res.getL();

            ans[i][j] = l;

            //top
            if(i-1>=0 && visited[i-1][j]!=1){
                q.add(new Pair(i-1,j,l+1));
                visited[i-1][j] = 1;
            }
            //down
            if(i+1<arr.length && visited[i+1][j]!=1){
                q.add(new Pair(i+1,j,l+1));
                visited[i+1][j] = 1;
            }
            //left
            if(j-1>=0 && visited[i][j-1]!=1){
                q.add(new Pair(i,j-1,l+1));
                visited[i][j-1] = 1;
            }
            //right
            if(j+1<arr[i].length && visited[i][j+1]!=1){
                q.add(new Pair(i,j+1,l+1));
                visited[i][j+1] = 1;
            }
        }


    }


    public int[][] highestPeak(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        int visited[][] = new int[row][col];
        int ans[][] = new int[row][col];
        BFS(arr, visited, ans, row, col);

        return ans;
    }
}