package view;

/**
 * <h1>The Interface IElement .</h1>
 * <p>
 * This Interface is just used to authorize the class who implement him to use the method getPermeability. 
 * </p>
 * @author Team12
 * @version final
 * 
 */

public interface IViewFacade {
	
	/**
	 * 
	 */
   void refresh();
   
   /**
    * 
    * @param message
    */
   void displayMessage(String message);
}
