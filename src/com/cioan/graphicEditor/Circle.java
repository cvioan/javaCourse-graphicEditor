package com.cioan.graphicEditor;

import com.cioan.graphicEditor.utils.Utils;

public class Circle extends Shape implements Comparable<Shape>{
    private int radius;

    Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Utils.roundDoubleTwoDecimals(Math.PI * Math.pow(this.radius, 2));
    }

    public String toString() {
        return "Circle(" + this.x + ", " + this.y + ", " + this.radius + ")";
    }

    @Override
    public boolean pointIn(int xRef, int yRef) {
        double distance;
        distance = Math.sqrt(Math.pow(xRef - this.x, 2) + Math.pow(yRef - this.y, 2));
        return (distance < radius);
    }

    @Override
    public int getMinX() {
        return this.x - radius;
    }

    @Override
    public void draw(IDrawable lib) {
        System.out.println("Circle");
        lib.drawCircle(x, y, radius);
        System.out.println();
    }

    @Override
    public boolean equals(Shape other) {
        Circle ot = (Circle) other;
        return (this.x == ot.x) && (this.y == ot.y) && (this.radius == ot.radius);
    }

    @Override
    public int compareTo(Shape o1) {
        return this.getMinX() - o1.getMinX();
    }
}

