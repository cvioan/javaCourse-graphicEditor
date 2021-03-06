package com.cioan.graphicEditor.graphicAdapters;

import com.cioan.graphicEditor.graphicEngines.GraphicEngine1;
import com.cioan.graphicEditor.IDrawable;

public class GraphicEngineAdapterOne implements IDrawable {
    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        GraphicEngine1.line(x1, y1, x2, y2);
    }

    @Override
    public void drawCircle(int x, int y, int r) {
        GraphicEngine1.circle(x, y, r);
    }
}
