package model;

import java.util.Observable;
import model.IMap;


public  class Map extends Observable implements IMap {
	
	private int width = 20;
	private int height = 12;
	private char onTheMap[] = new char[(height * width)];
	private IMap map;
	
	public void setMobileHasChanged() {
		this.setChanged();
        this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}
	
	public char getOnMap(int i){
		return onTheMap[i];
	}
	
	public char setOnMap(int i,char element){
		return onTheMap[i] = element ;
	}
	
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	@Override
	public IMobile getMyPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

}