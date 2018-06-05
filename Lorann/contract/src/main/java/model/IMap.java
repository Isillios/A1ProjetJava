package model;

import java.util.Observable;


public interface IMap {
	Observable getObservable();
	void setMobileHasChanged();
	int getHeight();
	int getWidth();
	char getOnMap(int i);
	char setOnMap(int i, char element);
	
	IMobile getMyPlayer();
	

}