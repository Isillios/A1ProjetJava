package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observer;
import javax.swing.JFrame;


public class BoardFrame extends JFrame implements IBoard, KeyListener {

    private static final long serialVersionUID = -6563585351564617603L;
    private final BoardPanel  boardPanel;
   
    public BoardFrame(final String title) {
        this.setTitle(title);
        this.boardPanel = new BoardPanel();
        this.setContentPane(this.boardPanel);
        this.setVisible(true);
        addKeyListener(this);
        requestFocusInWindow(); 
    }

    @Override
    public final void addSquare(final ISquare square, final int x, final int y) {
        this.getBoardPanel().addSquare(square, x, y);
    }
 
    @Override
    public final Observer getObserver() {
        return this.getBoardPanel();
    }

    @Override
    public final void setDimension(final Dimension dimension) {
        this.getBoardPanel().setDimension(dimension);
    }
     
    @Override
    public final void setDisplayFrame(final Rectangle displayFrame) {
        this.getBoardPanel().setDisplayFrame(displayFrame);
    }

    private BoardPanel getBoardPanel() {
        return this.boardPanel;
    }

    @Override
    public void keyTyped(final KeyEvent key) {
    }
    
    @Override
    public void keyPressed(KeyEvent key) {
        int codeDeLaTouche = key.getKeyCode();
        switch (codeDeLaTouche) 
        {
            case KeyEvent.VK_UP: 
                System.out.println("UP");
                break;
            case KeyEvent.VK_LEFT: 
                System.out.println("LEFT");
                break;
            case KeyEvent.VK_RIGHT: 
                System.out.println("RIGHT");
                break;
            case KeyEvent.VK_DOWN: 
                System.out.println("DOWN");
                break;
            case KeyEvent.VK_SPACE:
            	System.out.println("SHOOT");
            	break;
            	}
    }

        @Override
        public void keyReleased(KeyEvent key) {
        }

}
