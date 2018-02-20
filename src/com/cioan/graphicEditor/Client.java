package com.cioan.graphicEditor;

public class Client {

    public static void main(String[] args) {

        Editor editor = new Editor();
        editor.createRectangle(2, 1, 4, 2);
        editor.createRectangle(0, 0, 1, 1);
        editor.createRectangle(-3, 2, 2, 1);
        editor.createRectangle(3, 3, 1, 2);
        editor.createRectangle(1, 3, 2, 2);
        editor.createRectangle(5, -1, 4, 3);
        System.out.println("Aria totala este: " + editor.getTotalArea());
        editor.removeElementsSmallerThan(2);
        System.out.println(editor);
        System.out.println();
        Rectangle[] raport = editor.reportLeftToRight();
        for (Rectangle element: raport) {
            System.out.println(element);
        }
        System.out.println();
        Rectangle[] elements = editor.getElementsIntersectingPoint(4, 3);
        int qty = 0;
        for (Rectangle element: elements) {

            if (element != null) {
                System.out.println(element);
                qty++;
            }
        }
        if (qty==0) {
            System.out.println("Nici un element nu intersecteaza punctul");
        }
    }


}
