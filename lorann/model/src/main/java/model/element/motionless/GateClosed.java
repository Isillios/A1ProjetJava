package model.element.motionless;

import model.*;


	public class GateClosed extends MotionlessElement {
		
	@SuppressWarnings("unused")
	private static int position ;

	public GateClosed(int position) {
		super(Permeability.BLOCKING);
		this.setPosition(position);
	}
	
	public static int getPosition() {
		return position = 238;
	}
	
	@SuppressWarnings("static-access")
	public void setPosition(int position) {
		this.position = position;
	}
}