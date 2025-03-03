class Solution {

    void DFS(int arr[][], int cr, int cc, int color, int orgColor){


        if(cr < 0 || cr >= arr.length || cc < 0 || cc >= arr[0].length) return;
        if(arr[cr][cc] == color) return;
        // if(visited[cr][cc] == 1) return;
        // visited[cr][cc] = 1;
        if(arr[cr][cc] != orgColor) return;
        if(arr[cr][cc] == orgColor) arr[cr][cc]=color;

        DFS(arr,cr-1,cc,color,orgColor);
        DFS(arr,cr+1,cc,color,orgColor);
        DFS(arr,cr,cc-1,color,orgColor);
        DFS(arr,cr,cc+1,color,orgColor);

    }


    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int visited[][] = new int[arr.length][arr[0].length];
        DFS(arr,sr,sc,color,arr[sr][sc]);
        return arr;
    }
}