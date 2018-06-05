package model.element.mobile;

import model.*;

public abstract class Demon extends AI {

	public static IMobile hero;
	public Demon(int position ,IMap map, Permeability permeability,IMobile Hero) {
		super(position,map, permeability);
		hero = Hero;
	}
	public static void kill() {
		hero.setAlive();
	}
}