package model.element.mobile;

import model.*;


public abstract class AI extends Mobile {
	public AI(int position, IMap map, Permeability permeability) {
		super(position,map, permeability);
	}

}