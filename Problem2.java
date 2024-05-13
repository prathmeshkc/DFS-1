import java.util.*;

// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * We can solve this problem using BFS and DFS.
 * BFS - We will first add all the independent cells i.e 0's to the queue
 * and mark the rest of the cells as -1. We will process the cells level by level.
 * We can start with distance 1 and override the cells that are -1 with the distance
 * and add them to the queue. After each level is processed, increment the distance.
 * We will repeat this process until the queue is empty.
 */

public class Problem2 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dirs = new int[][]{
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
        };

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }

        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            //process the level
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];
                    //bounds check
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                        mat[nr][nc] = dist;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            dist++;
        }

        return mat;
    }
}
