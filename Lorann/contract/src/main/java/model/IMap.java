package model;

import java.util.Observable;

/**
 * <h1>The Interface IMap.</h1>
 * <p>
 * This Interface is just used to authorize the class who implement him to use the methods getObservable and setMobileHasChnaged for the DP Observer. 
 * But too, the methods getHeight, getWidth, getOnMap, setOnMap and getMyPlayer.
 * </p>
 * @author Team12
 * @version final
 * @see Observable
 * @see IMobile
 */

public interface IMap {
	
	/**
	 * 
	 * @return this
	 */
	Observable getObservable();
	
	/**
	 * notify the observer
	 */
	void setMobileHasChanged();
	
	/**
	 * 
	 * @return this.height
	 */
	int getHeight();
	
	/**
	 * 
	 * @return this.width
	 */
	int getWidth();
	
	/**
	 * 
	 * @param i
	 * @return map
	 */
	char getOnMap(int i);
	
	/**
	 * 
	 * @param i
	 * @param element
	 */
	char setOnMap(int i, char element);
	
	/**
	 * 
	 * @return null
	 */
	IMobile getMyPlayer();
	

}