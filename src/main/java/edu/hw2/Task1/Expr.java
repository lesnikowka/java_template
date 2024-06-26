package edu.hw2.Task1;

public interface Expr {
    double evaluate();

    class Constant implements Expr {
        private final double value;

        public Constant(double value) {
            this.value = value;
        }

        public Constant(Expr expr) {
            this(expr.evaluate());
        }

        public double evaluate() {
            return value;
        }
    }

    class Negate implements Expr {
        private final double value;

        public Negate(double value) {
            this.value = -value;
        }

        public Negate(Expr expr) {
            this(expr.evaluate());
        }

        public double evaluate() {
            return value;
        }
    }

    class Exponent implements Expr {
        private final double value;

        public Exponent(double value1, double value2) {
            value = Math.pow(value1, value2);
        }

        public Exponent(Expr expr, double value) {
            this(expr.evaluate(), value);
        }

        public Exponent(double value, Expr expr) {
            this(value, expr.evaluate());
        }

        public Exponent(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        public double evaluate() {
            return value;
        }
    }

    class Addition implements Expr {
        private final double value;

        public Addition(double value1, double value2) {
            value = value1 + value2;
        }

        public Addition(Expr expr, double value) {
            this(expr.evaluate(), value);
        }

        public Addition(double value, Expr expr) {
            this(value, expr.evaluate());
        }

        public Addition(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        public double evaluate() {
            return value;
        }
    }

    class Multiplication implements Expr {
        private final double value;

        public Multiplication(double value1, double value2) {
            value = value1 * value2;
        }

        public Multiplication(Expr expr, double value) {
            this(expr.evaluate(), value);
        }

        public Multiplication(double value, Expr expr) {
            this(value, expr.evaluate());
        }

        public Multiplication(Expr expr1, Expr expr2) {
            this(expr1.evaluate(), expr2.evaluate());
        }

        public double evaluate() {
            return value;
        }
    }
}
