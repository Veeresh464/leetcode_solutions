class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] visited = new int[m][n];

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] == 0 && grid[i][j] != '0'){
                    if(isPossiable(grid, visited, i, j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean isPossiable(char [][] grid, int visited[][], int cr, int cc){
        if(cr < 0 || cr >= grid.length || cc < 0 || cc >= grid[0].length) return true;
        
        if(visited[cr][cc] == 1 || grid[cr][cc] == '0') return true;

        visited[cr][cc] = 1;

        boolean top = isPossiable(grid, visited, cr-1, cc);
        boolean down  = isPossiable(grid, visited, cr+1, cc);
        boolean left = isPossiable(grid, visited, cr, cc-1);
        boolean right = isPossiable(grid, visited, cr, cc+1);

        return top && down && left && right;
    }
}