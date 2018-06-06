package controller;


/**
 * <h1>The Interface IController.</h1>
 * <p>
 * This Interface is just used to authorize the class who implement him to use the methods Start or getOrderPerfomer. 
 * </p>
 * 
 * @author Team12
 * @version final
 */

public interface IController {
     
	IOrderPerformer getOrderPeformer();
	
	/**
	 * Start the game
	 * @throws InterruptedException
	 */
	 void start() throws InterruptedException;
}
