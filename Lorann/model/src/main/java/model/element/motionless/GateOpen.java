package model.element.motionless;

import model.*;

/**
 * <h1>The Class GateOpen.</h1>
 * <p>This class extends to MotionLessElment and implement the different methods. 
 * @author Team12
 * @version final
 */

	public class GateOpen extends MotionlessElement {

	public GateOpen() {
		super(Permeability.BLOCKING);	
	}
		
	/**
	 * Open the gate when the crystallball is activated
	 * @param map
	 */
	static public void GateCtoGateO(IMap map) {
		map.setOnMap(GateClosed.getPosition(),'G');
	}
}