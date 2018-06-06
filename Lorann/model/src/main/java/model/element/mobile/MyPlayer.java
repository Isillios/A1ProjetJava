package model.element.mobile;

import model.*;
import model.element.Element;

/**
 * <h1>The Class MyPlayer.</h1>
 * <p>This class is a generalized class of the player
 * @author Team12
 * @version final
 * @see Element
 * @see IMobile
 */

public class MyPlayer extends Mobile implements IMobile {
	
	/**
	 *Set mana true
	 */
	private static boolean mana = true;
	
	/**
	 * The map
	 */
	private IMap map;
	
	/**
	 * The last position
	 */
	private int lastposition;
	
	/**
	 * The spell
	 */
	public Fireball spell;
	
	/**
	 * 
	 * @param position
	 * @param map
	 */
	public MyPlayer(int position, IMap map) {
		
		super(position,map,Permeability.BLOCKING);
		this.setLastposition(position);
		this.setPosition(position);
		this.map = map;
		this.setObjet("Player");
	}
	
	/**
	 * The fireball is thrown a box behind the character
	 * 
	 */
	public Fireball fireball() {
		int direction = 0 ;
		int order = getLastposition() - getPosition();
	
		switch (order) {
		case 1 :
			direction = 1;
			break;
		case -1 :
			direction = 2;
			break;
		case -20 :
			direction = 3;
			break;
		case 20 :
			direction = 4;
			break;
		}
		 spell = new Fireball(getLastposition(),map,direction,this);
		 setMana(false);
		return spell;	
	}

	public  boolean getMana() {
		return mana;
	}

	public void setMana(boolean mana) {
		MyPlayer.mana = mana;
	}
	
	/**
	 * Player's order
	 */
	public void move(int move) {
		switch(move) {
		case 1:
			setLastposition(this.getPosition());
			super.moveUp(this.getPosition(),this.getObjet());
			break;
		case 2:
			setLastposition(this.getPosition());
			super.moveDown(this.getPosition(),this.getObjet());
			break;
		case 3:
			setLastposition(this.getPosition());
			super.moveLeft(this.getPosition(),this.getObjet());
			break;
		case 4:
			setLastposition(this.getPosition());
			super.moveRight(this.getPosition(),this.getObjet());
			break;
		case 5:
			fireball();
			break;
		case 6:
			setLastposition(this.getPosition());
			super.moveUpRight(this.getPosition(),this.getObjet());
			break;
		case 7:
			setLastposition(this.getPosition());
			super.moveUpLeft(this.getPosition(),this.getObjet());
			break;
		case 8:
			setLastposition(this.getPosition());
			super.moveDownRight(this.getPosition(),this.getObjet());
			break;
		case 9:
			setLastposition(this.getPosition());
			super.moveDownLeft(this.getPosition(),this.getObjet());
			break;
			
		}
	}
	
	@Override
	public  Boolean isAlive() {
		return super.getAlive();
	}

	public void isDead() {
		super.death();
	}

	public int getLastposition() {
		return lastposition;
	}

	public void setLastposition(int lastposition) {
		this.lastposition = lastposition;
	}

	@Override
	public Boolean setAlive() {
		super.death();
		return isAlive();	
	}

	@Override
	public void stop() {	
	}

	public void setWin() {
		this.win = true;
		
	}

	@Override
	public Boolean getWin() {
		// TODO Auto-generated method stub
		return win;
	}	
}