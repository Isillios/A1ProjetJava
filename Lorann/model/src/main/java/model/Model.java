package model;


import java.sql.SQLException;

import model.ILorannModel;
import model.dao.MapDAO;
import model.element.mobile.Demon1;
import model.element.mobile.Demon2;
import model.element.mobile.Demon3;
import model.element.mobile.Demon4;
import model.element.mobile.MyPlayer;


public class Model implements ILorannModel {

	
	private ILorannModel model;
	private IMap map;
	private IMobile player;
	private IMobile demon1,demon2,demon3,demon4;
	private int score;
	public int getScore() {
		return this.score;
	}

	public void setScore() {
		this.score += 200;	
	}

	/**
	 * 
	 * throws exceptions
	 * @throws SQLException 
	 */
	public Model() throws SQLException {
		this.setMap(new Map());
		MapDAO dao = new MapDAO(map);
		this.setMyPlayer(new MyPlayer(dao.positionhero,map));
		this.setDemon1(new Demon1(dao.positiondemon1,map,player));
		this.setDemon2(new Demon2(dao.positiondemon2,map,player));
		this.setDemon4(new Demon3(dao.positiondemon3,map,player));
		this.setDemon3(new Demon4(dao.positiondemon4,map,player));
	}
	

	public  void setMyPlayer(IMobile ply) {
		this.player = ply;	
	}
	
	public  void setDemon1(IMobile dem) {
		this.demon1 = dem;	
	}
	
	public IMap getMap() {
		return this.map;
	}

	/**
	 * 
	 * @param map
	 */
	private void setMap(IMap map) {
		this.map = map;
	}

	@Override
	public IMobile getMyPlayer() {
		return this.player;
	}
public IMobile getDemon1() {
	return this.demon1;
	}

public IMobile getDemon2() {   
	return this.demon2;
}


public void setDemon2(IMobile demon2) {
	this.demon2 = demon2;
}

public IMobile getDemon3() {
	return demon3;
}


public void setDemon3(IMobile demon3) {
	this.demon3 = demon3;
}


public IMobile getDemon4() {
	return demon4;
}


public void setDemon4(IMobile demon4) {
	this.demon4 = demon4;
}


public ILorannModel getModel() {
	return model;
}


public void setModel(ILorannModel model) {
	this.model = model;
}
}