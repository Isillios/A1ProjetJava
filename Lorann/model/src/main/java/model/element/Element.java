package model.element;


import model.*;
public abstract class Element implements IElement {

	private Permeability permeability;
	/**
	 * 
	 * sprite
	 * @param permeability
	 */
	public Element( Permeability permeability) {
		this.setPermeability(permeability);
	}

	public Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * 
	 * @param permeability
	 */
	private void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

}