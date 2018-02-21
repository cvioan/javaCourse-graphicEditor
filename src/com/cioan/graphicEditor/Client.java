package com.cioan.graphicEditor;

import com.cioan.graphicEditor.Exceptions.EmptyArrayException;
import com.cioan.graphicEditor.Exceptions.FullArrayException;

public class Client {

    public static void main(String[] args) {

        Editor editor = new Editor();
        try {
            editor.createRectangle(2, 1, 4, 2);
            editor.createRectangle(0, 0, 1, 1);
            editor.createRectangle(-3, 2, 2, 1);
            editor.createRectangle(3, 3, 1, 2);
            editor.createRectangle(1, 3, 2, 2);
            editor.createRectangle(5, -1, 4, 3);
            editor.createCircle(0, 0, 3);
            editor.createCircle(1, -1, 2);
            editor.createRectangle(3, -2, 3, 3);
            editor.createCircle(3, 1, 8);
            editor.createCircle(9, -2, 6);
        } catch (FullArrayException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        System.out.println("Aria totala este: " + editor.getTotalArea());
        System.out.println(editor);
        System.out.println();
        editor.removeElementsSmallerThan(500);
        System.out.println(editor);
        System.out.println();
        Shape[] raport = editor.reportLeftToRight();
        try {
            Editor.printArray(raport);
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        System.out.println();
        Shape[] elements = editor.getElementsIntersectingPoint(1, 1);
        try {
            Editor.printArray(elements);
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }


}
