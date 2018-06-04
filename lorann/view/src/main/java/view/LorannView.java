package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LorannView extends JPanel {
	
	private static Player player1;

    private static final long serialVersionUID = -5247887007395270989L;
   
    private Hashtable<Character, Image> table = new Hashtable<Character, Image>();

    public static char map[] = {
    		'h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','U','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'v','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','b','v',
            'h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h','h'
    };


    public LorannView() throws IOException {
    
        // loading images and filling the HashTable
       
    	Image black = ImageIO.read(new File("sprite/black.png"));
        this.table.put('b', black);
        
        Image crystal_ball = ImageIO.read(new File("sprite/crystal_ball.png"));
        this.table.put('c', crystal_ball);
       
        Image gate_closed = ImageIO.read(new File("sprite/gate_closed.png"));
        this.table.put('g', gate_closed);
        Image gate_open = ImageIO.read(new File("sprite/gate_open.png"));
        this.table.put('G', gate_open);
        
        Image fireball_1 = ImageIO.read(new File("sprite/fireball_1.png"));
        this.table.put('f', fireball_1);
        Image fireball_2 = ImageIO.read(new File("sprite/fireball_2.png"));
        this.table.put('a', fireball_2);
        Image fireball_3 = ImageIO.read(new File("sprite/fireball_3.png"));
        this.table.put('z', fireball_3);
        Image fireball_4 = ImageIO.read(new File("sprite/fireball_4.png"));
        this.table.put('e', fireball_4);
        Image fireball_5 = ImageIO.read(new File("sprite/fireball_5.png"));
        this.table.put('t', fireball_5);
        
        Image bone = ImageIO.read(new File("sprite/bone.png"));
        this.table.put('i', bone);
        Image horizontal_bone = ImageIO.read(new File("sprite/horizontal_bone.png"));
        this.table.put('h', horizontal_bone);
        Image vertical_bone = ImageIO.read(new File("sprite/vertical_bone.png"));
        this.table.put('v', vertical_bone);
        
        Image lorann_b = ImageIO.read(new File("sprite/lorann_b.png"));
        this.table.put('D', lorann_b);
        Image lorann_bl = ImageIO.read(new File("sprite/lorann_bl.png"));
        this.table.put('l', lorann_bl);
        Image lorann_br = ImageIO.read(new File("sprite/lorann_br.png"));
        this.table.put('r', lorann_br);
        Image lorann_l = ImageIO.read(new File("sprite/lorann_l.png"));
        this.table.put('L', lorann_l);
        Image lorann_r = ImageIO.read(new File("sprite/lorann_r.png"));
        this.table.put('R', lorann_r);
        Image lorann_u = ImageIO.read(new File("sprite/lorann_u.png"));
        this.table.put('U', lorann_u);
        Image lorann_ul = ImageIO.read(new File("sprite/lorann_ul.png"));
        this.table.put('y', lorann_ul);
        Image lorann_ur = ImageIO.read(new File("sprite/lorann_ur.png"));
        this.table.put('Y', lorann_ur);
        
        Image monster_1 = ImageIO.read(new File("sprite/monster_1.png"));
        this.table.put('M', monster_1);
        Image monster_2 = ImageIO.read(new File("sprite/monster_2.png"));
        this.table.put('m', monster_2);
        Image monster_3 = ImageIO.read(new File("sprite/monster_3.png"));
        this.table.put('N', monster_3);
        Image monster_4 = ImageIO.read(new File("sprite/monster_4.png"));
        this.table.put('n', monster_4);
        
        Image purse = ImageIO.read(new File("sprite/purse.png"));
        this.table.put('p', purse);
        
        setPlayer1(new Player(lorann_u));

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(640, 384));
    }

    // starts at each modification of the frame to redraw the map
    public void paintComponent (final Graphics g){
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        for (int i = 0; i < map.length; i++) {
            width = this.getWidth();
            height = this.getHeight();
            x = (i % 20) * (width / 20);
            y = ((i - (x / (width / 20))) / 20) * (height / 12);
            g.drawImage(this.table.get(map[i]), x, y, width / 20, height / 12, this);
        }
        
    }

	public static int getPosition() {
		int position = 0;
		for (int i = 0; i< map.length; i++) {
			if(map[i] == 'U' ||map[i] == 'D' ||map[i] == 'R' ||map[i] == 'L') {
				position = i;
				System.out.println(i);
			}
		}
		return position;
	}

	public static Player getPlayer1() {
		return player1;
	}

	public static void setPlayer1(Player player1) {
		LorannView.player1 = player1;
	}
}
