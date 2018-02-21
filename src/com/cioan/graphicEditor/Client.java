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
        editor.createCircle(0, 0, 3);
        editor.createCircle(1, -1, 2);
        System.out.println("Aria totala este: " + editor.getTotalArea());
        System.out.println(editor);
        System.out.println();
        editor.removeElementsSmallerThan(2);
        System.out.println(editor);
        System.out.println();
        Shape[] raport = editor.reportLeftToRight();
        for (Shape element: raport) {
            System.out.println(element);
        }
        System.out.println();
        Shape[] elements = editor.getElementsIntersectingPoint(1, 1);
        int qty = 0;
        for (Shape element: elements) {

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
