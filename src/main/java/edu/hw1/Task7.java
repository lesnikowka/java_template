package edu.hw1;

public class Task7 {

    public int rotateLeft(int n, int shift) {
        int rotatedN = n;

        for (int i = 0; i < shift; i++) {
            rotatedN = rotateLeftOneStep(rotatedN, getBitLength(n));
        }

        return rotatedN;
    }

    public int rotateRight(int n, int shift) {
        int rotatedN = n;

        for (int i = 0; i < shift; i++) {
            rotatedN = rotateRightOneStep(rotatedN, getBitLength(n));
        }

        return rotatedN;
    }

    private int rotateLeftOneStep(int n, int bitLength) {
        int bitOneLast = 1;
        int bitOneFirst = 1 << bitLength - 1;

        boolean mustAddOne = (n & bitOneFirst) != 0;

        int maskForDeletingExtraOnes;

        if (bitLength < 32) {
            maskForDeletingExtraOnes = (1 << bitLength) - 1; // 1 0 0 0 0   1 1 1 1 1
        }
        else{
            maskForDeletingExtraOnes = (((1 << (bitLength - 1)) - 1) << 1) + 1;
        }

        if (mustAddOne) {
            return ((n << 1) & maskForDeletingExtraOnes) | bitOneLast;
        }

        return (n << 1) & maskForDeletingExtraOnes;
    }

    private int rotateRightOneStep(int n, int bitLength) { // 1 0 0 1
        int bitOneLast = 1;
        int bitOneFirst = 1 << bitLength - 1;

        boolean mustAddOne = (n & bitOneLast) != 0;

        if (mustAddOne) {
            return (n >> 1) | bitOneFirst;
        }

        return n >> 1;
    }

    private int getBitLength(int n) {
        final int intSize = 32;

        int bitOne = 1 << intSize - 1;

        for (int i = 0; i < intSize - 1; i++) {
            if ((bitOne & n) != 0) {
                return intSize - i;
            }
            bitOne = bitOne >> 1;
        }

        return 0;
    }
}
