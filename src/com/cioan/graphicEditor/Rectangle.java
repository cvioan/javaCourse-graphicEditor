package com.cioan.graphicEditor;

import com.cioan.graphicEditor.Utils.Utils;


public class Rectangle extends Shape {
    private int horizontal;
    private int vertical;

    Rectangle(int x, int y, int horizontal, int vertical) {
        super(x, y);
        this.horizontal = horizontal;
        this.vertical = vertical;

    }

    @Override
    public double getArea() {
        return Utils.roundDoubleTwoDecimals(this.horizontal * this.vertical);
    }

    int getHorizontal() {
        return horizontal;
    }

    int getVertical() {
        return vertical;
    }

    public String toString() {
        return "Rectangle(" + this.x + ", " + this.y + ", " + this.horizontal + ", " + this.vertical + ")";
    }

    @Override
    public boolean pointIn(int xRef, int yRef) {
        return (xRef >= this.x && xRef <= this.x + this.horizontal) && (yRef >= this.y && yRef <= this.y + this.vertical);
    }

    @Override
    public int getMinX() {
        return this.x;
    }
}
