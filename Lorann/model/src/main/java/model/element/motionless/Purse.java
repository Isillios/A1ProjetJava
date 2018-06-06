package model.element.motionless;

import model.*;

/**
 * <h1>The Class Purse.</h1>
 * <p>This class extends to MotionLessElment and implement the different methods. 
 * @author Team12
 * @version final
 */

public class Purse extends MotionlessElement {
	
	public Purse() {
		super(Permeability.PENETRABLE);
		Score.setScore();
		Score.getScore();	
	}
}