package com.cioan.graphicEditor;

@SuppressWarnings("ForLoopReplaceableByForEach")
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
        for (Rectangle element : elemente) {
            if (element != null) {
                totalArea = totalArea + element.getArea();
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
        for (Rectangle element : elemente) {
            if (element != null) {
                newArrayLength++;
            }
        }

        Rectangle[] report = new Rectangle[newArrayLength];

        int elem = 0;
        for (Rectangle element : elemente) {
            if (element != null) {
                report[elem] = element;
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
        StringBuilder ret = new StringBuilder("");

        for (Rectangle element : elemente) {
            if (element != null) {
                ret.append(element).append(", ");

            } else {
                ret.append("null, ");
            }
        }
        return ret.toString();
    }

    public Rectangle[] getElementsIntersectingPoint(int x, int y) {
        int newArrayLength = 0;

        for (Rectangle element : elemente) {
            if (element != null) {
                newArrayLength++;
            }
        }

        Rectangle[] ret = new Rectangle[newArrayLength];
        int elem = 0;

        for (Rectangle element : elemente) {
            if (element != null) {
                if (element.pointIn(x, y)) {
                    ret[elem++] = element;
                }
            }
        }

        return ret;
    }
}
