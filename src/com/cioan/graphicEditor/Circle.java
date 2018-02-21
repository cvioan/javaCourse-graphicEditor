package com.cioan.graphicEditor;

import com.cioan.graphicEditor.Utils.Utils;

public class Circle extends Shape {
    private int radius;

    Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Utils.roundDoubleTwoDecimals(Math.PI * Math.pow(this.radius, 2));
    }

    public String toString() {
        return "Circle(" + this.x + ", " + this.y + ", " + this.radius + ") ";
    }

    @Override
    public boolean pointIn(int xRef, int yRef) {
        double distance;
        distance = Math.sqrt(Math.pow(xRef-this.x, 2) + Math.pow(yRef - this.y, 2));
        return (distance < radius);
    }

    @Override
    public int getMinX() {
        return this.x - radius;
    }
}
