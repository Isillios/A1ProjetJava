package model;

import java.sql.SQLException;
//import java.util.Observable;

import model.ILorannModel;
import model.dao.MapDAO;
import model.element.mobile.Demon1;
import model.element.mobile.Demon2;
import model.element.mobile.Demon3;
import model.element.mobile.Demon4;
import model.element.mobile.MyPlayer;


/**
 * <h1>The Class Model .</h1>
 * <p>
 * This Class creates the methods which are present in the interface ILorannModel  
 * </p>
 * @author Team12
 * @version final
 * @see IMobile
 * @see ILorannModel
 * @see IMap
 */

public class Model implements ILorannModel {

	/**
	 * The model
	 */
	private ILorannModel model;
	
	/**
	 * The map
	 */
	private IMap map;
	
	/**
	 * The player and the demons
	 */
	private IMobile player, demon1, demon2, demon3, demon4;
	
	/**
	 * The score
	 */
	private int score;
	
	/**
	 * 
	 * @return this.score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Add 200 to the score
	 */
	public void setScore() {
		this.score += 200;	
	}

	/**
	 * 
	 * throws exceptions
	 * @throws SQLException 
	 */
	public Model() throws SQLException {
		/**
		 * Set the map
		 */
		this.setMap(new Map());
		/**
		 * Instantiate the map
		 */
		MapDAO dao = new MapDAO(map);
		
		/**
		 * Set the player and the demons on the map
		 */
		this.setMyPlayer(new MyPlayer(dao.positionhero,map));
		this.setDemon1(new Demon1(dao.positiondemon1,map,player));
		this.setDemon2(new Demon2(dao.positiondemon2,map,player));
		this.setDemon4(new Demon3(dao.positiondemon3,map,player));
		this.setDemon3(new Demon4(dao.positiondemon4,map,player));
	}
	
	/**
	 * 
	 * @param player
	 */
	public  void setMyPlayer(IMobile player) {
		this.player = player;	
	}
	
	/**
	 * 
	 * @param demon
	 */
	public  void setDemon1(IMobile demon) {
		this.demon1 = demon;	
	}
	
	/**
	 *@return this.map 
	 */
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

	/**
	 * 
	 */
	@Override
	public IMobile getMyPlayer() {
		return this.player;
	}
	
	/**
	 *@return this.demon1
	 */
	public IMobile getDemon1() {
		return this.demon1;
	}

	/**
	 *@return this.demon2
	 */
	public IMobile getDemon2() {   
		return this.demon2;
}

	/**
	 * 
	 * @param demon2
	 */
	public void setDemon2(IMobile demon2) {
		this.demon2 = demon2;
}

	/**
	 *@return demon3
	 */
	public IMobile getDemon3() {
		return demon3;
}

	/**
	 * 
	 * @param demon3
	 */
	public void setDemon3(IMobile demon3) {
	
		this.demon3 = demon3;
}

	/**
	 * @return demon4
	 */
	public IMobile getDemon4() {
	
		return demon4;
}

	/**
	 * 
	 * @param demon4
	 */
	public void setDemon4(IMobile demon4) {
	
		this.demon4 = demon4;
}

	/**
	 * 
	 * @return model
	 */
	public ILorannModel getModel() {
	
		return model;
}

	/**
	 * 
	 * @param model
	 */
	public void setModel(ILorannModel model) {
	
		this.model = model;
}

	@Override
	public IMobile getHero() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHero(IMobile her) {
		// TODO Auto-generated method stub
		
	}
}