package com.cioan.graphicEditor;

import com.cioan.graphicEditor.Utils.Utils;

@SuppressWarnings("unused")
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

    @Override
    public void draw(IDrawable lib) {
        System.out.println("Rectangle");
        lib.drawLine(x, y, x + horizontal, y);
        lib.drawLine(x + horizontal, y, x + horizontal, y + vertical);
        lib.drawLine(x + horizontal, y + vertical, x,  y + vertical);
        lib.drawLine(x,  y + vertical, x, y);
        System.out.println();
    }
}
