class Solution {
    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        int getI() {
            return i;
        }

        int getJ() {
            return j;
        }
    }

    int BFS(int arr[][], int row, int col){
        ArrayDeque <Pair> q = new ArrayDeque<>();
        int freshCnt = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                else if(arr[i][j]==1){
                    freshCnt++;
                }
            }
        }
        if(freshCnt == 0) return 0;
        q.add(new Pair(-1,-1));
        int count = 0;
        int freshCnt2 = 0;
        while(!q.isEmpty()){
            Pair res = q.poll();
            int r = res.getI();
            int c = res.getJ();

            if(r == -1 && c == -1){
                count++;
                if(q.size() == 0) break;
                else{
                    q.add(new Pair(-1,-1));
                    continue;
                }
            }

            //top
            if(r-1>=0 && arr[r-1][c] == 1){
                arr[r-1][c] = 2;
                q.add(new Pair(r-1,c));
                freshCnt2++;
            }
            //bottom
            if(r+1<row && arr[r+1][c] == 1){
                arr[r+1][c] = 2;
                q.add(new Pair(r+1,c));
                freshCnt2++;
            }
            if(c-1>=0 && arr[r][c-1] == 1){
                arr[r][c-1] = 2;
                q.add(new Pair(r,c-1));
                freshCnt2++;
            }
            if(c+1<col && arr[r][c+1] == 1){
                arr[r][c+1] = 2;
                q.add(new Pair(r,c+1));
                freshCnt2++;
            }
        }
        return (freshCnt2 == freshCnt)? count:-1;
    }

    public int orangesRotting(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        
        int ans = BFS(arr, row, col);

        return (ans >= 0)? (ans > 0)? ans-1:ans : -1 ;
        
    }

}