package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.Observable;
import javax.swing.SwingUtilities;
import java.util.*; 


public class ViewLorann extends Observable implements Runnable {

	private String tabmap[] = {
			"bc","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","bc",
			"vb","b","b","b","vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","vb","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","b","vb","b","b","b","b","b","b","b","b","b","b","b","b","gc",
			"vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","b","b","b","b","b","b","b","lb","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","m3","b","b","vb",
			"vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"vb","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","vb",
			"bc","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","bc"
			};
	
	private Hashtable<String, Tile> table = new Hashtable<String, Tile>();
	
    public static final int width = 20;
    public static final int height =12;
    private static final int timeLoop = 1920;
    private static final int sizeFrame = 1080;
    private static final Rectangle View = new Rectangle(0, 0, width - 0, height - 0);
    
    public ViewLorann() throws IOException {
    	
    	Tile black_Tile = new Tile("black.png");
        black_Tile.loadImage();
        this.table.put("b", black_Tile);
        
        Tile bone_Tile = new Tile("bone.png");
        bone_Tile.loadImage();
        this.table.put("bc", bone_Tile);
        
        Tile crystalball_Tile = new Tile("crystal_ball.png");
        crystalball_Tile.loadImage();
        this.table.put("cb", crystalball_Tile);
        
        Tile fireball_1_Tile = new Tile("fireball_1.png");
        fireball_1_Tile.loadImage();
        this.table.put("f1", fireball_1_Tile);
        
        Tile fireball_2_Tile = new Tile("fireball_2.png");
        fireball_2_Tile.loadImage();
        this.table.put("f2", fireball_2_Tile);
        
        Tile fireball_3_Tile = new Tile("fireball_3.png");
        fireball_3_Tile.loadImage();
        this.table.put("f3", fireball_3_Tile);
        
        Tile fireball_4_Tile = new Tile("fireball_4.png");
        fireball_4_Tile.loadImage();
        this.table.put("f4", fireball_4_Tile);
        
        Tile fireball_5_Tile = new Tile("fireball_5.png");
        fireball_5_Tile.loadImage();
        this.table.put("f5", fireball_5_Tile);
        
        Tile gate_closed_Tile = new Tile("gate_closed.png");
        gate_closed_Tile.loadImage();
        this.table.put("gc", gate_closed_Tile);
        
        Tile gate_open_Tile = new Tile("gate_open.png");
        gate_open_Tile.loadImage();
        this.table.put("go", gate_open_Tile);
        
        Tile horizontal_bone_Tile = new Tile("horizontal_bone.png");
        horizontal_bone_Tile.loadImage();
        this.table.put("hb", horizontal_bone_Tile);
        
        Tile lorann_b_Tile = new Tile("lorann_b.png");
        lorann_b_Tile.loadImage();
        this.table.put("lb", lorann_b_Tile);
        
        Tile lorann_bl_Tile = new Tile("lorann_bl.png");
        lorann_bl_Tile.loadImage();
        this.table.put("lbl", lorann_bl_Tile);
        
        Tile lorann_br_Tile = new Tile("lorann_br.png");
        lorann_br_Tile.loadImage();
        this.table.put("lbr", lorann_br_Tile);
        
        Tile lorann_l_Tile = new Tile("lorann_l.png");
        lorann_l_Tile.loadImage();
        this.table.put("ll", lorann_l_Tile);
        
        Tile lorann_r_Tile = new Tile("lorann_r.png");
        lorann_r_Tile.loadImage();
        this.table.put("lr", lorann_r_Tile);
        
        Tile lorann_u_Tile = new Tile("lorann_u.png");
        lorann_u_Tile.loadImage();
        this.table.put("lu", lorann_u_Tile);
        
        Tile lorann_ul_Tile = new Tile("lorann_ul.png");
        lorann_ul_Tile.loadImage();
        this.table.put("lul", lorann_ul_Tile);
        
        Tile lorann_ur_Tile = new Tile("lorann_ur.png");
        lorann_ur_Tile.loadImage();
        this.table.put("lur", lorann_ur_Tile);
        
        Tile monster_1_Tile = new Tile("monster_1.png");
        monster_1_Tile.loadImage();
        this.table.put("m1", monster_1_Tile);
        
        Tile monster_2_Tile = new Tile("monster_2.png");
        monster_2_Tile.loadImage();
        this.table.put("m2", monster_2_Tile);
        
        Tile monster_3_Tile = new Tile("monster_3.png");
        monster_3_Tile.loadImage();
        this.table.put("m3", monster_3_Tile);
        
        Tile monster_4_Tile = new Tile("monster_4.png");
        monster_4_Tile.loadImage();
        this.table.put("m4", monster_4_Tile);
        
        Tile purse_Tile = new Tile("purse.png");
        purse_Tile.loadImage();
        this.table.put("p", purse_Tile);
        
        Tile vertical_bone_Tile = new Tile("vertical_bone.png");
        vertical_bone_Tile.loadImage();
        this.table.put("vb", vertical_bone_Tile);
        
        SwingUtilities.invokeLater(this);
           
    }
    
    public final void run() {
        final BoardFrame frameView = new BoardFrame("Lorann View");
        frameView.setDimension(new Dimension(width, height));
        frameView.setDisplayFrame(View);
        frameView.setSize(sizeFrame, sizeFrame);
        this.frameConfigure(frameView);
    }
    
	public final void move() throws InterruptedException {
        for (;;) {
            this.setChanged();
            this.notifyObservers();
            Thread.sleep(timeLoop);
        }
    }
    
    public final void frameConfigure(final BoardFrame frame) {
    	int x = 0;
    	int y = 0;
    	for (int i = 0; i < this.tabmap.length; i++) {
            x = (i % 20);
            y = ((i - x)/ 20);
            frame.addSquare(this.table.get(tabmap[i]), x, y);
        }   
        this.addObserver(frame.getObserver());
        frame.setVisible(true);
    }	
}

