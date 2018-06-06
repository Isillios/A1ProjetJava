package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.ILorannModel;
import model.IMap;
import model.Score;


/**
 * <h1>The Class ViewPanel.</h1>
 * <p>This class View create the panel with the dimensions. 
 * @author Team12
 * @version final
 * @see JPanel
 */

public class ViewPanel extends JPanel  { 

	/*
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The hashtable for the correspondences
	 */
	private Hashtable<Character, Image> tabmap = new Hashtable<Character, Image>();
	
	/**
	 * The stop
	 */
	public boolean stop = false;
	
	/**
	 * The map
	 */
	public IMap map;
	
	/**
	 * The model
	 */
	public ILorannModel model;
	  
	/**
	 * The panel
	 * @param map
	 * @throws IOException
	 */
	public ViewPanel(IMap map) throws IOException {
		  this.map = map;	    
		  setBackground(Color.BLACK);		    
		  setPreferredSize(new Dimension(640, 410));  
		  loadImage();
		  }

	/**
	 * The image loading 
	 * @throws IOException
	 */
	 public void loadImage() throws IOException {
		 
		 	Image black = ImageIO.read(new File("sprite/black.png"));
	        this.tabmap.put('b', black);
	        
	        Image crystal_ball = ImageIO.read(new File("sprite/crystal_ball.png"));
	        this.tabmap.put('c', crystal_ball);
	       
	        Image gate_closed = ImageIO.read(new File("sprite/gate_closed.png"));
	        this.tabmap.put('g', gate_closed);
	        Image gate_open = ImageIO.read(new File("sprite/gate_open.png"));
	        this.tabmap.put('G', gate_open);
	        
	        Image fireball_1 = ImageIO.read(new File("sprite/fireball_1.png"));
	        this.tabmap.put('f', fireball_1);
	        Image fireball_2 = ImageIO.read(new File("sprite/fireball_2.png"));
	        this.tabmap.put('a', fireball_2);
	        Image fireball_3 = ImageIO.read(new File("sprite/fireball_3.png"));
	        this.tabmap.put('z', fireball_3);
	        Image fireball_4 = ImageIO.read(new File("sprite/fireball_4.png"));
	        this.tabmap.put('e', fireball_4);
	        Image fireball_5 = ImageIO.read(new File("sprite/fireball_5.png"));
	        this.tabmap.put('t', fireball_5);
	        
	        Image bone = ImageIO.read(new File("sprite/bone.png"));
	        this.tabmap.put('i', bone);
	        Image horizontal_bone = ImageIO.read(new File("sprite/horizontal_bone.png"));
	        this.tabmap.put('h', horizontal_bone);
	        Image vertical_bone = ImageIO.read(new File("sprite/vertical_bone.png"));
	        this.tabmap.put('v', vertical_bone); 
	        
	        Image lorann_b = ImageIO.read(new File("sprite/lorann_b.png"));
	        this.tabmap.put('D', lorann_b);
	        Image lorann_bl = ImageIO.read(new File("sprite/lorann_bl.png"));
	        this.tabmap.put('l', lorann_bl);
	        Image lorann_br = ImageIO.read(new File("sprite/lorann_br.png"));
	        this.tabmap.put('r', lorann_br);
	        Image lorann_l = ImageIO.read(new File("sprite/lorann_l.png"));
	        this.tabmap.put('L', lorann_l);
	        Image lorann_r = ImageIO.read(new File("sprite/lorann_r.png"));
	        this.tabmap.put('R', lorann_r);
	        Image lorann_u = ImageIO.read(new File("sprite/lorann_u.png"));
	        this.tabmap.put('U', lorann_u);
	        Image lorann_ul = ImageIO.read(new File("sprite/lorann_ul.png"));
	        this.tabmap.put('y', lorann_ul);
	        Image lorann_ur = ImageIO.read(new File("sprite/lorann_ur.png"));
	        this.tabmap.put('Y', lorann_ur);
	        
	        Image monster_1 = ImageIO.read(new File("sprite/monster_1.png"));
	        this.tabmap.put('M', monster_1);
	        Image monster_2 = ImageIO.read(new File("sprite/monster_2.png"));
	        this.tabmap.put('m', monster_2);
	        Image monster_3 = ImageIO.read(new File("sprite/monster_3.png"));
	        this.tabmap.put('N', monster_3);
	        Image monster_4 = ImageIO.read(new File("sprite/monster_4.png"));
	        this.tabmap.put('n', monster_4);
	        
	        Image purse = ImageIO.read(new File("sprite/purse.png"));
	        this.tabmap.put('p', purse);
	 }
	  
	 /**
	  * setting of the dimension of the view
	  */
	public void paint (final Graphics g){	  
		super.paint(g);       
		int x = 0;
	    int y = 0;
	    for (int i = 0; i < 240; i++) {
	        x = (i % 20) * (this.getWidth()/20);
	        y = ((i - (x / (this.getWidth()/20))) / 20) * (this.getHeight()/12);
	        g.drawImage(this.tabmap.get(map.getOnMap(i)), x, y,this.getWidth()/20,this.getHeight()/12, this);
	        g.drawString("Score " + String.valueOf(Score.getScore()),500 , 95);
	        g.setColor(Color.yellow);  
	    }   
	}
}
