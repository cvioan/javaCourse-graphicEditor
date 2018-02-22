package com.cioan.graphicEditor;
@SuppressWarnings("unused")
public abstract class Shape implements Comparable<Shape> {
    int x;
    int y;

    Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract double getArea();

    public abstract boolean pointIn(int x, int y);

    public abstract int getMinX();

    public abstract void draw(IDrawable lib);

    public abstract boolean equals(Shape other);

}
