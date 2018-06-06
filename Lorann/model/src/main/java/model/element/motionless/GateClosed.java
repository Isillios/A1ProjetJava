package model.element.motionless;

import model.*;

/**
 * <h1>The Class GateClosed.</h1>
 * <p>This class extends to MotionLessElment and implement the different methods. 
 * @author Team12
 * @version final
 */

	public class GateClosed extends MotionlessElement {
		
	@SuppressWarnings("unused")
	private static int position ;

	/**
	 * 
	 * @param position
	 */
	public GateClosed(int position) {
		super(Permeability.BLOCKING);
		this.setPosition(position);
	}
	
	/**
	 * 
	 * @return position
	 */
	public static int getPosition() {
		return position = 238;
	}
	
	@SuppressWarnings("static-access")
	public void setPosition(int position) {
		this.position = position;
	}
}