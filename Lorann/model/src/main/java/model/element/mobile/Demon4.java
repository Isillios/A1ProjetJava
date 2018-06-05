package model.element.mobile;

import model.IMap;
import model.IMobile;
import model.Permeability;

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

	@Override
	public void move(int move) {
		if(super.getAlive() == true) {
			Boolean collide = false ;
	
		if(bounce == false) {
			if(super.checkNextPosition(this.getPosition()+20,this.getObjet()) == true) {	
				bounce = false;
				collide = false;
			} 
		else if(super.checkNextPosition(this.getPosition()-20,this.getObjet())== true) {	
			bounce = true;	
			collide = true;
		}
		}
		else {
			if(super.checkNextPosition(this.getPosition()-20,this.getObjet()) == true) {
				bounce = true;
				collide = true;
			} 
			else if(super.checkNextPosition(this.getPosition()+20,this.getObjet())== true) {
				bounce = false;
				collide = false;
			}
		}
		if (collide == false) {
			super.moveDown(this.getPosition(),this.getObjet());
		}
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