package edu.hw1;

public class Task8 {
    public boolean allKnightsCannotAttackOtherKnights(int[][] board) {
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

    private boolean canAttackAnyKnight(final int[][] board, int x, int y) {
        return isKnightOnPlace1(board, x, y) || isKnightOnPlace2(board, x, y) &&
            isKnightOnPlace3(board, x, y) && isKnightOnPlace4(board, x, y);
    }

    private boolean isKnightOnPlace1(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2, newY = y - 1;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private boolean isKnightOnPlace2(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 2, newY = y + 1;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

    private boolean isKnightOnPlace3(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1, newY = y - 2;

        return (newX < n) && (newY >= 0) && (board[newX][newY] == 1);
    }

    private boolean isKnightOnPlace4(final int[][] board, int x, int y) {
        int n = board.length;
        int newX = x + 1, newY = y + 2;

        return (newX < n) && (newY < n) && (board[newX][newY] == 1);
    }

}
