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
        editor.removeElementsSmallerThan(1);
        System.out.println(editor);
        System.out.println();
        Rectangle[] raport = editor.reportLeftToRight();
        for (int cnt = 0; cnt < raport.length; ++cnt) {
            System.out.println(raport[cnt]);
        }
        System.out.println();
        Rectangle[] elements = editor.getElementsIntersectingPoint(4, 3);
        int qty = 0;
        for (int cnt = 0; cnt < elements.length; ++cnt) {

            if (elements[cnt] != null) {
                System.out.println(elements[cnt]);
                qty++;
            }
        }
        if (qty==0) {
            System.out.println("Nici un element nu intersecteaza punctul");
        }
    }


}
