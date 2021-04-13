package com.ash.ik.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NQueensArrangement {

    public static List<List<Integer>> driver(int n) {
        List<List<Integer>> possibleBoards = new ArrayList<>();
        helper(n, 0, new ArrayList<Integer>(), possibleBoards);
        return possibleBoards;
    }

    private static List<List<Integer>> helper(int boardSize, int currRow, List<Integer> board,
        List<List<Integer>> possibleBoards) {
        //base case
        if (currRow == boardSize) {
            possibleBoards.add(new ArrayList<>(board));
            //board.forEach(System.out::println);
        } else {
            for (int col = 0; col < boardSize; col++) {
                if (isSafeToPlaceQueenAt(board, currRow, col)) {
                    board.add(col);
                    helper(boardSize, currRow + 1, board, possibleBoards);
                    board.remove(board.size() - 1);
                }
            }
        }

        return possibleBoards;
    }

    private static boolean isSafeToPlaceQueenAt(List<Integer> board, int row, int col) {

        for (int row2 = 0; row2 < board.size(); row2++) {
            //Col constraint
            if (board.get(row2) == col) {
                return false;
            }

            //Diagonal constraint
            int xDist = Math.abs(row2 - row);
            int col2 = Math.abs(board.get(row2));
            int yDist = Math.abs(col2 - col);
            if (xDist == yDist) {
                return false;
            }
        }

        return true;
    }

    static List<List<List<String>>> find_all_arrangements(int n) {

        List<List<List<String>>> tmp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(n, 0, new ArrayList(), result);

        List<Integer> colValues;
        for (int i = 0; i < result.size(); i++) {
            colValues = result.get(i);
            tmp.add(i, new ArrayList<>());
            for (int j = 0; j < colValues.size(); j++) {
                tmp.get(i).add(j, new ArrayList<>());
                for (int k = 0; k < n; k++) {
                    if (k == colValues.get(j)) {
                        tmp.get(i).get(j).add("q");
                    } else {
                        tmp.get(i).get(j).add("-");
                    }
                }
            }
        }

        return tmp;
    }

    public static void main(String[] a) {

        List<List<Integer>> possibleBoards = driver(4);
        System.out.println("Possibilities :" + possibleBoards.size());
        possibleBoards.forEach(System.out::println);

        List<List<List<String>>> res = find_all_arrangements(4);

        res.forEach(System.out::println);

        // possibleBoards = driver(8);
        // System.out.println("Possibilities :" + possibleBoards.size());
        // possibleBoards.forEach(System.out::println);
    }
}
