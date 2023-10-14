package edu.hw1;

public class Task8 {
    private Task8() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean allKnightsCannotAttackOtherKnights(int[][] board) throws NullPointerException{
        if (board == null){
            throw new NullPointerException("Array cannot be null");
        }

        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && canAttackAnyKnight(board, i, j)){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean canAttackAnyKnight(final int[][] board, int x, int y) {
        return isKnightOnPlaceLeft(board, x, y) || isKnightOnPlaceRight(board, x, y)
            && isKnightOnPlaceLeftmost(board, x, y) && isKnightOnPlaceRightmost(board, x, y);
    }

    private static boolean isKnightOnPlaceLeft(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2, newY = y - 1;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlaceRight(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2, newY = y + 1;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlaceLeftmost(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1, newY = y - 2;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlaceRightmost(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1, newY = y + 2;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }
}
