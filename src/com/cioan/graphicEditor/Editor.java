package com.cioan.graphicEditor;

import com.cioan.graphicEditor.exceptions.EmptyArrayException;
import com.cioan.graphicEditor.exceptions.FullArrayException;
import com.cioan.graphicEditor.graphicAdapters.GraphicEngineAdapterOne;
import com.cioan.graphicEditor.graphicAdapters.GraphicEngineAdapterTwo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("ForLoopReplaceableByForEach")
public class Editor {

    private static IDrawable graphicEngine = new GraphicEngineAdapterOne();
    private List<Shape> elemente = new ArrayList<>();

    public static void toggleGraphicEngine() {
        if (graphicEngine instanceof GraphicEngineAdapterOne) {
            graphicEngine = new GraphicEngineAdapterTwo();
        } else {
            graphicEngine = new GraphicEngineAdapterOne();
            }
        }

        private static boolean isEmpty(List<Shape> elemente) {
            return elemente.size() == 0;
        }

        public static void printArray(List<Shape> elemente) throws EmptyArrayException {
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

        public void drawAll() {
            for (Shape element : elemente) {
                if (element != null) {
                    element.draw(graphicEngine);
                }
            }
        }

        public void createRectangle(int x, int y, int width, int height){
            elemente.add(new Rectangle(x, y, width, height));
        }

        public void createCircle(int x, int y, int radius){
            elemente.add(new Circle(x, y, radius));
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
            List<Shape> removable = new ArrayList<>();
            for(Shape element: elemente) {
                if (element.getArea() < area ) {
                    removable.add(element);
                }
            }

            for (Shape remElement: removable) {
                elemente.remove(remElement);
            }
        }

        public List<Shape> reportLeftToRight() {

            List<Shape> sorted = elemente;
            Collections.sort(sorted);
            return sorted;
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

    public List<Shape> getElementsIntersectingPoint(int x, int y) {
        List<Shape> ret = new ArrayList<>();
        for (Shape element: elemente) {
            if (element.pointIn(x, y)) {
                ret.add(element);
            }
        }

        return ret;
    }
}
