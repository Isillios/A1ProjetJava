package model.element.mobile;

import model.*;

/**
 * <h1>The Class AI.</h1>
 * <p>This class is a generalized class of artificial intelligence
 * @author Team12
 * @version final
 */

public abstract class AI extends Mobile {
	/**
	 * 
	 * @param position
	 * @param map
	 * @param permeability
	 */
	public AI(int position, IMap map, Permeability permeability) {
		/**
		 * It inherited of mobile 
		 */
		super(position,map, permeability);
	}

}