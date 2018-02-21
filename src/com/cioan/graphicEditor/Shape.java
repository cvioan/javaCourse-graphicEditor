package com.cioan.graphicEditor;

public abstract class Shape {
    int x;
    int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double getArea();

    public abstract boolean pointIn(int x, int y);

    public abstract int getMinX();
}
