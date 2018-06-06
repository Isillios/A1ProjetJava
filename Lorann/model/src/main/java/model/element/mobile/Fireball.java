package model.element.mobile;

import model.IMap;
import model.Permeability;
import model.element.mobile.MyPlayer;

/**
 * <h1>The Class Fireball.</h1>
 * <p>This class is a generalized class for the fireball</p>
 * @author Team12
 * @version final
 * @see AI
 */

public class Fireball extends AI {
	/**
	 * The map
	 */
	public IMap map;
	/**
	 * The direction
	 */
	int Direction;
	/**
	 * The hero
	 */
	private MyPlayer hero;
	
	/**
	 * 
	 * @param position
	 * @param map
	 * @param Direction
	 * @param hero
	 */
	public Fireball(int position, IMap map, int Direction,MyPlayer hero) {
		super(position,map,Permeability.PENETRABLE);
		this.map = map;
		this.Direction = Direction;
		this.setObjet("fireball");
		this.hero = hero;
		map.setOnMap(position, 'f');
	}
	
	/**
	 * Take the parameter of the controller to set a move for the fireball
	 */
	public void move(int move) {
		switch (Direction) {
		case 1 :
			super.moveLeft(getPosition(),this.getObjet());
			break;
		case 2 :
			super.moveRight(getPosition(),this.getObjet());
			break;
		case 3 :
			super.moveDown(getPosition(),this.getObjet());
			break;
		case 4 :
			super.moveUp(getPosition(),this.getObjet());
			break;
		}
	}

	@Override
	public Boolean isAlive() {
		return null;
	}

	@Override
	public Boolean setAlive() {
		return null;
	}

	@Override
	public void stop() {
	}

	@Override
	public void setMana(boolean b) {
		hero.setMana(true);
	}

	@Override
	public boolean getMana() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean getWin() {
		// TODO Auto-generated method stub
		return null;
	}
}