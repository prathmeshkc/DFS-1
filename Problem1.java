import java.util.*;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n) for BFS and O(1) for DFS
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We can solve this problem using both BFS and DFS.
 * BFS - We will start from the given cell and change the color of the cell
 * that is equal to the original color and add it to the queue and process the
 * neighbors (up, down, left, right) of the cell and change the color of the cell to the new color.
 * We will repeat this process until the queue is empty.
 * DFS - We will start from the given cell and change the color of the cell
 * that is equal to the original color and process the neighbors (up, down, left, right) of the cell and
 * change the color of the cell to the new color.
 */


public class Problem1 {
    int[][] dirs;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        this.dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };

        if (image[sr][sc] == color) return image;
        int originalColor = image[sr][sc];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int row = pos[0];
            int col = pos[1];
            for (int[] dir : this.dirs) {
                int nr = dir[0] + row;
                int nc = dir[1] + col;
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == originalColor) {
                    q.add(new int[]{nr, nc});
                    image[nr][nc] = color;
                }
            }
        }

        return image;
    }


    int originalColor;
    int m;
    int n;

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;
        this.dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };
        if (image[sr][sc] == color) return image;
        this.originalColor = image[sr][sc];
        dfs(image, sr, sc, color, m, n);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int m, int n) {
        //base
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != this.originalColor) return;
        //logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = dir[0] + sr;
            int nc = dir[1] + sc;
            dfs(image, nr, nc, color, m, n);
        }
    }
}
