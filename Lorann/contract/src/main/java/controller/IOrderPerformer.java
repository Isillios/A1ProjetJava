package controller;

import java.io.IOException;

/**
 * <h1>The Interface IOrderPerformer.</h1>
 * <p>
 * This Interface is just used to authorize the class who implement him to use the methods orderPerfom. 
 * </p>
 * 
 * @author Team12
 * @version final
 */

public interface IOrderPerformer {
	
	/**
	 * 
	 * @param userOrder
	 * @throws IOException
	 */
	void orderPerform(Order userOrder) throws IOException; 
}
