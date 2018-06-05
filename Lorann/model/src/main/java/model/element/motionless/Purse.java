package model.element.motionless;

import model.*;

public class Purse extends MotionlessElement {
	
	public Purse() {
		super(Permeability.PENETRABLE);
		Score.setScore();
		Score.getScore();	
	}
}