package model.element.mobile;

import model.*;

/**
 * <h1>The Class Demon.</h1>
 * <p>This class is a generalized class for the demons</p>
 * @author Team12
 * @version final
 * @see AI
 */

public abstract class Demon extends AI {
	
	/**
	 * The hero
	 */
	public static IMobile hero;
	
	/**
	 * 
	 * @param position
	 * @param map
	 * @param permeability
	 * @param Hero
	 */
	public Demon(int position ,IMap map, Permeability permeability,IMobile Hero) {
		super(position,map, permeability);
		hero = Hero;
	}
	
	/**
	 * Kill a demon set the mana to true to fire again
	 */
	public static void kill() {
		hero.setAlive();
		hero.setMana(true);
		
	}
}