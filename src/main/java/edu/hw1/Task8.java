package edu.hw1;

public class Task8 {
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
        return isKnightOnPlace1(board, x, y) || isKnightOnPlace2(board, x, y) &&
            isKnightOnPlace3(board, x, y) && isKnightOnPlace4(board, x, y);
    }

    private static boolean isKnightOnPlace1(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2, newY = y - 1;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlace2(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2, newY = y + 1;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlace3(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1, newY = y - 2;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private static boolean isKnightOnPlace4(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1, newY = y + 2;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

}
