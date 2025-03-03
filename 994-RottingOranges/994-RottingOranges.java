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


    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;
        int time = 0;
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                int r = p.getI(), c = p.getJ();

                // Visit 4 adjacent cells (top, bottom, left, right)
                for (int d = 0; d < 4; d++) {
                    int nr = r + dRow[d];
                    int nc = c + dCol[d];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2; // Rot the orange
                        queue.add(new Pair(nr, nc));
                        freshCount--; // Reduce fresh count
                        rotted = true;
                    }
                }
            }
            if (rotted) time++;
        }

        // If there are still fresh oranges, return -1
        return freshCount == 0 ? time : -1;
    }

}