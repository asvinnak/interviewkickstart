package com.ash.ik.dynamicprogramming;

/**
 * Do DFS from every cell
 * Compare every 4 direction and skip cells that are out of boundary or smaller
 * Get matrix max from every cell's max
 * Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
 * The key is to cache the distance because it's highly possible to revisit a cell
 */
public class LongestIncreasingPathInMatrix {
    public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for(int[] dir: directions) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }

    int dfs1(int[][] matrix, int min, int i, int j, int n, int m, int[][] cache) {

        // check boundary limits
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;

        // check min condition
        if (matrix[i][j] <= min)
            return 0;

        // check into cache
        if (cache[i][j] != 0)
            return cache[i][j];

        // update min
        min = matrix[i][j];

        // run dfs in all four directions
        int a = dfs1(matrix, min, i - 1, j, n, m, cache) + 1;
        int b = dfs1(matrix, min, i + 1, j, n, m, cache) + 1;
        int c = dfs1(matrix, min, i, j - 1, n, m, cache) + 1;
        int d = dfs1(matrix, min, i, j + 1, n, m, cache) + 1;

        // find max and update cache
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;

        return max;
    }

}
