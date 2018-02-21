package com.cioan.graphicEditor.GraphicLibraries;

import com.cioan.graphicEditor.GraphicEngines.GraphicEngine2;
import com.cioan.graphicEditor.IDrawable;

public class GEITwo implements IDrawable {
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        GraphicEngine2.dLine(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(int x, int y, int r) {
        GraphicEngine2.dCircle(x, y, r);
    }
}
