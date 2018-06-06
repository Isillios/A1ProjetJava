package model.element.mobile;

import java.util.Random;

import model.IMap;
import model.IMobile;
import model.Permeability;

/**
 * <h1>The Class Demon2.</h1>
 * <p>This class extends to Demon and implement the different methods. It has the similar methods to the others demons.</p>
 * @author Team12
 * @version final
 */

public   class Demon2 extends Demon {
	@Override
	public Boolean setAlive() {
		return isAlive();
	}

	@Override
	public void stop() {	
	}
	
	public Demon2(int position, IMap map,IMobile Hero) {	
		super(position, map,Permeability.BLOCKING,Hero);
		this.setPosition(position);
		this.setObjet("Demon");
	}

	public Boolean isAlive() {
		return super.getAlive();
	}

	/**
	 * AI for demon2 : diagonal movement
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
			case 1 :
				/**
				 * if the random is 1 : the demon goes upLeft
				 */
				super.moveUpLeft(this.getPosition(),this.getObjet());
				break;
			case 2 :
				/**
				 * if the random is 2 : the demon goes upRight
				 */
				super.moveUpRight(this.getPosition(),this.getObjet());
				break;
			case 3 :
				/**
				 * if the random is 3 : the demon goes downRight
				 */
				super.moveDownRight(this.getPosition(),this.getObjet());
				break;
			case 4 :
				/**
				 * if the random is 4 : the demon goes downLeft
				 */
				super.moveDownLeft(this.getPosition(),this.getObjet());
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