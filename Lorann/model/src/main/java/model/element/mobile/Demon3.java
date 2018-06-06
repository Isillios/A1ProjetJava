package model.element.mobile;

import model.IMap;
import model.IMobile;
import model.Permeability;

/**
 * <h1>The Class Demon1.</h1>
 * <p>This class extends to Demon and implement the different methods. It has the similar methods to the others demons.</p>
 * @author Team12
 * @version final
 */

	public  class Demon3 extends Demon {
		
		@Override
		public Boolean isAlive() {
			return super.getAlive();
		}
		
		@Override
		public Boolean setAlive() {
			return isAlive();
		}
		
		@Override
		public void stop() {
		}

		/**
		 * The bounce
		 */
		public boolean bounce = false;
	
	
		public Demon3(int position, IMap map,IMobile Hero) {
			super(position, map,Permeability.BLOCKING,Hero);
			this.setPosition(position);
			this.setObjet("Demon");
		}
		/**
		 * AI for demon3 : horizontal movement
		 */
		public void move(int move) {
			if(super.getAlive() == true) {
				Boolean collide = false ;
	
				if(bounce == false) {
					/**
					 * Check right position when there is no collision
					 */
					if(super.checkNextPosition(this.getPosition()+1,this.getObjet()) == true) {	
						bounce = false;
						collide = false;
					} 	
					
					/**
					 * Check left position  there is no collision
					 */
					else if(super.checkNextPosition(this.getPosition()-1,this.getObjet())== true) {			
						bounce = true;				
						collide = true;			
					}		
				}			
				else {	
					/**
					 * Check left position  there is collision
					 */
					if(super.checkNextPosition(this.getPosition()-1,this.getObjet()) == true) {					
						bounce = true;					
						collide = true;				
					} 		
					/**
					 * Check right position  there is collision
					 */
					else if(super.checkNextPosition(this.getPosition()+1,this.getObjet())== true) {					
						bounce = false;				
						collide = false;
					}
				}
				
				/**
				 * Demon move right there isn't collision
				 */
				if (collide == false) {	
					super.moveRight(this.getPosition(),this.getObjet());
				}
				/**
				 * Demon move right there is collision
				 */
				else
				{
					super.moveLeft(this.getPosition(),this.getObjet());
			
				}
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