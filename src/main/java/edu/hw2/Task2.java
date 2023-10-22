package edu.hw2;

class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return height * width;
    }
}

class Square extends Rectangle {
    public Square(int length) {
        super(length, length);
    }
}
