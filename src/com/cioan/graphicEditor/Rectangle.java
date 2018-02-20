package com.cioan.graphicEditor;

public class Rectangle {
    private int horizontal;
    private int vertical;
    private int x, y;

    Rectangle(int x, int y, int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.x = x;
        this.y = y;
    }

    int getArea() {
        return (this.horizontal * this.vertical);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getHorizontal() {
        return horizontal;
    }

    int getVertical() {
        return vertical;
    }

    public String toString() {
        return "(" + this.getX() + ", " + this.getY() + ", " + this.getHorizontal() + ", " + this.getVertical() + ") ";
    }

    public boolean pointIn(int xRef, int yRef) {
        return (xRef >= this.x && xRef <= this.x + this.vertical) && (yRef >= this.y && yRef <= this.y + this.vertical);
    }
}
