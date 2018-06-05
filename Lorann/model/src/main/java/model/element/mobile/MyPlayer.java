package model.element.mobile;

import model.*;

public class MyPlayer extends Mobile implements IMobile {
	
	private static boolean mana = true;
	private IMap map;
	private int lastposition;
	public Fireball spell;
	
	
	public MyPlayer(int position, IMap map) {
		
		super(position,map,Permeability.BLOCKING);
		this.setLastposition(position);
		this.setPosition(position);
		this.map = map;
		this.setObjet("Player");
	}
	
	public Fireball fireball() {
		int direction = 0 ;
		int order = getLastposition() - getPosition();
	
		switch (order) {
		case 1 :
			direction = 1;
			break;
		case -1 :
			direction = 2;
			break;
		case -20 :
			direction = 3;
			break;
		case 20 :
			direction = 4;
			break;
		}
		 spell = new Fireball(getLastposition(),map,direction,this);
		 setMana(false);
		return spell;	
	}

	public  boolean getMana() {
		return mana;
	}

	public void setMana(boolean mana) {
		MyPlayer.mana = mana;
	}
	
	public void move(int move) {
		switch(move) {
		case 1:
			setLastposition(this.getPosition());
			super.moveUp(this.getPosition(),this.getObjet());
			break;
		case 2:
			setLastposition(this.getPosition());
			super.moveDown(this.getPosition(),this.getObjet());
			break;
		case 3:
			setLastposition(this.getPosition());
			super.moveLeft(this.getPosition(),this.getObjet());
			break;
		case 4:
			setLastposition(this.getPosition());
			super.moveRight(this.getPosition(),this.getObjet());
			break;
		case 5:
			fireball();
			break;
		}
	}
	
	@Override
	public  Boolean isAlive() {
		return super.getAlive();
	}

	public void isDead() {
		super.death();
	}

	public int getLastposition() {
		return lastposition;
	}

	public void setLastposition(int lastposition) {
		this.lastposition = lastposition;
	}

	@Override
	public Boolean setAlive() {
		super.death();
		return isAlive();	
	}

	@Override
	public void stop() {	
	}

	@Override
	public void setWin() {
		// TODO Auto-generated method stub
		
	}	
}