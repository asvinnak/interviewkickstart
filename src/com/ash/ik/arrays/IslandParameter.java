package com.ash.ik.arrays;

public class IslandParameter {


    public static int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count += findIslands(grid, i, j);
                }
            }
        }

        return count;
    }

    private static int findIslands(int[][] grid, int row, int col) {
        int cnt = 0;

        cnt += findWater(grid, row, col + 1);
        cnt += findWater(grid, row, col - 1);
        cnt += findWater(grid, row + 1, col);
        cnt += findWater(grid, row - 1, col);

        return cnt;
    }

    private static int findWater(int[][] grid, int row, int col) {
        if ((col < 0 || row < 0 || col >= grid[0].length || row >= grid.length) || grid[row][col] == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 1, 0, 0, 0, 0},
            { 1, 1, 0, 0, 0, 0},
            { 0, 0, 0, 1, 1, 0},
            { 0, 1, 0, 0, 1, 0},
            { 0, 0, 0, 0, 0, 0},
            { 1, 1, 0, 0, 0, 0},
            { 0, 1, 1, 0, 0, 1},
            { 0, 1, 0, 0, 1, 1}
        };
        System.out.println("No of Islands ="+ islandPerimeter(matrix));
    }
}
