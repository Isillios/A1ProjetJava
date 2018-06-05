package model.element.mobile;

import model.IMap;
import model.Permeability;
import model.element.mobile.MyPlayer;

public class Fireball extends AI {
	public IMap map;
	int Direction;
	private MyPlayer hero;
	public Fireball(int position, IMap map, int Direction,MyPlayer hero) {
		super(position,map,Permeability.PENETRABLE);
		this.map = map;
		this.Direction = Direction;
		this.setObjet("fireball");
		this.hero = hero;
		map.setOnMap(position, 'f');
	}
	
	public void move(int move) {
		switch (Direction) {
		case 1 :
			super.moveLeft(getPosition(),this.getObjet());
			break;
		case 2 :
			super.moveRight(getPosition(),this.getObjet());
			break;
		case 3 :
			super.moveDown(getPosition(),this.getObjet());
			break;
		case 4 :
			super.moveUp(getPosition(),this.getObjet());
			break;
		}
	}

	@Override
	public Boolean isAlive() {
		return null;
	}

	@Override
	public Boolean setAlive() {
		return null;
	}

	@Override
	public void stop() {
	}

	@Override
	public void setMana(boolean b) {
		hero.setMana(true);
	}

	@Override
	public boolean getMana() {
		// TODO Auto-generated method stub
		return false;
	}
}