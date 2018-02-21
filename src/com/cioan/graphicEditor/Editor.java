package com.cioan.graphicEditor;

import com.cioan.graphicEditor.Exceptions.EmptyArrayException;
import com.cioan.graphicEditor.Exceptions.FullArrayException;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class Editor {

    private Shape elemente[] = new Shape[10];

    public static boolean isEmpty(Shape[] elemente) {
        boolean response = true;
        for (Shape element : elemente) {
            if (element != null) {
                response = false;
                break;
            }
        }
        return response;
    }

    public static void printArray(Shape[] elemente) throws EmptyArrayException {
        if (!Editor.isEmpty(elemente)) {
            for (Shape element : elemente) {
                if (element != null) {
                    System.out.print(element);
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else {
            throw new EmptyArrayException("Array is empty! Nothing to print.");
        }
    }

    public void createRectangle(int x, int y, int width, int height) throws FullArrayException {
        boolean response = false;
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] == null) {
                elemente[cnt] = new Rectangle(x, y, width, height);
                response = true;
                break;
            }
        }
        if (!response) {
            throw new FullArrayException("Array is full! Cannot add more Shapes.");
        }
    }

    public void createCircle(int x, int y, int radius) throws FullArrayException {
        boolean response = false;
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] == null) {
                elemente[cnt] = new Circle(x, y, radius);
                response = true;
                break;
            }
        }

        if (!response) {
            throw new FullArrayException("Array is full! Cannot add more Shapes.");
        }
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Shape element : elemente) {
            if (element != null) {
                totalArea = totalArea + element.getArea();
            }
        }
        return totalArea;
    }

    public void removeElementsSmallerThan(double area) {
        for (int cnt = 0; cnt < elemente.length; ++cnt) {
            if (elemente[cnt] != null) {
                if (elemente[cnt].getArea() < area) {
                    elemente[cnt] = null;
                }
            }
        }
    }

    public Shape[] reportLeftToRight() {
        int newArrayLength = 0;
        for (Shape element : elemente) {
            if (element != null) {
                newArrayLength++;
            }
        }

        Shape[] report = new Shape[newArrayLength];

        int elem = 0;
        for (Shape element : elemente) {
            if (element != null) {
                report[elem] = element;
                elem++;
            }
        }

        Shape aux;

        for (int cnt = 0; cnt < newArrayLength - 2; cnt++) {
            for (int cnt2 = cnt + 1; cnt2 < newArrayLength - 1; cnt2++) {
                if (report[cnt].getMinX() > report[cnt2].getMinX()) {
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

        for (Shape element : elemente) {
            if (element != null) {
                ret.append(element).append(" ");

            }
        }
        return ret.toString();
    }

    public Shape[] getElementsIntersectingPoint(int x, int y) {
        int newArrayLength = 0;

        for (Shape element : elemente) {
            if (element != null) {
                newArrayLength++;
            }
        }

        Shape[] ret = new Shape[newArrayLength];
        int elem = 0;

        for (Shape element : elemente) {
            if (element != null) {
                if (element.pointIn(x, y)) {
                    ret[elem++] = element;
                }
            }
        }

        return ret;
    }
}
