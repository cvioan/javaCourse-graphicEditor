package com.cioan.graphicEditor;

import com.cioan.graphicEditor.exceptions.EmptyArrayException;

import java.io.IOException;
import java.util.List;

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
        editor.createRectangle(3, -2, 3, 3);
        editor.createCircle(3, 1, 8);
        editor.createCircle(9, -2, 6);
        System.out.println();
        System.out.println("Aria totala este: " + editor.getTotalArea());
        System.out.println();
        editor.drawAll();
        System.out.println();
        Editor.toggleGraphicEngine();
        editor.drawAll();
        System.out.println();
        System.out.println("Before remove");
        System.out.println(editor);
        System.out.println();
        editor.removeElementsSmallerThan(35);
        System.out.println("After remove");
        System.out.println(editor);
        System.out.println();
        List<Shape> raport = editor.reportLeftToRight();
        try {
            Editor.printArray(raport);
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        System.out.println();
        List<Shape> elements = editor.getElementsIntersectingPoint(10, 10);
        try {
            Editor.printArray(elements);
        } catch (EmptyArrayException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        System.out.println();
        System.out.println(editor);
        System.out.println();
        try {
            editor.save("elements.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            editor.restore("elements.bin");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
