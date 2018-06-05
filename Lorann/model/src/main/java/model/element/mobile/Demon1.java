package model.element.mobile;


import java.util.Random;

import model.IMap;
import model.IMobile;
import model.Permeability;



public class Demon1 extends Demon {
	
	public Demon1(int position, IMap map,IMobile Hero) {
		super(position,map,Permeability.BLOCKING,Hero);
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
	
	public void move(int move) {
		
		if(super.getAlive() == true) {
			
		Random random = new Random();
		
		int IADirection = random.nextInt((4 - 1) + 1) + 1 ;
			
			switch(IADirection)
			{
			case 1 :
				super.moveUp(this.getPosition(),this.getObjet());
				break;
			case 2 :
				super.moveDown(this.getPosition(),this.getObjet());
				break;
			case 3 :
				super.moveLeft(this.getPosition(),this.getObjet());
				break;
			case 4 :
				super.moveRight(this.getPosition(),this.getObjet());
				break;
			}
		}
	}


	@Override
	public void setMana(boolean b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean getMana() {
		// TODO Auto-generated method stub
		return false;
	}
}