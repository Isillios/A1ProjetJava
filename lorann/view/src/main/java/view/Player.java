package view;

import java.awt.Image;

public class Player {
	
	private Image sprite_h;
	
	public Player(Image sprite) {
		this.sprite_h = sprite;
	}
	
	public static void up() {
		int x = LorannView.getPosition();
		LorannView.map[x] = 'b';
		LorannView.map[x -20] = 'U';
		
	}
	
	public static void down() {
		int x = LorannView.getPosition();
		LorannView.map[x] = 'b';
		LorannView.map[x +20] = 'D';
	}

	public static void right() {
		int y = LorannView.getPosition();
		LorannView.map[y] = 'b';
		LorannView.map[y +1] = 'R';
	}
	public static void left() {
		int y = LorannView.getPosition();
		LorannView.map[y] = 'b';
		LorannView.map[y -1] = 'L';
	}
	public static void stop() {
        int x = LorannView.getPosition();
        LorannView.map[x] = 'U';
    }

	public Image getSprite_h() {
		return sprite_h;
	}

	public void setSprite_h(Image sprite_h) {
		this.sprite_h = sprite_h;
	}

	
}
