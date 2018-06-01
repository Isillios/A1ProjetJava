package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LorannView extends JPanel implements KeyListener {

    private static final long serialVersionUID = -5247887007395270989L;
    private boolean           possedeDisque    = true;
    private int               px;
    private int               py;

    public boolean stop = false;

    private Hashtable<Character, Image> table = new Hashtable<Character, Image>();

    public char map[] = {
           'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
            'b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b',
    };


    public LorannView() throws IOException {
        this.px = 32;
        this.py = 32;

        Image wallH = ImageIO.read(new File("C:\\Users\\Public\\sprite\\WallH.png"));
        this.table.put('g', wallH);
        Image wallV = ImageIO.read(new File("C:\\Users\\Public\\sprite\\WallV.png"));
        this.table.put('j', wallV);
        Image purse = ImageIO.read(new File("C:\\Users\\Public\\sprite\\purse.png"));
        this.table.put('b', purse);
        Image black = ImageIO.read(new File("C:\\Users\\Public\\sprite\\black.png"));
        this.table.put('j', black);
        Image intersection = ImageIO.read(new File("C:\\Users\\Public\\sprite\\intersection.png"));
        this.table.put('p', intersection);
        Image crystalball = ImageIO.read(new File("C:\\Users\\Public\\sprite\\crystalball.png"));
        this.table.put('f', crystalball);
        Image door_closed = ImageIO.read(new File("C:\\Users\\Public\\sprite\\door_closed.png"));
        this.table.put('o', door_closed);
        Image door_open = ImageIO.read(new File("C:\\Users\\Public\\sprite\\door_open.png"));
        this.table.put('u', door_open);
        Image lorann = ImageIO.read(new File("C:\\Users\\Public\\sprite\\lorann_up.png"));
        this.table.put('A', lorann);

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(640, 384));
        addKeyListener(this);
        requestFocusInWindow();
    }

    public void paint (final Graphics g)/* throws IOException*/{
        int x = 0;
        int y = 0;
        for (int i = 0; i < map.length; i++) {
            x = (i % 20) * 32;
            y = ((i - (x / 32)) / 20) * 32;
            g.drawImage(this.table.get(map[i]), x, y, this);
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent key) {

        final int codeDeLaTouche = key.getKeyCode();
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
    public void keyReleased(KeyEvent e) {

    }
}
