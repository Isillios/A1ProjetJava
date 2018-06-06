package model;

/**
 * <h1>The Interface ILorannModel.</h1>
 * <p>
 * This Interface is just used to authorize the class who implement him to use the methods getMap, getMyPlayer and getDemon (the four possible) . 
 * </p>
 * @author Team12
 * @version final
 * @see IMap
 * @see IMobile
 */

public interface ILorannModel {
	/**
	 * 
	 * @return map
	 */
	IMap getMap();
	
	/**
	 * 
	 * @return player
	 */
	IMobile getMyPlayer();
	
	/**
	 * 
	 * @return demon1
	 */
	IMobile getDemon1();
	
	/**
	 * 
	 * @return demon2
	 */
	IMobile getDemon2();
	
	/**
	 * 
	 * @return demon3
	 */
	
	IMobile getDemon3();
	
	/**
	 * 
	 * @return demon4
	 */
	IMobile getDemon4();

	IMobile getHero();

	void setHero(IMobile her);
	
}