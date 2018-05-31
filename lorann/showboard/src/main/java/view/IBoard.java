package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observer;


public interface IBoard {

    void addSquare(ISquare square, int x, int y);
    Observer getObserver();
    void setDimension(Dimension dimension);
    void setDisplayFrame(Rectangle displayFrame);
}
