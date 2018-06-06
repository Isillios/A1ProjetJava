package model.element.mobile;


import java.util.Random;

import model.IMap;
import model.IMobile;
import model.Permeability;

/**
 * <h1>The Class Demon1.</h1>
 * <p>This class extends to Demon and implement the different methods. It has the similar methods to the others demons.</p>
 * @author Team12
 * @version final
 */

public class Demon1 extends Demon {
	
	/**
	 * 
	 * @param position
	 * @param map
	 * @param Hero
	 */
	public Demon1(int position, IMap map,IMobile Hero) {
		super(position,map,Permeability.BLOCKING,Hero);
		this.setPosition(position);
		this.setObjet("Demon");
	}


	/**
	 * @return isAliveS
	 */
	@Override
	public Boolean setAlive() {
		return isAlive();
	}

	@Override
	public void stop() {	
	}

	/**
	 * @return super.getAlive()
	 */
	public Boolean isAlive() {
		return super.getAlive();
	}
	
	/**
	 * AI for demon1 : horizontal + vertical movement
	 */
	public void move(int move) {
		
		if(super.getAlive() == true) {
			
		Random random = new Random();
		
		/**
		 * random(((max-min)+1)-min)
		 */
		int IADirection = random.nextInt((4 - 1) + 1) + 1 ;
			
		
			switch(IADirection)
			{
			/**
			 * if the random is 1 : the demon goes up
			 */
			case 1 :
				super.moveUp(this.getPosition(),this.getObjet());
				break;
			/**
			 * if the random is 1 : the demon goes down
			*/
			case 2 :
				super.moveDown(this.getPosition(),this.getObjet());
				break;
			/**
			* if the random is 3 : the demon goes left
			*/
			case 3 :
				super.moveLeft(this.getPosition(),this.getObjet());
				break;
			/**
			 * if the random is 4 : the demon goes right
			*/
			case 4 :
				super.moveRight(this.getPosition(),this.getObjet());
				break;
			}
		}
	}


	@Override
	public void setMana(boolean b) {
		hero.setMana(true);
		
	}


	@Override
	public boolean getMana() {
		// TODO Auto-generated method stub
		return true;
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