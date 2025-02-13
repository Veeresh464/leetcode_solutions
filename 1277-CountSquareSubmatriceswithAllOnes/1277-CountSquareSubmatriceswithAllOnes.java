class Solution {

    //tabulation
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 && n == 1) return matrix[0][0];

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] != 0)matrix[i][j] += Math.min(Math.min(matrix[i-1][j], matrix[i][j-1]), matrix[i-1][j-1]);
            }
        }
        int s =0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                s+=matrix[i][j];
            }
        }
        return s;
    }
}