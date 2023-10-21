package edu.hw1;

public final class Task7 {
    private static final int INT_SIZE = 32;

    private Task7() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int rotateLeft(int n, int shift) {
        int rotatedN = n;

        for (int i = 0; i < shift; i++) {
            rotatedN = rotateLeftOneStep(rotatedN, getBitLength(n));
        }

        return rotatedN;
    }

    public static int rotateRight(int n, int shift) {
        int rotatedN = n;

        for (int i = 0; i < shift; i++) {
            rotatedN = rotateRightOneStep(rotatedN, getBitLength(n));
        }

        return rotatedN;
    }

    private static int rotateLeftOneStep(int n, int bitLength) {
        int bitOneLast = 1;
        int bitOneFirst = 1 << bitLength - 1;

        boolean mustAddOne = (n & bitOneFirst) != 0;

        int maskForDeletingExtraOnes;

        if (bitLength < INT_SIZE) {
            maskForDeletingExtraOnes = (1 << bitLength) - 1;
        } else {
            maskForDeletingExtraOnes = (((1 << (bitLength - 1)) - 1) << 1) + 1;
        }

        if (mustAddOne) {
            return ((n << 1) & maskForDeletingExtraOnes) | bitOneLast;
        }

        return (n << 1) & maskForDeletingExtraOnes;
    }

    private static int rotateRightOneStep(int n, int bitLength) {
        int bitOneLast = 1;
        int bitOneFirst = 1 << bitLength - 1;

        boolean mustAddOne = (n & bitOneLast) != 0;

        if (mustAddOne) {
            return (n >> 1) | bitOneFirst;
        }

        return n >> 1;
    }

    @SuppressWarnings("MagicNumber")
    private static int getBitLength(int n) {
        int bitOne = 1 << INT_SIZE - 1;

        for (int i = 0; i < INT_SIZE - 1; i++) {
            if ((bitOne & n) != 0) {
                return INT_SIZE - i;
            }

            bitOne = bitOne >> 1;
        }

        return 0;
    }
}
