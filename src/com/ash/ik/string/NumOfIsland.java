package com.ash.ik.string;

public class NumOfIsland {


    public static int findNumOfIslands(int[][] matrix) {

        int islands = 0;
        for(int i=0; i<matrix.length; i++) { // rows
            for(int j=0; j<matrix[0].length; j++) { //cols
                if(matrix[i][j] == 1) {
                    if((i==0 || matrix[i-1][j] == 0) && (j==0 || matrix[i][j-1] == 0)) {
                        islands++;
                    }
                }
            }
        }

        return islands;
    }


    public static int findNumOfIslands1(int[][] matrix) {

        int islands = 0;
        for(int i=0; i<matrix.length; i++) { // rows
            for(int j=0; j<matrix[0].length; j++) { //cols
                if(matrix[i][j] == 1) {
                   islands += getNoOfIslands(matrix, i, j);
                }
            }
        }

        return islands;
    }

    private static int getNoOfIslands(int[][] matrix, int row, int col) {

        if(row < 0 || col < 0 || row > matrix.length || col > matrix[0].length) {
            return 0;
        }

        if(matrix[row][col] == 0) {
            return 0;
        }

        int size = 1;

        matrix[row][col] = 0;

        for(int i=row-1; i<row+1; i++) {
            for(int j=col-1; j<col+1; j++) {
                if(i != row || j != col) {
                    size += getNoOfIslands(matrix, i, j);
                }
            }
        }

        return size;
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


        System.out.println("No of Islands ="+ findNumOfIslands(matrix));

        System.out.println("No of Islands ="+ findNumOfIslands1(matrix));
    }


}
