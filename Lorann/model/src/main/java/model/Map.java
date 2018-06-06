package model;

import java.util.Observable;

/**
 * <h1>The Class Map .</h1>
 * <p>
 * This Class creates the methods which are present in the interface IMap  
 * </p>
 * @author Team12
 * @version final
 * @see Observable
 * @see IMap
 */

public  class Map extends Observable implements IMap {
	
	/**
	 * The width
	 */
	private int width = 20;
	
	/**
	 * The height
	 */
	private int height = 12;
	
	/**
	 * Table which contains the map elements
	 */
	private char onTheMap[] = new char[(height * width)];
	
	/**
	 * The map
	 */
	private IMap map;
	
	/**
	 * Notify the observer when the mobile has changed
	 */
	public void setMobileHasChanged() {
		this.setChanged();
        this.notifyObservers();
	}

	/**
	 * @return this
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * @return ontThemap[]
	 */
	public char getOnMap(int i){
		return onTheMap[i];
	}
	
	/**
	 * @param i
	 * @param element
	 * @return onTheMap[i] = element
	 */
	public char setOnMap(int i,char element){
		return onTheMap[i] = element ;
	}
	
	/**
	 *@return this.width 
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * @return this.height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * 
	 * @return map
	 */
	public IMap getMap() {
		return map;
	}

	/**
	 * 
	 * @param map
	 */
	public void setMap(IMap map) {
		this.map = map;
	}

	/**
	 * @return null
	 */
	@Override
	public IMobile getMyPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}