package view;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Frame extends JFrame implements KeyListener {
	
	LorannView view = new LorannView();

    public Frame() throws IOException {
    	//add title to the frame
    	this.setTitle("Lorann");
    	//add JPanel to the frame
        this.setContentPane(view);
        // frame resize
        this.setResizable(true);
        // frame size
        this.setSize(526, 294);
    
        //this.pack();
        // stop the program when the frame is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // capture keyboard inputs in frame
        addKeyListener(this);
        requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent key) {

        int codeDeLaTouche = key.getKeyCode();
        switch (codeDeLaTouche)
        {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                Player.up();
                this.repaint();

                break;

            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                Player.left();
                this.repaint();
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                Player.right();
                this.repaint();
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                Player.down();
                this.repaint();
                break;

            case KeyEvent.VK_SPACE:
                System.out.println("SHOOT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent key) {
    	int codeDeLaTouche = key.getKeyCode();
        switch (codeDeLaTouche)
        {
            case KeyEvent.VK_UP:
                System.out.println("UP");
                Player.stop();
                this.repaint();

                break;

            case KeyEvent.VK_LEFT:
                System.out.println("LEFT");
                Player.stop();
                this.repaint();
                break;

            case KeyEvent.VK_RIGHT:
                System.out.println("RIGHT");
                Player.stop();
                this.repaint();
                break;

            case KeyEvent.VK_DOWN:
                System.out.println("DOWN");
                Player.stop();
                this.repaint();
                break;
    }
}
}
