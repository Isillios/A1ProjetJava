package model.element.motionless;

import model.*;


	public class GateOpen extends MotionlessElement {

	public GateOpen() {
		super(Permeability.BLOCKING);	
	}
		
	static public void GateCtoGateO(IMap map) {
		map.setOnMap(GateClosed.getPosition(),'G');
	}
}