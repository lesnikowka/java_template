package edu.hw2.Task1;

import java.lang.Math;

interface Expr {
    double evaluate();

    class Constant implements Expr {
        private final double value;

        Constant(double value) {
            this.value = value;
        }

        Constant(Expr expr) {
            this(expr.evaluate());
        }

        double evaluate() {
            return value;
        }
    }

    class Negate implements Expr {
        private final double value;

        Negate(double value) {
            this.value = -value;
        }

        Negate(Expr expr) {
            this(expr.evaluate());
        }

        double evaluate() {
            return value;
        }
    }

    class Exponent implements Expr {
        final double value;

        Exponent(double value1, double value2) {
            value = Math.pow(value1, value2);
        }

        Exponent(Expr expr, double value) {
            this(expr.evaluate(), value);
        }

        Exponent(double value, Expr expr) {
            this(value, expr.evaluate());
        }

        Exponent(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        double evaluate() {
            return value;
        }
    }

    class Addition implements Expr {
        final double value;

        Addition(double value1, double value2) {
            value = value1 + value2;
        }

        Addition(Expr expr, double value) {
            this(expr.evaluate(), value);
        }

        Addition(double value, Expr expr) {
            this(value, expr.evaluate());
        }

        Addition(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        double evaluate() {
            return value;
        }
    }

    class Multiplication implements Expr {
        private final double value;

        Multiplication(double value1, double value2) {
            value = value1 * value2;
        }

        Multiplication(Expr expr, double value) {
            this(expr.evaluate(), value);
        }

        Multiplication(double value, Expr expr) {
            this(value, expr.evaluate());
        }

        Multiplication(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        double evaluate() {
            return value;
        }
    }
}
