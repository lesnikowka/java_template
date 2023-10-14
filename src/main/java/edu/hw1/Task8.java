package edu.hw1;

public final class Task8 {
    private Task8() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean allKnightsCannotAttackOtherKnights(int[][] board) throws NullPointerException, IllegalArgumentException {
        if (board == null) {
            throw new NullPointerException("Array cannot be null");
        }

        if (!isBoardCorrect(board)){
            throw new IllegalArgumentException("Board is incorrect");
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1 && canAttackAnyKnight(board, i, j)) {
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
        int newX = x + 2;
        int newY = y - 1;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlaceRight(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2;
        int newY = y + 1;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlaceLeftmost(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1;
        int newY = y - 2;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlaceRightmost(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1;
        int newY = y + 2;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

    private static boolean isBoardCorrect(final int[][] board){
        return isBoardSizeCorrect(board) && doesBoardHaveOnlyOnes(board);
    }

    private static boolean isBoardSizeCorrect(final int[][] board){
        final int boardSize = 8;

        if (board.length != boardSize){
            return false;
        }

        for (int[] row : board) {
            if (row == null || row.length != boardSize) {
                return false;
            }
        }

        return true;
    }

    private static boolean doesBoardHaveOnlyOnes(final int[][] board){
        for (int[] row : board){
            for (int element : row){
                if (element != 1 && element != 0){
                    return false;
                }
            }
        }

        return true;
    }
}
