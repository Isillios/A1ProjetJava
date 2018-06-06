package model;

/**
 * <h1>The Interface IMobile.</h1>
 * <p>
 * This Interface is just used to authorize the class as the demon or the player who implement him to use the methods isAlive, setAlive.
 * They used too the methods getPosition, move and stop for the movement.
 * The methods setMana and getMana to use the fireball
 * The method setWin to finish the game when the player uses the open gate.
 * </p>
 * @author Team12
 * @version final
 * @see IElement
 * 
 */

public interface IMobile extends IElement {
	
	/**
	 * 
	 * @return this.alive
	 */
	Boolean isAlive();
	
	/**
	 * set the Boolean to true = alive
	 * 
	 */
	Boolean setAlive();
	
	/**
	 * 
	 * @return this.position
	 */
	int getPosition();
	
	/**
	 * 
	 * @param move
	 */
	void move(int move);
	
	/**
	 * 
	 */
	void stop();
	
	/**
	 * 
	 * @param b
	 */
	void setMana(boolean b);
	
	/**
	 * 
	 * @return this.mana
	 */
	boolean getMana();
	
	/**
	 * 
	 * @return this.win
	 */
	Boolean getWin();
	
	/**
	 * 
	 */
	void setWin();

}