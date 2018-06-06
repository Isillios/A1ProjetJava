package model.element.mobile;

import model.IMap;
import model.IMobile;
import model.Permeability;


/**
 * <h1>The Class Demon1.</h1>
 * <p><p>This class extends to Demon and implement the different methods. It has the similar methods to the others demons.</p>
 * @author Team12
 * @version final
 */

public class Demon4 extends Demon {
		
	public boolean bounce = false;
	public Demon4(int position, IMap map,IMobile Hero) {
		super(position, map,Permeability.BLOCKING,Hero);
		this.setPosition(position);
		this.setObjet("Demon");
		
		
		
	}
	@Override
	public Boolean setAlive() {	
		return isAlive();
	}



	@Override
	public void stop() {
	}

	public Boolean isAlive() {	
		return super.getAlive();
	}

	/**
	 * AI for demon4 : vertical movement
	 */
	@Override
	public void move(int move) {
		if(super.getAlive() == true) {
			Boolean collide = false ;
	
		if(bounce == false) {
			/**
			 * Check up position when there is no collision
			 */
			if(super.checkNextPosition(this.getPosition()+20,this.getObjet()) == true) {	
				bounce = false;
				collide = false;
			} 
			/**
			 * Check down position  there is no collision
			 */
		else if(super.checkNextPosition(this.getPosition()-20,this.getObjet())== true) {	
			bounce = true;	
			collide = true;
		}
		}
		else {
			/**
			 * Check down position  there is collision
			 */
			if(super.checkNextPosition(this.getPosition()-20,this.getObjet()) == true) {
				bounce = true;
				collide = true;
			} 
			/**
			 * Check up position  there is collision
			 */
			else if(super.checkNextPosition(this.getPosition()+20,this.getObjet())== true) {
				bounce = false;
				collide = false;
			}
		}
		/**
		 * Demon move down there isn't collision
		 */
		if (collide == false) {
			
			super.moveDown(this.getPosition(),this.getObjet());
		}
		/**
		 * Demon move up there isn't collision
		 */
		else 
			super.moveUp(this.getPosition(),this.getObjet());
		}
	}
	@Override
	public void setMana(boolean b) {
		hero.setMana(true);
	}
	@Override
	public boolean getMana() {
		
		return true;
	}
	@Override
	public void setWin() {
		// TODO Auto-generated method stub
		
	}
}