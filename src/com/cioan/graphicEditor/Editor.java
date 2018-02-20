package com.cioan.graphicEditor;

public class Editor {

    private Rectangle elemente[] = new Rectangle[10];


    public boolean createRectangle(int x, int y, int width, int height) {
        boolean response = false;
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] == null) {
                elemente[cnt] = new Rectangle(x, y, width, height);
                response = true;
                break;
            }
        }
        return response;
    }


    public int getTotalArea() {
        int totalArea = 0;
        for (int cnt = 0; cnt < this.elemente.length; ++cnt) {
            if (this.elemente[cnt] != null) {
                totalArea = totalArea + this.elemente[cnt].getArea();
            }
        }
        return totalArea;
    }

    public void removeElementsSmallerThan(int area) {
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                if (elemente[cnt].getArea() < area) {
                    elemente[cnt] = null;
                }
            }
        }
    }

    public Rectangle[] reportLeftToRight() {
        int newArrayLength = 0;
        int minX;
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                newArrayLength++;
            }
        }

        Rectangle[] report = new Rectangle[newArrayLength];

        int elem = 0;
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                report[elem] = elemente[cnt];
                elem++;
            }
        }

        Rectangle aux;

        for (int cnt = 0; cnt < newArrayLength - 2; cnt++) {
            for (int cnt2 = cnt + 1; cnt2 < newArrayLength - 1; cnt2++) {
                if (report[cnt].getX() > report[cnt2].getX()) {
                    aux = report[cnt2];
                    report[cnt2] = report[cnt];
                    report[cnt] = aux;
                }
            }
        }

        return report;
    }


    public String toString() {
        String ret = "";

        for (int cnt = 0; cnt < this.elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                ret = ret + elemente[cnt] + ", ";
            } else {
                ret += "null, ";
            }
        }
        return ret;
    }

    public Rectangle[] getElementsIntersectingPoint(int x, int y) {
        int newArrayLength = 0;

        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                newArrayLength++;
            }
        }

        Rectangle[] ret = new Rectangle[newArrayLength];
        int elem = 0;

        for (int cnt = 0; cnt < this.elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                if (elemente[cnt].pointIn(x, y)) {
                    ret[elem] = elemente[cnt];
                }
            }
        }

        return ret;
    }
}
